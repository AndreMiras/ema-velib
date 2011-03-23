/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.dao;

import velib.model.Borne;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author andre
 */
public class BorneDAOTest {

    public BorneDAOTest() {
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
        System.out.println("create Borne");
        Borne borne = new Borne(0, "Borne1");
        BornesDAO borneDAO = new BornesDAO();
       
         // set the id to 0, the db should give a correct one
        assertEquals(0, borne.getIdBorne());

        borne = borneDAO.create(borne);

        // the id should now be 1
        assertEquals(1, borne.getIdBorne());
        
    }


    @Test
    public void testFindAllBorne()
    {
        System.out.println("find all borne");
        BornesDAO borneDAO = new BornesDAO();

        Borne borne1 = new Borne(0, "Borne1");
        assertTrue(borne1.getIdBorne() == 0);
        borne1 = borneDAO.create(borne1);

        Borne borne2 = new Borne(0, "Borne2");
        assertTrue(borne2.getIdBorne() == 0);
        borne1 = borneDAO.create(borne2);

        Borne[] resultat = borneDAO.findAllBorne();
        
        assertEquals(resultat.length,3);
    }

    @Test
    public void testFindBorneLibre()
    {
        System.out.println("find borne libre");
        BornesDAO borneDAO = new BornesDAO();

        Borne borne1 = new Borne(0, "Borne1");
        assertTrue(borne1.getIdBorne() == 0);
        borne1 = borneDAO.create(borne1);

        Borne borne2 = new Borne(0, "Borne2");
        borne2.setDisponible(false);
        assertTrue(borne2.getIdBorne() == 0);
        borne1 = borneDAO.create(borne2);

        Borne[] resultat = borneDAO.findBorneLibre();
        assertEquals(resultat.length,1);
    }

    @Test
    public void testFind_Borne()
    {
        System.out.println("find borne");
        BornesDAO borneDAO = new BornesDAO();
        int id = 1;
        Borne borne = borneDAO.find(id);
        
        // IDs should match together
        assertEquals(id, borne.getIdBorne());
    }

    /**
     * Test of update method, of class ClientDAO.
     * TODO: this tests isn't finished at all
     */
    @Test
    public void testUpdate()
    {
         System.out.println("update borne");
        Borne borne ;

        BornesDAO borneDAO = new BornesDAO();

        // first creating a new borne
        borne = new Borne(0, "Borne1");

        assertTrue(borne.getIdBorne() == 0);

        // create the borne in the DB
        borne = borneDAO.create(borne);
        // checking that the borne was actually created in the DB
         assertTrue(borne.getIdBorne() != 0);

        // before updating the name
        assertEquals(borne.getNomBorne(), "Borne1");

        // Updating name to Borne2
        borne.setNomBorne("Borne2");
        borneDAO.update(borne);
        assertEquals(borne.getNomBorne(), "Borne2");

    }

    /**
     * Test of delete method, of class ClientDAO.
     */
    @Test
    public void testDelete()
    {
        
    }

    /**
     * Test of createTablesStatementStrings method, of class ClientDAO.
     */
    @Test
    public void testCreateTablesStatementStrings()
    {
        System.out.println("createTablesStatementStrings");
        BornesDAO instance = new BornesDAO();
        String[] result = instance.createTablesStatementStrings();

        // very basic test
        assertTrue(result.length > 0);
    }

}