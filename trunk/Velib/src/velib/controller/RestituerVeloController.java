/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import velib.model.Client;
import velib.model.Location;
import velib.view.DeclarerProblemPanel;
import velib.view.MainWindowFrame;
import velib.view.RestituerVeloPanel;

/**
 *
 * @author andre
 */
public class RestituerVeloController extends AbstractMainWindowController
{
    private RestituerVeloPanel restituerVeloPanel;
    private Client client;
    private Location location;

    public RestituerVeloController(MainWindowController mainWindowController,
            RestituerVeloPanel restituerVeloPanel, Client client, Location location)
    {
        super(mainWindowController);
        
        this.restituerVeloPanel = restituerVeloPanel;
        this.client = client;
        this.location=location;

        addListeners();
    }

    private void addListeners()
    {
        restituerVeloPanel.addDeclarerProblemeButtonListener(
                new DeclarerProblemeButtonListener());
        restituerVeloPanel.addOkButtonListener(
                new OkButtonListener());
    }

    class DeclarerProblemeButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            //velos = veloDAO.findVeloPanne();
             DeclarerProblemPanel declarerProblemPanel = new DeclarerProblemPanel(client);
            DeclarerProblemController declarerProblemController =
                    new DeclarerProblemController(mainWindowController, 
                    declarerProblemPanel, client, location);
             setMainWindowContentPanel(declarerProblemPanel);
            //declarerProblemPanel.setVisible(true);
        }
    }

    class OkButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            initMainWindow();
        }
    }
}
