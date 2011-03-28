
package velib.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.Timestamp;
import java.util.Date;
import velib.dao.AbonnementDAO;
import velib.dao.BorneSingleton;
import velib.dao.BornetteDAO;
import velib.dao.LocationDAO;
import velib.model.Subscription;
import velib.model.Bornette;
import velib.model.Client;
import velib.model.Location;
import velib.view.LouerVeloPanel;
import velib.view.MainWindowFrame;

/**
 * TODO:
 * dispose when the velo is taken or when the time out is reached
 */
public class LouerVeloController extends AbstractMainWindowController
{

    private LouerVeloPanel louerVeloPanel;
    private Client client;
    private Bornette bornette;

    public LouerVeloController(MainWindowController mainWindowController,
            Client client, Bornette bornette, LouerVeloPanel louerVeloPanel)
    {
        super(mainWindowController);

        this.louerVeloPanel = louerVeloPanel;
        this.bornette = bornette;
        this.client = client;
        
        addListeners();
    }

    private void addListeners()
    {
        louerVeloPanel.addOkButtonListener(
                new OkButtonListener());
        // loggedInWelcomePanel.addRestituerUnVeloButtonListener(
        //         new RestituerUnVeloButtonListener());
        // view.addRechagerButtonListener(new TODO());

    }

    /*
     * Updates the bornette object
     * Creates a new location object in the DB
     * TODO: Call the home screen
     */
    class OkButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            Location location;
            LocationDAO locationDAO = new LocationDAO();
            Date dateDebutLocation = new Date();
            System.out.println("La date du jour est "+dateDebutLocation);
            
            location = new Location(
                    0 // generated by the DB
                    , client,
                    bornette.getVelo());
            location.setDateDebutLocation(dateDebutLocation);
            locationDAO.create(location);
            System.out.println("Creating a location object: " + location);
            
            BornetteDAO bornetteDAO = new BornetteDAO();
            
            System.out.println("Setting bornette->velo to null");
            bornette.setVelo(null);
            bornetteDAO.update(bornette);

            System.out.println("Creating a subscription object");
            initMainWindow();
        }
    }

    
}
