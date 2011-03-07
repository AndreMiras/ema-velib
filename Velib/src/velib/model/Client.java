/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.model;

/**
 *
 * @author fteysseire
 */
public class Client extends User {
    private String firstname;
    private String lastname;

    public Client() {
        // TODO: hardcoded value, ident envoyé de la BDD (DAO)
        super(1);
        
    }

    

    public Client(String firstname, String last) {
        this();
        this.firstname = firstname;
        this.lastname = lastname;
        //
    }





}
