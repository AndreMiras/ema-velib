/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import velib.dao.BorneSingleton;
import velib.dao.BornesDAO;
import velib.model.Borne;
import velib.model.Bornette;
import velib.dao.BornetteDAO;
import velib.view.MainWindowFrame;

import velib.view.AdministrationBorneFrame;

/**
 *
 * @author G
 */
class AdministrationBorneController
{

    private AdministrationBorneFrame administrationBorneFrame;

    public AdministrationBorneController(AdministrationBorneFrame administrationBorneFrame)
    {
        this.administrationBorneFrame = administrationBorneFrame;
        addListeners();
    }

    private void addListeners()
    {
        administrationBorneFrame.addAddBikeButtonListener(
                new AddBikeButtonListener());
        administrationBorneFrame.addBorneListe2jComboBoxListener(
                new BorneListe2jComboBoxListener());
    }

    class BorneListe2jComboBoxListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            administrationBorneFrame.setUpAdministrationBornetteFrame();
        }
    }
   
    class AddBikeButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {

        }
    }
}
