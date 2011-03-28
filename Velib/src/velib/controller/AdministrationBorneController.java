
package velib.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import velib.dao.BornesDAO;
import velib.model.Borne;
import velib.model.Bornette;
import velib.dao.BornetteDAO;
import velib.dao.VeloDAO;
import velib.model.Velo;
import velib.view.AdministrationBorneFrame;

class AdministrationBorneController
{
    Bornette [] bornettes;
    Bornette bornette;
    Borne borne;
    Velo velo;
    BornetteDAO bornetteDAO = new BornetteDAO();
    BornesDAO borneDAO = new BornesDAO();

    private AdministrationBorneFrame administrationBorneFrame;

    public AdministrationBorneController(AdministrationBorneFrame administrationBorneFrame)
    {
        this.administrationBorneFrame = administrationBorneFrame; //On déclare la Frame à utiliser
        addListeners();
    }

    private void addListeners() //On déclare les écouteurs (pour les actions réalisés sur la frame)
    {
        administrationBorneFrame.addAddBikeButtonListener(
                new AddBikeButtonListener());
        administrationBorneFrame.addBorneListe2jComboBoxListener(
                new BorneListe2jComboBoxListener());
        administrationBorneFrame.addAddBornetteButtonListener(
                new AddBornetteButtonListener());
        administrationBorneFrame.addAddBorneButtonListener(
                new AddBorneButtonListener());
    }

    class BorneListe2jComboBoxListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            administrationBorneFrame.setUpAdministrationBornetteFrame();
            //Si la valeur du menu déroulant bornette est modifié alors on charge le contenu correspondant dans le second menu déroulant.
        }
    }

    class AddBorneButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {        
            String nomBorne = administrationBorneFrame.getBorneNameTextField().getText();
            // On récupere le nom que l'on souhaite donner à la borne dans le champ nom
            Double latitude = new Double(
                    administrationBorneFrame.getBorneXPosTextField().getText());
            //On récupère la lattitude
            Double longitude = new Double(
                    administrationBorneFrame.getBorneYPosTextField().getText());
            //On récupère la longitude

            borne = new Borne(0, nomBorne);
            borne.setLatitude(latitude);
            borne.setLongitude(longitude);
            borne = borneDAO.create(borne);
            //On crée la borne avec les parametres du dessus, puis on l'integre à la BDD
        }
    }
    class AddBornetteButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            Long idBorne = administrationBorneFrame.getBorneFromInput();
            bornettes = bornetteDAO.findAll(idBorne);
            borne = borneDAO.find(idBorne);
            //On cherche la borne ayant l'ID affichée dans le menu déroulant.
            
            long numero = bornettes.length+1; //On compte le nb de bornettes et on fait +1 pour la nouvelle
            bornette = new Bornette(0, numero, borne, null);
            bornette = bornetteDAO.create(bornette);
            //On crée la bornette, on lui affecte une borne parent, puis on l'enregistre dans la BDD.
        }
    }
   
    class AddBikeButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            velo = new Velo (0, true);
            VeloDAO veloDAO = new VeloDAO();
            BornetteDAO bornetteDAO = new BornetteDAO();
            velo = veloDAO.create(velo);
            //On crée un vélo fonctionnel (true).
            Long idBornette = administrationBorneFrame.getBornetteFromInput();
            bornette = bornetteDAO.find(idBornette);    //On cherhce la bornette correpondante.
            bornette.setVelo(velo);     //On acroche le vélo à la bornette sélectionnée
            bornette = bornetteDAO.update(bornette);  //Dans la BDD
        }
    }
}
