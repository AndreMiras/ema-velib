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
import velib.view.DBConnectionFrame;
import velib.view.MainWindowFrame;

/**
 *
 * @author G
 */
public class DBConnectionController
{
    private DBConnectionFrame dBConnectionPanel;

    public DBConnectionController(DBConnectionFrame dBConnectionPanel)
    {
        this.dBConnectionPanel = dBConnectionPanel;
        addListeners();
    }

    private void addListeners()
    {
        dBConnectionPanel.addConnexionButtonListener(
                new ConnexionButtonListener());
    }

    class ConnexionButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            Borne oldBorne, newBorne;
            BornesDAO bornesDAO = new BornesDAO();

            oldBorne = BorneSingleton.getInstance();
            newBorne = dBConnectionPanel.getBorneFromInput();
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

