/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import velib.model.IModel;
import velib.view.WelcomeScreenPanel;

/**
 *
 * @author andre
 */
public class WelcomeScreenController
{
    private IModel model;
    private WelcomeScreenPanel view;

    public WelcomeScreenController(IModel model, WelcomeScreenPanel view)
    {
        this.model = model;
        this.view = view;
    }


    private void addListeners()
    {
        view.addIdentifierButtonListener(new IdentifierButtonListener());

        // view.addEditDatabaseButtonListener(new EditDatabaseButtonListener());
    }

      class IdentifierButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            /*
            loginScreenFrame = new LoginScreenFrame();
            loginScreenController = new LoginScreenController(
                    model, loginScreenFrame);
            loginScreenFrame.setVisible(true);
             * 
             */
        }
    }

    class EditDatabaseButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            /*
            databaseManagement = new DatabaseManagementDAO();
            databaseManagementFrame = new DatabaseManagementFrame();
            databaseManagementController = new DatabaseManagementController(
                    databaseManagement, databaseManagementFrame);
            databaseManagementFrame.setVisible(true);
             * 
             */
        }
    }
    
}
