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

    private void addListeners() //On declare les écouteurs
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

            /*On crée deux bornes, la premiere affectée au démarrage sera
             déclarée comme libre si changement fait (ID disponible),
             la nouvelle borne avec l'ID sélectionné est déclarée comme occupée*/
            oldBorne = BorneSingleton.getInstance();
            newBorne = dBConnectionPanel.getBorneFromInput();
            System.out.println("Setting new borne singleton to: "
                    + newBorne);
            BorneSingleton.setBorne(newBorne);

            /* On met à jour les bornes dans la BDD (ID utilisés ou libres)*/
            oldBorne.setDisponible(true);
            newBorne.setDisponible(false);
            bornesDAO.update(oldBorne);
            bornesDAO.update(newBorne);
        }
    }
}

