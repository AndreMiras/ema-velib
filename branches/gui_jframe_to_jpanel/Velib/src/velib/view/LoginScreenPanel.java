/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * LoginScreenPanel.java
 *
 * Created on Mar 15, 2011, 7:33:43 PM
 */

package velib.view;

import java.awt.event.ActionListener;

/**
 *
 * @author andre
 */
public class LoginScreenPanel extends javax.swing.JPanel {

    /** Creates new form LoginScreenPanel */
    public LoginScreenPanel() {
        initComponents();
    }


    public void addValiderButtonListener(ActionListener al)
    {
        this.validerButton.addActionListener(al);
    }


    public String getIdentifyTextField()
    {
        return identifyTextField.getText();
    }

    public void loginErrorPopup()
    {
        System.out.println("TODO: error popup, wrong login");
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        identifyTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        validerButton = new javax.swing.JButton();

        identifyTextField.setText("Identifiant");

        jLabel1.setText("Veuillez saisir votre identifiant pour accéder à votre compte.");

        validerButton.setText("Valider");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(identifyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(validerButton)
                .addContainerGap(262, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(identifyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(validerButton)
                .addContainerGap(88, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField identifyTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton validerButton;
    // End of variables declaration//GEN-END:variables

}