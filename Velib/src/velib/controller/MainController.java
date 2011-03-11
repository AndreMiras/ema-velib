/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import velib.model.IModel;
import velib.view.IView;
import velib.view.LoginScreenFrame;
import velib.view.WelcomeScreenFrame;

/**
 *
 * @author andre
 */
public class MainController implements IController {
    
    private IModel model;
    private WelcomeScreenFrame view;

    public MainController(IModel model, WelcomeScreenFrame view)
    {
        this.model = model;
        this.view = view;

        addListeners();
    }

    private void addListeners()
    {
        view.addIdentifierButtonListener(new IdentifierButtonListener());
    }

    

    public IModel getModel()
    {
        return model;
    }

    public IView getView()
    {
        return view;
    }

    class IdentifierButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            System.out.println("next window");
            LoginScreenFrame loginScreenFrame = new LoginScreenFrame();
            loginScreenFrame.setVisible(true);
        }
    }//end inner class MultiplyListener
    

}
