/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import velib.dao.ClientDAO;
import velib.dao.UserDAO;
import velib.model.Client;
import velib.model.IModel;
import velib.model.User;
import velib.view.LoggedInWelcomePanel;
import velib.view.LoginScreenPanel;
import velib.view.MainWindowFrame;

/**
 *
 * @author andre
 */
public class LoginScreenController extends AbstractController
{

    private IModel model;
    private LoginScreenPanel view;

    // TODO: does it really need to be kept as an attribute
    private LoggedInWelcomePanel choixIdentificationPanel;
    private LoggedInWelcomeController choixIdentificationController;

    private UserDAO userDAO;
    private User user;

    private ClientDAO clientDAO;
    private Client client;

    // TODO: actually I think we will path it a DAO rather than a model
    public LoginScreenController(MainWindowFrame mainWindowFrame, IModel model, LoginScreenPanel view)
    {
        super(mainWindowFrame);
        this.model = model;
        this.view = view;

        userDAO = new UserDAO();
        clientDAO = new ClientDAO();

        addListeners();
    }

    private void addListeners()
    {
        view.addValiderButtonListener(new ValidaterButtonListener());
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
                choixIdentificationPanel = new LoggedInWelcomePanel(client);
                choixIdentificationController =
                        new LoggedInWelcomeController(mainWindowFrame,
                        client, choixIdentificationPanel);
                mainWindowFrame.setContentPanel(choixIdentificationPanel);
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

}
