/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib;

import java.sql.SQLException;
import velib.controller.AdministrationWindowController;
import velib.controller.MainWindowController;
import velib.model.Client;
import velib.view.AdministrationWindowFrame;
import velib.view.MainWindowFrame;


/**
 *
 * @author fteysseire
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException
    {
       /* Borne */
        // Creating the main view
        MainWindowFrame view = new MainWindowFrame();
        view.setVisible(true);
        // Create the controller
        MainWindowController controller = new MainWindowController(null, view);

        /* Borne administration */
        // Creating the admin view
        AdministrationWindowFrame administrationView = new AdministrationWindowFrame();
        administrationView.setVisible(true);
        // Create the controller
        AdministrationWindowController administrationWindowController =
                new AdministrationWindowController(administrationView);
        view.setVisible(true);

    }

}
