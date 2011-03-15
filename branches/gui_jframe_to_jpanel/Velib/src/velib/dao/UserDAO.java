/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.dao;
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
    public User create(User obj)
    {
        return null;
    }

    @Override
    public User find(long id)
    {
        User user = new User();
        
	try
        {
        ResultSet result =
                this.connect.createStatement(
                                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                                    ResultSet.CONCUR_READ_ONLY
                                 ).executeQuery(
                                    "SELECT * FROM user WHERE id = " + id
                                 );
        if(result.first())
        {
            user = new User(
                    id,
                    result.getString("password"));
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
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(User obj)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
