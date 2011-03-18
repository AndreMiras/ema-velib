/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import velib.model.User;

/**
 *
 * @author andre
 */
// TODO: finish up
public class UserDAO extends DAO<User>
{

    public UserDAO()
    {
        tableNames = new String[] { "users" };
    }

    public User create(User obj)
    {
        String usersTable = tableNames[0];
         try {
             /*
             ResultSet result = this.connect.createStatement(
                                ResultSet.TYPE_SCROLL_INSENSITIVE,
                      		ResultSet.CONCUR_UPDATABLE
                                    ).executeQuery(
                                       "SELECT NEXT VALUE FOR sequenceuser FROM " +
                                       usersTable +
                                       " as id"
                                    );
              *
              */

             ResultSet result = this.connect.createStatement(
                                ResultSet.TYPE_SCROLL_INSENSITIVE,
                      		ResultSet.CONCUR_UPDATABLE
                                    ).executeQuery(
                                       "CALL NEXT VALUE FOR sequence_users"
                                    );
            if(result.first())
            {
            long id = result.getLong(1);
            System.out.println("id :" + id);
            PreparedStatement prepare = this.connect.prepareStatement(
                                                    	"INSERT INTO " +
                                                        usersTable +
                                                        " (iduser, identifiant, password) VALUES(?, ?, ?)"
                                                    );
				prepare.setLong(1, id);
                                prepare.setString(2, obj.getIdentifiant());
				prepare.setString(3, obj.getPassword());

				prepare.executeUpdate();
				obj = this.find(id);
            }
	    }
            catch (SQLException e) {
	            e.printStackTrace();
	    }
	    return obj;
    }

    public User find(String identifiant, String password)
    {
        User user = new User();
        String usersTable = tableNames[0];
        
	try
        {
            ResultSet result = this.connect.createStatement(
                                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                                    ResultSet.CONCUR_READ_ONLY
                                     ).executeQuery(
                                    "SELECT * FROM " +
                                    usersTable +
                                    " WHERE identifiant = '" + identifiant +
                                    "' AND password = '" + password + "'"
                                    );
            if(result.first())
            {
                //System.out.println("I'm in the result");
                Long id = result.getLong("id");
                String identifiantDB = result.getString("identifiant");
                String passwordDB = result.getString("password");
                //System.out.println("id =" + id);

                user = new User(id, identifiantDB, passwordDB);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public User update(User obj)
    {
        String usersTable = tableNames[0];
        try {
                this .connect.createStatement(
                    	ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_UPDATABLE
                     ).executeUpdate(
                    	"UPDATE " +
                        usersTable +
                        " SET password = '" + obj.getPassword() + "'"+
                    	" WHERE id = " + obj.getUserId()
                     );

	obj = this.find(obj.getUserId());
	    }
        catch (SQLException e)
        {
	  e.printStackTrace();
	}
        return obj;
    }

    @Override
    public void delete(User obj)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public User find(long id)
    {
        User user = new User();
        String usersTable = tableNames[0];

	try
        {
            ResultSet result = this.connect.createStatement(
                                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                                    ResultSet.CONCUR_READ_ONLY
                                     ).executeQuery(
                                    "SELECT * FROM " +
                                    usersTable +
                                    " WHERE iduser = '" + id + "'"
                                    );
            if(result.first())
            {
                String identifiantDB = result.getString("identifiant");
                String passwordDB = result.getString("password");
              
                user = new User(id, identifiantDB, passwordDB);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public String[] createTablesStatementStrings()
    {
        String[] statementStrings = new String[5];
        statementStrings[0] =
                "CREATE SEQUENCE sequence_users START WITH 1 INCREMENT BY 1";
        statementStrings[1] =
                    String.format("CREATE TABLE %s" +
                    "(iduser INTEGER, " +
                    "identifiant VARCHAR(40), " +
                    "password VARCHAR(40), " , tableNames[0]);
         statementStrings[2] =
                "ALTER TABLE"
                + tableNames[0]
                + "ADD CONSTRAINT primary_key_users (iduser)";
      
        return statementStrings;
    }
}
