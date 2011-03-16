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
    private String identifiant;
    private String password;

    public User()
    {
        this.id = 0;
        this.password = "";
        this.identifiant="";
    }   

    public User(long id, String identifiant, String password) {
        this.id = id;
        this.identifiant=identifiant;
        this.password = password;
    }

    public long getId()
    {
        return id;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public String getPassword()
    {
        return password;
    }


    


}