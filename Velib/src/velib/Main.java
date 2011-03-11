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
       
        // Creating the main view
        WelcomeScreenFrame view = new WelcomeScreenFrame();
        view.setVisible(true);

        // Create the controller
        MainController controller = new MainController(null, view);
        view.setVisible(true);
    }

}
