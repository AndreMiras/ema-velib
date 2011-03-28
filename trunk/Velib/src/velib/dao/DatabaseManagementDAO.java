/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import velib.model.Borne;
import velib.model.Bornette;
import velib.model.Client;
import velib.model.SubscriptionType;
import velib.model.SubscriptionTypeEnum;
import velib.model.User;
import velib.model.Velo;

/**
 *
 * @author andre
 */
public class DatabaseManagementDAO implements IDatabaseManagementDAO
{

    public Connection connect = ConnectionHSQL.getInstance();

    public void createDatabase()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void dropDatabase()
    {
        try
        {
        PreparedStatement prepare = this.connect.prepareStatement(
                    "DROP SCHEMA PUBLIC CASCADE ");
        prepare.execute();
        }
        catch (SQLException e)
        {
             e.printStackTrace();
        }
    }

    public void createTables()
    {
        createBornesTable();
        createUserTable();
        createBanquesTable();
        createTypeAbonnementTable();
        createAbonnementsTable();
        createClientTable();
        createVeloTable();
        createBornetteTable();
        createLocationTable();
     }

    public void dropTables()
    {
        dropUserTable();
        dropClientTable();
    }


    /*
     * Data for testing purpose only.
     * TODO: That won't be used in the final product
     */
    public void fillUpTables()
    {
        fillUpSubscriptionTypeTable();
        fillUpClientTable();
        fillUpBorneTable();
    }

    private void createUserTable()
    {
        UserDAO userDAO = new UserDAO();
        userDAO.createTables();
    }

    private void createClientTable()
    {
        ClientDAO clientDAO = new ClientDAO();
        clientDAO.createTables();
    }
    private void createAbonnementsTable()
    {
       AbonnementDAO abonnementDAO = new AbonnementDAO();
       abonnementDAO.createTables();
    }
    private void createBanquesTable()
    {
       BanqueDAO banqueDAO = new BanqueDAO();
       banqueDAO.createTables();
    }
    private void createBornesTable()
    {
       BornesDAO borneDAO = new BornesDAO();
       borneDAO.createTables();
    }
    private void createBornetteTable()
    {
       BornetteDAO bornetteDAO = new BornetteDAO();
       bornetteDAO.createTables();
    }
    private void createLocationTable()
    {
       LocationDAO locationDAO = new LocationDAO();
       locationDAO.createTables();
    }
    private void createTypeAbonnementTable()
    {
       SubscriptionTypeDAO subscriptionTypeDAO = new SubscriptionTypeDAO();
       subscriptionTypeDAO.createTables();
    }
    private void createVeloTable()
    {
       VeloDAO veloDAO = new VeloDAO();
       veloDAO.createTables();
    }

    private void fillUpBorneTable()
    {
        Borne borne;
        BornesDAO borneDAO;
        String nomBorne;
        Bornette bornette;
        BornetteDAO bornetteDAO;
        Velo velo;
        VeloDAO veloDAO;
        long numero = 0;
        int id = 0;

        // some latlong around Nimes center
        double latlongs[][] = new double[][] {
            {43.835, 4.361},
            {43.837, 4.366},
            {43.833, 4.362}
        };
        System.out.println("Filling up borne table");

       for (int i=0; i<3; i++)
       {
           nomBorne = "Borne" + i;

           borneDAO = new BornesDAO();
           borne = new Borne(id, nomBorne);
           borne.setLatLong(latlongs[i][0], latlongs[i][1]);
           borne = borneDAO.create(borne);

           for (int j=0; j<5; j++)
           {
               veloDAO = new VeloDAO();
               velo = new Velo (id);
               velo = veloDAO.create(velo);

               numero = j+1;
               bornetteDAO = new BornetteDAO();
               bornette = new Bornette(id, numero, borne, velo);
               bornette = bornetteDAO.create(bornette);
           }
       }
    }

    /*
     * Adds default subscription types
     */
    private void fillUpSubscriptionTypeTable()
    {
        SubscriptionTypeDAO subscriptionTypeDAO =
                new SubscriptionTypeDAO();
        // TODO: this is hardcoded at the moment but should be done
        // using iterate
        SubscriptionType subscriptionType =
                new SubscriptionType(SubscriptionTypeEnum.ONE_WEEK);
        subscriptionTypeDAO.create(subscriptionType);

        // and a second one (TODO: to be removed later)
        subscriptionType =
                new SubscriptionType(SubscriptionTypeEnum.ONE_MONTH);
        subscriptionTypeDAO.create(subscriptionType);

        subscriptionType =
                new SubscriptionType(SubscriptionTypeEnum.ONE_DAY);
        subscriptionTypeDAO.create(subscriptionType);
    }


    /*
     * TODO: get it cleaner
     */
    private void fillUpClientTable()
    {

       User user;
       Client client;
       UserDAO userDAO;
       ClientDAO clientDAO;
       int id = 0;
       long idUser = 0; // TODO: I think this shoulnd't have to be providen
               
       System.out.println("Filling up clients table");

       String[] firstnames = {
       "Jean",
       "Maurice",
       "Ives",
       "Gilles"
       };

       String[] lastnames = {
       "Dujardin",
       "Lebreton",
       "Legaragiste",
       "Desbois"
       };

       String[] addresses = {
       "5 rue torrino",
       "34 rue de tulipe",
       "6 avenue de la chips",
       "89 rue delpine"
       };

       String[] cities = {
       "Nimes",
       "Arraz",
       "Valence",
       "Montpeliz"
       };

       long[] CP = {
       30000,
       56870,
       26000,
       38462
       };

       for (int i=0; i<4; i++)
       {
           userDAO = new UserDAO();
           user = new User(id, firstnames[i], "pwd");
           user = userDAO.create(user);

           client = new Client(id, firstnames[i], lastnames[i], user);
           clientDAO = new ClientDAO();
           client.setAdresse(addresses[i]);
           client.setCodePostal(CP[i]);
           client.setVille(cities[i]);
           client = clientDAO.create(client);
           System.out.println("created client: " + client);
       }
    }

    private void dropUserTable()
    {
        UserDAO userDAO = new UserDAO();
        userDAO.dropTables();
    }

    private void dropClientTable()
    {
        ClientDAO clientDAO = new ClientDAO();
        clientDAO.dropTables();
    }

}
