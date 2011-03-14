/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.dao;

/**
 *
 * @author andre
 *  Helper for creading/deleting database and tables
 */
public interface IDatabaseManagementDAO
{

    public void createDatabase();

    public void dropDatabase();

    public void createTables();
    
    public void dropTables();

}
