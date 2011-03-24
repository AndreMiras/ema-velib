/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import velib.dao.DatabaseManagementDAO;
import velib.dao.IDatabaseManagementDAO;
import velib.view.AdministrationBorneFrame;
import velib.view.AdministrationWindowFrame;
import velib.view.CheckDefectsFrame;
import velib.view.DatabaseManagementFrame;
import velib.view.UsersControlFrame;
import velib.dao.LocationDAO;
import velib.model.Location;
import velib.dao.VeloDAO;
import velib.model.Velo;
import velib.model.Borne;
import velib.dao.BornesDAO;
import velib.dao.ClientDAO;
import velib.model.Client;
import velib.view.ListeClientFrame;




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
    LocationDAO locationDAO = new LocationDAO();
    private Location[] locations;

        // Born Management mvc
    private AdministrationWindowFrame administrationWindowFrame;
    private AdministrationWindowController administrationWindowController;

        // General Station administration
    private AdministrationBorneFrame administrationBorneFrame;
    private AdministrationBorneController administrationBorneController;
    private BornesDAO borneDAO;

        // Bike defects mvc
    private CheckDefectsFrame checkDefectsFrame;
    private CheckDefectsController checkDefectsController;
    VeloDAO veloDAO = new VeloDAO();
    private Velo[] velos;

        //Administration clients
    private ListeClientFrame listeClientFrame;
    private ListeClientController listeClientController;
    private ClientDAO clientDAO;

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
        administrationWindowFrame.addUsersListButtonListener(
                new UsersListButtonListener());
        administrationWindowFrame.addCheckDefectsButtonListener(
                new CheckDefectsButtonListener());
        administrationWindowFrame.addClientButtonListener(
                new ClientButtonListener ());
    }

    class CheckDefectsButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            velos = veloDAO.findVeloPanne();
            checkDefectsFrame = new CheckDefectsFrame(velos);
            checkDefectsController = new CheckDefectsController(checkDefectsFrame);
            checkDefectsFrame.setVisible(true);
        }
    }

    class UsersListButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            locations = locationDAO.findAllLocation();
            usersControlFrame = new UsersControlFrame(locations);
            usersControlController = new UsersControlController(usersControlFrame);
            usersControlFrame.setVisible(true);
        }
    }

    class GeneralManagementButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {

            borneDAO = new BornesDAO();
            Borne[] bornes;
            bornes = borneDAO.findAllBorne();
            administrationBorneFrame = new AdministrationBorneFrame(bornes);
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

        class ClientButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            clientDAO = new ClientDAO();
            Client[] clients;
            clients = clientDAO.findAllClient();
            listeClientFrame = new ListeClientFrame(clients);
            listeClientController = new ListeClientController(listeClientFrame
                    );
            listeClientFrame.setVisible(true);
        }
    }
}