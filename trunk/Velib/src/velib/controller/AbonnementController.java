/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.controller;

import velib.view.AbonnementPanel;
import velib.view.MainWindowFrame;

/**
 *
 * @author andre
 */
public class AbonnementController extends AbstractController
{
    private AbonnementPanel abonnementPanel;

    public AbonnementController(MainWindowFrame mainWindowFrame,
            AbonnementPanel abonnementPanel)
    {
        super(mainWindowFrame);
        this.abonnementPanel = abonnementPanel;
    }

    
}
