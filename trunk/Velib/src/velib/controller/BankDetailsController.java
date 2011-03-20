/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.controller;

import velib.model.Client;
import velib.view.BankDetailsPanel;
import velib.view.MainWindowFrame;

/**
 *
 * @author andre
 */
public class BankDetailsController extends AbstractController
{
    private Client client;
    private BankDetailsPanel bankDetailsPanel;

    public BankDetailsController(Client client,
            MainWindowFrame mainWindowFrame,
            BankDetailsPanel bankDetailsPanel)
    {
        super(mainWindowFrame);
        this.client = client;
        this.bankDetailsPanel = bankDetailsPanel;
    }

    

}
