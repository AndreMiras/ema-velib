/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.model;

/**
 *
 * @author fteysseire
 */
public class Paiement {
    private float cbchiffre;
    private boolean valide;

    public Paiement () {
        // TODO: hardcoded value, ident envoyé de la BDD (DAO)


    }

 public Paiement (Float cbchiffre) {
        this();
        this.cbchiffre = cbchiffre;
        this.valide = false;            // TODO : à voir

        //
    }
}
