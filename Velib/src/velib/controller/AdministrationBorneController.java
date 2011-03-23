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
import velib.view.MainWindowFrame;

import velib.view.AdministrationBorneFrame;

/**
 *
 * @author G
 */
class AdministrationBorneController
{

    private AdministrationBorneFrame administrationBorneFrame;
    private BornetteDAO bornetteDAO;

    public AdministrationBorneController(AdministrationBorneFrame administrationBorneFrame)
    {
        this.administrationBorneFrame = administrationBorneFrame;
        addListeners();
    }

    private void addListeners()
    {
        administrationBorneFrame.addAddBornetteButtonListener(
                new AddBornetteButtonListener());
    }
/*
        class GeneralManagementButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {

            borneDAO = new BornesDAO();
            Borne[] bornes;
            bornes = borneDAO.findAllBorne();
            bornetteDAO = new BornetteDAO();
            Bornette[] bornettes;
            //bornettes = bornetteDAO.findLibre(BorneSingleton.);
            administrationBorneFrame = new AdministrationBorneFrame(bornes, bornettes);
            administrationBorneController = new AdministrationBorneController(administrationBorneFrame);
            administrationBorneFrame.setVisible(true);
        }
    }

    */
    
    class AddBornetteButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            Borne oldBorne, newBorne;
            BornesDAO bornesDAO = new BornesDAO();

            oldBorne = BorneSingleton.getInstance();
            newBorne = administrationBorneFrame.getBorneFromInput();
            System.out.println("Setting new borne singleton to: "
                    + newBorne);
            BorneSingleton.setBorne(newBorne);

            /* updating the station, setting it up to used in the DB */
            oldBorne.setDisponible(true);
            newBorne.setDisponible(false);
            bornesDAO.update(oldBorne);
            bornesDAO.update(newBorne);
        }
    }
}
