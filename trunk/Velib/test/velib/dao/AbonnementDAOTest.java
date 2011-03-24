/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.dao;

import java.util.Calendar;
import java.util.Date;
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

    // before the test
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

    // after the test
    @AfterClass
    public static void tearDownClass() throws Exception
    {
        DatabaseManagementDAO databaseManagementDAO =
                new DatabaseManagementDAO();
        // databaseManagementDAO.dropTables();

        // cleaning-up
        databaseManagementDAO.dropDatabase();
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
        Date today, tomorrow;

        today = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        calendar.add(Calendar.DATE, 1); // adding a day to today
        tomorrow = calendar.getTime();

        typeAbonnement = new TypeAbonnement(0, AbonnementType.HALF_DAY);
        Abonnement abonnement = new Abonnement(0, typeAbonnement);
        abonnement.setDateDebut(today);
        abonnement.setDateFin(tomorrow);
        
        AbonnementDAO abonnementDAO = new AbonnementDAO();
        abonnementFromDAO = abonnementDAO.create(abonnement);

        // the abonnement object shouldn't have an id
        assertEquals(0, abonnement.getId());
        assertEquals(today, abonnement.getDateDebut());
        assertEquals(tomorrow, abonnement.getDateFin());

        // until it's being created by the DAO
        assertEquals(1, abonnementFromDAO.getId());
        assertEquals(today, abonnementFromDAO.getDateDebut());
        assertEquals(tomorrow, abonnementFromDAO.getDateFin());
    }

    /**
     * Test of find method, of class AbonnementDAO.
     */
    @Test
    public void testFind()
    {
        System.out.println("find");

        AbonnementDAO instance = new AbonnementDAO();
        Abonnement expResult = null;

        // trying to find an non existing object
        Abonnement result = instance.find(0);
        assertEquals(null, result);

        // trying to find an existing one
        result = instance.find(1);
        assertEquals(1, result.getId());
    }

    /**
     * Test of update method, of class AbonnementDAO.
     * TODO: change/add date
     * http://www.rgagnon.com/javadetails/java-0101.html
     * http://stackoverflow.com/questions/428918/how-can-i-increment-a-date-by-one-day-in-java
     */
    @Test
    public void testUpdate()
    {
        System.out.println("update");
        Date yesterday, today, tomorrow, dateDebut, dateFin;
        Abonnement abonnementBeforeUpdate, abonnementAfterUpdate;
        AbonnementDAO abonnementDAO = new AbonnementDAO();
        dateFin = new Date();
        today = new Date();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        calendar.add(Calendar.DATE, 1); // adding a day to today
        tomorrow = calendar.getTime();

        calendar.setTime(today);
        calendar.add(Calendar.DATE, -1); // removing a day to today
        yesterday = calendar.getTime();

        abonnementBeforeUpdate = abonnementDAO.find(1);
        abonnementBeforeUpdate.setDateDebut(yesterday);
        abonnementBeforeUpdate.setDateFin(tomorrow);

        // updating
        abonnementAfterUpdate = abonnementDAO.update(abonnementBeforeUpdate);

        // the dates should be as
        assertEquals(yesterday, abonnementAfterUpdate.getDateDebut());
        assertEquals(tomorrow, abonnementAfterUpdate.getDateFin());
    }

    /**
     * Test of delete method, of class AbonnementDAO.
     */
    @Test
    public void testDelete()
    {
        System.out.println("delete");
        AbonnementDAO abonnementDAO = new AbonnementDAO();

        Abonnement abonnement = abonnementDAO.find(1);
        abonnementDAO.delete(abonnement);
        assertEquals(1, abonnement.getId());

        // after deleting, the find should return null
        abonnement = abonnementDAO.find(1);
        assertEquals(null, abonnement);
    }

    /**
     * Test of createTablesStatementStrings method, of class AbonnementDAO.
     */
    @Test
    public void testCreateTablesStatementStrings()
    {
        System.out.println("createTablesStatementStrings");
        AbonnementDAO instance = new AbonnementDAO();
        String[] result = instance.createTablesStatementStrings();

        // very basic test
        assertTrue(result.length > 0);
    }

}