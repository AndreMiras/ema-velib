/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.controller;

import velib.view.IView;
import velib.model.IModel;

/**
 *
 * @author andre
 */
public interface IController {



    IModel getModel();
    
    IView getView();

}
