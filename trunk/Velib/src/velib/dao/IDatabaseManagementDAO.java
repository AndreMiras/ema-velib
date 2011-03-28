package velib.dao;

/**
 *  Helper for creading/deleting database and tables
 */
public interface IDatabaseManagementDAO
{

    public void createDatabase();

    public void dropDatabase();

    public void createTables();
    
    public void dropTables();

    public void fillUpTables();

}
