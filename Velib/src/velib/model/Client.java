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
    private long client_id;
    private String firstname;
    private String lastname;
    private Date dateNaissance;
    private String adresse;
    private long codePostal;

    private Abonnement abonnement;

    /*
     * plusieurs clients peuvent avoir la meme carte mais on considere qu'un
     * client n'a qu'une carte
     */
    private Bank banque;


    public Client()
    {
    }

    public Client(long idClient, String firstname, String lastname, User user)
    {
        super(user.getUserId(), user.getIdentifiant(), user.getPassword());
        this.client_id = idClient;
        this.firstname = firstname;
        this.lastname = lastname;
        
        this.dateNaissance = new Date();
        this.abonnement = new Abonnement();
        this.banque = new Bank();
    }

    public String getFirstname()
    {
        return firstname;
    }

    public String getLastname()
    {
        return lastname;
    }

    public String getFullName()
    {
        return firstname + " " + lastname;
    }

    public String getAdresse() {
        return adresse;
    }

    public long getCodePostal() {
        return codePostal;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    

    public long getClientId() {
        return client_id;
    }


    public Abonnement getAbonnement() {
        return abonnement;
    }

    public void setAbonnement(Abonnement abonnement) {
        this.abonnement = abonnement;
    }


    public Bank getBanque() {
        return banque;
    }

    public void setBanque(Bank banque) {
        this.banque = banque;
    }




    @Override
    public String toString()
    {
        return getFullName();
    }

    public User getUser()
    {
        return this;
    }

    public void setUser(User user)
    {
        setUserId(user.getUserId());
        setIdentifiant(user.getIdentifiant());
        setPassword(user.getPassword());
    }

    /*
    @Override
    public int getId()
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }
     * 
     */
}
