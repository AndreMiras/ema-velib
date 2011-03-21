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
    private int positionX;
    private int positionY;
    /* is the borne already associated with a soft */
    private boolean etat;

    public Borne(long id, String nomBorne) {
        this.idBorne=id;
        this.nomBorne=nomBorne;
        this.positionX=0;
        this.positionY=0;

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

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public boolean getEtat() {
        return etat;
    }

    public void setDisponible(boolean state)
    {
        etat = state;
    }


}
