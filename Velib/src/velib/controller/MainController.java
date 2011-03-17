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
import velib.view.EditBornFrame;
import velib.view.IView;
import velib.view.MainWindowFrame;
import velib.view.WelcomeScreenPanel;

/**
 *
 * @author andre
 */
// TODO: to be renamed as MainWindowFrameController
public class MainController extends AbstractController implements IController
{
    
    private IModel model;
    private WelcomeScreenPanel welcomeScreenPanel;
    private WelcomeScreenController welcomeScreenController;

    private LoginScreenController loginScreenController;

    // Database Management mvc
    private IDatabaseManagementDAO databaseManagement;
    private DatabaseManagementFrame databaseManagementFrame;
    private DatabaseManagementController databaseManagementController;

    // Born Management mvc
    private EditBornFrame editBornFrame;
    private EditBornController editBornController;

    public MainController(IModel model, MainWindowFrame view)
    {
        super(view);
        this.model = model;

        // addListeners();
        mainWindowFrameSetup();
        addListeners();
    }

    /*
     * Add first WelcomeScreenPanel and register associated controller
     */
    private void mainWindowFrameSetup()
    {
        welcomeScreenPanel = new WelcomeScreenPanel();
        welcomeScreenController = new WelcomeScreenController(
                mainWindowFrame, model, welcomeScreenPanel);
        
        mainWindowFrame.setContentPanel(welcomeScreenPanel);
        
    }
    
    private void addListeners()
    {
        mainWindowFrame.addEditDatabaseButtonListener(
                new EditDatabaseButtonListener());
        mainWindowFrame.addEditBornButtonListener(
                new EditBornButtonListener());
    }

    public IModel getModel()
    {
        return model;
    }

    public IView getView()
    {
        return mainWindowFrame;
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

    class EditBornButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            editBornFrame = new EditBornFrame();
            editBornController = new EditBornController(mainWindowFrame,
                    editBornFrame);
            editBornFrame.setVisible(true);
        }
    }

    /*
     * Might not be needed
     */
    class PreviousButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
        }
    }

    class NextButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
        }
    }
    

}
