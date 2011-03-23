/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.controller;

import javax.swing.JPanel;


/**
 *
 * @author andre
 */
public class AbstractMainWindowController
{
    public MainWindowController mainWindowController;

    public AbstractMainWindowController(MainWindowController mainWindowController)
    {
        this.mainWindowController = mainWindowController;
    }

    protected void setMainWindowContentPanel(JPanel jpanel)
    {
        mainWindowController.setMainWindowContentPanel(jpanel);
    }


    protected void initMainWindow()
    {
        mainWindowController.mainWindowFrameSetup();
    }

}
