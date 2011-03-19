/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.controller;

import velib.model.Client;
import velib.view.CreateUserPasswordPanel;
import velib.view.MainWindowFrame;

/**
 *
 * @author andre
 */
public class CreateUserPasswordController extends AbstractController
{
    private Client client;
    private CreateUserPasswordPanel createUserPasswordPanel;
    
    CreateUserPasswordController(
            Client client,
            MainWindowFrame mainWindowFrame,
            CreateUserPasswordPanel createUserPasswordPanel)
    {
        super(mainWindowFrame);
        this.client = client;
        this.createUserPasswordPanel = createUserPasswordPanel;
    }

}
