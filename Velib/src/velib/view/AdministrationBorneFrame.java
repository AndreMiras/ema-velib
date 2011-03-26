/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.view;

import java.awt.event.ActionListener;
import javax.swing.JTextField;
import velib.dao.BornetteDAO;
import velib.model.Borne;
import velib.model.Bornette;
/**
 *
 * @author G
 */
public class AdministrationBorneFrame extends javax.swing.JFrame
{
    private velib.view.AdministrationBorneFrame administrationBorneFrame;
    private Borne[] bornes;
    private Bornette[] bornettes;
    long idBORNE;
    BornetteDAO bornetteDAO = new BornetteDAO();

    /** Creates new form AdministrationBorneFrame */
    public AdministrationBorneFrame()
    {
        initComponents();
    }

    public AdministrationBorneFrame(Borne[] bornes)
    {
        this();
        this.bornes = bornes;
        setUpAdministrationBorneFrame();    //On rempli les menus lors de l'ouverture de la page.
    }

    public AdministrationBorneFrame getAdministrationBorneFrame()
    {
        return administrationBorneFrame;
    }

    //On rempli le menu déroulant avec les ID des différentes bornes
    private void setUpAdministrationBorneFrame()
    {
        for (int i=0; i<bornes.length; i++)
        {
            borneListejComboBox.addItem(bornes[i].getIdBorne()); //Menu déroulant 1
            borneListe2jComboBox.addItem(bornes[i].getIdBorne()); //Menu déroulant 2
        }
    }

    public void setUpAdministrationBornetteFrame()
    {
        idBORNE = (Long) borneListe2jComboBox.getSelectedItem(); //ON récupere les ID affichés dans la liste
        bornettes = bornetteDAO.findLibreAll(idBORNE); //On récupere les ID des bornes libres

        bornetteListjComboBox.removeAllItems(); //Nettoyage de la liste avant nouvelle insertion
        for (int i=0; i<bornettes.length; i++)
        {
            bornetteListjComboBox.addItem(bornettes[i].getId());
            //On affiche la liste des bornettes correspondantes à la borne du menu ci-dessus
        }
    }

    public void addAddBornetteButtonListener(ActionListener al)
    {
        addBornetteButton.addActionListener(al);
    }

    public void addAddBorneButtonListener(ActionListener al)
    {
        addBorneButton.addActionListener(al);
    }

    public void addAddBikeButtonListener(ActionListener al)
    {
        addBikeButton.addActionListener(al);
    }

    public void addBorneListe2jComboBoxListener(ActionListener al)
    {
        borneListe2jComboBox.addActionListener(al);
    }

    public Long getBorneFromInput() //Récuperation des valeurs du menu déroulant
    {
        Long selectedBorne;
        selectedBorne = (Long)borneListejComboBox.getSelectedItem();
        return selectedBorne;
    }

    public Long getBornetteFromInput() //Récuperation des valeurs du menu déroulant
    {
        Long selectedBornette;
        selectedBornette = (Long) bornetteListjComboBox.getSelectedItem();
        return selectedBornette;
    }

    public JTextField getBorneNameTextField() //Récuperation de la valeur dans le champ de saisie
    {
        return BorneNameTextField;
    }

    public JTextField getBorneXPosTextField() //Récuperation de la valeur dans le champ de saisie
    {
        return BorneXPosTextField;
    }

    public JTextField getBorneYPosTextField() //Récuperation de la valeur dans le champ de saisie
    {
        return BorneYPosTextField;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        BorneNameTextField = new javax.swing.JTextField();
        BorneXPosTextField = new javax.swing.JTextField();
        BorneYPosTextField = new javax.swing.JTextField();
        addBorneButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        addBornetteButton = new javax.swing.JButton();
        borneListejComboBox = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        addBikeButton = new javax.swing.JButton();
        bornetteListjComboBox = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        borneListe2jComboBox = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Ajouter une Borne"));

        jLabel1.setText("Nom de la Borne");

        jLabel3.setText("Lattitude");

        jLabel4.setText("Longitude");

        addBorneButton.setText("Ajouter");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(BorneYPosTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE))
                    .addComponent(BorneNameTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                    .addComponent(BorneXPosTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                    .addComponent(addBorneButton))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BorneNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BorneXPosTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BorneYPosTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addBorneButton, javax.swing.GroupLayout.PREFERRED_SIZE, 22, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Ajouter une bornette"));

        jLabel6.setText("ID de la Borne parent");

        addBornetteButton.setText("Ajouter");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(borneListejComboBox, 0, 150, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE))
                    .addComponent(addBornetteButton))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(borneListejComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addBornetteButton)
                .addContainerGap(126, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Ajouter un vélo"));

        addBikeButton.setText("Ajouter");

        jLabel7.setText("ID de la Bornette parent");

        jLabel8.setText("ID de la Borne parent");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(borneListe2jComboBox, 0, 152, Short.MAX_VALUE)
                    .addComponent(bornetteListjComboBox, 0, 152, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE))
                    .addComponent(addBikeButton))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(borneListe2jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bornetteListjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addBikeButton)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel9.setText("Ajout de Bornes / Bornettes / Vélos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addComponent(jLabel9)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGap(102, 102, 102)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                new AdministrationBorneFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField BorneNameTextField;
    private javax.swing.JTextField BorneXPosTextField;
    private javax.swing.JTextField BorneYPosTextField;
    private javax.swing.JButton addBikeButton;
    private javax.swing.JButton addBorneButton;
    private javax.swing.JButton addBornetteButton;
    private javax.swing.JComboBox borneListe2jComboBox;
    private javax.swing.JComboBox borneListejComboBox;
    private javax.swing.JComboBox bornetteListjComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
