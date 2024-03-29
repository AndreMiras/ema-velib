package velib.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import velib.dao.BornesDAO;
import velib.dao.ConnectionHSQL;
import velib.dao.DatabaseManagementDAO;
import velib.dao.IDatabaseManagementDAO;
import velib.model.Borne;
import velib.model.IModel;
import velib.view.DBConnectionFrame;
import velib.view.DatabaseManagementFrame;
import velib.view.IView;
import velib.view.MainWindowFrame;
import velib.view.WelcomeScreenPanel;
import velib.view.UsersControlFrame;

public class MainWindowController
{
  
    private IModel model;
    private WelcomeScreenPanel welcomeScreenPanel;
    private WelcomeScreenController welcomeScreenController;
    private MainWindowFrame mainWindowFrame;

    private LoginScreenController loginScreenController;

    // Database Management mvc
    private IDatabaseManagementDAO databaseManagement;
    private DatabaseManagementFrame databaseManagementFrame;
    private DatabaseManagementController databaseManagementController;

    private BornesDAO borneDAO;



    // Database Connection
    private DBConnectionFrame dBConnectionFrame;
    private DBConnectionController dBConnectionController;

    // Users Control mvc
    private UsersControlFrame usersControlFrame;
    private UsersControlController usersControlController;

    public MainWindowController(IModel model,
            MainWindowFrame mainWindowFrame) throws SQLException
    {
        // super(null);
        this.model = model;
        this.mainWindowFrame = mainWindowFrame;

        mainWindowFrameSetup();
        addListeners();
    }
    
    //Fonction qui regarde si les tables sont crées, sinon les crées et les rempli
    //au lancement de l'application
    private void testAndCreateDB()
    {
        try
        {
            Connection connect = ConnectionHSQL.getDebugInstance();
            DatabaseMetaData dbm = connect.getMetaData();
            ResultSet tables = dbm.getTables(null, null, "bornes", null);
            if (tables.next())
            {
                // Table exists
            } else
            {
                // Table does not exist
                BornesDAO borneDAO = new BornesDAO();
                DatabaseManagementDAO databaseManagement = new DatabaseManagementDAO();
                databaseManagement.createTables();
                databaseManagement.fillUpTables();
                mainWindowFrame.creationDBPopup();
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(MainWindowController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*
     * Add first WelcomeScreenPanel and register associated controller
     */
    public final void mainWindowFrameSetup()
    {
        testAndCreateDB();
        mainWindowFrame.initMainWindow();
        welcomeScreenPanel = new WelcomeScreenPanel();
        welcomeScreenController = new WelcomeScreenController(
                this, model, welcomeScreenPanel);
        
        mainWindowFrame.setContentPanel(welcomeScreenPanel);
        
    }

    protected void setMainWindowContentPanel(JPanel jpanel)
    {
        mainWindowFrame.setContentPanel(jpanel);
    }

    
    private void addListeners()
    {
        mainWindowFrame.addDBConnectionButtonListener(
                new DBConnectionButtonListener());
    }

    public IModel getModel()
    {
        return model;
    }

    public IView getView()
    {
        return mainWindowFrame;
    }

    class DBConnectionButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            borneDAO = new BornesDAO();
            Borne[] bornes;
            bornes = borneDAO.findBorneLibre();
            
            DBConnectionFrame dBConnectionFrame = new DBConnectionFrame(bornes);

            DBConnectionController dBConnectionController =
                    new DBConnectionController(dBConnectionFrame);
            dBConnectionFrame.setVisible(true);

        }
    }

    class PreviousButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            /*
            JPanel previousPanel;
            previousPanel = 
                    mainWindowFrame.middleContentPanelsVector.lastElement();
            mainWindowFrame.setContentPanel(previousPanel);
             * 
             */
        }
    }

    class NextButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
        }
    }
    

}
