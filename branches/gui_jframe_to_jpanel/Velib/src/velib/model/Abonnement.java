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
    }

}
