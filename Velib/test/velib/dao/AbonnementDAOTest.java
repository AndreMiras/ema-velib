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
import velib.model.Abonnement;
import velib.model.AbonnementType;
import velib.model.TypeAbonnement;

/**
 *
 * @author andre
 */
public class AbonnementDAOTest {

    public AbonnementDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception
    {
    }

    @AfterClass
    public static void tearDownClass() throws Exception
    {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class AbonnementDAO.
     */
    @Test
    public void testCreate()
    {
        System.out.println("create");
        TypeAbonnement typeAbonnement;
        Abonnement abonnementFromDAO;

        typeAbonnement = new TypeAbonnement(0, AbonnementType.HALF_DAY);
        Abonnement abonnement = new Abonnement(typeAbonnement);
        
        AbonnementDAO abonnementDAO = new AbonnementDAO();
        abonnementFromDAO = abonnementDAO.create(abonnement);

        // the abonnement object shouldn't have an id
        assertEquals(abonnement.getId(), 0);

        // until it's being created by the DAO
        assertEquals(abonnementFromDAO.getId(), 1);
    }

    /**
     * Test of find method, of class AbonnementDAO.
     */
    @Test
    public void testFind()
    {
        System.out.println("find");
        long id = 0L;
        AbonnementDAO instance = new AbonnementDAO();
        Abonnement expResult = null;
        Abonnement result = instance.find(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class AbonnementDAO.
     */
    @Test
    public void testUpdate()
    {
        System.out.println("update");
        Abonnement obj = null;
        AbonnementDAO instance = new AbonnementDAO();
        Abonnement expResult = null;
        Abonnement result = instance.update(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class AbonnementDAO.
     */
    @Test
    public void testDelete()
    {
        System.out.println("delete");
        Abonnement obj = null;
        AbonnementDAO instance = new AbonnementDAO();
        instance.delete(obj);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createTablesStatementStrings method, of class AbonnementDAO.
     */
    @Test
    public void testCreateTablesStatementStrings()
    {
        System.out.println("createTablesStatementStrings");
        AbonnementDAO instance = new AbonnementDAO();
        String[] expResult = null;
        String[] result = instance.createTablesStatementStrings();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}