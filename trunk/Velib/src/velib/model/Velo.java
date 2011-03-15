/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.model;

/**
 *
 * @author fteysseire
 */
public class Velo {

    private long id;
    private boolean etat;
    private Bornette idBornette;

    public long getId() {
        return id;
    }

    public Bornette getIdBornette() {
        return idBornette;
    }

    public boolean getEtat() {
        return etat;
    }

}
