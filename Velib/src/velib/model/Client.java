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
    private Date dateNaissance; // TODO: is it worth keeping that?
    private String adresse;
    private long codePostal;
    private String questionSecrete;
    private String reponseSecrete;
    private Abonnement abonnement;
    private Banque idBanque;


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

    public long getClientId() {
        return client_id;
    }


    public Abonnement getAbonnement() {
        return abonnement;
    }

    public String getQuestionSecrete() {
        return questionSecrete;
    }

    public String getReponseSecrete() {
        return reponseSecrete;
    }

    public Banque getIdBanque() {
        return idBanque;
    }


    @Override
    public String toString()
    {
        return getFullName();
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
