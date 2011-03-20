/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.controller;

import javax.swing.JPanel;


/**
 *
 * @author andre
 * TODO: add an instance to the currentBorn singleton
 */
public class AbstractMainWindowController
{
    public MainWindowController mainWindowController;

    public AbstractMainWindowController(MainWindowController mainWindowController)
    {
        this.mainWindowController = mainWindowController;
    }

    // TODO: add up the model


    protected void setMainWindowContentPanel(JPanel jpanel)
    {
        mainWindowController.setMainWindowContentPanel(jpanel);
    }
    


}
