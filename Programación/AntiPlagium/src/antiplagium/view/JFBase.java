package antiplagium.view;

import antiplagium.BE.*;
import antiplagium.BL.*;
import java.awt.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Vector;
import javax.swing.*;

public class JFBase extends javax.swing.JFrame {

       
    private Dimension dim;
    public static UsuarioBE usuarioBE = null;
    protected static RegistroOperacionBE operacionBE;    

    public JFBase(UsuarioBE usuarioBE)
    {
        int ancho = Toolkit.getDefaultToolkit().getScreenSize().width;
        int alto = Toolkit.getDefaultToolkit().getScreenSize().height;
        int ancholabel=Toolkit.getDefaultToolkit().getScreenSize().width;
        this.setSize(ancho, alto - 40);
        this.usuarioBE = usuarioBE;
        initComponents();
        
        LBLUsuario.setSize(ancho,14);
        LBLUsuario.setText(usuarioBE.getApellidoPaterno() + " " + usuarioBE.getApellidoMaterno() + ", " + usuarioBE.getNombres());

        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.getContentPane().setBackground(Color.lightGray);        
    }

    protected void aplicarSeguridad(JMenuBar menu, Integer idRol) {
        
        String nombreVentana = this.getName();
        ResultSet tablaControles;
        Vector vector = new Vector();
        JRootPane jroot = this.getRootPane();
        Component[] componentes = jroot.getJMenuBar().getComponents();
        Component[] componentesInternos;

        SeguridadBL seguridadBL = new SeguridadBL();
        try {
            seguridadBL.AbrirConexion();
            tablaControles = seguridadBL.getListControlesDeshabilitadosPorRol(nombreVentana, idRol);

            if (tablaControles.getMetaData().getColumnCount() > 0) {
                int nroColumnas = tablaControles.getMetaData().getColumnCount();
                while (tablaControles.next()) {
                    Object[] registro = new Object[nroColumnas];
                    for (int i = 0; i < nroColumnas; i++) {
                        registro[i] = tablaControles.getObject(i + 1);
                    }
                    vector.addElement(registro);
                }
            }
            seguridadBL.CerrarConexion();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, ex.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException excepcionSQL) {
            JOptionPane.showMessageDialog(this, excepcionSQL.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }

        for (int i = 0; i < vector.size(); i++) {
            Object[] registro = (Object[]) vector.get(i);
            String nombreControl = registro[3].toString();

            //System.out.println(nombreControl);
            for (int k = 0; k < menu.getMenuCount(); k++) {
                componentesInternos = menu.getMenu(k).getMenuComponents();
                for (int j = 0; j < componentesInternos.length; j++) {
                    if (((JMenuItem) componentesInternos[j]).getName().equals(nombreControl)) {
                        ((JMenuItem) componentesInternos[j]).setVisible(true);
                    }
                }

                if (menu.getMenu(k).getName().equals(nombreControl)) {
                    menu.getMenu(k).setVisible(true);
                }
            }
        }
    }
   
    public static void setOperacion(String nombreVentana, String tipoOperacion, String descripcion)
    {
        operacionBE.setFechaOperacion(new Date(System.currentTimeMillis()));
        operacionBE.setNombreVentana(nombreVentana);
        operacionBE.setTipoOperacion(tipoOperacion);
        setOperacionDescripcion(operacionBE.getFechaOperacion(), descripcion);
    }

    public static void setOperacionDescripcion(java.util.Date fecha, String descripcion)
    {
        String cadenaFecha = null;
        SimpleDateFormat formato=new SimpleDateFormat("dd/MMM/yyyy HH:mm:ss");
        if (operacionBE.getFechaOperacion()!= null)
        {
            cadenaFecha = formato.format(operacionBE.getFechaOperacion());
        }

        String descripcionOperacion = "Usuario: " + JFBase.usuarioBE.getNombreUsuario() + "\n" +
                                      "Fecha:   " + cadenaFecha + "\n" +
                                      "Tipo Operacion: " + descripcion;

        operacionBE.setDescripcion(descripcionOperacion);
    }

    public static void registrarOperacion() throws SQLException
    {
        RegistroOperacionBL operacionBL = new RegistroOperacionBL();
        operacionBL.insertOperacion(JFBase.operacionBE);
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
        LBLUsuario.setMaximumSize(new java.awt.Dimension(1600, 14));
        LBLUsuario.setMinimumSize(new java.awt.Dimension(1600, 14));
        LBLUsuario.setOpaque(true);
        LBLUsuario.setPreferredSize(new java.awt.Dimension(1600, 14));
        getContentPane().add(LBLUsuario, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JLabel LBLUsuario;
    // End of variables declaration//GEN-END:variables
}
