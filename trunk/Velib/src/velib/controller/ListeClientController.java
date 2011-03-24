/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import velib.dao.ClientDAO;

import velib.model.Client;

import velib.view.ListeClientFrame;

/**
 *
 * @author andre
 */
public class ListeClientController
{


    private ListeClientFrame listeClientFrame;
    Client client;
    ClientDAO clientDAO = new ClientDAO();

    public ListeClientController(ListeClientFrame listeClientFrame)
    {
        this.listeClientFrame = listeClientFrame;
        addListeners();
    }

    private void addListeners()
    {
        listeClientFrame.addClientValiderButtonListener(
                new ClientListe2ComboBoxListener());
    }

    class ClientListe2ComboBoxListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String lastName = listeClientFrame.getLastNamejTextField().getText();
            String firstName = listeClientFrame.getFirstNamejTextField().getText();
            System.out.println("Lastname " + lastName);
            System.out.println("Firstname " + firstName);
             client = clientDAO.findByName(lastName, firstName);
            System.out.println("Id du client " + client.getClientId());
             listeClientFrame.setUpInfoClientFrame(client);

        }
    }

    

}
