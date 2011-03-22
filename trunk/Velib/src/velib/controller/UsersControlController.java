/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.controller;

import velib.view.UsersControlFrame;
import velib.view.MainWindowFrame;
import velib.dao.LocationDAO;
import velib.model.Location;

/**
 *
 * @author G
 */
public class UsersControlController
{
    private UsersControlFrame usersControlFrame;

    public UsersControlController(UsersControlFrame usersControlFrame)
    {
        this.usersControlFrame = new UsersControlFrame();
    }
}
