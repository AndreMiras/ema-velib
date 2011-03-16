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
    private Banque idBanque;


    public Client()
    {
    }

    public Client(long id, String firstname, String lastname) {
        super(1, new String(), new String()); // TODO: hardcoded
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getFirstname()
    {
        return firstname;
    }

    public String getLastname()
    {
        return lastname;
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

    //To insert the data in the database
    public java.sql.Date getDateNaissanceSQL() {
        long t = dateNaissance.getTime();
        java.sql.Date dateNaissanceSql = new java.sql.Date(t);
        return dateNaissanceSql;
    }

    @Override
    public long getId() {
        return super.getId();
    }

    public Abonnement getIdAbonnement() {
        return idAbonnement;
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

    /*
    @Override
    public int getId()
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }
     * 
     */
}