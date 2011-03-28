package velib.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import velib.model.Subscription;
import velib.model.Bank;

import velib.model.Client;
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
        if(obj.getAbonnement().getId() == 0)
        {
            AbonnementDAO abonnementDAO = new AbonnementDAO();
            obj.setAbonnement(abonnementDAO.create(obj.getAbonnement()));
        }
        //Si le compte en banque n'existe pas
        if(obj.getBanque().getId() == 0)
        {
            BanqueDAO banqueDAO = new BanqueDAO();
            obj.setBanque(banqueDAO.create(obj.getBanque()));
        }
        try
        {
            ResultSet result = connect.createStatement(
            ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.CONCUR_UPDATABLE).executeQuery(
                "CALL NEXT VALUE FOR sequence_clients");

            if(result.first())
            {
                long id = result.getLong(1);

                PreparedStatement prepare =
                        connect.prepareStatement(
                            "INSERT INTO "
                            + clientTable
                            + " (idclient, "
                            + "firstname, "
                            + "lastname, "
                            + "datenaissance, "
                            + "adresse, "
                            + "ville, "
                            + "codepostal, "
                            + "idsubscription, "
                            + "iduser, "
                            + "idbanque) "
                            + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                prepare.setLong(1, id);
                prepare.setString(2, obj.getFirstname());
                prepare.setString(3, obj.getLastname());
                prepare.setDate(4,
                        new java.sql.Date(
                        obj.getDateNaissance().getTime()));
                prepare.setString(5, obj.getAdresse());
                prepare.setString(6, obj.getVille());
                prepare.setLong(7, obj.getCodePostal());
                prepare.setLong(8, obj.getAbonnement().getId());
                prepare.setLong(9, obj.getUserId());
                prepare.setLong(10, obj.getBanque().getId());

                prepare.executeUpdate();

                obj = find(id);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
	return obj;
    }


	public Client find(long id)
        {
            String clientTable = tableNames[0];
            Client client = null;
            UserDAO userDAO = new UserDAO();
            BanqueDAO banqueDAO = new BanqueDAO();
            AbonnementDAO abonnementDAO = new AbonnementDAO();
            User user;
            Bank banque;
            Subscription subscription;
          

            try
            {
                String sqlString =  "SELECT * FROM "
                        + clientTable
                        + " WHERE idclient = '" + id + "'";
                ResultSet result = this .connect
                                        .createStatement(
                                            ResultSet.TYPE_SCROLL_INSENSITIVE,
                                            ResultSet.CONCUR_READ_ONLY
                                         ).executeQuery(sqlString);
                if(result.first())
                {
                    user = userDAO.find(result.getLong("iduser"));
                    banque = banqueDAO.find(result.getLong("idbanque"));
                    subscription = abonnementDAO.find(
                            result.getLong("idsubscription"));
                    client = new Client(
                                        result.getLong("idclient"),
                                        result.getString("firstname"),
                                        result.getString("lastname"), user);
                    client.setAdresse(result.getString("adresse"));
                    client.setVille(result.getString("ville"));
                    client.setDateNaissance(result.getTimestamp("Datenaissance"));
                    client.setCodePostal(result.getLong("codepostal"));
                    client.setBanque(banque);
                    client.setAbonnement(subscription);
                }

            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
            return client;
	}

        public Client findByName(String lastname, String firstname)
        {
            String clientTable = tableNames[0];
            Client client = null;

            try
            {
                ResultSet result = this .connect
                                        .createStatement(
                                            ResultSet.TYPE_SCROLL_INSENSITIVE,
                                            ResultSet.CONCUR_READ_ONLY
                                         ).executeQuery(
                                            "SELECT idclient FROM "
                                            + clientTable
                                            + " WHERE firstname = '" + firstname + "'"
                                            + " AND lastname = '" + lastname + "'"
                                         );
                if(result.first())
                {
                    client = find(result.getLong("idclient"));
                }

            }
            catch (SQLException e)
            {
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
            Client client = null;

            try
            {
                 ResultSet result = this.connect.createStatement(
                                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                                    ResultSet.CONCUR_READ_ONLY
                                     ).executeQuery(
                                    "SELECT idclient FROM "
                                    +  clientTable
                                    + " WHERE iduser = '"
                                    + user.getUserId()
                                    + "'"
                                    );
                if(result.first())
                {
                    client = find(result.getLong("idclient"));
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
                    "UPDATE "
                    + clientTable
                    + " SET iduser = '" + obj.getUserId() + "',"
                    + " idbanque = '" + obj.getBanque().getId() + "',"
                    + " idsubscription = '" + obj.getAbonnement().getId() + "',"
                    + " firstname = '" + obj.getFirstname() + "',"
                    + " lastname = '" + obj.getLastname() + "',"
                    + " datenaissance = '" + new java.sql.Date(obj.getDateNaissance().getTime()) + "',"
                    + " adresse = '" + obj.getAdresse() + "',"
                    + " ville = '" + obj.getVille() + "',"
                    + " codepostal = '" + obj.getCodePostal() + "'"
                    + " WHERE idclient = " + obj.getClientId()
             );

                obj = this.find(obj.getClientId());
            }
            catch (SQLException e)
            {
                e.printStackTrace();
                obj = null;
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
                     + " WHERE idclient = " + obj.getClientId()
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
            "adresse VARCHAR(200), " +
            "ville VARCHAR(40), " +
            "codepostal VARCHAR(40), " +
            "idsubscription INTEGER, " +
            "iduser INTEGER, " +
            "idbanque INTEGER) " , tableNames[0]);
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
                 + " ADD CONSTRAINT foreign_key_clients_subscription FOREIGN KEY (idsubscription) REFERENCES subscriptions (idsubscription)";
         statementStrings[5] =
                 "ALTER TABLE "
                 + tableNames[0]
                 + " ADD CONSTRAINT foreign_key_clients_banques FOREIGN KEY (idbanque) REFERENCES banques (idbanque)";
         return statementStrings;
    }


}
