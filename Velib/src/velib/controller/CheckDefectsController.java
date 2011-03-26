/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import velib.dao.BornetteDAO;
import velib.dao.VeloDAO;
import velib.model.Bornette;
import velib.model.Velo;
import velib.view.CheckDefectsFrame;

/**
 *
 * @author G
 */
public class CheckDefectsController
{
    Velo velo;
    BornetteDAO bornetteDAO = new BornetteDAO();
    VeloDAO veloDAO = new VeloDAO();
    Bornette bornette;
    private CheckDefectsFrame checkDefectsFrame;

    public CheckDefectsController(CheckDefectsFrame checkDefectsFrame)
    {
        //this.checkDefectsFrame = checkDefectsFrame;
    }

    private void addListeners()
    {
        checkDefectsFrame.addActivateButtonButtonListener(new ActivateButtonButtonListener());
    }

    class ActivateButtonButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            System.out.println(" TOOTO");
            /*
            Long idVelo = checkDefectsFrame.getIDVeloFromInput();         
            velo = new Velo (idVelo, true);
            velo = veloDAO.create(velo);

            bornette = bornetteDAO.find(idVelo);
            bornette.setVelo(velo);
            bornette = bornetteDAO.update(bornette);
            checkDefectsFrame.fillUpJList(); //Rafraichit la liste des vélos en panne.
            */
        }
    }

}
