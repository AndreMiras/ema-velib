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
public class UsersControlController extends AbstractController
{
    private UsersControlFrame usersControlFrame;

    public UsersControlController(MainWindowFrame mainWindowFrame,
            UsersControlFrame usersControlFrame)
    {
        super(mainWindowFrame);
        this.usersControlFrame = usersControlFrame;
    }
}
