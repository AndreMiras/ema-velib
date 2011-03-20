/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.controller;

import velib.model.Client;
import velib.view.CoordonneesBancairePanel;
import velib.view.MainWindowFrame;

/**
 *
 * @author andre
 */
public class BankDetailsController extends AbstractController
{
    private Client client;
    private CoordonneesBancairePanel bankDetailsPanel;

    public BankDetailsController(Client client,
            MainWindowFrame mainWindowFrame,
            CoordonneesBancairePanel bankDetailsPanel)
    {
        super(mainWindowFrame);
        this.client = client;
        this.bankDetailsPanel = bankDetailsPanel;
    }

    

}
