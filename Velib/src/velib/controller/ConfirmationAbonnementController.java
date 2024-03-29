package velib.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import velib.model.Client;
import velib.view.ConfirmationAbonnementPanel;


public class ConfirmationAbonnementController extends AbstractMainWindowController
{
    private Client client;
    private ConfirmationAbonnementPanel confirmationAbonnementPanel;

    public ConfirmationAbonnementController(Client client,
            MainWindowController mainWindowController,
            ConfirmationAbonnementPanel confirmationAbonnementPanel)
    {
        super(mainWindowController);
        this.client = client;
        this.confirmationAbonnementPanel = confirmationAbonnementPanel;
        addListeners();
    }

    private void addListeners()
    {
        confirmationAbonnementPanel.addOkButtonListener(
                new OkButtonListener());
    }

  class OkButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            initMainWindow();
        }
    }

}
