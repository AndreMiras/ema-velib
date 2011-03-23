/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.model;

/**
 *
 * @author Nicolas
 */
public class Borne {

    private long idBorne;
    private String nomBorne;
    
    private double latitude;
    private double longitude;
    /* is the borne already associated with a soft */
    private boolean etat;

    public Borne(long id, String nomBorne) {
        this.idBorne=id;
        this.nomBorne=nomBorne;

        /* by default the borne is free */
        this.etat = true;
    }

    public Borne()
    {
        this.idBorne=0;
        this.nomBorne="";
    }

    @Override
    public String toString()
    {
        return nomBorne;
    }
    
    public long getIdBorne()
    {
        return idBorne;
    }

    public String getNomBorne()
    {
        return nomBorne;
    }

    public double getLatitude()
    {
        return latitude;
    }

    public double getLongitude()
    {
        return longitude;
    }

    public double[] getLatLong()
    {
        return new double[] {latitude, longitude};
    }
    
    public void setLatitude(double latitude)
    {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude)
    {
        this.longitude = longitude;
    }

    public void setLatLong(double latitude, double longitude)
    {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public boolean getEtat()
    {
        return etat;
    }

    public void setDisponible(boolean state)
    {
        etat = state;
    }

    public void setNomBorne(String nomBorne) {
        this.nomBorne = nomBorne;
    }




}
