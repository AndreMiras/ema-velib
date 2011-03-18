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
    private boolean etat;

    public Borne(long id, String nomBorne) {
        this.idBorne=id;
        this.nomBorne=nomBorne;
    }

    public Borne() {
        this.idBorne=0;
        this.nomBorne="";
    }




}
