/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.controller;

import velib.model.IModel;
import velib.view.IView;

/**
 *
 * @author andre
 */
public class MainController implements IController {
    
    private IModel model;
    private IView view;

    public MainController(IModel model, IView view)
    {
        this.model = model;
        this.view = view;
    }

    

    public IModel getModel()
    {
        return model;
    }

    public IView getView()
    {
        return view;
    }

    

}
