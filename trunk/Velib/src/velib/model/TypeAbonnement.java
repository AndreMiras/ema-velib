/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.model;

/**
 *
 * @author Nicolas
 */
public class TypeAbonnement {

        private float prix;

    public TypeAbonnement () {
        // TODO: hardcoded value, ident envoyé de la BDD (DAO)


    }

 public TypeAbonnement (Float prix) {
        this();
        this.prix = prix;
    }


}
