/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib;

import velib.controller.MainController;
import velib.model.Client;
import velib.view.WelcomeScreenFrame;


/**
 *
 * @author fteysseire
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        // model for tests
        Client client = new Client(1, "foo", "bar");
        // TODO: give it the model instead of null
        // Create the main view
        WelcomeScreenFrame view = new WelcomeScreenFrame(client);
        view.setVisible(true);

        // Create the controller
        MainController controller =  new MainController(null, view);
        view.setVisible(true);

    }

}
