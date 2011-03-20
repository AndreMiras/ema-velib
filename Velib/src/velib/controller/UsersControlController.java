/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.controller;

import velib.view.UsersControlFrame;
import velib.view.MainWindowFrame;

/**
 *
 * @author G
 */
public class UsersControlController extends AbstractMainWindowController
{
    private UsersControlFrame usersControlFrame;

    public UsersControlController(MainWindowController mainWindowController,
            UsersControlFrame usersControlFrame)
    {
        super(mainWindowController);
        this.usersControlFrame = usersControlFrame;
    }
}
