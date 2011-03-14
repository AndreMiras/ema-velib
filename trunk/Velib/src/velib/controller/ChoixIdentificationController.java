/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.controller;

import velib.model.IModel;
import velib.view.ChoixIdentificationFrame;

/**
 *
 * @author andre
 */
class ChoixIdentificationController {

    private IModel model ;
    private ChoixIdentificationFrame view;

    public ChoixIdentificationController(IModel model, ChoixIdentificationFrame view)
    {
        this.model = model;
        this.view = view;
    }


}
