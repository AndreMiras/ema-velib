/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import velib.dao.BorneSingleton;
import velib.dao.BornetteDAO;
import velib.dao.LocationDAO;
import velib.model.Bornette;
import velib.model.Client;
import velib.model.IModel;
import velib.model.Location;
import velib.model.Velo;
import velib.view.LoggedInWelcomePanel;
import velib.view.LouerVeloPanel;
import velib.view.MainWindowFrame;
import velib.view.RestituerVeloPanel;

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
        loggedInWelcomePanel.addRestituerUnVeloButtonListener(
            new RestituerUnVeloButtonListener());
        // view.addRechagerButtonListener(new TODO());

    }

    class LouerUnVeloButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            long idBorne = BorneSingleton.getInstance().getIdBorne();

            BornetteDAO bornetteDAO = new BornetteDAO();
            Bornette bornette = bornetteDAO.findOccupe(new Long(14));
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

    /*
     * Put the velo back to the stand by setting stand->velo = velo
     */
    class RestituerUnVeloButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            Bornette bornette;
            Velo bike;
            Location location;
            LocationDAO locationDAO = new LocationDAO();
            BornetteDAO bornetteDAO = new BornetteDAO();
            
            location = locationDAO.find(client);
            bike = location.getVelo();
            bornette = bornetteDAO.findLibre(
                    BorneSingleton.getInstance().getIdBorne());
            // attaching the bike to the stand
            bornette.setVelo(bike);
            // hitting the database
            bornetteDAO.update(bornette);
            

            // TODO: screen when given bike back
            RestituerVeloPanel restituerVeloPanel =
                    new RestituerVeloPanel(client, bornette);
            RestituerVeloController restituerVeloController =
                    new RestituerVeloController(
                    mainWindowFrame, restituerVeloPanel, client);
            mainWindowFrame.setContentPanel(restituerVeloPanel);
           
        }
    }


}
