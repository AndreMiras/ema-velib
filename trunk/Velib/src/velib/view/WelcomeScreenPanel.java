package velib.view;

import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import velib.model.Borne;

public class WelcomeScreenPanel extends javax.swing.JPanel {

    /** Creates new form WelcomeScreenPanel */
    public WelcomeScreenPanel()
    {
        initComponents();
    }

    /*
     * Setup stations for the map widget
     */
    public void setMapWidgetStations(Borne thisStation, Borne[] otherStations)
    {
        mapPanel1.setThisStation(thisStation);
        mapPanel1.setOtherStations(otherStations);
        mapPanel1.updateMapImage();
    }

    public void addAbonnerButtonListener(ActionListener al)
    {
        abonnerButton.addActionListener(al);
    }

    public void addIdentifierButtonListener(ActionListener al)
    {
        identifierButton.addActionListener(al);
    }

    public void addAideButtonListener(ActionListener al)
    {
        aideButton.addActionListener(al);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        aideButton = new javax.swing.JButton();
        abonnerButton = new javax.swing.JButton();
        identifierButton = new javax.swing.JButton();
        mapPanel1 = new velib.view.MapPanel();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        aideButton.setFont(new java.awt.Font("Tahoma", 1, 14));
        aideButton.setText("Aide");

        abonnerButton.setFont(new java.awt.Font("Tahoma", 1, 14));
        abonnerButton.setText("S'abonner");

        identifierButton.setFont(new java.awt.Font("Tahoma", 1, 14));
        identifierButton.setText("S'identifier");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(abonnerButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                    .addComponent(identifierButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                    .addComponent(aideButton, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(abonnerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(identifierButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(aideButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(mapPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mapPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton abonnerButton;
    private javax.swing.JButton aideButton;
    private javax.swing.JButton identifierButton;
    private javax.swing.JPanel jPanel1;
    private velib.view.MapPanel mapPanel1;
    // End of variables declaration//GEN-END:variables

}
