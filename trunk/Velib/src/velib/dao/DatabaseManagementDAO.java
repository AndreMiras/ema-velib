/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

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


    /*
     * Data for testing purpose only.
     * TODO: That won't be used in the final product
     */
    public void fillUpTables()
    {
        fillUpUserTable();
    }


    private void createUserTable()
    {
        String tableName = "user";

        System.out.println("Creating table user");
        try
        {
            Statement statement = connect.createStatement();

            String sql =
                    String.format("CREATE TABLE %s" +
                    "(id INTEGER, " +
                    "password VARCHAR, " +
                    "PRIMARY KEY (id))", tableName);

            System.out.println("SQL: " + sql);

            statement.executeUpdate(sql);
        }
        catch (SQLException ex)
        {
            System.out.println("Error creating user table: " + ex);
            Logger.getLogger(DatabaseManagementDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void fillUpUserTable()
    {
        System.out.println("Filling up user table");
        try
        {
            // INSERT INTO Test (Id, Name) VALUES (NULL,'Test');
            PreparedStatement prepare = this.connect.prepareStatement("INSERT INTO user (id, password) VALUES(?, ?)");
            // user1
            prepare.setLong(1, 1);
            prepare.setString(2, "pwd1");
            prepare.executeUpdate();
            // user2
            prepare.setLong(1, 2);
            prepare.setString(2, "pwd2");
            prepare.executeUpdate();
            // user3
            prepare.setLong(1, 3);
            prepare.setString(2, "pwd3");
            prepare.executeUpdate();
        }
        catch (SQLException ex)
        {
            System.out.println("Error inserting to user table: " + ex);
            Logger.getLogger(DatabaseManagementDAO.class.getName()).log(Level.SEVERE, null, ex);
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
