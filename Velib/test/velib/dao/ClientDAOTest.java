/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.dao;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import velib.model.Client;
import velib.model.User;

/**
 *
 * @author andre
 */
public class ClientDAOTest
{

    public ClientDAOTest() {
    }

    //Méthode effectuée avant le test
    @BeforeClass
    public static void setUpClass() throws Exception
    {
        ConnectionHSQL.getDebugInstance();

        DatabaseManagementDAO databaseManagementDAO =
                new DatabaseManagementDAO();

        // cleaning-up before all
        databaseManagementDAO.dropDatabase();

        databaseManagementDAO.createTables();
    }

    //Méthode effectuée à la fin du test
    @AfterClass
    public static void tearDownClass() throws Exception
    {
        DatabaseManagementDAO databaseManagementDAO =
                new DatabaseManagementDAO();
        // databaseManagementDAO.dropTables();

        // cleaning-up
        databaseManagementDAO.dropDatabase();
    }

    /*
     * Instanciating an in-memory hsql db instance
     * Creating tables
     */
    @Before
    public void setUp()
    {
    }

    @After
    public void tearDown()
    {
    }

    /**
     * Test of create method, of class ClientDAO.
     */
    @Test
    public void testCreate()
    {
        System.out.println("create");
        User user = new User(0, "user", "pwd");
        UserDAO userDAO = new UserDAO();
        user = userDAO.create(user);

        
        ClientDAO clientDAO = new ClientDAO();
        Client client = new Client(0, "firstname", "lastname", user);

        // set the id to 0, the db should give a correct one
        assertEquals(0, client.getClientId());

        client = clientDAO.create(client);

        // the id should now be 1
        assertEquals(1, client.getClientId());
    }

    /**
     * Test of find method, of class ClientDAO.
     * TODO: comment these tests
     */
    @Test
    public void testFind_long()
    {
        System.out.println("find");
        long id = 1;
        ClientDAO instance = new ClientDAO();
        Client client = instance.find(id);
        assertEquals(id, client.getClientId());
    }

    /**
     * Test of find method, of class ClientDAO.
     */
    @Test
    public void testFind_User()
    {
        System.out.println("find");
        UserDAO userDAO = new UserDAO();
        User user = userDAO.find(1);
        ClientDAO instance = new ClientDAO();
        Client result = instance.find(user);

        // IDs should match together
        assertEquals(user.getUserId(), result.getUserId());
        assertEquals(user.getIdentifiant(), result.getIdentifiant());
    }

    /**
     * Test of findByUser method, of class ClientDAO.
     * TODO: should we keep that one, same as above
     */
    @Test
    public void testFindByUser()
    {
        System.out.println("findByUser");
        testFind_User();
    }

    /**
     * Test of update method, of class ClientDAO.
     * Firstname, lastname and birthdate cannot be changed for a client
     * all the other attribute can.
     */
    @Test
    public void testUpdate()
    {
        System.out.println("update client");
        Client client;
        
        ClientDAO clientDAO = new ClientDAO();

        // first creating a new client
        client = new Client(0, "Andre", "Miras", new User());
        client.setVille("Montpellier");
        assertTrue(client.getClientId() == 0);

        // create the client in the DB
        client = clientDAO.create(client);
        // checking that the client was actually created in the DB
        System.out.println("Id du client après création : " + client.getClientId());
         assertTrue(client.getClientId() != 0);
         System.out.println("Ville avant update " + client.getVille());

        // before updating the city
        assertEquals(client.getFirstname(), "Andre");

        System.out.println("Ville avant update " + client.getVille());
        
        // Updating ville to Nimes
        client.setVille("Nimes");
        client = clientDAO.update(client);

        assertEquals(client.getVille(), "Nimes");
    }

    /**
     * Test of delete method, of class ClientDAO.
     */
    @Test
    public void testDelete()
    {
        System.out.println("delete");
        Client client;
        ClientDAO clientDAO = new ClientDAO();
        client = clientDAO.find(1);
        
        // the client should exist
        assertNotNull(client);
        clientDAO.delete(client);
        
        // the client should NOT exist
        client = clientDAO.find(1);
        assertNull(client);
    }

    /**
     * Test of createTablesStatementStrings method, of class ClientDAO.
     */
    @Test
    public void testCreateTablesStatementStrings()
    {
        System.out.println("createTablesStatementStrings");
        ClientDAO instance = new ClientDAO();
        String[] result = instance.createTablesStatementStrings();

        // very basic test
        assertTrue(result.length > 0);
    }

}