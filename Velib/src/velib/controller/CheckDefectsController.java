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
    Velo veloOk;
    BornetteDAO bornetteDAO = new BornetteDAO();
    VeloDAO veloDAO = new VeloDAO();
    Bornette bornette;
    Long idVelo;
    private CheckDefectsFrame checkDefectsFrame;

    public CheckDefectsController(CheckDefectsFrame checkDefectsFrame)
    {
        this.checkDefectsFrame = checkDefectsFrame;
        addListeners();
    }

    private void addListeners()                                     //On ajoute les écouteurs
    {
        checkDefectsFrame.addActivateButtonButtonListener(new ActivateButtonButtonListener());
    }

    class ActivateButtonButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            idVelo = checkDefectsFrame.getIDVeloFromInput();        //Récuperation de ID velo de la liste
            velo = new Velo (idVelo, true);                         //On change l'état du vélo
            velo = veloDAO.update(velo);            //On met à jour l'état du vélo
            bornette = bornetteDAO.find(idVelo);    //On cherche la bornette à laquelle est attaché le vélo en panne
            bornette.setVelo(velo);
            bornette = bornetteDAO.update(bornette);//On met à jour la bornette (dévérouille)
            checkDefectsFrame.fillUpJList();        //Rafraichit la liste des vélos en panne.
        }
    }

}
