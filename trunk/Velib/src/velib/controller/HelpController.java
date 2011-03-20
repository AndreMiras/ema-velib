/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.controller;

import velib.model.IModel;
import velib.view.HelpPanel;
import velib.view.MainWindowFrame;
/**
 *
 * @author G
 */
public class HelpController extends AbstractMainWindowController
{

    private IModel model;
    private HelpPanel view;

    public HelpController(MainWindowController mainWindowController, IModel model, HelpPanel view)
    {
        super(mainWindowController);
        this.model = model;
        this.view = view;
    }
}
