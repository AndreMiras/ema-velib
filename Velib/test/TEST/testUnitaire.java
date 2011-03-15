/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TEST;

import velib.dao.ClientDAO;
import velib.model.Client;

/**
 *
 * @author gvandiemen
 */
public class testUnitaire
{

    public testUnitaire() {
        Client client = new Client(0, "firstname", "lastname");
        System.out.println("Id should be 0: " + client.getId());

        ClientDAO clientDAO = new ClientDAO();
        client = clientDAO.create(client);
        System.out.println("Id shouldn't be 0: " + client.getId());
        
        clientDAO.create(client);
    }
    
}
