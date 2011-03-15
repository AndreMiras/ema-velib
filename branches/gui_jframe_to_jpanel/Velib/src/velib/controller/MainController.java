/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import velib.dao.DatabaseManagementDAO;
import velib.dao.IDatabaseManagementDAO;
import velib.model.IModel;
import velib.view.DatabaseManagementFrame;
import velib.view.IView;
import velib.view.LoginScreenFrame;
import velib.view.MainWindowFrame;
import velib.view.WelcomeScreenPanel;

/**
 *
 * @author andre
 */
// TODO: to be renamed as MainWindowFrameController
public class MainController implements IController {
    
    private IModel model;
    private MainWindowFrame view;
    private WelcomeScreenPanel welcomeScreenPanel;
    private WelcomeScreenController welcomeScreenController;

    private LoginScreenController loginScreenController;
    private LoginScreenFrame loginScreenFrame;

    // Database Management mvc
    private IDatabaseManagementDAO databaseManagement;
    private DatabaseManagementFrame databaseManagementFrame;
    private DatabaseManagementController databaseManagementController;

    public MainController(IModel model, MainWindowFrame view)
    {
        this.model = model;
        this.view = view;

        // addListeners();
        mainWindowFrameSetup();
        addListeners();
    }

    /*
     * Add first WelcomeScreenPanel and register associated controller
     */
    public void mainWindowFrameSetup()
    {
        welcomeScreenPanel = new WelcomeScreenPanel();
        welcomeScreenController = new WelcomeScreenController(
                model, welcomeScreenPanel);
        view.setContentPanel(welcomeScreenPanel);
        
    }
    
    private void addListeners()
    {
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


    class EditDatabaseButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            databaseManagement = new DatabaseManagementDAO();
            databaseManagementFrame = new DatabaseManagementFrame();
            databaseManagementController = new DatabaseManagementController(
                    databaseManagement, databaseManagementFrame);
            databaseManagementFrame.setVisible(true);
        }
    }
    

}
