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
         try {
             ResultSet result = this.connect.createStatement(
                                ResultSet.TYPE_SCROLL_INSENSITIVE,
                      		ResultSet.CONCUR_UPDATABLE
                                    ).executeQuery(
                                       "SELECT NEXT VALUE FOR sequence_client FROM user as id"
                                    );
            if(result.first()){
            long id = result.getLong(1);
            System.out.println("id :" + id);
            PreparedStatement prepare = this.connect.prepareStatement(
                                                    	"INSERT INTO user (idclient, nomclient, prenomclient, datenaissance, adresse, codepostal, questionsecrete, reponsesecrete, idabonnement, idbanque) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"
                                                    );
				prepare.setLong(1, id);
				prepare.setString(2, obj.getLastname());
                                prepare.setString(3, obj.getFirstname());
                                prepare.setDate(4, obj.getDateNaissanceSQL());
                                prepare.setString(5, obj.getAdresse());
                                prepare.setLong(6, obj.getCodePostal());
                                prepare.setString(7, obj.getQuestionSecrete());
                                prepare.setString(8, obj.getReponseSecrete());
                                prepare.setLong(9, obj.getIdAbonnement().getId());


				prepare.executeUpdate();
				obj = this.find(2);
			}
	    }
            catch (SQLException e) {
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
             //TODO remove that shit, man (something else, you say firstname = obj.getLastname and lastname = obj.getFirstname ???)
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
                 //TODO remove that shit, man
                	"DELETE FROM client WHERE dev_id = " + obj.getId()
                 );

	    } catch (SQLException e) {
	            e.printStackTrace();
	    }
	}

}