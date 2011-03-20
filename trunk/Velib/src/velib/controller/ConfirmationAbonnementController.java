/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.controller;

import velib.model.Client;
import velib.view.ConfirmationAbonnementPanel;
import velib.view.MainWindowFrame;

/**
 *
 * @author andre
 */
public class ConfirmationAbonnementController extends AbstractMainWindowController
{
    private Client client;
    private ConfirmationAbonnementPanel confirmationAbonnementPanel;

    public ConfirmationAbonnementController(Client client,
            MainWindowController mainWindowController,
            ConfirmationAbonnementPanel confirmationAbonnementPanel)
    {
        super(mainWindowController);
        this.client = client;
        this.confirmationAbonnementPanel = confirmationAbonnementPanel;
    }



}
