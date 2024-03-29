package velib.view;

public class HelpPanel extends javax.swing.JPanel {

    /** Creates new form HelpPanel */
    public HelpPanel()
    {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel1.setText("Aide NemoVélo");

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Monospaced", 0, 12));
        jTextArea1.setRows(5);
        jTextArea1.setText("NemoVélo est un réseau de bicyclettes mises à disposition librement.\n\nLe réseau NemoVélo est composé de stations (bornes) ou les vélos sont\n mis à disposition, toute personne abonnée au système peut décider de\n louer un vélo sur une des stations existantes et peut restituer \n celui-ci sur n’importe quelle autre station du réseau.\n\nPour s’abonner : Munissez-vous d’une carte bancaire, et cliquez sur le\n menu « S’abonner » de la borne, il existe deux principaux types \n d’abonnements les abonnements longue et courte durée, mais les \n abonnements de type longue durée peuvent être rechargés. \n Votre civilité et votre adresse vous seront alors demandés, une \n fois toutes les informations fournies, un identifiant et un mot de \n passe vous seront fournis (attention ils vous sont propre, ne les \n partagez jamais).\n\nUne fois en possession de vos identifiants, il vous est possible de \n vous connecter sur n’importe quelle borne du réseau NemoVélo afin de\n louer ou restituer un vélo par le biais du menu « S’identifier ».\n\nDans le cas où la station ne dispose plus de vélos à louer : \n La page d’accueil de la station montre une carte des différentes \n stations les plus proches afin de vous proposer un choix plus \n complet.\n\nDans le cas où la station ne dispose plus d’emplacement libres:\n La page d’accueil de la station montre une carte des différentes \n stations les plus proches afin de vous proposer le chemin le plus \n court pour restituer votre vélo.\n\nDans le cas où le vélo que vous avez loué s’avère être défectueux ou \n abimé : Suivez la procédure habituelle de restitution puis, à la\n dernière étape, cliquez sur \"Déclarer un problème\". \n\nNemoVélo vous souhaite un agréable trajet.");
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(222, 222, 222)
                        .addComponent(jLabel1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables

}
