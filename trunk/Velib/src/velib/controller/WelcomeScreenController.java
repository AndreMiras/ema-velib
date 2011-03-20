/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import velib.model.IModel;
import velib.view.AbonnementPanel;
import velib.view.HelpPanel;
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
public class WelcomeScreenController extends AbstractMainWindowController
{
    // TODO: controller might not be needed
    private IModel model;
    private WelcomeScreenPanel view;

    public WelcomeScreenController(
            MainWindowController mainWindowController,
            IModel model, WelcomeScreenPanel view)
    {
        super(mainWindowController);
        this.model = model;
        this.view = view;

        addListeners();
    }


    private void addListeners()
    {
        view.addAbonnerButtonListener(new AbonnerButtonListener());
        view.addIdentifierButtonListener(new IdentifierButtonListener());
        view.addAideButtonListener(new AideButtonListener());
    }

    class AbonnerButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            // TODO: does it really need to be kept as a private attribute?
            AbonnementPanel abonnementPanel = new AbonnementPanel();
            AbonnementController abonnementController =
                    new AbonnementController(mainWindowController,
                    abonnementPanel);
            // loginScreenPanel.setVisible(true);
            setMainWindowContentPanel(abonnementPanel);
        }
    }
    
    class IdentifierButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            // TODO: does it really need to be kept as a private attribute?
            LoginScreenPanel loginScreenPanel = new LoginScreenPanel();
            LoginScreenController loginScreenController =
                    new LoginScreenController(mainWindowController,
                    model, loginScreenPanel);
            // loginScreenPanel.setVisible(true);
            setMainWindowContentPanel(loginScreenPanel);
        }
    }

    class AideButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            HelpPanel helpPanel = new HelpPanel();
            HelpController helpController = new HelpController(
                    mainWindowController,
                    model, helpPanel);
            setMainWindowContentPanel(helpPanel);
        }
    }
    
}
