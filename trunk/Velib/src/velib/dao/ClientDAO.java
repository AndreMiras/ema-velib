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
import velib.model.Abonnement;
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

        //If user doesn't exist
        if(obj.getUser().getUserId() == 0)
        {
            UserDAO userDAO = new UserDAO();
            obj.setUser(userDAO.create(obj.getUser()));
        }
        //Si l'abonnement n'existe pas
        /*if(obj.getAbonnement().getId() == 0)
        {
            AbonnementDAO abonnementDAO = new AbonnementDAO();
            obj.setAbonnement(abonnementDAO.create(obj.getAbonnement()));
        }*/
        //Si le compte en banque n'existe pas
        /*if(obj.getBanque().getId() == 0)
        {
            BanqueDAO banqueDAO = new BanqueDAO();
            obj.setBanque(banqueDAO.create(obj.getBanque()));
        }*/
         try
         {
             ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE
                        ).executeQuery(
                           "CALL NEXT VALUE FOR sequence_clients"
                        );
            if(result.first()){
            long id = result.getLong(1);
            System.out.println("id :" + id);
            PreparedStatement prepare = this.connect.prepareStatement(
                                            "INSERT INTO "
                                            + clientTable
                                            + " (idclient, "
                                            + "firstname, "
                                            + "lastname, "
                                            + "datenaissance, "
                                            + "adresse, "
                                            + "codepostal, "
                                            + "idabonnement, "
                                            + "iduser, "
                                            + "idbanque) "
                                            + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)"
                                        );
				prepare.setLong(1, id);
				prepare.setString(2, obj.getLastname());
                                prepare.setString(3, obj.getFirstname());
                                prepare.setDate(4,
                                        new java.sql.Date(
                                        obj.getDateNaissance().getTime()));
                                prepare.setString(5, obj.getAdresse());
                                prepare.setLong(6, obj.getCodePostal());
                                prepare.setLong(7, obj.getAbonnement().getId());
                                prepare.setLong(8, obj.getUserId());
                                prepare.setLong(9, obj.getBanque().getId());
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
                                        + " WHERE idclient = " + id
                                     );
            if(result.first())
            {
                user = userDAO.find(result.getLong("iduser"));
                client = new Client(
                                    id,
                                    result.getString("firstname"),
                                    result.getString("lastname"), user);
            }

            }
            catch (SQLException e) {
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
                                    + user.getUserId()
                                    + "'"
                                    );
            if(result.first())
            {
             
                Long idClient = result.getLong("idclient");
                Long idUser = result.getLong("iduser");
                String firstname = result.getString("firstname");
                String lastname = result.getString("lastname");
                //System.out.println("id =" + id);

                client = new Client(idClient, firstname, lastname, user);
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
                      this.connect.createStatement(
                        ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_UPDATABLE
             ).executeUpdate(
             //TODO remove that shit, man (something else, you say firstname = obj.getLastname and lastname = obj.getFirstname ???)
                    "UPDATE"
                    + clientTable
                    + " SET iduser = '" + obj.getUserId() + "',"
                    + " idbanque = '" + obj.getBanque().getId() + "',"
                    + " idabonnement = '" + obj.getAbonnement().getId() + "',"
                    + " WHERE id = " + obj.getClientId()
             );

                obj = this.find(obj.getClientId());
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
                     + "WHERE id = " + obj.getClientId()
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
        String[] statementStrings = new String[6];
        statementStrings[0] =
                "CREATE SEQUENCE sequence_clients START WITH 1 INCREMENT BY 1";
        statementStrings[1] =
            String.format("CREATE TABLE %s" +
            "(idclient INTEGER, " +
            "firstname VARCHAR(40), " +
            "lastname VARCHAR(40), " +
            "datenaissance DATE, " +
            "adresse VARCHAR(40), " +
            "codepostal VARCHAR(40), " +
            // TODO: to me this should be part of the user model, not the client
            "idabonnement INTEGER, " + // TODO: to be foreign key
            "iduser INTEGER, " + // TODO: to be foreign key
            "idbanque INTEGER) " , tableNames[0]); // TODO: foreign key
         statementStrings[2] =
                 "ALTER TABLE "
                 + tableNames[0]
                 + " ADD CONSTRAINT primary_key_clients PRIMARY KEY (idclient)";
         statementStrings[3] =
                 "ALTER TABLE "
                 + tableNames[0]
                 + " ADD CONSTRAINT foreign_key_clients_users FOREIGN KEY (iduser) REFERENCES users (iduser)";
         statementStrings[4] =
                 "ALTER TABLE "
                 + tableNames[0]
                 + " ADD CONSTRAINT foreign_key_clients_abonnement FOREIGN KEY (idabonnement) REFERENCES abonnements (idabonnement)";
         statementStrings[5] =
                 "ALTER TABLE "
                 + tableNames[0]
                 + " ADD CONSTRAINT foreign_key_clients_banques FOREIGN KEY (idbanque) REFERENCES banques (idbanques)";
         return statementStrings;
    }


}