/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.dao;

import velib.model.Velo;
import velib.model.Borne;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import velib.model.Bornette;
import static org.junit.Assert.*;


/**
 *
 * @author andre
 */
public class BornetteDAOTest {

    public BornetteDAOTest() {
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
    public void setUp() throws Exception
    {
        setUpClass();
    }

    @After
    public void tearDown()
    {
    }

    @Test
    public void testCreate()
    {
        System.out.println("create Bornette");

        Borne borne = new Borne(0, "Borne1");
        Velo velo = new Velo(0, true);
        BornesDAO borneDAO = new BornesDAO();
        VeloDAO veloDAO = new VeloDAO();
         // set the id to 0, the db should give a correct one
        assertEquals(0, borne.getIdBorne());
        borne = borneDAO.create(borne);
        assertEquals(0, velo.getId());
        velo = veloDAO.create(velo);

        Bornette bornette = new Bornette(0, 1, borne, velo);
        BornetteDAO bornetteDAO = new BornetteDAO();
        
        assertEquals(0, bornette.getId());
        bornette = bornetteDAO.create(bornette);

        // the id should now be 1
        assertEquals(1, borne.getIdBorne());

    }

        @Test
    public void testFindBornetteLibre()
    {
        System.out.println("find bornette libre");

        BornesDAO borneDAO = new BornesDAO();
        VeloDAO veloDAO = new VeloDAO();
        BornetteDAO bornetteDAO = new BornetteDAO();

        Borne borne1 = new Borne(0, "Borne1");
        Velo velo1 = new Velo(0, true);
         // set the id to 0, the db should give a correct one
        assertEquals(0, borne1.getIdBorne());
        borne1 = borneDAO.create(borne1);
        assertEquals(0, velo1.getId());
        velo1 = veloDAO.create(velo1);

       Bornette bornette1 = new Bornette(0, 1, borne1, velo1);
       Bornette bornette2 = new Bornette (0, 1, borne1, null);
       bornette1 = bornetteDAO.create(bornette1);
       bornette2 = bornetteDAO.create(bornette2);

       Bornette bornetteResultat = bornetteDAO.findLibreOne(borne1.getIdBorne());

        assertEquals(bornetteResultat.getId(),2);
    }


    @Test
    public void testFindAllBornette()
    {
        System.out.println("find all bornette");
        BornesDAO borneDAO = new BornesDAO();
        BornetteDAO bornetteDAO = new BornetteDAO();

        Borne borne1 = new Borne(0, "Borne1");
        // set the id to 0, the db should give a correct one
        assertEquals(0, borne1.getIdBorne());
        borne1 = borneDAO.create(borne1);
 

       Bornette bornette1 = new Bornette(0, 1, borne1, null);
       Bornette bornette2 = new Bornette (0, 1, borne1, null);
       bornette1 = bornetteDAO.create(bornette1);
       bornette2 = bornetteDAO.create(bornette2);


        Bornette[] resultat = bornetteDAO.findLibreAll(borne1.getIdBorne());
       
        System.out.println("La taille du tableau de toute les bornettes est "
                +resultat.length);
        assertEquals(resultat.length,2);
    }

    @Test
     public void testFindBornetteOccupe()
    {
        
        System.out.println("find bornette occupe");

        BornesDAO borneDAO = new BornesDAO();
        VeloDAO veloDAO = new VeloDAO();
        BornetteDAO bornetteDAO = new BornetteDAO();

        Borne borne1 = new Borne(0, "Borne1");
        Velo velo1 = new Velo(0, true);
         // set the id to 0, the db should give a correct one
        assertEquals(0, borne1.getIdBorne());
        borne1 = borneDAO.create(borne1);
        assertEquals(0, velo1.getId());
        velo1 = veloDAO.create(velo1);

       Bornette bornette1 = new Bornette(0, 1, borne1, velo1);
       Bornette bornette2 = new Bornette (0, 1, borne1, null);
       bornette1 = bornetteDAO.create(bornette1);
       bornette2 = bornetteDAO.create(bornette2);

       Bornette bornetteResultat = bornetteDAO.findOccupe(borne1.getIdBorne());

        assertEquals(bornetteResultat.getId(),1);
    }

    @Test
    public void testFindBornette_long()
    {
        System.out.println("find bornette");
        testCreate();
        BornetteDAO bornetteDAO = new BornetteDAO();
        int id = 1;
        Bornette bornette = bornetteDAO.find(id);

        // IDs should match together
        assertEquals(id, bornette.getId());
    }

    @Test
    public void testNoFindBornette_long()
    {
        System.out.println("find bornette");
        testCreate();
        BornetteDAO bornetteDAO = new BornetteDAO();
        int id = 1;
        Bornette bornette = bornetteDAO.find(365);

        // IDs should match together
        assertEquals(null, bornette);

    }
    /**
     * Test of update method, of class ClientDAO.
     * TODO: this tests isn't finished at all
     */
    @Test
    public void testUpdate()
    {
        /* System.out.println("update borne");
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
        assertEquals(borne.getNomBorne(), "Borne2");*/

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