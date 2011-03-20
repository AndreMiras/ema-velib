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

//plusieurs clients peuvent avoir la meme carte mais on considere qu'un client n'a qu'une carte
public class Bank {

     private long id;
     private long numero;
     private Date dateExpiration;
     private String identifiant;
     private long codeVerif;
    
    public Bank(long id, long numero, String identifiant, long codeVerif) {
        this.id=id;
        this.numero=numero;
        this.identifiant=identifiant;
        this.codeVerif=codeVerif;
    }

    public Bank() {
    }
    
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

    public java.sql.Date getDateExpirationSQL() {
        long t = dateExpiration.getTime();
        java.sql.Date dateExpirationSql = new java.sql.Date(t);
        return dateExpirationSql;
    }

     

}
