/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.model;

/**
 *
 * @author fteysseire
 */
public class Velo
{

    private long id;
    private boolean etat;
    private Bornette bornette;

    public Velo()
    {
    }

    

    public Velo(long id)
    {
        this.id = id;
        etat = true;
    }



    public long getId()
    {
        return id;
    }

    public Bornette getBornette()
    {
        return bornette;
    }

    public void setBornette(Bornette bornette)
    {
        this.bornette = bornette;
    }

    

    public boolean getEtat()
    {
        return etat;
    }

}
