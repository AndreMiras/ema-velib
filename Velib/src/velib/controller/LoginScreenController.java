package velib.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import velib.dao.ClientDAO;
import velib.dao.UserDAO;
import velib.model.Client;
import velib.model.IModel;
import velib.model.User;
import velib.view.IdentifiantPerduPanel;
import velib.view.LoggedInWelcomePanel;
import velib.view.LoginScreenPanel;


public class LoginScreenController extends AbstractMainWindowController
{

    private IModel model;
    private LoginScreenPanel view;

    // TODO: does it really need to be kept as an attribute
    private LoggedInWelcomePanel loggedInWelcomePanel;
    private LoggedInWelcomeController loggedInWelcomeController;

    private UserDAO userDAO;
    private User user;

    private ClientDAO clientDAO;
    private Client client;

    // TODO: actually I think we will path it a DAO rather than a model
    public LoginScreenController(MainWindowController mainWindowController,
            IModel model, LoginScreenPanel view)
    {
        super(mainWindowController);
        this.model = model;
        this.view = view;

        userDAO = new UserDAO();
        clientDAO = new ClientDAO();

        addListeners();
    }

    private void addListeners()
    {
        view.addValiderButtonListener(new ValidaterButtonListener());
        view.addIdentifiantPerduButtonListener(new IdentifiantPerduListener());
    }
    

    class ValidaterButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            // TODO: use Nicolas' User DAO and stuffs
            System.out.println("Get find() the user");
            String userIdentifiant = view.getIdentifyTextField();
            String userPassword = view.getcodeTextField();
            
            // FIXME: we should later use the password field to find
            // the client rather than the id;
            
            // Integer idTest = Integer.parseInt(userPassword);
            //Integer idTest = 1; // TODO: testing purpose, to be removed

            user = userDAO.find(userIdentifiant, userPassword);
                         
            /*
             * If the User exists
             * Create window and associated controller
             * TODO: move this to a dedicated function for readability
             */
            if(user.getUserId() != 0)
            {
                // Get the client associated to the given user
                client = clientDAO.find(user);
                
                loggedInWelcomePanel = new LoggedInWelcomePanel(client);
                loggedInWelcomeController =
                        new LoggedInWelcomeController(mainWindowController,
                        client, loggedInWelcomePanel);
                setMainWindowContentPanel(loggedInWelcomePanel);
                System.out.println("Users ok");
                // mainWindow.showMessage("User ok");
            }
            else
            {
                // display an error message
                view.loginErrorPopup();

            }
        }
    }

    class IdentifiantPerduListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            IdentifiantPerduPanel identifiantPerduPanel = new IdentifiantPerduPanel();
            IdentifiantPerduController identifiantPerduControler =
                    new IdentifiantPerduController(mainWindowController,
                    identifiantPerduPanel);
            setMainWindowContentPanel(identifiantPerduPanel);
        }
    }

}
