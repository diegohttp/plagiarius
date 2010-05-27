
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
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LBLUsuario = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 900, 600));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(1000, 700));

        LBLUsuario.setBackground(new java.awt.Color(153, 204, 255));
        LBLUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LBLUsuario.setText("Nombre del Usuario");
        LBLUsuario.setMaximumSize(new java.awt.Dimension(1000, 14));
        LBLUsuario.setMinimumSize(new java.awt.Dimension(1000, 14));
        LBLUsuario.setOpaque(true);
        LBLUsuario.setPreferredSize(new java.awt.Dimension(900, 14));
        getContentPane().add(LBLUsuario, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LBLUsuario;
    // End of variables declaration//GEN-END:variables

}
