/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import velib.model.Borne;
import velib.model.Bornette;
import velib.model.Client;
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
        // fillUpUserTable();
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
       TypeAbonnementDAO typeAbonnementDAO = new TypeAbonnementDAO();
       typeAbonnementDAO.createTables();
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

           veloDAO = new VeloDAO();
           velo = new Velo (id);
           velo = veloDAO.create(velo);

           numero = i+1;
           bornetteDAO = new BornetteDAO();
           bornette = new Bornette(id, numero, borne, velo);
           bornette = bornetteDAO.create(bornette);

           System.out.println("created borne: " + borne);
           System.out.println("created bornette: " + bornette);
       }
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

       String firstname;
       String lastname;
               
       System.out.println("Filling up clients table");
       for (int i=0; i<3; i++)
       {
           firstname = "firstname" + i;
           lastname = "lastname" + i;

           userDAO = new UserDAO();
           user = new User(id, "user", "pwd");
           user = userDAO.create(user);
           
           client = new Client(id, firstname, lastname, user);
           clientDAO = new ClientDAO();
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
