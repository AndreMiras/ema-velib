/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * WelcomeScreenPanel.java
 *
 * Created on Mar 15, 2011, 5:03:52 PM
 */

package velib.view;

import java.awt.event.ActionListener;

/**
 *
 * @author andre
 */
public class WelcomeScreenPanel extends javax.swing.JPanel {

    /** Creates new form WelcomeScreenPanel */
    public WelcomeScreenPanel() {
        initComponents();
    }



    public void addIdentifierButtonListener(ActionListener al)
    {
        identifierButton.addActionListener(al);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        abonnerButton = new javax.swing.JButton();
        identifierButton = new javax.swing.JButton();
        aideButton = new javax.swing.JButton();

        abonnerButton.setText("S'abonner");

        identifierButton.setText("S'identifier");

        aideButton.setText("Aide");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(identifierButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(aideButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(abonnerButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(276, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(abonnerButton)
                .addGap(18, 18, 18)
                .addComponent(identifierButton)
                .addGap(18, 18, 18)
                .addComponent(aideButton)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton abonnerButton;
    private javax.swing.JButton aideButton;
    private javax.swing.JButton identifierButton;
    // End of variables declaration//GEN-END:variables

}