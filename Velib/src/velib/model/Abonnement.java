/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package velib.model;

import java.util.Date;

/**
 *
 * @author fteysseire
 * TODO: inherit a child class as specified cahier_charges_specifications.pdf
 */
public class Abonnement
{

    private long id;
    private Date dateDebut;
    private Date dateFin;
    private Client client;
    private TypeAbonnement type;
  
    public Abonnement()
    {
        this(new TypeAbonnement());
    }

    public Abonnement(TypeAbonnement type)
    {
        // TODO: hardcoded value, ident envoyé de la BDD (DAO)
        dateDebut = new Date();
        dateFin = new Date();
        this.type = type;

        /*
         * TODO: set dateDebut based on type
         */
        // TODO: this.dateFin = new Date();
    }

    public long getId()
    {
        return id;
    }

    public Date getDateDebut()
    {
        return dateDebut;
    }

    public Date getDateFin()
    {
        return dateFin;
    }

    public Client getClient()
    {
        return client;
    }

    public TypeAbonnement getType()
    {
        return type;
    }

    public void setType(TypeAbonnement type)
    {
        this.type = type;
    }
    

}
