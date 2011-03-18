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
import velib.model.Client;
import velib.model.User;

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
        createClientTable();
        createVeloTable();
        createBanquesTable();
        createTypeAbonnementTable();
        createAbonnementsTable();
        createBanquesTable();
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

    private void fillUpUserTable()
    {
        System.out.println("Filling up user table");
        
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
