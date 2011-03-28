package velib.model;

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

    public void setEtat(boolean etat)
    {
        this.etat = etat;
    }

    

    @Override
    public String toString()
    {
        return "velo" + id;
    }

}
