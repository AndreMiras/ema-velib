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
    
    private float latitude;
    private float longitude;
    /* is the borne already associated with a soft */
    private boolean etat;

    public Borne(long id, String nomBorne) {
        this.idBorne=id;
        this.nomBorne=nomBorne;

        /* by default the borne is free */
        this.etat=true;
    }

    public Borne() {
        this.idBorne=0;
        this.nomBorne="";
    }

    @Override
    public String toString()
    {
        return nomBorne;
    }
    
    public long getIdBorne() {
        return idBorne;
    }

    public String getNomBorne() {
        return nomBorne;
    }

    public float getLatitude() {
        return latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public boolean getEtat() {
        return etat;
    }

    public void setDisponible(boolean state)
    {
        etat = state;
    }


}
