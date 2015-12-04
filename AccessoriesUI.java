import javax.swing.JFrame;
/**
 *
 * @author David
 */
public class AccessoriesUI extends JFrame {

	/**
     * Creates new form AccessoriesUI
     */
	

	private static final String[] accessories = {"Covers"}; 

    public AccessoriesUI(){   	
		initComponents();
		setVisible(true);
	 }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    private void initComponents() {

        jScrollPane = new javax.swing.JScrollPane();
        jAccessoriesList = new javax.swing.JList<>();
        jAccessoriesLabel = new javax.swing.JLabel();
        jCancelButton = new javax.swing.JButton();
        jAddButton = new javax.swing.JButton();
        jPurchaseButton = new javax.swing.JButton();
        jTotalPriceLabel = new javax.swing.JLabel();
        jPriceResultLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jAccessoriesList.setModel(new javax.swing.AbstractListModel<String>() {
    
			public int getSize() { return accessories.length; }
            public String getElementAt(int i) { return accessories[i]; }
        });
        
        jScrollPane.setViewportView(jAccessoriesList);

        jAccessoriesLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jAccessoriesLabel.setForeground(new java.awt.Color(0, 0, 255));
        jAccessoriesLabel.setText("Accessories");

        jCancelButton.setText("Cancel");

        jAddButton.setText("Add");
        jAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAddButtonActionPerformed(evt);
            }
        });

        jPurchaseButton.setText("Purchase");

        jTotalPriceLabel.setText("Total Price:");

        jPriceResultLabel.setText("$ ___");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTotalPriceLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPriceResultLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPurchaseButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCancelButton)
                        .addGap(4, 4, 4))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jAccessoriesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jAddButton))
                    .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jAccessoriesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jAddButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCancelButton)
                    .addComponent(jPurchaseButton)
                    .addComponent(jTotalPriceLabel)
                    .addComponent(jPriceResultLabel))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }

    private void jAddButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    /**
     * @param args the command line arguments
     */
    public  void launchAccessoriesUI() {
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
       //     java.util.logging.Logger.getLogger(AccessoriesUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
        //    java.util.logging.Logger.getLogger(AccessoriesUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
         //   java.util.logging.Logger.getLogger(AccessoriesUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
          //  java.util.logging.Logger.getLogger(AccessoriesUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
     //    Create and display the form 
     /*   java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AccessoriesUI().setVisible(true);
            }
        });*/
    }

    // Variables declaration
    private javax.swing.JButton jCancelButton;
    private javax.swing.JButton jAddButton;
    private javax.swing.JButton jPurchaseButton;
    private javax.swing.JLabel jAccessoriesLabel;
    private javax.swing.JLabel jTotalPriceLabel;
    private javax.swing.JLabel jPriceResultLabel;
    private javax.swing.JList<String> jAccessoriesList;
    private javax.swing.JScrollPane jScrollPane;
}