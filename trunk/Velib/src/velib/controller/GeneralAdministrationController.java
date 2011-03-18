/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import velib.dao.BornetteDAO;
import velib.dao.ClientDAO;
import velib.dao.UserDAO;
import velib.dao.VeloDAO;
import velib.model.Bornette;
import velib.model.Client;
import velib.model.IModel;
import velib.model.User;
import velib.model.Velo;
import velib.view.GeneralAdministrationPanel;
import velib.view.MainWindowFrame;

/**
 *
 * @author G
 */


public class GeneralAdministrationController
{
    private GeneralAdministrationPanel generalAdministrationPanel;

    public GeneralAdministrationController(GeneralAdministrationPanel generalAdministrationPanel)
    {
        this.generalAdministrationPanel = generalAdministrationPanel;

        addListeners();
    }
  

    private void addListeners()
    {
        // view.addValiderButtonListener(new AjouterVeloButtonListener());
        generalAdministrationPanel.addAjouterVeloButtonListener(
                new AjouterVeloButtonListener());
        /*
        view.supprimerVelo.addActionListener(al);
        view.ajouterUtilisateur.addActionListener(al);
        view.supprimerUtilisateur.addActionListener(al);
        view.checkDefects.addActionListener(al);
         *
         */
    }

        class AjouterVeloButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            BornetteDAO bornetteDAO = new BornetteDAO();
            Bornette bornette = bornetteDAO.find(
                    Long.parseLong(generalAdministrationPanel.getInput()));


            Velo velo = new Velo();
            velo.setBornette(bornette);
            VeloDAO veloDAO = new VeloDAO();
            veloDAO.create(velo);
        }
    }

}
