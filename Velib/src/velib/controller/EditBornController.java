/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.controller;

import velib.view.EditBornFrame;
import velib.view.MainWindowFrame;

/**
 *
 * @author andre
 * TODO/ to be removed (replaced by Gaetan controller)
 */
public class EditBornController extends AbstractController
{
    private EditBornFrame editBornFrame;

    public EditBornController(MainWindowFrame mainWindowFrame,
            EditBornFrame editBornFrame)
    {
        super(mainWindowFrame);
        this.editBornFrame = editBornFrame;
    }



}
