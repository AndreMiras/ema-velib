/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ChoixIdenticationPanel.java
 *
 * Created on Mar 16, 2011, 12:53:32 PM
 */

package velib.view;

import java.awt.event.ActionListener;
import velib.model.Client;
import velib.model.User;

/**
 *
 * @author andre
 */
public class LoggedInWelcomePanel extends javax.swing.JPanel
{
    private Client client;

    /** Creates new form ChoixIdenticationPanel */
    public LoggedInWelcomePanel() {
        initComponents();
    }

    public LoggedInWelcomePanel(Client client)
    {
        this();
        this.client = client;


        setUpLoggedInWelcomePanel();
    }

    public void addLouerUnVeloButtonListener(ActionListener al)
    {
        this.louerVeloButton.addActionListener(al);
    }

    public void addRestituerUnVeloButtonListener(ActionListener al)
    {
        this.restituerVeloButton.addActionListener(al);
    }

    public void addRechargerButtonListener(ActionListener al)
    {
        this.rechargerButton.addActionListener(al);
    }

    /*
     * Setup the window based on user model values
     */
    private void setUpLoggedInWelcomePanel()
    {
        fullNameLabel.setText(client.getFullName());
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        fullNameLabel = new javax.swing.JLabel();
        rechargerButton = new javax.swing.JButton();
        restituerVeloButton = new javax.swing.JButton();
        louerVeloButton = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(0, 0));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Possibilités", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(0, 0, 0))); // NOI18N

        jLabel1.setText("Bonjour");

        jLabel2.setText("Il vous est possible de :");

        jLabel3.setText("Louer un velo");

        jLabel4.setText("Restituer un velo");

        jLabel5.setText("Recharger votre abonnement");

        fullNameLabel.setText("FullName");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fullNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(fullNameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        rechargerButton.setText("Recharger");

        restituerVeloButton.setText("Restituer un velo");

        louerVeloButton.setText("Louer un velo");
        louerVeloButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                louerVeloButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(restituerVeloButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(louerVeloButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rechargerButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(louerVeloButton)
                        .addGap(18, 18, 18)
                        .addComponent(restituerVeloButton)
                        .addGap(18, 18, 18)
                        .addComponent(rechargerButton)
                        .addGap(180, 180, 180))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void louerVeloButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_louerVeloButtonActionPerformed
    {//GEN-HEADEREND:event_louerVeloButtonActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_louerVeloButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fullNameLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton louerVeloButton;
    private javax.swing.JButton rechargerButton;
    private javax.swing.JButton restituerVeloButton;
    // End of variables declaration//GEN-END:variables

}
