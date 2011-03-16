/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.controller;

import velib.model.IModel;
import velib.view.LoggedInWelcomePanel;
import velib.view.MainWindowFrame;

/**
 *
 * @author andre
 */
class ChoixIdentificationController extends AbstractController
{

    private IModel model ;
    private LoggedInWelcomePanel view;

    public ChoixIdentificationController(
            MainWindowFrame mainWindowFrame, IModel model,
            LoggedInWelcomePanel view)
    {
        super(mainWindowFrame);
        this.model = model;
        this.view = view;
    }


}
