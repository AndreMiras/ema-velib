/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.model;

import java.util.Date;

/**
 *
 * @author Nicolas
 * plusieurs clients peuvent avoir la meme carte mais on considere qu'un
 * client n'a qu'une carte
 */

public class Bank
{
     private long id;
     private String numero;
     private Date dateExpiration;
     // name on the card
     // TODO: change for relevant name e.g. cardHolder
     private String identifiant;
     private String codeVerif;
    
    public Bank(long id, String numero, String identifiant, String codeVerif)
    {
        this.id=id;
        this.numero=numero;
        this.identifiant=identifiant;
        this.codeVerif=codeVerif;
    }

    public Bank()
    {
    }
    
    public long getId() {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getCodeVerif() {
        return codeVerif;
    }

    public Date getDateExpiration() {
        return dateExpiration;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public String getNumero() {
        return numero;
    }

    public java.sql.Date getDateExpirationSQL() {
        long t = dateExpiration.getTime();
        java.sql.Date dateExpirationSql = new java.sql.Date(t);
        return dateExpirationSql;
    }

     

}
