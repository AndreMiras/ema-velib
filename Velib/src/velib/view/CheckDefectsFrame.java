/*
 * CheckDefectsFrame.java
 *
 * Created on 22 mars 2011, 18:17:28
 */

package velib.view;

/**
 *
 * @author G
 */
public class CheckDefectsFrame extends javax.swing.JFrame
{

    private velib.view.CheckDefectsFrame checkDefectsFrame;
    //private Problems[] problems;
    /** Creates new form CheckDefectsFrame */
    public CheckDefectsFrame()
    {
        initComponents();
    }
    /*
    public CheckDefectsFrame(Problems[] problems)
    {
        this();
        this.problems = problems;
        fillUpJList();
    }*/

    public CheckDefectsFrame getCheckDefectsFrame()
    {
        return checkDefectsFrame;
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        DefectBikeList = new javax.swing.JList();
        Title = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        DefectBikeList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Aucun problème actuellement déclaré" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(DefectBikeList);

        Title.setFont(new java.awt.Font("Tahoma", 0, 14));
        Title.setText("Liste des vélos ayant le statut \"Problème déclaré\"");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Title))
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(Title)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[])
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new CheckDefectsFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList DefectBikeList;
    private javax.swing.JLabel Title;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
