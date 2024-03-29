package velib.view;

import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import velib.model.Client;

public class LoggedInWelcomePanel extends javax.swing.JPanel
{
    private Client client;

    /** Creates new form ChoixIdenticationPanel */
    public LoggedInWelcomePanel() {
        initComponents();
    }

    public LoggedInWelcomePanel(Client client)
    {
        this();
        this.client = client;


        setUpLoggedInWelcomePanel();
    }


    public void addLouerUnVeloButtonListener(ActionListener al)
    {
        this.louerVeloButton.addActionListener(al);
    }

    public void addRestituerUnVeloButtonListener(ActionListener al)
    {
        this.restituerVeloButton.addActionListener(al);
    }

    public void addRechargerButtonListener(ActionListener al)
    {
        this.rechargerButton.addActionListener(al);
    }

    public void restituionErrorPopup()
    {
        JOptionPane.showMessageDialog(this, "Vous n'avez pas de vélo en location");
    }
    public void locationErrorPopup()
    {
        JOptionPane.showMessageDialog(this, "Vous avez déjà un vélo en location");
    }
    public void veloErrorPopup()
    {
        JOptionPane.showMessageDialog(this, "Il n'y a plus de vélos disponibles dans cette station");
    }
        public void bornetteErrorPopup()
    {
        JOptionPane.showMessageDialog(this, "Il n'y a plus de bornettes disponible dans cette station. "
                + "Merci de vous rendre dans une autre station pour rendre votre "
                + "vélo");
    }

    /*
     * Setup the window based on user model values
     */
    private void setUpLoggedInWelcomePanel()
    {
        fullNameLabel.setText(client.getFullName());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        fullNameLabel = new javax.swing.JLabel();
        rechargerButton = new javax.swing.JButton();
        restituerVeloButton = new javax.swing.JButton();
        louerVeloButton = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(0, 0));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Possibilités"));

        jLabel1.setText("Bonjour");

        jLabel2.setText("Il vous est possible de :");

        jLabel3.setText("- Louer un velo");

        jLabel4.setText("- Restituer un velo");

        jLabel5.setText("- Recharger votre abonnement");

        fullNameLabel.setText("FullName");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fullNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(fullNameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addContainerGap(148, Short.MAX_VALUE))
        );

        rechargerButton.setFont(new java.awt.Font("Tahoma", 1, 14));
        rechargerButton.setText("Recharger");

        restituerVeloButton.setFont(new java.awt.Font("Tahoma", 1, 14));
        restituerVeloButton.setText("Restituer");

        louerVeloButton.setFont(new java.awt.Font("Tahoma", 1, 14));
        louerVeloButton.setText("Louer");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(rechargerButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(louerVeloButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(restituerVeloButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(louerVeloButton, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(restituerVeloButton, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(rechargerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(53, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fullNameLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton louerVeloButton;
    private javax.swing.JButton rechargerButton;
    private javax.swing.JButton restituerVeloButton;
    // End of variables declaration//GEN-END:variables

}
