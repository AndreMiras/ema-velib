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
 public class Location {

    private long id;
    private Client client;
    private Velo velo;
    private Date date;

    public Location (long id, Client client, Velo velo) {
        // TODO: hardcoded value, ident envoyé de la BDD (DAO)
        this.id=id;
        this.client=client;
        this.velo=velo;
    }

    public Location() {
    }


    public Client getClient() {
        return client;
    }

    public Date getDate() {
        return date;
    }

    public Velo getVelo() {
        return velo;
    }

    public java.sql.Date getDateSQL() {
        long t = date.getTime();
        java.sql.Date dateSql = new java.sql.Date(t);
        return dateSql;
    }

    @Override
    public String toString()
    {
        return client + " utilise vélo n° " + velo;
    }

}
