/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import velib.model.IModel;
import velib.view.LoggedInWelcomePanel;
import velib.view.LouerVeloPanel;
import velib.view.MainWindowFrame;

/**
 *
 * @author andre
 */
class LoggedInWelcomeController extends AbstractController
{

    private IModel model ;
    private LoggedInWelcomePanel loggedInWelcomePanel;

    public LoggedInWelcomeController(
            MainWindowFrame mainWindowFrame, IModel model,
            LoggedInWelcomePanel loggedInWelcomePanel)
    {
        super(mainWindowFrame);
        this.model = model;
        this.loggedInWelcomePanel = loggedInWelcomePanel;
    }

    private void addListeners()
    {
        loggedInWelcomePanel.addLouerUnVeloButtonListener(
                new LouerUnVeloButtonListener());
        // loggedInWelcomePanel.addRestituerUnVeloButtonListener(
        //         new RestituerUnVeloButtonListener());
        // view.addRechagerButtonListener(new TODO());

    }

    class LouerUnVeloButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            // TODO: does it really need to be kept as a private attribute?
            LouerVeloPanel louerVeloPanel = new LouerVeloPanel();
            LouerVeloController louerVeloController =
                    new LouerVeloController(mainWindowFrame, louerVeloPanel);
            // loginScreenPanel.setVisible(true);
            mainWindowFrame.setContentPanel(louerVeloPanel);
        }
    }


}
