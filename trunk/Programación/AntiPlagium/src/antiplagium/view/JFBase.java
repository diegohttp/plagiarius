
package antiplagium.view;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.UIManager;

public class JFBase extends javax.swing.JFrame {

    private Dimension dim;

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
        dim=super.getToolkit().getScreenSize();
        super.setSize(dim.width, dim.height);
        super.setVisible(true);
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
        LBLUsuario.setMaximumSize(new java.awt.Dimension(1200, 14));
        LBLUsuario.setOpaque(true);
        LBLUsuario.setPreferredSize(new java.awt.Dimension(1200, 14));
        getContentPane().add(LBLUsuario, java.awt.BorderLayout.NORTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JLabel LBLUsuario;
    // End of variables declaration//GEN-END:variables

}
