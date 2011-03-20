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
import velib.view.LouerVeloPanel;
import velib.view.MainWindowFrame;

/**
 *
 * @author andre
 * TODO:
 * dispose when the velo is taken or when the time out is reached
 */
public class LouerVeloController extends AbstractController
{

    private LouerVeloPanel louerVeloPanel;
    private Client client;
    private Bornette bornette;

    public LouerVeloController(MainWindowFrame mainWindowFrame,
            Client client, Bornette bornette, LouerVeloPanel louerVeloPanel)
    {
        super(mainWindowFrame);

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
     * Updates the bornette:
     * TODO: Call the home screen
     */
    class OkButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            BornetteDAO bornetteDAO = new BornetteDAO();
            
            System.out.println("Setting bornette->velo to null");
            bornette.setVelo(null);
            bornetteDAO.update(bornette);
            // TODO: Call the home screen by cleaning the mainWindowFrame
            mainWindowFrame.setContentPanel(louerVeloPanel);
        }
    }

    
}
