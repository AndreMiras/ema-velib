/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.dao;
import velib.model.User;

/**
 *
 * @author andre
 */
// TODO: finish up
public class UserDAO extends DAO<User> {
    public User create(User obj)
    {
        return null;
    }

    @Override
    public User find(long id)
    {
        throw new UnsupportedOperationException("Not supported yet.");
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
