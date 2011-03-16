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
class ChoixIdentificationController {

    private IModel model ;
    private LoggedInWelcomePanel view;
    private MainWindowFrame mainWindowFrame;

    public ChoixIdentificationController(
            MainWindowFrame mainWindow, IModel model,
            LoggedInWelcomePanel view)
    {
        this.model = model;
        this.view = view;
        this.mainWindowFrame = mainWindow;
    }


}
