package velib.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import velib.dao.ClientDAO;
import velib.model.Subscription;
import velib.model.Client;
import velib.view.CreateUserPasswordPanel;
import velib.view.MainWindowFrame;
import velib.view.RegisterFormPanel;

public class RegisterFormController extends AbstractMainWindowController
{
    private RegisterFormPanel registerFormPanel;
    private Subscription subscription;

    RegisterFormController(MainWindowController mainWindowController,
            Subscription subscription, RegisterFormPanel registerFormPanel)
    {
        super(mainWindowController);
        this.registerFormPanel = registerFormPanel;
        this.subscription = subscription;

        addListeners();
    }

    private void addListeners()
    {
        registerFormPanel.addOkButtonListener(
                new OkButtonListener());
    }

    /*
     * TODO: payment process to finish up
     */
    class OkButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            Client client;
            ClientDAO clientDAO = new ClientDAO();

            client = registerFormPanel.getClientFromInputs();

            /* Adding the subscription object to the client */
            // finally hit the database with the subscription object
            client.setAbonnement(subscription);
            
            client = clientDAO.create(client);
            System.out.println("Client created: " + client);


            /* Calling up the create CreateUserPassword  */
            CreateUserPasswordPanel createUserPasswordPanel =
                    new CreateUserPasswordPanel();
            createUserPasswordPanel.setVisible(true);
            CreateUserPasswordController createUserPasswordController =
                    new CreateUserPasswordController(client,
                        mainWindowController,
                        createUserPasswordPanel);

            setMainWindowContentPanel(createUserPasswordPanel);

        }
    }

}
