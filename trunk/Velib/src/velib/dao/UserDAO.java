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
             ResultSet result = this.connect.createStatement(
                                ResultSet.TYPE_SCROLL_INSENSITIVE,
                      		ResultSet.CONCUR_UPDATABLE
                                    ).executeQuery(
                                       "SELECT NEXT VALUE FOR sequenceuser FROM " +
                                       usersTable +
                                       " as id"
                                    );
            if(result.first())
            {
            long id = result.getLong(1);
            System.out.println("id :" + id);
            PreparedStatement prepare = this.connect.prepareStatement(
                                                    	"INSERT INTO " +
                                                        usersTable +
                                                        " (id, identifiant, password) VALUES(?, ?, ?)"
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
                    	" WHERE id = " + obj.getId()
                     );

	obj = this.find(obj.getId());
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
    public User find(long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void createTable()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void dropTable()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
