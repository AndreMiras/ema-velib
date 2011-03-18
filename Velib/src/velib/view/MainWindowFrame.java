/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MainWindow.java
 *
 * Created on Mar 15, 2011, 1:49:25 PM
 */

package velib.view;

import java.awt.Component;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author andre
 */
public class MainWindowFrame extends javax.swing.JFrame implements IView
{

    // Register middleContentPanels ref for previous button
    // TODO: this is public at the moment for testing purpose only
    // We actually might move all of this to the dedicated controller
    public Vector<JPanel> middleContentPanelsVector;

    /** Creates new form MainWindow */
    public MainWindowFrame() {
        initComponents();
        
        setUpMainWindow();

        middleContentPanelsVector = new Vector<JPanel>();
    }

    /*
     * Set up the first screen which is the WelcomeScreen
     * TODO: shouldn't some of this handled in the controller?
     */
    private void setUpMainWindow()
    {
    }

    public void showMessage(String message)
    {
        JOptionPane.showMessageDialog(this, message);
    }


    // TODO: see CardLayout
    // See http://stackoverflow.com/questions/218155/how-do-i-change-jpanel-inside-a-jframe-on-the-fly
    //
    /*
     * Replaces the current content panel by the given one
     * TODO: the previous panel content doesn't seem to cleanup with the
     * removeAll()
     */
    public void setContentPanel(JPanel panel)
    {
        // panel.setVisible(true);

        middleContentPanelsVector.add(panel);
       
        middleContentPanel.removeAll();


        middleContentPanel.revalidate();
        middleContentPanel.add(panel);

        middleContentPanel.revalidate();

        // set previous/next buttons states
        // TODO: we can auto update previous/next status by creating
        // a widget that listen on middleContentPanelsVector events
        if (middleContentPanelsVector.size() > 1)
        {
            enablePreviousButton(true);
        }
    }

    private void enablePreviousButton(boolean enable)
    {
        previousButton.setEnabled(enable);
    }

    private void enableNextButton(boolean enable)
    {
        nextButton.setEnabled(enable);
    }


    /*
     * might not be necessary
     */
    public void addPreviousButtonListener(ActionListener al)
    {
        previousButton.addActionListener(al);
    }

      public void addNextButtonListener(ActionListener al)
    {
        nextButton.addActionListener(al);
    }



    public void addEditDatabaseButtonListener(ActionListener al)
    {
        editDatabaseMenuItem.addActionListener(al);
    }

    public void addEditBornButtonListener(ActionListener al)
    {
        editBornMenuItem.addActionListener(al);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        middleContentPanel = new javax.swing.JPanel();
        footersPanel = new javax.swing.JPanel();
        previousButton = new javax.swing.JButton();
        nextButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        editDatabaseMenuItem = new javax.swing.JMenuItem();
        editBornMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("NemoVelo");

        middleContentPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Content"));

        footersPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Footers (broken)"));

        previousButton.setText("Previous");
        previousButton.setEnabled(false);

        nextButton.setText("Next");
        nextButton.setEnabled(false);

        javax.swing.GroupLayout footersPanelLayout = new javax.swing.GroupLayout(footersPanel);
        footersPanel.setLayout(footersPanelLayout);
        footersPanelLayout.setHorizontalGroup(
            footersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(footersPanelLayout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(previousButton)
                .addGap(18, 18, 18)
                .addComponent(nextButton)
                .addContainerGap(280, Short.MAX_VALUE))
        );
        footersPanelLayout.setVerticalGroup(
            footersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(footersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(footersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nextButton)
                    .addComponent(previousButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        editDatabaseMenuItem.setText("Edit DB");
        jMenu2.add(editDatabaseMenuItem);

        editBornMenuItem.setText("Edit Born");
        jMenu2.add(editBornMenuItem);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(footersPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(middleContentPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(middleContentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(footersPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindowFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem editBornMenuItem;
    private javax.swing.JMenuItem editDatabaseMenuItem;
    private javax.swing.JPanel footersPanel;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel middleContentPanel;
    private javax.swing.JButton nextButton;
    private javax.swing.JButton previousButton;
    // End of variables declaration//GEN-END:variables

}