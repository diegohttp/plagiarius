package antiplagium.view;

import antiplagium.BE.GestorTiposOperacion;
import antiplagium.BE.RegistroOperacionBE;
import antiplagium.BL.RegistroOperacionBL;
import antiplagium.DAL.ConexionJDBC;
import java.awt.BorderLayout;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;
import org.freixas.jcalendar.JCalendarCombo;

public class JDLogDeUsuarios extends JDialog {

    JCalendarCombo calendarInicio;
    JCalendarCombo calendarFin;
    RegistroOperacionBL registroOperacionBL;
    ResultSet rs;
    ArrayList<RegistroOperacionBE> listaOperaciones;
    String cadenaFechaI;
    String cadenaFechaF;

    /** Creates new form JDLogDeUsuarios */
    public JDLogDeUsuarios() {
        initComponents();

        calendarInicio = new JCalendarCombo();
        calendarFin = new JCalendarCombo();

        calendarInicio.setSize(215, 30);
        calendarFin.setSize(215, 30);
        JPFechaInicio.add(calendarInicio);
        JPFechaFin.add(calendarFin);

        //GestorTiposOperacion.getTipoOperacion("")

        cmbOperacion.addItem("Todos");
        cmbOperacion.addItem(GestorTiposOperacion.getTipoOperacion("ingreso"));
        cmbOperacion.addItem(GestorTiposOperacion.getTipoOperacion("salida"));
        cmbOperacion.addItem(GestorTiposOperacion.getTipoOperacion("consulta"));
        cmbOperacion.addItem(GestorTiposOperacion.getTipoOperacion("modifica"));
        cmbOperacion.addItem(GestorTiposOperacion.getTipoOperacion("registra"));
        cmbOperacion.addItem(GestorTiposOperacion.getTipoOperacion("eliminacion"));
        cmbOperacion.addItem(GestorTiposOperacion.getTipoOperacion("comparacion"));
        cmbOperacion.addItem(GestorTiposOperacion.getTipoOperacion("reporte"));


    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTOperaciones = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        btnBuscarUsuario = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        JPFechaInicio = new javax.swing.JPanel();
        JPFechaFin = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtCategoria = new javax.swing.JTextField();
        btnBuscarCategoria = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cmbOperacion = new javax.swing.JComboBox();
        btnFiltrar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setTitle("Log de Usuarios");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Operaciones"));

        jTOperaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID OPeracion", "OPeracion", "ID Usuario", "Usuario", "Fecha"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTOperaciones);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 655, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtro Operaciones"));

        jLabel2.setText("Usuario");

        btnBuscarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/buscar.png"))); // NOI18N
        btnBuscarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarUsuarioActionPerformed(evt);
            }
        });

        jLabel1.setText("Desde");

        JPFechaInicio.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        JPFechaInicio.setPreferredSize(new java.awt.Dimension(215, 30));

        javax.swing.GroupLayout JPFechaInicioLayout = new javax.swing.GroupLayout(JPFechaInicio);
        JPFechaInicio.setLayout(JPFechaInicioLayout);
        JPFechaInicioLayout.setHorizontalGroup(
            JPFechaInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 211, Short.MAX_VALUE)
        );
        JPFechaInicioLayout.setVerticalGroup(
            JPFechaInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 26, Short.MAX_VALUE)
        );

        JPFechaFin.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        JPFechaFin.setPreferredSize(new java.awt.Dimension(215, 30));

        javax.swing.GroupLayout JPFechaFinLayout = new javax.swing.GroupLayout(JPFechaFin);
        JPFechaFin.setLayout(JPFechaFinLayout);
        JPFechaFinLayout.setHorizontalGroup(
            JPFechaFinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 211, Short.MAX_VALUE)
        );
        JPFechaFinLayout.setVerticalGroup(
            JPFechaFinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 26, Short.MAX_VALUE)
        );

        jLabel4.setText("Categoria");

        btnBuscarCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/buscar.png"))); // NOI18N
        btnBuscarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarCategoriaActionPerformed(evt);
            }
        });

        jLabel3.setText("Hasta");

        jLabel5.setText("Operacion");

        btnFiltrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/buscar.png"))); // NOI18N
        btnFiltrar.setText("Buscar");
        btnFiltrar.setPreferredSize(new java.awt.Dimension(135, 35));
        btnFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBuscarUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBuscarCategoria))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbOperacion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JPFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JPFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addComponent(btnFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(35, 35, 35))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnBuscarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(btnBuscarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JPFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JPFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbOperacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cancelar.png"))); // NOI18N
        jButton1.setText("Cancelar");
        jButton1.setPreferredSize(new java.awt.Dimension(135, 35));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Reporte.png"))); // NOI18N
        jButton2.setText("Reporte");
        jButton2.setPreferredSize(new java.awt.Dimension(135, 35));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/seleccionar.png"))); // NOI18N
        jButton3.setText("Ver Detalle");
        jButton3.setPreferredSize(new java.awt.Dimension(135, 35));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(9, 9, 9)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarUsuarioActionPerformed

          String nombreUsuario=txtUsuario.getText();

        JDAdministrarUsuarios jdAdminUsuario= new JDAdministrarUsuarios(nombreUsuario);
        jdAdminUsuario.setModal(true);
        jdAdminUsuario.setLocationRelativeTo(this);
        jdAdminUsuario.setVisible(true);

        if (jdAdminUsuario.getUsuarioBESeleccionado()!=null){
            txtUsuario.setText(jdAdminUsuario.getUsuarioBESeleccionado().getNombreUsuario());
        }
    }//GEN-LAST:event_btnBuscarUsuarioActionPerformed

    private void btnBuscarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCategoriaActionPerformed

       String nombreCategoria=txtCategoria.getText();


        JDAdministrarCategoria jdAdminCategoria = new JDAdministrarCategoria(nombreCategoria);
        jdAdminCategoria.setModal(true);
        jdAdminCategoria.setLocationRelativeTo(this);
        jdAdminCategoria.setVisible(true);

        if (jdAdminCategoria.getCategoriaSeleccionado()!=null){
            txtCategoria.setText(jdAdminCategoria.getCategoriaSeleccionado().getNombre());
        }

    }//GEN-LAST:event_btnBuscarCategoriaActionPerformed

    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed
        try {

            ConexionJDBC.abrirConexion();

            registroOperacionBL = new RegistroOperacionBL();
            String nombreUsuario = txtUsuario.getText();
            String nombreCategoria = txtCategoria.getText();
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            String cadenaFechaI = formato.format(calendarInicio.getDate());
            String cadenaFechaF = formato.format(calendarFin.getDate());
            String tipoOperacion = cmbOperacion.getSelectedItem().toString();

            if(tipoOperacion.compareTo("Todos")==0){
                tipoOperacion="";
            }


            listaOperaciones = registroOperacionBL.ObtenerLog(0, nombreUsuario, nombreCategoria, cadenaFechaI, cadenaFechaF, tipoOperacion);
            
            rs = registroOperacionBL.ObtenerLogOperaciones(0,nombreUsuario, nombreCategoria, cadenaFechaI, cadenaFechaF, tipoOperacion);

            if (rs != null) {
                DefaultTableModel modelo = (DefaultTableModel) jTOperaciones.getModel();
                while (modelo.getRowCount() > 0) {
                    modelo.removeRow(0);
                }
                ResultSetMetaData rsmd = rs.getMetaData();
                int numeroColum = rsmd.getColumnCount();
                while (rs.next()) {
                    Object[] objetos = new Object[numeroColum];
                    for (int i = 0; i < numeroColum; i++) {
                        objetos[i] = rs.getObject(i + 1);
                    }
                    if (modelo.getRowCount() != 0) {
                        if (Integer.parseInt(objetos[0].toString()) != Integer.parseInt(modelo.getValueAt(modelo.getRowCount() - 1, 0).toString())) {
                            modelo.addRow(objetos);
                        }
                    } else {
                        modelo.addRow(objetos);
                    }
                }
            }

            ConexionJDBC.cerrarConexion();
            // TODO add your handling code here:
        } catch (SQLException ex) {
            Logger.getLogger(JDLogDeUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JDLogDeUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnFiltrarActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        try {

            // TODO add your handling code here:
            ResultSet rs;
            RegistroOperacionBE registroOperacionBE;
            boolean selecciona = false;
            ConexionJDBC.abrirConexion();

            DefaultTableModel modelo = (DefaultTableModel) jTOperaciones.getModel();
            int[] filasSeleccionadas = jTOperaciones.getSelectedRows();

            if (filasSeleccionadas.length == 0) {
                JOptionPane.showMessageDialog(this, "Debe seleccionar una fila o registro de la lista de usuarios", "Error", JOptionPane.ERROR_MESSAGE);
            } else
                if (filasSeleccionadas.length > 1) {
                JOptionPane.showMessageDialog(this, "Debe seleccionar solo una fila o registro de la lista usuaios", "Error", JOptionPane.ERROR_MESSAGE);
            } else
                if (filasSeleccionadas.length == 1) {
                int idRegistroOperacion = Integer.parseInt(jTOperaciones.getValueAt(jTOperaciones.getSelectedRow(), 0).toString());
                String cadenaFecha =jTOperaciones.getValueAt(jTOperaciones.getSelectedRow(), 4).toString();

                rs = registroOperacionBL.ObtenerLogOperaciones(idRegistroOperacion, "", "", cadenaFecha, cadenaFecha, "");
                if (rs.next()) {
                    String cidOperacion=String.valueOf(rs.getInt("idOperacion"));
                    String ctipoOperacion=rs.getString("tipoOperacion");
                    String cnombreUsuario=rs.getString("nombreUsuario");
                    String cfechaOperacion=rs.getString("fecha");
                    String cDescripcion=rs.getString("descripcion");
                    JDDetalleLogDeUsuario jdDetalleLogUsuario=new JDDetalleLogDeUsuario(cidOperacion,ctipoOperacion,cnombreUsuario,cfechaOperacion,cDescripcion);
                    jdDetalleLogUsuario.setModal(true);
                    jdDetalleLogUsuario.setLocationRelativeTo(this);
                    jdDetalleLogUsuario.setVisible(true);
                    jdDetalleLogUsuario.dispose();
                    //JOptionPane.showMessageDialog(this,cad ,"Informacion del registro", JOptionPane.INFORMATION_MESSAGE);
                }
            }


            ConexionJDBC.cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(JDLogDeUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JDLogDeUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         System.out.println("entra akiiiiiiii");
        Map pars = new HashMap();

        pars.put("P_TITULO", "Reporte Log de Usuario");
        pars.put("P_SUBTITULO", "");
        pars.put("PAR_FECHADESDE",cadenaFechaI);
        pars.put("PAR_FECHAHASTA",cadenaFechaF);
        JasperPrint jasperPrint= Utilitarios.GeneraReportes.gestorReporte("LogUsr", pars, this.listaOperaciones);
        try {

            JRViewer v = new JRViewer(jasperPrint);
            JFrame ventana=new JFrame();
            ventana.getContentPane().add(v,BorderLayout.CENTER);
            ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            ventana.setSize(706, 478);

            ventana.setTitle("Vista Previa");
            ventana.setLocation(512-ventana.getWidth()/2,387 - ventana.getHeight()/2 );

            ventana.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se cuenta con un equipo de impresion");
        }
    }//GEN-LAST:event_jButton2ActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPFechaFin;
    private javax.swing.JPanel JPFechaInicio;
    private javax.swing.JButton btnBuscarCategoria;
    private javax.swing.JButton btnBuscarUsuario;
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JComboBox cmbOperacion;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTOperaciones;
    private javax.swing.JTextField txtCategoria;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

}
