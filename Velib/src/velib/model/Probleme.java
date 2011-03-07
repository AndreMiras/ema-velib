/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.model;

/**
 *
 * @author fteysseire
 */
public class Probleme {
    private String description;

    public Probleme () {
        // TODO: hardcoded value, ident envoyé de la BDD (DAO)


    }

 public Probleme (String description) {
        this();
        this.description = description;

        //
    }

}
