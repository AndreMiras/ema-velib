package velib.model;

public class Bornette {

    private long id;
    private long numero;
    private Borne borne;
    private Velo velo;
 

    public Bornette()
    {
        this.id = 0;
        this.numero = 0;
        this.borne = null;
        this.velo = null;
    }

    public Bornette(long id, long numero, Borne borne, Velo velo) {
        this.id = id;
        this.numero = numero;
        this.borne = borne;
        this.velo = velo;
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

    public void setVelo(Velo velo)
    {
        this.velo = velo;
    }

    @Override
    public String toString()
    {
        return Long.toString(numero);
    }


    
}
