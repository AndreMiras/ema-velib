/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AdministrationBornePanel.java
 *
 * Created on 17 mars 2011, 20:34:05
 */

package velib.view;

/**
 *
 * @author G
 */
public class AdministrationBornePanel extends javax.swing.JPanel {

    /** Creates new form AdministrationBornePanel */
    public AdministrationBornePanel() {
        initComponents();
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
        AddBorneButton = new javax.swing.JToggleButton();
        NomBorneTextField = new javax.swing.JTextField();
        IDBorneTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        PositionXBorneTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        PositionYBorneTextField = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        PositionYBornetteTextField = new javax.swing.JTextField();
        AddBornetteButton = new javax.swing.JToggleButton();
        PositionXBornetteTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        IDBornetteTextField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        IDBorneBornetteTextField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        IDBorneConnectionTextField = new javax.swing.JTextField();
        ConnectBorneButton = new javax.swing.JToggleButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Ajouter une borne"));

        AddBorneButton.setText("Ajouter");
        AddBorneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddBorneButtonActionPerformed(evt);
            }
        });

        NomBorneTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NomBorneTextFieldActionPerformed(evt);
            }
        });

        IDBorneTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDBorneTextFieldActionPerformed(evt);
            }
        });

        jLabel1.setText("Nom de la borne");

        jLabel2.setText("ID de la borne");

        jLabel3.setText("Position X");

        PositionXBorneTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PositionXBorneTextFieldActionPerformed(evt);
            }
        });

        jLabel4.setText("Position Y");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel3)
                        .addComponent(jLabel1)
                        .addComponent(NomBorneTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addComponent(IDBorneTextField)
                        .addComponent(PositionXBorneTextField)
                        .addComponent(jLabel4)
                        .addComponent(PositionYBorneTextField))
                    .addComponent(AddBorneButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NomBorneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(IDBorneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PositionXBorneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PositionYBorneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(AddBorneButton))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Ajouter une bornette"));

        AddBornetteButton.setText("Ajouter");
        AddBornetteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddBornetteButtonActionPerformed(evt);
            }
        });

        PositionXBornetteTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PositionXBornetteTextFieldActionPerformed(evt);
            }
        });

        jLabel5.setText("Position Y");

        jLabel6.setText("ID de la bornette");

        jLabel7.setText("Position X");

        IDBornetteTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDBornetteTextFieldActionPerformed(evt);
            }
        });

        jLabel9.setText("ID de la borne parent");

        IDBorneBornetteTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDBorneBornetteTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PositionXBornetteTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                    .addComponent(IDBornetteTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                    .addComponent(IDBorneBornetteTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AddBornetteButton, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PositionYBornetteTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(IDBorneBornetteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(IDBornetteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PositionXBornetteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PositionYBornetteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(AddBornetteButton))
        );

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Ajout de Bornes \\ Bornettes");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Se connecter comme borne"));

        jLabel10.setText("ID de la borne");

        IDBorneConnectionTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDBorneConnectionTextFieldActionPerformed(evt);
            }
        });

        ConnectBorneButton.setText("Se connecter");
        ConnectBorneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConnectBorneButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(IDBorneConnectionTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(jLabel10)
                    .addComponent(ConnectBorneButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(256, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(IDBorneConnectionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ConnectBorneButton)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(jLabel8))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel8)
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void AddBorneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddBorneButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddBorneButtonActionPerformed

    private void NomBorneTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NomBorneTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NomBorneTextFieldActionPerformed

    private void IDBorneTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDBorneTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IDBorneTextFieldActionPerformed

    private void AddBornetteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddBornetteButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddBornetteButtonActionPerformed

    private void IDBornetteTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDBornetteTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IDBornetteTextFieldActionPerformed

    private void PositionXBorneTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PositionXBorneTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PositionXBorneTextFieldActionPerformed

    private void PositionXBornetteTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PositionXBornetteTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PositionXBornetteTextFieldActionPerformed

    private void IDBorneBornetteTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDBorneBornetteTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IDBorneBornetteTextFieldActionPerformed

    private void IDBorneConnectionTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDBorneConnectionTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IDBorneConnectionTextFieldActionPerformed

    private void ConnectBorneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConnectBorneButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ConnectBorneButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton AddBorneButton;
    private javax.swing.JToggleButton AddBornetteButton;
    private javax.swing.JToggleButton ConnectBorneButton;
    private javax.swing.JTextField IDBorneBornetteTextField;
    private javax.swing.JTextField IDBorneConnectionTextField;
    private javax.swing.JTextField IDBorneTextField;
    private javax.swing.JTextField IDBornetteTextField;
    private javax.swing.JTextField NomBorneTextField;
    private javax.swing.JTextField PositionXBorneTextField;
    private javax.swing.JTextField PositionXBornetteTextField;
    private javax.swing.JTextField PositionYBorneTextField;
    private javax.swing.JTextField PositionYBornetteTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables

}
