
package velib.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import velib.dao.VeloDAO;
import velib.view.DeclarerProblemPanel;
import velib.model.Client;
import velib.model.Location;
import velib.model.Velo;

public class DeclarerProblemController extends AbstractMainWindowController
{
    private DeclarerProblemPanel declarerProblemPanel;
    private Client client;
    private Location location;
    private Velo velo;
    VeloDAO veloDAO = new VeloDAO();

    public DeclarerProblemController(MainWindowController mainWindowController,
           DeclarerProblemPanel declarerProblemPanel, Client client, Location location)
    {
        super(mainWindowController);

        this.declarerProblemPanel = declarerProblemPanel;
        this.client = client;
        this.location = location;
        addListeners();
    }

    private void addListeners()
    {
        declarerProblemPanel.addValiderButtonListener(
                new validerProblemeButtonListener());
        declarerProblemPanel.addAnnulerButtonListener(
                new annulerProblemeButtonListener());
    }

    class validerProblemeButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            long idVelo = location.getVelo().getId();   //On récupère les ID des vélos en location
            velo = veloDAO.find(idVelo);
            velo.setEtat(false);
            velo = veloDAO.update(velo); //On changé l'état du vélo en "en panne"
            initMainWindow();   //On le met à jour dans la BDD
        }
    }

    class annulerProblemeButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            initMainWindow();
        }
    }
}
