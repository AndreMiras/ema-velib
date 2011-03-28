package velib.view;

import java.awt.event.ActionListener;
import velib.model.Velo;

public class CheckDefectsFrame extends javax.swing.JFrame
{
    private Velo[] velos;
    private velib.view.CheckDefectsFrame checkDefectsFrame;
    Long idVelo;

    /** Creates new form CheckDefectsFrame */
    public CheckDefectsFrame()
    {
        initComponents();
    }

    public CheckDefectsFrame(Velo[] velos)
    {
        this();
        this.velos = velos;
        fillUpJList();                  // Fonction de remplissage de tableau et liste
    }

    public CheckDefectsFrame getCheckDefectsFrame()
    {
        return checkDefectsFrame;
    }

    public void addActivateButtonButtonListener(ActionListener al)
    {
        activateButton.addActionListener(al);
    }

    public void fillUpJList()
    {
        jScrollPane1.setViewportView(null); //Nettoyage du tableau avant nouvelle insertion
        defectBikejList.setModel(new javax.swing.AbstractListModel() // On construit le conteneur
        {
            public int getSize() { return velos.length; }           //On compte le nombre d'éléments
            public Object getElementAt(int i) { return velos[i]; }  //On reécupère les éléments
        });
        jScrollPane1.setViewportView(defectBikejList);              //On insère le tout dans le tableau


        defectListjComboBox.removeAllItems();   //Nettoyage de la liste avant nouvelle insertion
        for (int i=0; i<velos.length; i++)      //On insère les éléments dans la liste
        {
            defectListjComboBox.addItem(velos[i].getId());
        }
    }

    public Long getIDVeloFromInput()
    {

        idVelo = (Long) defectListjComboBox.getSelectedItem();  //On récupère l'élément sélectionné dans le menu déroulant
        return idVelo;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        defectBikejList = new javax.swing.JList();
        Title = new javax.swing.JLabel();
        defectListjComboBox = new javax.swing.JComboBox();
        activateButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        defectBikejList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Aucun problème actuellement déclaré" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(defectBikejList);

        Title.setFont(new java.awt.Font("Tahoma", 0, 14));
        Title.setText("Liste des vélos ayant le statut \"Problème déclaré\"");

        activateButton.setText("Activer");

        jLabel1.setText("Pour remettre un vélo en service, sélectionnez le dans la liste ci-dessous, puis cliquez sur activer :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Title)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(defectListjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(activateButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Title)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(defectListjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(activateButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[])
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new CheckDefectsFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Title;
    private javax.swing.JButton activateButton;
    private javax.swing.JList defectBikejList;
    private javax.swing.JComboBox defectListjComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
