
package antiplagium.view;

import java.awt.Color;
import javax.swing.UIManager;

public class JFBase extends javax.swing.JFrame {

    /** Creates new form JFBase */
    public JFBase() {
        initComponents();
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
            catch (Exception e)
        {
            e.printStackTrace();
        }               
        this.getContentPane().setBackground(Color.lightGray);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LBLUsuario = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximizedBounds(getMaximizedBounds());

        LBLUsuario.setBackground(new java.awt.Color(153, 204, 255));
        LBLUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LBLUsuario.setText("Nombre del Usuario");
        LBLUsuario.setMaximumSize(new java.awt.Dimension(1024, 14));
        LBLUsuario.setOpaque(true);
        LBLUsuario.setPreferredSize(new java.awt.Dimension(1024, 14));
        getContentPane().add(LBLUsuario, java.awt.BorderLayout.NORTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JLabel LBLUsuario;
    // End of variables declaration//GEN-END:variables

}
