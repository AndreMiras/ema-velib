package velib.controller;

import velib.view.IView;
import velib.model.IModel;

public interface IController
{
    IModel getModel();
    
    IView getView();

}
