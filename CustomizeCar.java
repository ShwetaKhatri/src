import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
/*
 * This class helps in adding accessories to
 * cars selected
 */
public class CustomizeCar extends GeneralLayout {

	private JLabel jTotalCostLabel;
	private JLabel jTotalCost;
	private JButton jAddButton;

	private JButton jBuyButton;
	private JButton jCancelButton;
	private Car selectedCar;
	private static double addedValue;


	private static final String TITLE = "Customize your Car ";
	private static String SUB_TITLE ;
	private static final String TOP_LEFT_LABEL = "Accessory:";
	private static final String TOP_RIGHT_LABEL = "Price:"; 


	/*
	 * @param namufactureName,name of Manufacturer whose car is being Customized
	 * @param Car, car to be customized
	 */
	public CustomizeCar(String manufacturerName, Car car) {
		selectedCar = car;
		SUB_TITLE = "You selected "+ manufacturerName + " " +selectedCar.toString() ;

		jTotalCostLabel = new JLabel("Total Cost: ");
		jTotalCost = new JLabel(String.valueOf(selectedCar.getCarPrice()));
		jAddButton = new JButton("Add");		
		jBuyButton = new JButton("Buy");
		jCancelButton = new JButton("Cancel");
		addListeners();
		drawHeader(TITLE, SUB_TITLE);
		drawTop(TOP_LEFT_LABEL, TOP_RIGHT_LABEL, getLeftComboBoxData(), getRightComboBoxData());
		getjOptionsPanel().add(jAddButton);
		drawCenter(defaultResultToBeDisplayed());
		drawBottom();	
	}

	private void addListeners() {
		jAddButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jTotalCost.setText(String.valueOf(addedValue));
				repaint();
			}
		});
		jBuyButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				BuyCarUI.launchUI();	
			}
		});
		jCancelButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});
	}

	@Override
	public String[] getLeftComboBoxData() {
		return Tester.getAccessoriesTypes();
	}

	@Override
	public String[] getRightComboBoxData() {
		return Tester.getAccessoriesPriceRange();
	}

	@Override
	public void optionsPanelLeftComboBoxActionPerformed(ActionEvent evt) {
		int selectedItem =  getjOptionsPanelLeftComboBox().getSelectedIndex();
		Accessory accessory = Tester.getAccessories(selectedItem);
		setCenterList(accessory.getAccessoriesDetails());
	}


	@Override
	public void optionsPanelRightComboBoxActionPerformed(ActionEvent evt) {
		int selectedItem =  getjOptionsPanelLeftComboBox().getSelectedIndex();
		Accessory accessory = Tester.getAccessories(selectedItem);
		String priceRange = (String)getjOptionsPanelRightComboBox().getSelectedItem(); 
		if(priceRange.startsWith("All ")) {
			setCenterList(accessory.getAccessoriesDetails());
		}
		else {
			String[] range = priceRange.split("-");
			setCenterList(accessory.getAccessoryInPriceRange(Double.parseDouble(range[0]),
					Double.parseDouble(range[1])));
		}
		repaint();	
	}

	@Override
	public void jOnDoubleClickListItemActionPerformed(Object elementClicked) {
		double price = getPriceFromString((String)elementClicked);
		System.out.println(price);
		Double totalCost = Double.parseDouble(jTotalCost.getText());
		addedValue = totalCost + price;
	}

	@Override
	public String[] defaultResultToBeDisplayed() {
		return Tester.defaultAccessoriesToBeDisplayed();
	}

	/*
	 * @param stringRepresentationOfAccessory, toString() representation of accessory
	 * @return price extracted from input
	 */
	public double getPriceFromString(String stringRepresentationOfAccessory) {
		int startIndex = stringRepresentationOfAccessory.lastIndexOf(":");
		int endIndex = stringRepresentationOfAccessory.length();
		String price = stringRepresentationOfAccessory.substring(startIndex+1, endIndex);
		Double p = Double.parseDouble(price);
		return p;
	}
	
	// Bottom part of Frame
	@Override
	public void drawBottom() {
		JPanel bottom = new JPanel();
		bottom.add(jTotalCostLabel);
		bottom.add(jTotalCost);
		bottom.add(jBuyButton);
		bottom.add(jCancelButton);
		add(bottom);

	}

}
