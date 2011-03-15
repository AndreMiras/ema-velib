/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.dao;

/**
 *
 * @author andre
 */

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import velib.model.Client;
import velib.dao.AbstractDAOFactory;
import velib.dao.DAO;
import velib.dao.FactoryType;

public class ClientDAO extends DAO<Client>
{

    public Client create(Client obj)
    {
        try
        {
            // If the user doesn't exist
            /*
            if(obj.getUser().getId() == 0)
            {
                    DAO<User> userDAO =
                            AbstractDAOFactory.getFactory(FactoryType.DAO_FACTORY).getClientDAO();
                    obj.setUser(userDAO.create(obj.getUser()));
            }
            *
            */
            ResultSet result =
                    this.connect.createStatement(
                        ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_UPDATABLE).executeQuery(
                            "SELECT NEXTVAL('user_id_seq') as id"
                            );
            if(result.first())
            {
                long id = result.getLong("id");
                PreparedStatement prepare = this.connect
                                        .prepareStatement(
                                                    "INSERT INTO user (id, firstname, lastname)"+
                                                    "VALUES(?, ?, ?)"
                                        );
                    prepare.setLong(1, id);
                    prepare.setString(2, obj.getLastname());
                    prepare.setString(3, obj.getFirstname());

                    prepare.executeUpdate();
                    obj = this.find(id);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return obj;
    }

	public Client find(long id) {

		Client client = new Client();
		try {
            ResultSet result = this .connect
                                    .createStatement(
                                    	ResultSet.TYPE_SCROLL_INSENSITIVE,
                                        ResultSet.CONCUR_READ_ONLY
                                     ).executeQuery(
                                        "SELECT * FROM client WHERE id = " + id
                                     );
            if(result.first())
            {
                client = new Client(
                                    id,
                                    result.getString("firstname"),
                                    result.getString("lastname"));
            }

		    } catch (SQLException e) {
		            e.printStackTrace();
		    }
		   return client;

	}
	public Client update(Client obj)
        {
            try
            {
                /*
                    DAO<Langage> langageDAO = AbstractDAOFactory.getFactory(FactoryType.DAO_FACTORY)
                                                                   .getLangageDAO();
                    //Si le langage n'existe pas en base, on le créé
                    if(obj.getLangage().getId() == 0)
                    {
                            obj.setLangage(langageDAO.create(obj.getLangage()));
                    }
                    //On met à jours l'objet Langage
                    langageDAO.update(obj.getLangage());
                 * 
                 */

                    this.connect
            .createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_UPDATABLE
             ).executeUpdate(
                    "UPDATE developpeur SET firstname = '" + obj.getLastname() + "',"+
                    " lastname = '" + obj.getFirstname() + "',"+
                    " WHERE id = " + obj.getId()
             );

                obj = this.find(obj.getId());
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }

            return obj;
	}


	public void delete(Client obj)
        {
		try {

			this.connect
                .createStatement(
                	ResultSet.TYPE_SCROLL_INSENSITIVE,
                	ResultSet.CONCUR_UPDATABLE
                 ).executeUpdate(
                	"DELETE FROM client WHERE dev_id = " + obj.getId()
                 );

	    } catch (SQLException e) {
	            e.printStackTrace();
	    }
	}

}