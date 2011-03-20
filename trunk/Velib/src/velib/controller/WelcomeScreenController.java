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
public class WelcomeScreenController extends AbstractController
{
    // TODO: controller might not be needed
    private IModel model;
    private WelcomeScreenPanel view;

    public WelcomeScreenController(
            MainWindowFrame mainWindowFrame, IModel model, WelcomeScreenPanel view)
    {
        super(mainWindowFrame);
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
                    new AbonnementController(mainWindowFrame, abonnementPanel);
            // loginScreenPanel.setVisible(true);
            mainWindowFrame.setContentPanel(abonnementPanel);
        }
    }
    
    class IdentifierButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            // TODO: does it really need to be kept as a private attribute?
            LoginScreenPanel loginScreenPanel = new LoginScreenPanel();
            LoginScreenController loginScreenController =
                    new LoginScreenController(mainWindowFrame,
                    model, loginScreenPanel);
            // loginScreenPanel.setVisible(true);
            mainWindowFrame.setContentPanel(loginScreenPanel);
        }
    }

    class AideButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            HelpPanel helpPanel = new HelpPanel();
            HelpController helpController = new HelpController(mainWindowFrame,
                    model, helpPanel);
            mainWindowFrame.setContentPanel(helpPanel);
        }
    }
    
}
