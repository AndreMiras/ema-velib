/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.dao;
import velib.model.Client;
import velib.model.Abonnement;

/**
 *
 * @author andre
 */
public class DAOFactory extends AbstractDAOFactory
{

	public DAO<Client> getClientDAO(){
		return new ClientDAO();
	}

	public DAO<Abonnement> getAbonnementDAO(){
		return new AbonnementDAO();
	}

}