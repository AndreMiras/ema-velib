/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import velib.dao.ClientDAO;
import velib.dao.LocationDAO;
import velib.model.Client;
import velib.model.Location;
import velib.model.User;
import velib.view.IdentifiantPerduPanel;
import velib.view.ListeClientFrame;
import velib.view.ShowActivitiesClientFrame;

public class IdentifiantPerduController extends AbstractMainWindowController
{

    private IdentifiantPerduPanel identifiantPerduPanel;
    ClientDAO clientDAO = new ClientDAO();
    Client client;

    public IdentifiantPerduController(MainWindowController mainWindowController,
            IdentifiantPerduPanel identifiantPerduPanel)
   {
        super(mainWindowController);
        this.identifiantPerduPanel = identifiantPerduPanel;
        addListeners();
    }

    private void addListeners()
    {
        identifiantPerduPanel.addOkButtonListener(
                new OkButtonListener());
        identifiantPerduPanel.addOk2ButtonListener(
            new Ok2ButtonListener());
        identifiantPerduPanel.addOk3ButtonListener(
            new Ok3ButtonListener());
    }

    class OkButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String lastname = identifiantPerduPanel.getLastNameTextField().getText();
            String firstname = identifiantPerduPanel.getFirstNameTextField1().getText();
            client = clientDAO.findByName(lastname, firstname);
            if (client != null)
            {
            identifiantPerduPanel.fillUpQuestionSecrete(client);
            }
            else
            {
                identifiantPerduPanel.clienErrorPopup();
            }
            
        }
    }

    class Ok2ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String reponseSecrete = identifiantPerduPanel.getReponseSecreteJTextField().getText();
            if(reponseSecrete.equals(client.getUser().getReponseSecrete()))
            {
                identifiantPerduPanel.fillUpPassword(client);
            }
            else
            {
                identifiantPerduPanel.reponseErrorPopup();
            }
        }
    }

    class Ok3ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            initMainWindow();
        }
    }



}
