package velib.view;

import velib.model.Client;
import velib.model.Location;

public class ShowActivitiesClientFrame extends javax.swing.JFrame {

    Client client;
    Location[] locations;
    /** Creates new form ShowActivitiesClientFrame */
    public ShowActivitiesClientFrame()
    {
        initComponents();
    }

    public ShowActivitiesClientFrame(Client client, Location[] locations)
    {
        this();
        this.client = client;
        this.locations=locations;
        setUpNameClient();
        fillUpJList();
        //On apelle les fonctions de remplissage des divers menu et tableaux de la frame
    }

    public void setUpNameClient()
    {
        fullNameLabel.setText(client.getFullName());
    }

    // Rempli le tableau avec l'historique des locations
    private void fillUpJList()
    {
        locationjList.setModel(new javax.swing.AbstractListModel()
        {
            public int getSize() { return locations.length; }
            public Object getElementAt(int i) { return locations[i]; }
        });
        jScrollPane1.setViewportView(locationjList); // On affiche le tout dans le tableau
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TitleLabel = new java.awt.Label();
        fullNameLabel = new java.awt.Label();
        jScrollPane1 = new javax.swing.JScrollPane();
        locationjList = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        TitleLabel.setFont(new java.awt.Font("Dialog", 0, 14));
        TitleLabel.setText("Historique des locations de : ");

        fullNameLabel.setText("nom/prenom");

        locationjList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Aucun historique à afficher..." };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(locationjList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(TitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fullNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fullNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ShowActivitiesClientFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Label TitleLabel;
    private java.awt.Label fullNameLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList locationjList;
    // End of variables declaration//GEN-END:variables

}
