import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author David
 * @modified Shweta - Divided code into methods to make
 * it more readable
 */
public class HomepageUI extends JFrame {

	
	private static final long serialVersionUID = 1L;
	/**
	 * Creates new form ContactEditorUI
	 */
	
	public HomepageUI(Manufacturer[] manufacturer, String[] priceRanges ,String[] defaultResultList) {
		this.manufacturer = manufacturer;
		this.priceRanges = priceRanges;	
		this.defaultResultList = defaultResultList;
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */

	// initComponents
	private void initComponents() {

		jHeaderPanel = new JPanel();
		jTitle = new JLabel();
		jSubTitle = new JLabel();
		designHeader();

		optionsPanel = new JPanel();
		jManufacturerComboBox = new JComboBox<>();
		
		jManufacturerLabel = new JLabel();
		jPriceComboBox = new JComboBox<>();  
		jPriceLabel = new JLabel();
		//jSearchButton = new JButton();
		designOptionsPanel();


		jResultPanel = new JPanel();
		jResultScrollPane1 = new javax.swing.JScrollPane();
		jResultList = new javax.swing.JList<>();
		jUserNameTextField = new javax.swing.JFormattedTextField();
		jPasswordField = new javax.swing.JPasswordField();
		jLogin = new JButton();
		designResultsAndLogin();		
		
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		
		wrapLayouts();
		addListeners();
		setVisible(true);
		pack();
	}
	
	/*
	 * Adds listener to button and combo boxes
	 */
	private void addListeners() {
		
		/*jSearchButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jSearchButtonButtonActionPerformed(evt);
			}
		});*/
		jUserNameTextField.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jUserNameTextField1ActionPerformed(evt);
			}
		});
		
		jManufacturerComboBox.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jManufacturerComboBoxActionPerformed(evt);
			}
		});

		jPriceComboBox.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jPriceComboBoxActionPerformed(evt);
			}
		});
		jResultList.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent evt) {
				jResultListActionPerformed(evt);
				
			}
		});
						
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

	/*
	 * This method is responsible for designing header which includes 
	 * Title and sub title. 
	 */
	private void designHeader() {
		// TODO Auto-generated method stub  title.setFont(new Font("Segoe UI", 0, 18)); // NOI18N
		jTitle.setForeground(new Color(0, 0, 255));
		jTitle.setText("Welcome to the DHKS Car Showroom! ");

		jSubTitle.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
		jSubTitle.setForeground(new Color(0, 0, 255));
		jSubTitle.setText("We sell the newest cars at the cheapest prices!");

		GroupLayout headerPanelLayout = new GroupLayout(jHeaderPanel);
		jHeaderPanel.setLayout(headerPanelLayout);
		headerPanelLayout.setHorizontalGroup(
				headerPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(headerPanelLayout.createSequentialGroup()
						.addGroup(headerPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(headerPanelLayout.createSequentialGroup()
										.addGap(107, 107, 107)
										.addComponent(jSubTitle, GroupLayout.PREFERRED_SIZE, 293, GroupLayout.PREFERRED_SIZE))
								.addGroup(headerPanelLayout.createSequentialGroup()
										.addGap(98, 98, 98)
										.addComponent(jTitle)))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
		headerPanelLayout.setVerticalGroup(
				headerPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(headerPanelLayout.createSequentialGroup()
						.addComponent(jTitle, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jSubTitle, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
						.addGap(0, 15, Short.MAX_VALUE))
				);

	}
	/*
	 * This method displays Options to user, mainly a list of
	 * manufacturer, price in sorted order.
	 */
	private void designOptionsPanel() {
		jManufacturerLabel.setText("Manufacturer:");
		jPriceLabel.setText("Price:");
		//jSearchButton.setText("Search");
		setjManufacturerComboBox();
		setjPriceComboBox();
		GroupLayout jOptionsPanelLayout = new GroupLayout(optionsPanel);
		optionsPanel.setLayout(jOptionsPanelLayout);
		jOptionsPanelLayout.setHorizontalGroup(
				jOptionsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jOptionsPanelLayout.createSequentialGroup()
						.addGap(39, 39, 39)
						.addComponent(jManufacturerLabel)
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jManufacturerComboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGap(17, 17, 17)
						.addComponent(jPriceLabel)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jPriceComboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						//.addComponent(jSearchButton)
						.addGap(26, 26, 26))
				);
		jOptionsPanelLayout.setVerticalGroup(
				jOptionsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(GroupLayout.Alignment.TRAILING, jOptionsPanelLayout.createSequentialGroup()
						.addGap(10, 10, 10)
						.addGroup(jOptionsPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(jManufacturerComboBox)
								.addComponent(jPriceComboBox)
								.addComponent(jManufacturerLabel)
								.addComponent(jPriceLabel)))
								//.addComponent(jSearchButton)))
				);
	}
	/*
	 * @param manufacturerNames, populates Manufacturer combo box with names
	 * of Manufacturers
	 */
	public void setjManufacturerComboBox() {
		String names[] = new String[manufacturer.length];
		for(int i = 0; i< manufacturer.length;i++) {
			names[i] = manufacturer[i].getManufacturerName();
		}
		jManufacturerComboBox.setModel(new DefaultComboBoxModel<String>(names));
	}

	/*
	 * @param priceRanges, an array of price ranges offered by
	 * administrator
	 */
	public void setjPriceComboBox() {		
		jPriceComboBox.setModel(new DefaultComboBoxModel<>(priceRanges));
	}

	/*
	 * Add result values
	 */
	public void setjResultList(final String[] result) {
		jResultList.setModel(new javax.swing.AbstractListModel<String>() {
			public int getSize() { return result.length; }
			public String getElementAt(int i) { return result[i]; }
		});
	}
	/*
	 * Designs Result list display and Log in display
	 */
	private void designResultsAndLogin() {
		GroupLayout jResultAndLoginPanelLayout = new GroupLayout(jResultPanel);
		jUserNameTextField.setText("Username");
		jPasswordField.setText("Password");
		jLogin.setText("LogIn");
		setjResultList(defaultResultList);
		jResultPanel.setLayout(jResultAndLoginPanelLayout);
		jResultScrollPane1.setViewportView(jResultList);
		jResultAndLoginPanelLayout.setHorizontalGroup(
				jResultAndLoginPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jResultAndLoginPanelLayout.createSequentialGroup()
						.addGroup(jResultAndLoginPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(jResultAndLoginPanelLayout.createSequentialGroup()
										.addGap(41, 41, 41)
										.addComponent(jResultScrollPane1, GroupLayout.PREFERRED_SIZE, 414, GroupLayout.PREFERRED_SIZE))
								.addGroup(jResultAndLoginPanelLayout.createSequentialGroup()
										.addGap(84, 84, 84)
										.addComponent(jUserNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(29, 29, 29)
										.addComponent(jPasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jLogin)))
						.addContainerGap(65, Short.MAX_VALUE))
				);
		jResultAndLoginPanelLayout.setVerticalGroup(
				jResultAndLoginPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jResultAndLoginPanelLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jResultScrollPane1, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addGroup(jResultAndLoginPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(jUserNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(jPasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(jLogin))
						.addContainerGap(18, Short.MAX_VALUE))
				);
		
	}


	/*
	 * Wraps sub layouts in one layout that creates the overall
	 * home page
	 */
	private void wrapLayouts() {
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(jHeaderPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(optionsPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
						.addComponent(jResultPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, Short.MAX_VALUE))
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(jHeaderPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(optionsPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jResultPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				);

		
	}
	
	
	private void jManufacturerComboBoxActionPerformed(ActionEvent evt) {
		//:event_jComboBox1ActionPerformed
		String selectedItem = (String)jManufacturerComboBox.getSelectedItem();
		Manufacturer manufacturer = getManufacturerFromString(selectedItem);
		String[] carsDetails = manufacturer.getCarsDetails();
		setjResultList(carsDetails);
		repaint();		
	}

	private void jPriceComboBoxActionPerformed(ActionEvent evt) {//:event_jComboBox2ActionPerformed
		String manufacturer = (String)jManufacturerComboBox.getSelectedItem();
		Manufacturer manufact = getManufacturerFromString(manufacturer);
		String priceRange = (String)jPriceComboBox.getSelectedItem(); 
		if(priceRange.startsWith("All ")) {
			setjResultList(manufact.getCarsDetails());
		}
		else {
			String[] range = priceRange.split("-");
			setjResultList(manufact.getCarsInPriceRange(Double.parseDouble(range[0]),
					Double.parseDouble(range[1])));
		}
		repaint();
	}//GEN-LAST:event_jComboBox2ActionPerformed

	/*private void jSearchButtonButtonActionPerformed(ActionEvent evt) {//:event_jButton1ActionPerformed
		// TODO add your handling code here:
	}*///GEN-LAST:event_jButton1ActionPerformed

	private void jUserNameTextField1ActionPerformed(ActionEvent evt) {//:event_jFormattedTextField1ActionPerformed
		// TODO add your handling code here:
	}//GEN-LAST:event_jFormattedTextField1ActionPerformed
	
	private void jResultListActionPerformed(ListSelectionEvent evt) {
		
	}

	/**
	 * @param args the command line arguments
	 */
	public void launchUI() {
		/* Set the Nimbus look and feel */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
		/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
		 * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(HomepageUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(HomepageUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(HomepageUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(HomepageUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	//private javax.swing.JButton jSearchButton;
	private javax.swing.JButton jLogin;
	private javax.swing.JComboBox<String> jManufacturerComboBox;
	private javax.swing.JComboBox<String> jPriceComboBox;
	private javax.swing.JFormattedTextField jUserNameTextField;
	private javax.swing.JLabel jTitle;
	private javax.swing.JLabel jSubTitle;
	private javax.swing.JLabel jManufacturerLabel;
	private javax.swing.JLabel jPriceLabel;
	private javax.swing.JList<String> jResultList;
	private javax.swing.JPanel jHeaderPanel;
	private javax.swing.JPanel optionsPanel;
	private javax.swing.JPanel jResultPanel;
	private javax.swing.JPasswordField jPasswordField;
	private javax.swing.JScrollPane jResultScrollPane1;
	private Manufacturer[] manufacturer;
	private String[] priceRanges;
	private String[] defaultResultList;
	// End of variables declaration//GEN-END:variables
}
