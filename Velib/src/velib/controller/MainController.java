/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import velib.dao.DatabaseManagement;
import velib.dao.IDatabaseManagement;
import velib.model.IModel;
import velib.view.DatabaseManagementFrame;
import velib.view.IView;
import velib.view.LoginScreenFrame;
import velib.view.WelcomeScreenFrame;

/**
 *
 * @author andre
 */
public class MainController implements IController {
    
    private IModel model;
    private WelcomeScreenFrame view;

    private LoginScreenController loginScreenController;
    private LoginScreenFrame loginScreenFrame;

    // Database Management mvc
    private IDatabaseManagement databaseManagement;
    private DatabaseManagementFrame databaseManagementFrame;
    private DatabaseManagementController databaseManagementController;

    public MainController(IModel model, WelcomeScreenFrame view)
    {
        this.model = model;
        this.view = view;

        addListeners();
    }

    private void addListeners()
    {
        view.addIdentifierButtonListener(new IdentifierButtonListener());

        view.addEditDatabaseButtonListener(new EditDatabaseButtonListener());
    }

    

    public IModel getModel()
    {
        return model;
    }

    public IView getView()
    {
        return view;
    }

    class IdentifierButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            loginScreenFrame = new LoginScreenFrame();
            loginScreenController = new LoginScreenController(
                    model, loginScreenFrame);
            loginScreenFrame.setVisible(true);
        }
    }

    class EditDatabaseButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            databaseManagement = new DatabaseManagement();
            databaseManagementFrame = new DatabaseManagementFrame();
            databaseManagementController = new DatabaseManagementController(
                    databaseManagement, databaseManagementFrame);
            databaseManagementFrame.setVisible(true);
        }
    }
    

}
