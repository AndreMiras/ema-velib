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
    private Borne borne;
    private Velo velo;

    public Bornette()
    {
        this.id = 0;
        this.libre = false;
        this.numero = 0;
        this.borne = null;
        this.velo = null;
    }

    public Bornette(long id, long numero, Borne borne) {
        this.id = id;
        this.libre=false;
        this.numero = numero;
        this.borne = borne;
        this.velo = new Velo();
     }
    
    public long getId() {
        return id;
    }

    public long getNumero() {
        return numero;
    }

    public Borne getBorne() {
        return borne;
    }

    public Velo getVelo() {
        return velo;
    }

    public boolean getLibre(){
        return libre;
    }




    



    
}
