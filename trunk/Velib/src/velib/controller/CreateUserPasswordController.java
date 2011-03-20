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
import velib.model.User;
import velib.view.BankDetailsPanel;
import velib.view.CreateUserPasswordPanel;
import velib.view.MainWindowFrame;

/**
 *
 * @author andre
 */
public class CreateUserPasswordController extends AbstractController
{
    private Client client;
    private CreateUserPasswordPanel createUserPasswordPanel;
    
    CreateUserPasswordController(
            Client client,
            MainWindowFrame mainWindowFrame,
            CreateUserPasswordPanel createUserPasswordPanel)
    {
        super(mainWindowFrame);
        this.client = client;
        this.createUserPasswordPanel = createUserPasswordPanel;

        addListeners();
    }

    private void addListeners()
    {
        createUserPasswordPanel.addValiderButtonListener(
                new ValiderButtonListener());
    }

    /*
     * TODO:
     *  - payment process
     *  - user/password creation
     *  - congrat screen
     */
    class ValiderButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            User user;
            UserDAO userDAO = new UserDAO();
            ClientDAO clientDAO = new ClientDAO();

            user = createUserPasswordPanel.getUserFromInputs();
            user.setUserId(client.getUser().getUserId());
            System.out.println("Updating user: " + user);
            userDAO.update(user);

            /* Calling up the create CreateUserPassword  */
            // updating the client object in memory first
            client = clientDAO.find(client.getClientId());
            BankDetailsPanel bankDetailsPanel =
                    new BankDetailsPanel();
            bankDetailsPanel.setVisible(true);
            BankDetailsController bankDetailsController =
                    new BankDetailsController(
                        client, mainWindowFrame, bankDetailsPanel);

            mainWindowFrame.setContentPanel(bankDetailsPanel);

        }
    }

}
