/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import velib.dao.BornetteDAO;
import velib.model.Bornette;
import velib.view.StatusBorneFrame;

/**
 *
 * @author Nicolas
 */
public class StatusBorneController
{
    private StatusBorneFrame statusBorneFrame;
    private BornetteDAO bornetteDAO = new BornetteDAO();
    private Bornette[] bornettesLibre;
    private Bornette[] bornettesOccupe;

    public StatusBorneController(StatusBorneFrame statusBorneFrame)
    {
        this.statusBorneFrame = statusBorneFrame;
        addListeners();
    }

    private void addListeners() //Déclaration des écouteurs
    {
        statusBorneFrame.addAfficherButtonListener(
                 new BorneComboBoxListener ());
    }

    class BorneComboBoxListener implements ActionListener  
    {
        public void actionPerformed(ActionEvent e)
        {
            int idBorne = statusBorneFrame.getNomBorneComboBox().getSelectedIndex()+1;
            Boolean etatVelo;
            int veloPane = 0;
            int bornetteDispo=0;
            int veloDispo=0;
 
            bornettesLibre=bornetteDAO.findLibreAll(idBorne);           
            bornettesOccupe=bornetteDAO.findOccupeAll(idBorne);

            for (int i=0; i<bornettesOccupe.length; i++)
            {
                 etatVelo = bornettesOccupe[i].getVelo().getEtat();
                 if (etatVelo == false)
                 {
                    veloPane=veloPane+1;
                 }
             }
            
            bornetteDispo=bornettesLibre.length;
            veloDispo=bornettesOccupe.length-veloPane;
            statusBorneFrame.setUpInfoBorneFrame(bornetteDispo, veloDispo, veloPane);
        }
    }
}


