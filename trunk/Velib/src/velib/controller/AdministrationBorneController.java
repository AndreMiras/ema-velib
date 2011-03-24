/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import velib.dao.BorneSingleton;
import velib.dao.BornesDAO;
import velib.model.Borne;
import velib.model.Bornette;
import velib.dao.BornetteDAO;
import velib.dao.VeloDAO;
import velib.model.Velo;
import velib.view.MainWindowFrame;

import velib.view.AdministrationBorneFrame;

/**
 *
 * @author G
 */
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
        this.administrationBorneFrame = administrationBorneFrame;
        addListeners();
    }

    private void addListeners()
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
        }
    }

    class AddBorneButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            
            String nomBorne = administrationBorneFrame.getBorneNameTextField().getText();
            Double latitude = new Double(
                    administrationBorneFrame.getBorneXPosTextField().getText());
            Double longitude = new Double(
                    administrationBorneFrame.getBorneYPosTextField().getText());

            borne = new Borne(0, nomBorne);
            borne.setLatitude(latitude);
            borne.setLongitude(longitude);

            borne = borneDAO.create(borne);
        }
    }
    class AddBornetteButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {

            Long idBorne = administrationBorneFrame.getBorneFromInput();
            bornettes = bornetteDAO.findAll(idBorne);
            borne = borneDAO.find(idBorne);
            
            long numero = bornettes.length+1;

            bornette = new Bornette(0, numero, borne, null);

            bornette = bornetteDAO.create(bornette);


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

            Long idBornette = administrationBorneFrame.getBornetteFromInput();
            System.out.println(idBornette);
            bornette = bornetteDAO.find(idBornette);
            bornette.setVelo(velo);
            
            bornette = bornetteDAO.update(bornette);            

        }
    }
}
