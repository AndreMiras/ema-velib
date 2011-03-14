/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import velib.model.IModel;
import velib.view.LoginScreenFrame;

/**
 *
 * @author andre
 */
public class LoginScreenController {

    private IModel model;
    private LoginScreenFrame view;

    // TODO: actually I think we will path it a DAO rather than a model
    public LoginScreenController(IModel model, LoginScreenFrame view)
    {
        this.model = model;
        this.view = view;

        addListeners();
    }

    private void addListeners()
    {
        view.addValiderButtonListener(new ValidaterButtonListener());
    }
    

    class ValidaterButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            // TODO: use Nicolas' User DAO and stuffs
            System.out.println("Get find() the user");
        }
    }

}
