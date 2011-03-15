/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.model;

import sun.security.util.Password;

/**
 *
 * @author fteysseire
 */
public class User implements IModel {

    private long id;
    private String password;

    public User()
    {
    }

    

    public User(long id, String password) {
        this.id = id;
        this.password = password;
    }

    public long getId()
    {
        return id;
    }

      public String getPassword()
    {
        return password;
    }

    


}
