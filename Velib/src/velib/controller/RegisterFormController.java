/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import velib.dao.ClientDAO;
import velib.model.Client;
import velib.view.CreateUserPasswordPanel;
import velib.view.MainWindowFrame;
import velib.view.RegisterFormPanel;

/**
 *
 * @author andre
 * TODO: manage all three kind of long subscription
 */
public class RegisterFormController extends AbstractController
{
    private RegisterFormPanel registerFormPanel;

    RegisterFormController(MainWindowFrame mainWindowFrame,
            RegisterFormPanel registerFormPanel)
    {
        super(mainWindowFrame);
        this.registerFormPanel = registerFormPanel;

        addListeners();
    }

    private void addListeners()
    {
        registerFormPanel.addOkButtonListener(
                new OkButtonListener());
    }

    /*
     * TODO:
     *  - payment process
     *  - user/password creation
     *  - congrat screen
     */
    class OkButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            Client client;
            ClientDAO clientDAO = new ClientDAO();

            client = registerFormPanel.getClientFromInputs();
            client = clientDAO.create(client);
            System.out.println("Client created: " + client);

            CreateUserPasswordPanel createUserPasswordPanel =
                    new CreateUserPasswordPanel();
            createUserPasswordPanel.setVisible(true);
            CreateUserPasswordController createUserPasswordController =
                    new CreateUserPasswordController(
                        client, mainWindowFrame, createUserPasswordPanel);

            mainWindowFrame.setContentPanel(createUserPasswordPanel);

        }
    }

}
