/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.model;
/**
 *
 * @author fteysseire
 */
public class Bornette {

    private long id;
    private boolean libre;
    private long numero;
    private Borne idBorne; 
    private Velo idVelo;

    public long getId() {
        return id;
    }

    public long getNumero() {
        return numero;
    }

    public Borne getIdBorne() {
        return idBorne;
    }

    public Velo getIdVelo() {
        return idVelo;
    }

    public boolean getLibre(){
        return libre;
    }




    



    
}
