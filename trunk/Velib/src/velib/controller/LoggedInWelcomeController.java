/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import velib.dao.BorneSingleton;
import velib.dao.BornetteDAO;
import velib.model.Bornette;
import velib.model.Client;
import velib.model.IModel;
import velib.view.LoggedInWelcomePanel;
import velib.view.LouerVeloPanel;
import velib.view.MainWindowFrame;

/**
 *
 * @author andre
 */
class LoggedInWelcomeController extends AbstractController
{

    private Client client ;
    private LoggedInWelcomePanel loggedInWelcomePanel;

    public LoggedInWelcomeController(
            MainWindowFrame mainWindowFrame, Client client,
            LoggedInWelcomePanel loggedInWelcomePanel)
    {
        super(mainWindowFrame);
        this.client = client;
        this.loggedInWelcomePanel = loggedInWelcomePanel;

        addListeners();
    }

    private void addListeners()
    {
        loggedInWelcomePanel.addLouerUnVeloButtonListener(
                new LouerUnVeloButtonListener());
        // loggedInWelcomePanel.addRestituerUnVeloButtonListener(
        //         new RestituerUnVeloButtonListener());
        // view.addRechagerButtonListener(new TODO());

    }

    class LouerUnVeloButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            long idBorne = BorneSingleton.getInstance().getIdBorne();

            BornetteDAO bornetteDAO = new BornetteDAO();
            Bornette bornette = bornetteDAO.findOccupe(idBorne);
            // TODO: does it really need to be kept as a private attribute?
            // This might just be a pop up dialog rather than an actual
            // panel plus its dedicated controller
            LouerVeloPanel louerVeloPanel =
                    new LouerVeloPanel(client, bornette);
            LouerVeloController louerVeloController =
                    new LouerVeloController(
                    mainWindowFrame, client, bornette, louerVeloPanel);
            mainWindowFrame.setContentPanel(louerVeloPanel);
        }
    }


}
