import javax.swing.*;

/**
 *
 * @author David
 */
@SuppressWarnings("serial")
public class AdministratorUI extends JFrame {

    /**
     * Constructor AdministratorUI
     */
    public AdministratorUI() {
    	setVisible(true);
        initComponents();
    }


 
    private void initComponents() {

        jWelcomeLabel = new javax.swing.JLabel();
        jModelLabel = new javax.swing.JLabel();
        jManufactureLabel = new javax.swing.JLabel();
        jPriceLabel = new javax.swing.JLabel();
        jMPGLabel = new javax.swing.JLabel();
        jManuTextField = new javax.swing.JTextField(20);
        jModelTextField = new javax.swing.JTextField(20);
        jPriceTextField = new javax.swing.JTextField(20);
        jMPGTextField = new javax.swing.JTextField(20);
        jAddButton = new javax.swing.JButton();
        jRemoveButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jWelcomeLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); 
        jWelcomeLabel.setForeground(new java.awt.Color(255, 0, 0));
        jWelcomeLabel.setText("Welcome Administrator!");

        jModelLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); 
        jModelLabel.setText("Model:");

        jManufactureLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); 
        jManufactureLabel.setText("Manufacture:");

        jPriceLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); 
        jPriceLabel.setText("Price:");

        jMPGLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); 
        jMPGLabel.setText("MPG:");

 

        jAddButton.setText("Add to Inventory");

        jRemoveButton.setText("Remove from Inventory");
        jRemoveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRemoveButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jWelcomeLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jManufactureLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jManuTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jMPGLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jMPGTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jPriceLabel)
                                    .addGap(90, 90, 90)
                                    .addComponent(jPriceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jModelLabel)
                                .addGap(80, 80, 80)
                                .addComponent(jModelTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jAddButton)
                        .addGap(18, 18, 18)
                        .addComponent(jRemoveButton)))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jWelcomeLabel)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jManufactureLabel)
                    .addComponent(jManuTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jModelLabel)
                    .addComponent(jModelTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPriceLabel)
                    .addComponent(jPriceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jMPGLabel)
                    .addComponent(jMPGTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jAddButton)
                    .addComponent(jRemoveButton))
                .addGap(41, 41, 41))
        );

        pack();
    }

    private void jRemoveButtonActionPerformed(java.awt.event.ActionEvent evt) {
       
    }

    /**
     * @param args the command line arguments
     */
    public  void launchUI() {
 
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
       // TODO     java.util.logging.Logger.getLogger(AdministratorUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
        // TODO   java.util.logging.Logger.getLogger(AdministratorUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
         // TODO  java.util.logging.Logger.getLogger(AdministratorUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
          //TODO  java.util.logging.Logger.getLogger(AdministratorUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    
    }

    // Variables declaration 
    private javax.swing.JButton jAddButton;
    private javax.swing.JButton jRemoveButton;
    private javax.swing.JLabel jWelcomeLabel;
    private javax.swing.JLabel jModelLabel;
    private javax.swing.JLabel jPriceLabel;
    private javax.swing.JLabel jManufactureLabel;
    private javax.swing.JLabel jMPGLabel;
    private javax.swing.JTextField jManuTextField;
    private javax.swing.JTextField jModelTextField;
    private javax.swing.JTextField jPriceTextField;
    private javax.swing.JTextField jMPGTextField;
}
