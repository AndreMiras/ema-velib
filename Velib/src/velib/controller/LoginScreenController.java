/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import velib.dao.UserDAO;
import velib.model.IModel;
import velib.model.User;
import velib.view.LoggedInWelcomePanel;
import velib.view.LoginScreenPanel;
import velib.view.MainWindowFrame;

/**
 *
 * @author andre
 */
public class LoginScreenController {

    private IModel model;
    private LoginScreenPanel view;

    // TODO: does it really need to be kept as an attribute
    private LoggedInWelcomePanel choixIdentificationPanel;
    private ChoixIdentificationController choixIdentificationController;
    private MainWindowFrame mainWindow;

    private UserDAO userDAO;
    private User user;

    // TODO: actually I think we will path it a DAO rather than a model
    public LoginScreenController(MainWindowFrame mainWindow, IModel model, LoginScreenPanel view)
    {
        this.model = model;
        this.view = view;
        this.mainWindow = mainWindow;

        userDAO = new UserDAO();

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
            String userPassword = view.getIdentifyTextField();

            // FIXME: we should later use the password field to find
            // the client rather than the id;
            
            // Integer idTest = Integer.parseInt(userPassword);
            Integer idTest = 1; // TODO: testing purpose, to be removed
            String password = "azerty";
            String identifiant ="toto";
            user = userDAO.find(idTest);
             
            /*
             * If the User exists
             * Create window and associated controller
             * TODO: move this to a dedicated function for readability
             */
            // if(user.getId() != 0)
            if(true)
            {
                // TODO: Open the next screen
                choixIdentificationPanel = new LoggedInWelcomePanel();
                choixIdentificationController =
                        new ChoixIdentificationController(mainWindow,
                        model, choixIdentificationPanel);
                mainWindow.setContentPanel(choixIdentificationPanel);
            }
            else
            {
                // display an error message
                // view.loginErrorPopup();
                System.out.println("Can't login");
            }
        }
    }

}
