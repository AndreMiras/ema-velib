/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.model;

import java.util.Date;

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

    public Client() {
        // TODO: hardcoded value, ident envoyé de la BDD (DAO)
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
