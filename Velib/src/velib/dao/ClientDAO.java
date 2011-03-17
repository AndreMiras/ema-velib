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
import velib.model.User;

public class ClientDAO extends DAO<Client>
{

        public ClientDAO()
    {
        tableNames = new String[] { "clients" };
    }


    public Client create(Client obj)
    {
        String clientTable = tableNames[0];
        /*
         * TODO: work on this use case:
         * trying to create a Client with an empty user reference
         * should lead to the DAO creating it automatically for us
         * see developpez article
         */
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
                           "SELECT NEXT VALUE FOR sequence_client FROM "
                           + clientTable
                           + " as id"
                        );
            if(result.first()){
            long id = result.getLong(1);
            System.out.println("id :" + id);
            PreparedStatement prepare = this.connect.prepareStatement(
                                            "INSERT INTO "
                                            + clientTable
                                            + " (idclient, "
                                            + "nomclient, "
                                            + "prenomclient, "
                                            + "datenaissance, "
                                            + "adresse, "
                                            + "codepostal, "
                                            + "questionsecrete, "
                                            + "reponsesecrete, "
                                            + "idabonnement, "
                                            + "idbanque) "
                                            + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"
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
                                prepare.setLong(10, obj.getIdBanque().getId());
				prepare.executeUpdate();
				obj = this.find(id);
			}
	    }
            catch (SQLException e) {
	            e.printStackTrace();
	    }
	    return obj;
    }


	public Client find(long id)
        {
                String clientTable = tableNames[0];
		Client client = new Client();
                UserDAO userDAO = new UserDAO();
                User user;

		try {
            ResultSet result = this .connect
                                    .createStatement(
                                    	ResultSet.TYPE_SCROLL_INSENSITIVE,
                                        ResultSet.CONCUR_READ_ONLY
                                     ).executeQuery(
                                        "SELECT * FROM "
                                        + clientTable
                                        + " WHERE id = " + id
                                     );
            if(result.first())
            {
                user = userDAO.find(result.getLong("iduser"));
                client = new Client(
                                    id,
                                    result.getString("firstname"),
                                    result.getString("lastname"), user);
            }

		    } catch (SQLException e) {
		            e.printStackTrace();
		    }
		   return client;

	}

        public Client find(User user)
        {
            return findByUser(user);
        }

        public Client findByUser(User user)
        {
            String clientTable = tableNames[0];
            Client client = new Client();

	try
        {
            ResultSet result = this.connect.createStatement(
                                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                                    ResultSet.CONCUR_READ_ONLY
                                     ).executeQuery(
                                    "SELECT * FROM "
                                    +  clientTable
                                    + " WHERE iduser = '"
                                    + user.getId()
                                    + "'"
                                    );
            if(result.first())
            {
             
                Long idClient = result.getLong("idclient");
                Long idUser = result.getLong("iduser");
                String nomClient = result.getString("nomclient");
                String prenomClient = result.getString("prenomclient");
                //System.out.println("id =" + id);

                client = new Client(idClient, prenomClient, nomClient, user);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return client;

        }

	public Client update(Client obj)
        {
            String clientTable = tableNames[0];
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
                    "UPDATE"
                    + clientTable
                    + " SET firstname = '" + obj.getLastname() + "',"
                    + " lastname = '" + obj.getFirstname() + "',"
                    + " WHERE id = " + obj.getId()
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
            String clientTable = tableNames[0];
            try
            {

                this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE
             ).executeUpdate(
             //TODO remove that shit, man
                    "DELETE FROM "
                     + clientTable
                     + "WHERE id = " + obj.getId()
             );

	    }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
	}

    @Override
    public String[] createTablesStatementStrings()
    {
        /*
         * TODO: see below
         */
        String[] statementStrings = new String[2];
        statementStrings[0] =
                "CREATE SEQUENCE sequence_client START WITH 1 INCREMENT BY 1";
        statementStrings[1] =
            String.format("CREATE TABLE %s" +
            "(id INTEGER, " +
            "nomclient VARCHAR(40), " +
            "prenomclient VARCHAR(40), " +
            "datenaissance DATE, " +
            "adresse VARCHAR(40), " +
            "codepostal VARCHAR(40), " +
            "reponsesecrete INTEGER, " + // TODO: to me this should be part of the user model, not the client
            "idabonnement INTEGER, " + // TODO: to be foreign key
            "iduser INTEGER, " + // TODO: to be foreign key
            "idbanque VARCHAR(40), " + // TODO: foreign key
            "PRIMARY KEY (id))", tableNames[0]);
        return statementStrings;
    }


}