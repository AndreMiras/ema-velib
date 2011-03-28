package velib.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import velib.dao.BanqueDAO;
import velib.model.Bank;
import velib.model.Client;
import velib.view.BankDetailsPanel;
import velib.view.ConfirmationAbonnementPanel;

public class BankDetailsController extends AbstractMainWindowController
{
    private Client client;
    private BankDetailsPanel bankDetailsPanel;

    public BankDetailsController(Client client,
            MainWindowController mainWindowController,
            BankDetailsPanel bankDetailsPanel)
    {
        super(mainWindowController);
        this.client = client;
        this.bankDetailsPanel = bankDetailsPanel;

        addListeners();
    }

    private void addListeners()
    {
        bankDetailsPanel.addValiderButtonListener(
                new ValiderButtonListener());
    }

    // TODO: payment process
    class ValiderButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            Bank bankDetails;
            BanqueDAO bankDAO = new BanqueDAO();

            bankDetails = bankDetailsPanel.getBankDetailsFromInputs();
            bankDetails.setId(client.getBanque().getId());
            System.out.println("Updating bank details: " + bankDetails);
            bankDAO.update(bankDetails);

            /* Calling up the create ConfirmationAbonnement  */
            ConfirmationAbonnementPanel confirmationAbonnementPanel =
                    new ConfirmationAbonnementPanel(client);
            ConfirmationAbonnementController confirmationAbonnementController =
                    new ConfirmationAbonnementController(client,
                    mainWindowController, confirmationAbonnementPanel);

            setMainWindowContentPanel(confirmationAbonnementPanel);

        }
    }

}
