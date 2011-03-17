/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.controller;

import velib.view.LouerVeloPanel;
import velib.view.MainWindowFrame;

/**
 *
 * @author andre
 * TODO:
 * dispose when the velo is taken or when the time out is reached
 */
public class LouerVeloController extends AbstractController
{

    private LouerVeloPanel louerVeloPanel;

    public LouerVeloController(MainWindowFrame mainWindowFrame,
            LouerVeloPanel louerVeloPanel)
    {
        super(mainWindowFrame);

        this.louerVeloPanel = louerVeloPanel;
    }



    
}
