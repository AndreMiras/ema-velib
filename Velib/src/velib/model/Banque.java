/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.model;

import java.util.Date;

/**
 *
 * @author Nicolas
 */
public class Banque {

     private long id;
     private long numero;
     private Date dateExpiration;
     private String identifiant;
     private long codeVerif;
     private Client client;

    public long getId() {
        return id;
    }

    public long getCodeVerif() {
        return codeVerif;
    }

    public Date getDateExpiration() {
        return dateExpiration;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public long getNumero() {
        return numero;
    }

    public Client getClient() {
        return client;
    }


    public java.sql.Date getDateExpirationSQL() {
        long t = dateExpiration.getTime();
        java.sql.Date dateExpirationSql = new java.sql.Date(t);
        return dateExpirationSql;
    }

     

}
