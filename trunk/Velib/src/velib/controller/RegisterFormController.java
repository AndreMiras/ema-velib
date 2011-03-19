/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import velib.dao.ClientDAO;
import velib.model.Client;
import velib.model.User;
import velib.view.RegisterFormPanel;

/**
 *
 * @author andre
 * TODO: manage all three kind of long subscription
 */
public class RegisterFormController
{
    private RegisterFormPanel registerFormPanel;

    RegisterFormController(RegisterFormPanel registerFormPanel)
    {
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

        }
    }

}
