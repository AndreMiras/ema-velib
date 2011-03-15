/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.controller;

import velib.model.IModel;
import velib.view.WelcomeScreenPanel;

/**
 *
 * @author andre
 */
public class WelcomeScreenController
{
    private IModel model;
    private WelcomeScreenPanel view;

    public WelcomeScreenController(IModel model, WelcomeScreenPanel view)
    {
        this.model = model;
        this.view = view;
    }

    
}
