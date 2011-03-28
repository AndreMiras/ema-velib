package velib.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import velib.dao.ClientDAO;
import velib.dao.LocationDAO;
import velib.model.Client;
import velib.model.Location;
import velib.view.ListeClientFrame;
import velib.view.ShowActivitiesClientFrame;

public class ListeClientController
{


    private ListeClientFrame listeClientFrame;
    private ShowActivitiesClientFrame showActivitiesClientFrame;
    private ShowActivitiesClientController showActivitiesClientController;
    Client client;
    ClientDAO clientDAO = new ClientDAO();
    Location[] locations;
    LocationDAO locationDAO = new LocationDAO();

    public ListeClientController(ListeClientFrame listeClientFrame)
    {
        this.listeClientFrame = listeClientFrame;
        addListeners();
    }

    private void addListeners()
    {
        listeClientFrame.addClientValiderButtonListener(
                new ClientListe2ComboBoxListener());
        listeClientFrame.addShowActivitiesButtonListener(
                new ShowActivitiesButtonListener());
    }

    class ClientListe2ComboBoxListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String lastName = listeClientFrame.getLastNamejTextField().getText();
            String firstName = listeClientFrame.getFirstNamejTextField().getText();
            //On récupère le nom et prénom saisis dans les champs de la frame
             //On recherhce le client correspondant, puis on affiche ses inofrmations sur la frame
            client = clientDAO.findByName(lastName, firstName);
            if(client==null)
            {
               listeClientFrame.clientErrorPopup();
            }
            else
            {
                listeClientFrame.setUpInfoClientFrame(client);
            }

        }
    }

        class ShowActivitiesButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            locations = locationDAO.findAllLocationByClient(client);
            //On récupère l'ensemble des locations éffectuées par le client
            showActivitiesClientFrame = new ShowActivitiesClientFrame(client, locations);
            showActivitiesClientController = new ShowActivitiesClientController(showActivitiesClientFrame);
            showActivitiesClientFrame.setVisible(true);
            //Puis on les affiche dans la liste (tableau de la page)
        }
    }

    

}
