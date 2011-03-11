/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.model;

import java.util.Date;
import sun.security.util.Password;

/**
 *
 * @author fteysseire
 */
public class Client extends User {
    private long id;
    private String firstname;
    private String lastname;
    private Date dateNaissance;
    private String adresse;
    private long codePostal;
    private String questionSecrete;
    private String reponseSecrete;
    private Abonnement idAbonnement;


    

    public Client(long id, String firstname, String lastname) {
        super(1, new Password()); // TODO: hardcoded
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
