/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.text.DefaultEditorKit.InsertTabAction;
import velib.dao.IDatabaseManagementDAO;
import velib.view.DatabaseManagementFrame;
import velib.view.ListeClientFrame;

/**
 *
 * @author andre
 */
public class ListeClientController
{

    private IDatabaseManagementDAO databaseManagement;
    private DatabaseManagementFrame view;

    private ListeClientFrame listeClientFrame;

    public ListeClientController(ListeClientFrame listeClientFrame)
    {
        this.listeClientFrame = listeClientFrame;
        addListeners();
    }

    private void addListeners()
    {
        listeClientFrame.addClientListeComboBoxListener(
                new ClientListe2ComboBoxListener());
    }

    class ClientListe2ComboBoxListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {

        }
    }

    

}
