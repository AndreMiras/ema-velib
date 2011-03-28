package velib.view;

import java.awt.event.ActionListener;
import java.util.Enumeration;
import javax.swing.AbstractButton;

public class AbonnementPanel extends javax.swing.JPanel {

    /** Creates new form AbonnementPanel */
    public AbonnementPanel() {
        initComponents();
    }

    // Add action listener to every buttons in the group
    public void addAbonnementGroupButtonListener(ActionListener actionListener)
    {
        Enumeration elements = buttonGroup1.getElements();

        while (elements.hasMoreElements())
        {
            AbstractButton button = (AbstractButton)elements.nextElement();
            button.addActionListener(actionListener);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        oneDay = new javax.swing.JButton();
        halfDayButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        oneWeekButton = new javax.swing.JButton();
        oneMonthButton = new javax.swing.JButton();
        oneYearButton = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Courte duree"));

        oneDay.setText("1 Journee");
        oneDay.setActionCommand(velib.model.SubscriptionTypeEnum.ONE_DAY.value());
        buttonGroup1.add(oneDay);

        halfDayButton.setText("1/2 Journee");
        halfDayButton.setActionCommand(velib.model.SubscriptionTypeEnum.HALF_DAY.value());
        buttonGroup1.add(halfDayButton);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(oneDay, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                    .addComponent(halfDayButton, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(halfDayButton, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(oneDay, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(77, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Longue duree"));

        oneWeekButton.setText("1 Semaine");
        oneWeekButton.setActionCommand(velib.model.SubscriptionTypeEnum.ONE_WEEK.value());
        buttonGroup1.add(oneWeekButton);

        oneMonthButton.setText("1 Mois");
        oneMonthButton.setActionCommand(velib.model.SubscriptionTypeEnum.ONE_MONTH.value());
        buttonGroup1.add(oneMonthButton);
        oneMonthButton.setMaximumSize(new java.awt.Dimension(81, 23));
        oneMonthButton.setMinimumSize(new java.awt.Dimension(81, 23));

        oneYearButton.setText("1 An");
        oneYearButton.setActionCommand(velib.model.SubscriptionTypeEnum.ONE_YEAR.value());
        buttonGroup1.add(oneYearButton);
        oneYearButton.setMaximumSize(new java.awt.Dimension(81, 23));
        oneYearButton.setMinimumSize(new java.awt.Dimension(81, 23));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(oneYearButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                    .addComponent(oneMonthButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                    .addComponent(oneWeekButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(oneWeekButton, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(oneMonthButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(oneYearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(127, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(29, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton halfDayButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton oneDay;
    private javax.swing.JButton oneMonthButton;
    private javax.swing.JButton oneWeekButton;
    private javax.swing.JButton oneYearButton;
    // End of variables declaration//GEN-END:variables

}
