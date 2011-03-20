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
public class Abonnement {

    private long id;
    private Date dateDebut;
    private Date dateFin;
    private Client client;
    private TypeAbonnement type;
  
    public Abonnement () {
        // TODO: hardcoded value, ident envoyé de la BDD (DAO)
        this.id=0;
        this.dateDebut = new Date();
        this.dateFin = new Date();
    }

    public long getId() {
        return id;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public Client getClient() {
        return client;
    }

    public TypeAbonnement getType() {
        return type;
    }
    
    public java.sql.Date getDateDebutSQL() {
        long t = dateDebut.getTime();
        java.sql.Date dateDebutSql = new java.sql.Date(t);
        return dateDebutSql;
    }

    public java.sql.Date getDateFinSQL() {
        long t = dateFin.getTime();
        java.sql.Date dateFinSql = new java.sql.Date(t);
        return dateFinSql;
    }
    

}
