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
public class Subscription
{

    private long id;
    private Date dateDebut;
    private Date dateFin;
    private Client client;
    private TypeAbonnement type;
  
    public Subscription()
    {
        this(0, new TypeAbonnement());
    }

    public Subscription(long id, TypeAbonnement type)
    {
        this.id = id;
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
        return new Date(dateDebut.getTime());
    }

    public Date getDateFin()
    {
        return dateFin;
    }

    public void setDateDebut(Date dateDebut)
    {
        this.dateDebut = dateDebut;
    }

    public void setDateFin(Date dateFin)
    {
        this.dateFin = dateFin;
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
