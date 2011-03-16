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

    public Location () {
        // TODO: hardcoded value, ident envoyé de la BDD (DAO)
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

}
