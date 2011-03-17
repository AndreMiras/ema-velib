/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import velib.model.Client;
import velib.view.MainWindowFrame;
import velib.view.RestituerVeloPanel;

/**
 *
 * @author andre
 */
public class RestituerVeloController extends AbstractController
{
    private RestituerVeloPanel restituerVeloPanel;
    private Client client;

    public RestituerVeloController(MainWindowFrame mainWindowFrame,
            RestituerVeloPanel restituerVeloPanel, Client client)
    {
        super(mainWindowFrame);
        
        this.restituerVeloPanel = restituerVeloPanel;
        this.client = client;

        addListeners();
    }

    private void addListeners()
    {
        restituerVeloPanel.addDeclarerProblemeButtonListener(
                new DeclarerProblemeButtonListener());
    }

    class DeclarerProblemeButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            System.out.println("TODO: Create a Probleme object in the DB using the DAO");
        }
    }
}
