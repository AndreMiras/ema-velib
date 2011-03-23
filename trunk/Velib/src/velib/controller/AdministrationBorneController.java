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
import velib.view.MainWindowFrame;

import velib.view.AdministrationBorneFrame;

/**
 *
 * @author G
 */
class AdministrationBorneController
{

    private AdministrationBorneFrame administrationBorneFrame;

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
