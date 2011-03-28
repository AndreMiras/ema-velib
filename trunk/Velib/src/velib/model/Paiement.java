package velib.model;

public class Paiement {
    private float cbchiffre;
    private boolean valide;

    public Paiement ()
    {
        // TODO: hardcoded value, ident envoyé de la BDD (DAO)


    }

 public Paiement (Float cbchiffre)
 {
        this();
        this.cbchiffre = cbchiffre;
        this.valide = false;            // TODO : à voir

        //
 }
}
