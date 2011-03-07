/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.model;

/**
 *
 * @author fteysseire and andre
 */
public class Client extends User implements IModel {
    private String firstname;
    private String lastname;

    public Client() {
        // TODO: hardcoded value, ident envoye de la BDD (DAO)
        super(1);
        
    }

    

    public Client(String firstname, String lastname) {
        this();
        this.firstname = firstname;
        this.lastname = lastname;
        //
    }





}
