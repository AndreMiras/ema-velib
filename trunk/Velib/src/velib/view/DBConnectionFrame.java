/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DBConnexionPanel.java
 *
 * Created on 18 mars 2011, 17:50:12
 */

package velib.view;

import javax.swing.JComboBox;
import velib.model.Borne;

/**
 *
 * @author G
 */
public class DBConnectionFrame extends javax.swing.JFrame
{
    private Borne[] bornes;

    /** Creates new form DBConnexionPanel */
    public DBConnectionFrame()
    {
        initComponents();
    }

    public DBConnectionFrame(Borne[] bornes)
    {
        this();
        this.bornes = bornes;
        /*TODO make this shit work
        listeBorneComboBox = new javax.swing.JComboBox(bornes);
        listeBorneComboBox.setSelectedIndex(4);
        listeBorneComboBox.addActionListener(this);
        */
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        listeBorneComboBox = new javax.swing.JComboBox();
        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();

        listeBorneComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Choisissez un ID" }));

        jToggleButton1.setText("Connexion");

        jLabel1.setText("Authentification Interface");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(listeBorneComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jToggleButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(listeBorneComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToggleButton1)
                .addContainerGap(28, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JComboBox listeBorneComboBox;
    // End of variables declaration//GEN-END:variables

}
