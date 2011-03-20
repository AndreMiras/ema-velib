/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import velib.dao.BorneSingleton;
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
            Borne borne;
            borne = dBConnectionPanel.getBorneFromInput();
            System.out.println("Setting new borne singleton to: "
                    + borne);
            BorneSingleton.setBorne(borne);
        }
    }
}

