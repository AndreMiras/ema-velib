package velib.model;

import java.util.Date;

public class Location
{

    private long id;
    private Client client;
    private Velo velo;
    private Date dateDebutLocation;
    private Date dateFinLocation;

    public Location (long id, Client client, Velo velo) {
        // TODO: hardcoded value, ident envoyé de la BDD (DAO)
        this.id=id;
        this.client=client;
        this.velo=velo;
        dateDebutLocation=null;
        dateFinLocation=null;
    }

    public Location() {
    }

    public long getId() {
        return id;
    }


    
    public Client getClient() {
        return client;
    }

    public Date getDateDebutLocation() {
        return dateDebutLocation;
    }

    public void setDateDebutLocation(Date dateDebutLocation) {
        this.dateDebutLocation = dateDebutLocation;
    }

    public Date getDateFinLocation() {
        return dateFinLocation;
    }

    public void setDateFinLocation(Date dateFinLocation) {
        this.dateFinLocation = dateFinLocation;
    }


    public Velo getVelo() {
        return velo;
    }

  

    @Override
    public String toString()
    {
        return client + " utilise : " + velo + " de : " + dateDebutLocation +
                " à : " + dateFinLocation;
    }

}
