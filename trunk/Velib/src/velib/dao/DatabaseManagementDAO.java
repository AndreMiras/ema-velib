/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author andre
 */
public class DatabaseManagementDAO implements IDatabaseManagementDAO
{

    public Connection connect = ConnectionHSQL2.getInstance();

    public void createDatabase()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void dropDatabase()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void createTables()
    {
        createUserTable();
    }

    public void dropTables()
    {
        dropUserTable();
    }


    // TODO: add keys and constraints
    private void createUserTable()
    {
        String tableName = "user";

        System.out.println("Creating table user");
        try
        {
            Statement statement = connect.createStatement();

            String sql =
                    String.format("CREATE TABLE %s" +
                    "(id INTEGER" +
                    "password VARCHAR", tableName);

            System.out.println("SQL: " + sql);

            statement.executeUpdate(sql);
        }
        catch (SQLException e) // TODO: handle this exception properly
        {
            System.out.println("Error creating user table: " + e);
        }
    }

    private void dropUserTable()
    {
        String tableName = "user";

        System.out.println("Dropping table user");
        try
        {
            Statement statement = connect.createStatement();

            String sql = "DROP TABLE " + tableName;

            statement.executeUpdate(sql);
        }
        catch (SQLException e)
        {
            System.out.println("Error dropping user table: " + e);
        }
    }

}
