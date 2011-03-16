/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DatabaseManagementFrame.java
 *
 * Created on Mar 14, 2011, 6:30:05 PM
 */

package velib.view;

import java.awt.event.ActionListener;

/**
 *
 * @author andre
 */
public class DatabaseManagementFrame extends javax.swing.JFrame {

    /** Creates new form DatabaseManagementFrame */
    public DatabaseManagementFrame() {
        initComponents();
    }


    public void addCreateDatabaseButtonListener(ActionListener al)
    {
        createDatabaseButton.addActionListener(al);
    }

    public void addDropDatabaseButtonListener(ActionListener al)
    {
        dropDatabaseButton.addActionListener(al);
    }

    public void addCreateTablesButtonListener(ActionListener al)
    {
        createTablesButton.addActionListener(al);
    }

    public void addDropTablesButtonListener(ActionListener al)
    {
        dropTablesButton.addActionListener(al);
    }

    public void addInsertTablesDataButtonListener(ActionListener al)
    {
        insertDataButton.addActionListener(al);
    }


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        createDatabaseButton = new javax.swing.JButton();
        dropDatabaseButton = new javax.swing.JButton();
        createTablesButton = new javax.swing.JButton();
        dropTablesButton = new javax.swing.JButton();
        insertDataButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Database Management");

        createDatabaseButton.setText("Create DB");

        dropDatabaseButton.setText("Drop DB");

        createTablesButton.setText("Create Tables");

        dropTablesButton.setText("Drop Tables");

        insertDataButton.setText("Insert Data");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(insertDataButton)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(dropDatabaseButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dropTablesButton))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(createDatabaseButton)
                            .addGap(62, 62, 62)
                            .addComponent(createTablesButton))))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createDatabaseButton)
                    .addComponent(createTablesButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dropDatabaseButton)
                    .addComponent(dropTablesButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(insertDataButton)
                .addContainerGap(113, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DatabaseManagementFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createDatabaseButton;
    private javax.swing.JButton createTablesButton;
    private javax.swing.JButton dropDatabaseButton;
    private javax.swing.JButton dropTablesButton;
    private javax.swing.JButton insertDataButton;
    // End of variables declaration//GEN-END:variables

}
