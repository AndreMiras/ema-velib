/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import velib.model.IModel;
import velib.view.LoginScreenPanel;
import velib.view.MainWindowFrame;
import velib.view.WelcomeScreenPanel;

/**
 *
 * @author andre
 *
 * TODO: controller cleaning
 * basically this controller doesn't do any Model changes
 * just delegates
 */
public class WelcomeScreenController
{
    // TODO: controller might not be needed
    private IModel model;
    private WelcomeScreenPanel view;
    private MainWindowFrame mainWindow;

    public WelcomeScreenController(
            MainWindowFrame mainWindow, IModel model, WelcomeScreenPanel view)
    {
        this.mainWindow = mainWindow;
        this.model = model;
        this.view = view;

        addListeners();
    }


    private void addListeners()
    {
        view.addIdentifierButtonListener(new IdentifierButtonListener());

    }

    class IdentifierButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            // TODO: does it really need to be kept as a private attribute?
            LoginScreenPanel loginScreenPanel = new LoginScreenPanel();
            LoginScreenController loginScreenController =
                    new LoginScreenController(mainWindow,
                    model, loginScreenPanel);
            // loginScreenPanel.setVisible(true);
            mainWindow.setContentPanel(loginScreenPanel);
        }
    }

    
}
