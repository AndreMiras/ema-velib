package velib;

import java.sql.SQLException;
import velib.controller.AdministrationWindowController;
import velib.controller.MainWindowController;
import velib.model.Client;
import velib.view.AdministrationWindowFrame;
import velib.view.MainWindowFrame;

public class Main
{
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
