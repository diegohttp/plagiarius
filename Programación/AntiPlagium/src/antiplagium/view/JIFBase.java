package antiplagium.view;

import java.awt.Dimension;
import javax.swing.UIManager;


public class JIFBase extends javax.swing.JInternalFrame {

    public JIFBase() {
        super("", true, true, false, true);
        
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LBLUsuario = new javax.swing.JLabel();

        setClosable(true);
        setTitle("SISTEMA ANTIPLAGIUM");
        setPreferredSize(new java.awt.Dimension(1300, 45));

        LBLUsuario.setBackground(new java.awt.Color(153, 204, 255));
        LBLUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LBLUsuario.setText("Nombre del Usuario");
        LBLUsuario.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        LBLUsuario.setDoubleBuffered(true);
        LBLUsuario.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        LBLUsuario.setMaximumSize(new java.awt.Dimension(1200, 14));
        LBLUsuario.setOpaque(true);
        LBLUsuario.setPreferredSize(new java.awt.Dimension(1024, 14));
        getContentPane().add(LBLUsuario, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JIFBase().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JLabel LBLUsuario;
    // End of variables declaration//GEN-END:variables

}
