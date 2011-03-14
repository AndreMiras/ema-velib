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
import velib.view.ChoixIdentificationFrame;
import velib.view.LoginScreenFrame;

/**
 *
 * @author andre
 */
public class LoginScreenController {

    private IModel model;
    private LoginScreenFrame view;

    private ChoixIdentificationFrame choixIdentificationFrame;
    private ChoixIdentificationController choixIdentificationController;

    private UserDAO userDAO;
    private User user;

    // TODO: actually I think we will path it a DAO rather than a model
    public LoginScreenController(IModel model, LoginScreenFrame view)
    {
        this.model = model;
        this.view = view;

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
                choixIdentificationFrame = new ChoixIdentificationFrame();
                choixIdentificationController =
                        new ChoixIdentificationController(
                        model, choixIdentificationFrame);
                choixIdentificationFrame.setVisible(true);
            }
            else
            {
                // display an error message
                view.loginErrorPopup();
            }
        }
    }

}
