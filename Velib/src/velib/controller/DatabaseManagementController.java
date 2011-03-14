/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import velib.dao.IDatabaseManagement;
import velib.view.DatabaseManagementFrame;

/**
 *
 * @author andre
 */
public class DatabaseManagementController
{

    private IDatabaseManagement databaseManagement;
    private DatabaseManagementFrame view;

    public DatabaseManagementController(IDatabaseManagement databaseManagement, DatabaseManagementFrame view)
    {
        this.databaseManagement = databaseManagement;
        this.view = view;

        addListeners();
    }

    private void addListeners()
    {
        view.addCreateDatabaseButtonListener(
                new CreateDatabaseButtonListener());

        view.addDropDatabaseButtonListener(
                new DropDatabaseButtonListener());

        view.addCreateTablesButtonListener(
                new CreateTablesButtonListener());

        view.addCreateDatabaseButtonListener(
                new DropTablesButtonListener());
    }


    class CreateDatabaseButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            // TODO: call DatabaseManagement methods
        }
    }

    class DropDatabaseButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            // TODO: call DatabaseManagement methods
        }
    }

    class CreateTablesButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            // TODO: call DatabaseManagement methods
        }
    }

    class DropTablesButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            // TODO: call DatabaseManagement methods
        }
    }

}
