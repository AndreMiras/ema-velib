
package velib.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import velib.dao.IDatabaseManagementDAO;
import velib.view.DatabaseManagementFrame;

public class DatabaseManagementController
{

    private IDatabaseManagementDAO databaseManagement;
    private DatabaseManagementFrame view;

    public DatabaseManagementController(IDatabaseManagementDAO databaseManagement, DatabaseManagementFrame view)
    {
        this.databaseManagement = databaseManagement;
        this.view = view;
        addListeners();
    }

    private void addListeners()
    {
        view.addDropDatabaseButtonListener(
                new DropDatabaseButtonListener());

        view.addCreateTablesButtonListener(
                new CreateTablesButtonListener());

        view.addInsertTablesDataButtonListener(
                new InsertTablesDataButtonListener());
    }

    /* Les fonctions suivantes sont directement éxecutées par la DAO databaseManagement */

    class DropDatabaseButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            databaseManagement.dropDatabase();
        }
    }

    class CreateTablesButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            databaseManagement.createTables();
        }
    }

    class InsertTablesDataButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            databaseManagement.fillUpTables();
        }
    }

}
