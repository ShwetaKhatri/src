import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
/*
 * @author Shweta
 * Creates Homepage
 */
@SuppressWarnings("serial")
public class HomePage extends GeneralLayout {

	private static final String TITLE = "Welcome to the DHKS Car Showroom! ";
	private static final String SUB_TITLE = "We sell the newest cars at the cheapest prices!";
	private static final String TOP_LEFT_LABEL = "Manufacturer:";
	private static final String TOP_RIGHT_LABEL = "Price:"; 


	private Manufacturer[] manufacturer;
	private String[] priceRanges;
	private JTextField jUserNameTextField;
	private JTextField jPassword;
	private JButton jLogin;


	/*
	 * @param carManufacturer, Manufacturer to be displayed
	 * in left combo box
	 * @param prices, price ranges to be displayed in right combo
	 * box
	 */
	public HomePage(Manufacturer[] carManufacturer, String[] prices) {
		manufacturer = carManufacturer;
		priceRanges = prices;
		jUserNameTextField =  new JTextField("Username");
		jPassword = new JTextField("Password");
		jLogin = new JButton("Login");
		
		drawHeader(TITLE, SUB_TITLE);
		drawTop(TOP_LEFT_LABEL, TOP_RIGHT_LABEL, getLeftComboBoxData(), getRightComboBoxData());
		drawCenter(defaultResultToBeDisplayed());
		drawBottom();
		jLogin.addActionListener(new ActionListener() {
			boolean adminUiOpen = false;
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!adminUiOpen) {
					AdministratorUI ui = new AdministratorUI();
					ui.launchUI();
					adminUiOpen = true;
				}
			}
		});
	}

	@Override
	public String[] getLeftComboBoxData() {
		String names[] = new String[manufacturer.length];
		for(int i = 0; i< manufacturer.length;i++) {
			names[i] = manufacturer[i].getManufacturerName();
		}
		return names;
	}

	@Override
	public String[] getRightComboBoxData() {
		return priceRanges;
	}

	@Override
	public void optionsPanelLeftComboBoxActionPerformed(ActionEvent evt) {
		String selectedItem = (String)getjOptionsPanelLeftComboBox().getSelectedItem();
		Manufacturer manufacturer = getManufacturerFromString(selectedItem);
		String[] carsDetails = manufacturer.getCarsDetails();
		setCenterList(carsDetails);
		repaint();		
	}

	@Override
	public void optionsPanelRightComboBoxActionPerformed(ActionEvent evt) {
		String manufacturer = (String)getjOptionsPanelLeftComboBox().getSelectedItem();
		Manufacturer manufact = getManufacturerFromString(manufacturer);
		String priceRange = (String)getjOptionsPanelRightComboBox().getSelectedItem(); 
		if(priceRange.startsWith("All ")) {
			setCenterList(manufact.getCarsDetails());
		}
		else {
			String[] range = priceRange.split("-");
			setCenterList(manufact.getCarsInPriceRange(Double.parseDouble(range[0]),
					Double.parseDouble(range[1])));
		}
		repaint();		
	}

	@Override
	public void jOnDoubleClickListItemActionPerformed(Object elementClicked) {
		String value = (String)elementClicked;
		String selectedItem = (String)getjOptionsPanelLeftComboBox().getSelectedItem();
		Manufacturer manufacturer = getManufacturerFromString(selectedItem);
		ArrayList<Car> cars = manufacturer.getCars();
		for(int i =0; i<cars.size();i++) {
			if(value.equals(cars.get(i).toString())) {
				CustomizeCar ui = new CustomizeCar(selectedItem,cars.get(i));
				ui.launchUI();
			}
		}		
	}

	/*
	 * @param selectedItem, name of Manufacturer selected 
	 * Extracts manufacturer object from manufacturer array
	 * that matches the string passed.
	 */
	private Manufacturer getManufacturerFromString(String selectedItem) {
		Manufacturer obj = null;
		for(int i =0; i<manufacturer.length;i++) {
			if(manufacturer[i].getManufacturerName().equalsIgnoreCase(selectedItem)) {
				obj = manufacturer[i];
			}
		}
		if(obj == null) {
			throw new NullPointerException("No such manufacturer found");
		}
		return obj;
	}

	@Override
	public void drawBottom() {
		JPanel bottom = new JPanel();
		bottom.add(jUserNameTextField);
		bottom.add(jPassword);
		bottom.add(jLogin);
		add(bottom);
	}

	@Override
	public String[] defaultResultToBeDisplayed() {
		return Tester.defaultManufacturersToBeDiplayed();
	}

}
