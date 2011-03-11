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
    private long id;
    private String firstname;
    private String lastname;

    public Client() {
        // TODO: hardcoded value, ident envoye de la BDD (DAO)
        super(1);
        
    }

    

    public Client(long id, String firstname, String lastname) {
        this();
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        //
    }

    public String getFirstname()
    {
        return firstname;
    }

    public String getLastname()
    {
        return lastname;
    }

    public int getId()
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }





}
