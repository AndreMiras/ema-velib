/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.dao;
import velib.model.Client;
import velib.model.Subscription;

/**
 *
 * @author andre
 */
public class DAOFactory extends AbstractDAOFactory
{

	public DAO<Client> getClientDAO(){
		return new ClientDAO();
	}

	public DAO<Subscription> getAbonnementDAO(){
		return new AbonnementDAO();
	}

}