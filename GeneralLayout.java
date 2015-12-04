import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractListModel;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public abstract class GeneralLayout extends JFrame {


	// Header of Frame
	private JPanel jHeaderPanel;
	private JLabel jHeaderTitle;
	private JLabel jHeaderSubTitle;

	// Top of Frame
	private JPanel jOptionsPanel;
	private JLabel jOptionsPanelLeftLabel;
	private JLabel jOptionsPanelRightLabel;
	private JComboBox<String> jOptionsPanelLeftComboBox;
	private JComboBox<String> jOptionsPanelRightComboBox;

	// Center of Frame
	private JPanel jCenter;
	private JList<String> jCenterList;
	private JScrollPane jCenterScrollPane;

	private static final Color COLOR = new Color(0,0,255);
	private static final Font FONT = new Font("Segoe UI", 0, 14);

	public GeneralLayout() {
		initComponents();
		addListeners();
		setVisible(true);
		pack();
	}

	// Initializes Components
	private void initComponents() {
		jHeaderPanel = new JPanel();
		jHeaderTitle = new JLabel();
		jHeaderSubTitle = new JLabel();

		jOptionsPanel = new JPanel();
		jOptionsPanelLeftLabel = new JLabel();
		jOptionsPanelRightLabel = new JLabel();
		jOptionsPanelLeftComboBox = new JComboBox<>();
		jOptionsPanelRightComboBox = new JComboBox<>();

		jCenter = new JPanel();
		jCenterList = new JList<>();
		jCenterScrollPane = new JScrollPane();
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		wrapLayouts();

	}

	/*
	 * Draws a Header with a given Title and sub title
	 * @param title the title of header
	 * @param subTitle the sub title of header
	 * @precondition title != null 
	 * @precondition subTitle != null
	 */
	public void drawHeader(String title, String subTitle) {
		jHeaderTitle.setForeground(COLOR);
		jHeaderTitle.setText(title);

		jHeaderSubTitle.setFont(FONT);
		jHeaderSubTitle.setForeground(COLOR);
		jHeaderSubTitle.setText(subTitle);

		jHeaderPanel.setLayout(new BoxLayout(jHeaderPanel,BoxLayout.Y_AXIS));
		jHeaderPanel.add(jHeaderTitle);
		jHeaderPanel.add(jHeaderSubTitle);

	}

	/*
	 * Draws a Panel with components passed as arguments 
	 * @param leftLabelText, Combo box title displayed to the left of frame
	 * @param rightLabelText , Combo box Title displayed to the right of frame
	 * @param  leftComboBox, Combo displayed to the left of frame, takes String values
	 * @param rightComboBox, Combo box displayed to right of Frame, takes String values 
	 */
	public void drawTop(String leftLabelText, String rightLabelText,
			String[] leftComboBoxItems, String[] rightComboBoxItems) {
		jOptionsPanelLeftLabel.setText(leftLabelText);
		jOptionsPanelRightLabel.setText(rightLabelText);

		// Set Combo Box Model
		jOptionsPanelLeftComboBox.setModel(new DefaultComboBoxModel<>(leftComboBoxItems));
		jOptionsPanelRightComboBox.setModel(new DefaultComboBoxModel<>(rightComboBoxItems));

		jOptionsPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
		jOptionsPanel.add(jOptionsPanelLeftLabel);
		jOptionsPanel.add(jOptionsPanelLeftComboBox);
		jOptionsPanel.add(jOptionsPanelRightLabel);
		jOptionsPanel.add(jOptionsPanelRightComboBox);
	}

	public JPanel getjOptionsPanel() {
		return jOptionsPanel;
	}

	public void drawCenter(String[] centerListData) {		
		GroupLayout centerPanelLayout = new GroupLayout(jCenter);

		setCenterList(centerListData);

		jCenter.setLayout(centerPanelLayout);
		jCenterScrollPane.setViewportView(jCenterList);

		centerPanelLayout.setHorizontalGroup(
				centerPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(centerPanelLayout.createSequentialGroup()
						.addGroup(centerPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(centerPanelLayout.createSequentialGroup()
										.addGap(41, 41, 41)
										.addComponent(jCenterScrollPane, GroupLayout.PREFERRED_SIZE, 414, GroupLayout.PREFERRED_SIZE))
								)
						.addContainerGap(65, Short.MAX_VALUE))
				);
		centerPanelLayout.setVerticalGroup(
				centerPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(centerPanelLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jCenterScrollPane, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18))
				);
	}


	public void setCenterList(final String[] result) {
		jCenterList.setModel(new AbstractListModel<String>() {
			public int getSize() { return result.length; }
			public String getElementAt(int i) { return result[i]; }
		});
	}


	/*
	 * Adds Listener to Components.
	 * Child Class implements its own implementation of Action Performed
	 */
	private void addListeners() {
		jOptionsPanelLeftComboBox.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				optionsPanelLeftComboBoxActionPerformed(evt);
			}
		});

		jOptionsPanelRightComboBox.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				optionsPanelRightComboBoxActionPerformed(evt);
			}
		});
		jCenterList.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent mouseEvent) {
				boolean uiOpen = false;
				JList<String> list = (JList)mouseEvent.getSource();
				if (mouseEvent.getClickCount() == 2) {					
					int index = list.locationToIndex(mouseEvent.getPoint());
					if(index >= 0 && !uiOpen) {
						jOnDoubleClickListItemActionPerformed(jCenterList.getModel().getElementAt(index));
						uiOpen = true;
					}
				}
			}
		});
	}

	/*
	 * @return data to be populated in left combo Box
	 */
	public abstract  String[] getLeftComboBoxData();

	/*
	 * @return data to e populated in right combo box
	 */
	public abstract String[] getRightComboBoxData();

	/*
	 * Action to be performed item is  selected in Left Combo Box
	 */
	public abstract void optionsPanelLeftComboBoxActionPerformed(ActionEvent evt) ;

	/*
	 * Action to be performed item is  selected in Right Combo Box
	 */

	public abstract void optionsPanelRightComboBoxActionPerformed(ActionEvent evt) ;

	/*
	 * Action to be performed when item is double clicked in center panel
	 */
	public abstract void jOnDoubleClickListItemActionPerformed(Object elementClicked);

	public abstract String[] defaultResultToBeDisplayed();
	
	public JList<String> getjCenterList() {
		return jCenterList;
	}

	public JComboBox<String> getjOptionsPanelLeftComboBox() {
		return jOptionsPanelLeftComboBox;
	}

	public JComboBox<String> getjOptionsPanelRightComboBox() {
		return jOptionsPanelRightComboBox;
	}


	/**
	 * Launches the UI
	 */
	public void launchUI() {

		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			// TODO
			//java.util.logging.Logger.getLogger(HomepageUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			// TODO
			//java.util.logging.Logger.getLogger(HomepageUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			// TODO
			//java.util.logging.Logger.getLogger(HomepageUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			// TODO
			//java.util.logging.Logger.getLogger(HomepageUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>
	}

	/*
	 * Wraps sub layouts in one layout that creates the overall
	 * home page
	 */
	private void wrapLayouts() {
		setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
		add(jHeaderPanel);
		add(jOptionsPanel);
		add(jCenter);
		setPreferredSize(new Dimension(500, 500));


	}
}
