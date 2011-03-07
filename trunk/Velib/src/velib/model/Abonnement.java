/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.model;

/**
 *
 * @author fteysseire
 */
public class Abonnement {
    private float prix;

    public Abonnement () {
        // TODO: hardcoded value, ident envoyé de la BDD (DAO)


    }

 public Abonnement (Float prix) {
        this();
        this.prix = prix;

        //
    }

}
