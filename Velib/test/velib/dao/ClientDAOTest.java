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
public class ClientDAOTest {

    public ClientDAOTest() {
    }

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
        Client client = new Client(0, "fistname", "lastname", user);

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
        User user = null;
        ClientDAO instance = new ClientDAO();
        Client expResult = null;
        Client result = instance.find(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByUser method, of class ClientDAO.
     */
    @Test
    public void testFindByUser()
    {
        System.out.println("findByUser");
        User user = null;
        ClientDAO instance = new ClientDAO();
        Client expResult = null;
        Client result = instance.findByUser(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class ClientDAO.
     */
    @Test
    public void testUpdate()
    {
        System.out.println("update");
        Client obj = null;
        ClientDAO instance = new ClientDAO();
        Client expResult = null;
        Client result = instance.update(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class ClientDAO.
     */
    @Test
    public void testDelete()
    {
        System.out.println("delete");
        Client obj = null;
        ClientDAO instance = new ClientDAO();
        instance.delete(obj);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createTablesStatementStrings method, of class ClientDAO.
     */
    @Test
    public void testCreateTablesStatementStrings()
    {
        System.out.println("createTablesStatementStrings");
        ClientDAO instance = new ClientDAO();
        String[] expResult = null;
        String[] result = instance.createTablesStatementStrings();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}