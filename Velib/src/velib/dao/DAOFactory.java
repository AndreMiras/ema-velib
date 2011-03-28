package velib.dao;
import velib.model.Client;
import velib.model.Subscription;

public class DAOFactory extends AbstractDAOFactory
{

	public DAO<Client> getClientDAO(){
		return new ClientDAO();
	}

	public DAO<Subscription> getAbonnementDAO(){
		return new AbonnementDAO();
	}

}