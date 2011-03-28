/*
 * UsersControlFrame.java
 *
 * Created on 20 mars 2011, 12:32:17
 */

package velib.view;

import velib.model.Location;
/**
 *
 * @author G
 */
public class UsersControlFrame extends javax.swing.JFrame
{
    private Location[] locations;
    private velib.view.UsersControlFrame usersControlFrame;
    /** Creates new form UsersControlFrame */
    public UsersControlFrame()
    {
        initComponents();
    }

    public UsersControlFrame(Location[] locations)
    {
        this();
        this.locations = locations;
        fillUpJList();  //On rempli les éléments de la page
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */

    public UsersControlFrame getUsersControlFrame()
    {
        return usersControlFrame;
    }

    //On rempli la liste avec les utilisateurs ayant le statut actif (location en cours)
    private void fillUpJList()
    {
        usersjList.setModel(new javax.swing.AbstractListModel()
        {
            public int getSize() { return locations.length; }
            public Object getElementAt(int i) { return locations[i]; }
        });
        jScrollPane1.setViewportView(usersjList);
    }
    //On affiche le tout dans le tableau (jList)
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Title = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        usersjList = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        Title.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Title.setText("Liste des utilisateurs actifs");

        usersjList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Aucun utilisateur actif actuellement" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(usersjList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
                    .addComponent(Title))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Title)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * @param args the command line arguments
    */
    public static void main(String args[])
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new UsersControlFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Title;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList usersjList;
    // End of variables declaration//GEN-END:variables

}
