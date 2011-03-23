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
   
    public Velo(long id, boolean etat)
    {
        this.id=id;
        this.etat=etat;
        
    }
  
    public Velo(long id)
    {
        this.id = id;
        etat = true;
    }

    public Velo() {
    }

    public long getId() {
        return id;
    }

   
    public boolean getEtat()
    {
        return etat;
    }

    @Override
    public String toString()
    {
        return "velo" + id;
    }

}
