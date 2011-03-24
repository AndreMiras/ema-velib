/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import velib.dao.BorneSingleton;
import velib.dao.BornetteDAO;
import velib.dao.LocationDAO;
import velib.model.Bornette;
import velib.model.Client;
import velib.model.Location;
import velib.model.Velo;
import velib.view.LoggedInWelcomePanel;
import velib.view.LouerVeloPanel;
import velib.view.RestituerVeloPanel;

/**
 *
 * @author andre
 */
class LoggedInWelcomeController extends AbstractMainWindowController
{

    private Client client ;
    private LoggedInWelcomePanel loggedInWelcomePanel;

    public LoggedInWelcomeController(
            MainWindowController mainWindowController, Client client,
            LoggedInWelcomePanel loggedInWelcomePanel)
    {
        super(mainWindowController);
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
            Location location;
            Bornette[] bornettesOccupe;

            BornetteDAO bornetteDAO = new BornetteDAO();
            LocationDAO locationDAO = new LocationDAO();
            bornettesOccupe = bornetteDAO.findOccupeAll(idBorne);
                      
             if (bornettesOccupe.length != 0)
            {
                 location = locationDAO.find(client);
                if (location==null)
                {
                    Bornette bornette = bornetteDAO.findOccupe(idBorne);

                    LouerVeloPanel louerVeloPanel =
                        new LouerVeloPanel(client, bornette);
                    LouerVeloController louerVeloController =
                        new LouerVeloController(
                            mainWindowController, client, bornette, louerVeloPanel);
                    setMainWindowContentPanel(louerVeloPanel);
                }
                else
                {
                    loggedInWelcomePanel.locationErrorPopup();
                }
            }
            else
            {
                loggedInWelcomePanel.veloErrorPopup();
            }
        }
    }

    /*
     * Put the velo back to the stand by setting stand->velo = velo
     */
    class RestituerUnVeloButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            long idBorne = BorneSingleton.getInstance().getIdBorne();

            Bornette bornette;
            Velo bike;
            Location location;
            Bornette[] bornettesLibre;

            LocationDAO locationDAO = new LocationDAO();
            BornetteDAO bornetteDAO = new BornetteDAO();
            bornettesLibre = bornetteDAO.findLibreAll(idBorne);
            System.out.println("La taille du tableau est : " + bornettesLibre.length);
            if(bornettesLibre.length != 0)
            {
                location = locationDAO.find(client);

                if (location != null)
                {
                    Date dateFinLocation = new Date();
                    location.setDateFinLocation(dateFinLocation);
                    bike = location.getVelo();
                    bornette = bornetteDAO.findLibreOne(idBorne);
                    // attaching the bike to the stand
                    bornette.setVelo(bike);
                    // hitting the database
                    bornetteDAO.update(bornette);
            
                    locationDAO.update(location);


                    // TODO: screen when given bike back
                    RestituerVeloPanel restituerVeloPanel =
                            new RestituerVeloPanel(client, bornette);
                    RestituerVeloController restituerVeloController =
                            new RestituerVeloController(
                            mainWindowController, restituerVeloPanel, client, location);
                    setMainWindowContentPanel(restituerVeloPanel);
                }
                else
                {
                    loggedInWelcomePanel.restituionErrorPopup();
                }
            }
            else
            {
                loggedInWelcomePanel.bornetteErrorPopup();
            }
           
        }
    }


}
