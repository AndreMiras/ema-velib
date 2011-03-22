/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import velib.dao.BornesDAO;
import velib.dao.DatabaseManagementDAO;
import velib.dao.IDatabaseManagementDAO;
import velib.model.Borne;
import velib.model.IModel;
import velib.view.AdministrationBorneFrame;
import velib.view.AdministrationWindowFrame;
import velib.view.DBConnectionFrame;
import velib.view.DatabaseManagementFrame;
import velib.view.EditBornFrame;
import velib.view.IView;
import velib.view.MainWindowFrame;
import velib.view.WelcomeScreenPanel;
import velib.view.UsersControlFrame;

/**
 *
 * @author G
 */
public class AdministrationWindowController
{
        // Database Management mvc
    private IDatabaseManagementDAO databaseManagement;
    private DatabaseManagementFrame databaseManagementFrame;
    private DatabaseManagementController databaseManagementController;

        // Users Control mvc
    private UsersControlFrame usersControlFrame;
    private UsersControlController usersControlController;

        // Born Management mvc
    private AdministrationWindowFrame administrationWindowFrame;
    private AdministrationWindowController administrationWindowController;

    private AdministrationBorneFrame administrationBorneFrame;
    private AdministrationBorneController administrationBorneController;

    public AdministrationWindowController(AdministrationWindowFrame administrationWindowFrame)
    {
        this.administrationWindowFrame = administrationWindowFrame;
        addListeners();
    }

    private void addListeners()
    {
        administrationWindowFrame.addEditDatabaseButtonListener(
                new EditDatabaseButtonListener());
        administrationWindowFrame.addGeneralManagementButtonListener(
                new GeneralManagementButtonListener());
        administrationWindowFrame.addusersListButtonListener(
                new UsersListButtonListener());
    }

    class UsersListButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            usersControlFrame = new UsersControlFrame();
            usersControlController = new UsersControlController(usersControlFrame);
            usersControlFrame.setVisible(true);
        }
    }

    class GeneralManagementButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            administrationBorneFrame = new AdministrationBorneFrame();
            administrationBorneController = new AdministrationBorneController(administrationBorneFrame);
            administrationBorneFrame.setVisible(true);
        }
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