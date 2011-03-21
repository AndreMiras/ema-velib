/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * UsersControlFrame.java
 *
 * Created on 20 mars 2011, 12:32:17
 */

package velib.view;

import javax.swing.JList;
import javax.swing.JTextArea;
import velib.dao.LocationDAO;
import velib.model.Location;
/**
 *
 * @author G
 */
public class UsersControlFrame extends javax.swing.JFrame
{
    LocationDAO locationDAO = new LocationDAO();
    private Location[] location;

    /** Creates new form UsersControlFrame */
    public UsersControlFrame()
    {
        initComponents();

        // TODO: this shouldn't be done in  the view but in the controller
        location = locationDAO.findAllLocation();
        setUpUsersControlFrame();
        fillUpJList();
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

     // Fills the combo box with bornes objects
    private void setUpUsersControlFrame()
    {
        System.out.println("Taille du tableau : " + location.length);
        for (int i=0; i<location.length; i++)
        {
            String nomClient = location[i].getClient().getFullName();
            Long idVelo = location[i].getVelo().getId();
            String ClientEtVelo = nomClient+" utilise vélo: "+ idVelo+"\n" ;
            System.out.println(i);
        }
    }

    private void fillUpJList()
    {
        // polygonsScrollPane

        jList1.setModel(new javax.swing.AbstractListModel() {
            // model.Polygon[] polygons = model.getPolygons();
            public int getSize() { return location.length; }
            public Object getElementAt(int i) { return location[i]; }
        });
        jScrollPane1.setViewportView(jList1);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Title = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        Title.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Title.setText("Liste des utilisateurs actifs");

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Title)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(Title)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(304, Short.MAX_VALUE))
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

    private velib.view.UsersControlFrame usersControlFrame;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Title;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
