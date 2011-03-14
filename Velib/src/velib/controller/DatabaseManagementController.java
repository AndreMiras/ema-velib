/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.text.DefaultEditorKit.InsertTabAction;
import velib.dao.IDatabaseManagementDAO;
import velib.view.DatabaseManagementFrame;

/**
 *
 * @author andre
 */
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
        view.addCreateDatabaseButtonListener(
                new CreateDatabaseButtonListener());

        view.addDropDatabaseButtonListener(
                new DropDatabaseButtonListener());

        view.addCreateTablesButtonListener(
                new CreateTablesButtonListener());

        view.addDropTablesButtonListener(
                new DropTablesButtonListener());

        view.addInsertTablesDataButtonListener(
                new InsertTablesDataButtonListener());
        
    }


    class CreateDatabaseButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            databaseManagement.createDatabase();
        }
    }

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

    class DropTablesButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            databaseManagement.dropTables();
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
