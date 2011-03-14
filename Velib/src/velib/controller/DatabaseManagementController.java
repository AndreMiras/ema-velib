/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.controller;

import velib.dao.IDatabaseManagement;
import velib.view.DatabaseManagementFrame;

/**
 *
 * @author andre
 */
public class DatabaseManagementController
{

    private IDatabaseManagement databaseManagement;
    private DatabaseManagementFrame databaseManagementFrame;

    public DatabaseManagementController(IDatabaseManagement databaseManagement, DatabaseManagementFrame databaseManagementFrame)
    {
        this.databaseManagement = databaseManagement;
        this.databaseManagementFrame = databaseManagementFrame;
    }



}
