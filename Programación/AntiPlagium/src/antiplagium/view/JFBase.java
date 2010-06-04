
package antiplagium.view;

import antiplagium.BL.SeguridadBL;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.UIManager;

public class JFBase extends javax.swing.JFrame {

    private Dimension dim;
    private static String nombreUsuario =   "";
    private static String nombreRol =       "Principal";

    public JFBase()
    {
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

    protected void aplicarSeguridad(JMenuBar menu)
    {
        if (nombreRol == "Administrador") return;
        String nombreVentana = this.getName();
        ResultSet tablaControles;
        Vector vector = new Vector();
        JRootPane jroot = this.getRootPane();
        Component[] componentes = jroot.getJMenuBar().getComponents();
        Component[] componentesInternos;

        SeguridadBL seguridadBL = new SeguridadBL();
        try
        {
            seguridadBL.AbrirConexion();
            tablaControles = seguridadBL.getListControlesDeshabilitadosPorRol(nombreVentana, nombreRol);

            if (tablaControles.getMetaData().getColumnCount() > 0)
            {
                int nroColumnas = tablaControles.getMetaData().getColumnCount();
                while(tablaControles.next())
                {
                    Object[] registro = new Object[nroColumnas];
                    for (int i=0; i < nroColumnas; i++)
                    {
                        registro[i] = tablaControles.getObject(i+1);
                    }
                    vector.addElement(registro);
                }
            }
            seguridadBL.CerrarConexion();
        }
        catch (ClassNotFoundException ex)
        {
            JOptionPane.showMessageDialog(this, ex.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        catch (SQLException excepcionSQL)
        {
            JOptionPane.showMessageDialog(this, excepcionSQL.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }

        for(int i=0 ; i< vector.size(); i++)
        {
            Object[] registro = (Object[])vector.get(i);
            String nombreControl = registro[3].toString();

            System.out.println(nombreControl);

            for (int k=0; k < menu.getMenuCount() ;k++)
            {                
                componentesInternos = menu.getMenu(k).getMenuComponents();
                for(int j=0; j < componentesInternos.length; j++)
                {
                    if (((JMenuItem)componentesInternos[j]).getName().equals(nombreControl))
                    {
                        ((JMenuItem)componentesInternos[j]).setVisible(false);
                    }
                }

                if (menu.getMenu(k).getName().equals(nombreControl))
                {
                        menu.getMenu(k).setVisible(false);
                }
            }
        }
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
