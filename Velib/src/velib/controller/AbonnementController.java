/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import velib.model.AbonnementType;
import velib.view.AbonnementPanel;
import velib.view.MainWindowFrame;
import velib.view.RegisterFormPanel;

/**
 *
 * @author andre
 */
public class AbonnementController extends AbstractMainWindowController
{
    private AbonnementPanel abonnementPanel;
    

    public AbonnementController(MainWindowController mainWindowController,
            AbonnementPanel abonnementPanel)
    {
        super(mainWindowController);
        this.abonnementPanel = abonnementPanel;

        abonnementPanel.addAbonnementGroupButtonListener(
                new AbonnementTypeGroupButtonListener());
    }


    /*
     * Creates and displays the appropriated abonnement page
     * based on clicked button
     */
    class AbonnementTypeGroupButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String actionCommand;
            AbonnementType abonnementType;
            JButton clickedButton = (JButton)e.getSource();

            actionCommand = clickedButton.getActionCommand();
            abonnementType = AbonnementType.valueOf(actionCommand);
            
            switch(abonnementType)
            {
                /* short subscription */
                case HALF_DAY:
                    System.out.println("cmd1");
                    break;
                case ONE_DAY:
                    System.out.println("foo");
                    break;
                    
                /* long subscription */
                case ONE_WEEK:
                    longSubscription();
                    break;
                case ONE_MONTH:
                    longSubscription();
                    break;
                case ONE_YEAR:
                    longSubscription();
                    break;
                default:
                    System.out.println("Unknown");
                    break;
            }
        }

        /*
         * TODO: finish up
         */
        private void shortSubscription()
        {
            
        }

        private void longSubscription()
        {
            RegisterFormPanel registerFormPanel = new RegisterFormPanel();
            RegisterFormController registerFormController =
                    new RegisterFormController(mainWindowController,
                    registerFormPanel);
            registerFormPanel.setVisible(true);

            setMainWindowContentPanel(registerFormPanel);
        }
    }

    
}
