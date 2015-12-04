import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CustomizeCar extends GeneralLayout {
	
	
	private JLabel jTotalCostLabel;
	private JLabel jTotalCost;
	private JButton jAddButton;

	private JButton jBuyButton;
	private JButton jCancelButton;
	private Car selectedCar;
	
	private Accessory[] accessories;
	
	private static final String TITLE = "Customize your Car ";
	private static String SUB_TITLE ;
	private static final String TOP_LEFT_LABEL = "Accessory:";
	private static final String TOP_RIGHT_LABEL = "Price:"; 


	public CustomizeCar(String manufacturerName, Car car) {
		selectedCar = car;
		accessories= Tester.getAccessories();
		SUB_TITLE = "You selected "+ manufacturerName + " " +selectedCar.toString() ;
		
		jTotalCostLabel = new JLabel("Total Cost: ");
		jTotalCost = new JLabel("$" +String.valueOf(selectedCar.getPrice()));
		jAddButton = new JButton("Add");
		
		jBuyButton = new JButton("Buy");
		jCancelButton = new JButton("Cancel");
		
		drawHeader(TITLE, SUB_TITLE);
		drawTop(TOP_LEFT_LABEL, TOP_RIGHT_LABEL, getLeftComboBoxData(), getRightComboBoxData());
		getjOptionsPanel().add(jAddButton);
	    drawCenter(defaultResultToBeDisplayed());
	    drawBottom();	
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
		// TODO Auto-generated method stub

	}

	@Override
	public void jOnDoubleClickListItemActionPerformed(Object elementClicked) {
		// TODO Auto-generated method stub

	}

	@Override
	public String[] defaultResultToBeDisplayed() {
		return Tester.defaultAccessoriesToBeDisplayed();
	}
	
	private void drawBottom() {
		JPanel bottom = new JPanel();
		bottom.add(jTotalCostLabel);
		bottom.add(jTotalCost);
		bottom.add(jBuyButton);
		bottom.add(jCancelButton);
		add(bottom);
		
	}

}
