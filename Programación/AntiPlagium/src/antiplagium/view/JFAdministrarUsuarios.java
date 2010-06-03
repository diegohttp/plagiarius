package antiplagium.view;

//import org.freixas.jcalendar.JCalendarCombo;

import antiplagium.*;
import antiplagium.BE.CategoriaBE;
import antiplagium.BL.CategoriaBL;
import antiplagium.BL.RolBL;
import antiplagium.BL.UsuarioBL;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.table.DefaultTableModel;
import org.freixas.jcalendar.JCalendarCombo;
import sun.swing.table.DefaultTableCellHeaderRenderer;

/**
 *
 * @author a20050354
 */
public class JFAdministrarUsuarios extends JIFBase {

    private JCalendarCombo cmbCalendarioInicio = new JCalendarCombo();
    private JCalendarCombo cmbCalendarioFin= new JCalendarCombo();
    private RolBL rolBL;
    private CategoriaBL categoriaBl;
    private UsuarioBL usuarioBL;

//    JDesktopPane desktop;
    /** Creates new form JFAministrarUsuarios */
    public JFAdministrarUsuarios() {


        try {
            //         super("", true, true, false, true);
            //        desktop=new JDesktopPane();
            //        setContentPane(desktop);
            initComponents();
            cmbCalendarioInicio.setSize(269, 29);
            Date fechaI = new Date();
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            fechaI = formato.parse("2010-05-01");
            cmbCalendarioInicio.setDate(fechaI);
            cmbCalendarioFin.setSize(269, 29);
            jPFechaInicio.add(cmbCalendarioInicio);
            jPFechaFin.add(cmbCalendarioFin);
            rolBL = new RolBL();
            categoriaBl = new CategoriaBL();
            try {
                rolBL.AbrirConexion();
                ResultSet registros = rolBL.getListRoles();
                int numeroRegistros = registros.getRow();
                jCBRol.addItem("Todos");
                jCBRol.addItem("Ninguno");
                while (registros.next()) {
                    jCBRol.addItem(registros.getString("nombre"));
                }
                rolBL.CerrarConexion();
                ArrayList<CategoriaBE> listaCategorias = categoriaBl.buscarCategoria("", "");
                jCBArea.addItem("Todos");
                jCBArea.addItem("Ninguno");
                int cantidadCategorias = listaCategorias.size();
                for (int i = 0; i < cantidadCategorias; i++) {
                    jCBArea.addItem(listaCategorias.get(i).getNombre());
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(JFAdministrarUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(JFAdministrarUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(JFAdministrarUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(JFAdministrarUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            }


        } catch (ParseException ex) {
            Logger.getLogger(JFAdministrarUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }



   
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTFUsuario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jCBRol = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jCBArea = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jPFechaInicio = new javax.swing.JPanel();
        jPFechaFin = new javax.swing.JPanel();
        jBConsultar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        JTFNombreCompleto = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTListaUsuarios = new javax.swing.JTable();
        jBModificar = new javax.swing.JButton();
        JBNuevo = new javax.swing.JButton();
        jBEliminar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximizable(true);
        setTitle("Administrar Usuarios");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtros"));

        jLabel2.setText("Nombre deUsuario");

        jTFUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFUsuarioActionPerformed(evt);
            }
        });

        jLabel3.setText("Rol");

        jCBRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBRolActionPerformed(evt);
            }
        });

        jLabel4.setText("Fecha incio");

        jLabel9.setText("Fecha fin");

        jCBArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBAreaActionPerformed(evt);
            }
        });

        jLabel10.setText("Area Academica");

        jPFechaInicio.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPFechaInicio.setPreferredSize(new java.awt.Dimension(247, 29));

        javax.swing.GroupLayout jPFechaInicioLayout = new javax.swing.GroupLayout(jPFechaInicio);
        jPFechaInicio.setLayout(jPFechaInicioLayout);
        jPFechaInicioLayout.setHorizontalGroup(
            jPFechaInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 267, Short.MAX_VALUE)
        );
        jPFechaInicioLayout.setVerticalGroup(
            jPFechaInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        jPFechaFin.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPFechaFin.setPreferredSize(new java.awt.Dimension(247, 29));

        javax.swing.GroupLayout jPFechaFinLayout = new javax.swing.GroupLayout(jPFechaFin);
        jPFechaFin.setLayout(jPFechaFinLayout);
        jPFechaFinLayout.setHorizontalGroup(
            jPFechaFinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 265, Short.MAX_VALUE)
        );
        jPFechaFinLayout.setVerticalGroup(
            jPFechaFinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        jBConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/buscar.png"))); // NOI18N
        jBConsultar.setText("Buscar");
        jBConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBConsultarActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombres y Apellidos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCBRol, 0, 271, Short.MAX_VALUE)
                    .addComponent(JTFNombreCompleto, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                    .addComponent(jPFechaInicio, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jBConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPFechaFin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                            .addComponent(jCBArea, 0, 269, Short.MAX_VALUE)))
                    .addComponent(jTFUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE))
                .addGap(39, 39, 39))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTFNombreCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jPFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(17, 17, 17)
                .addComponent(jBConsultar)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista de Usuarios"));

        jTListaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre Usuario", "Nombre Completo", "Rol", "Fecha Caducidad", "Area Academica"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class
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
        jScrollPane1.setViewportView(jTListaUsuarios);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jBModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/modificar.png"))); // NOI18N
        jBModificar.setText("Modificar");
        jBModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBModificarActionPerformed(evt);
            }
        });

        JBNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/nuevo.png"))); // NOI18N
        JBNuevo.setText("Nuevo");
        JBNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBNuevoActionPerformed(evt);
            }
        });

        jBEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Eliminar - 16.png"))); // NOI18N
        jBEliminar.setText("Eliminar");
        jBEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEliminarActionPerformed(evt);
            }
        });

        jMenuBar1.setBackground(new java.awt.Color(0, 153, 153));

        jMenu1.setBackground(new java.awt.Color(0, 153, 153));
        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/nuevo.png"))); // NOI18N
        jMenu1.setText("Nuevo");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jMenu1MouseReleased(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu2.setBackground(new java.awt.Color(0, 153, 153));
        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/modificar.png"))); // NOI18N
        jMenu2.setText("Modificar");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jMenu2MouseReleased(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        jMenu5.setBackground(new java.awt.Color(0, 153, 153));
        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Eliminar - 16.png"))); // NOI18N
        jMenu5.setText("Eliminar");
        jMenu5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu5MouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jMenu5MouseReleased(evt);
            }
        });
        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(262, Short.MAX_VALUE)
                .addComponent(JBNuevo)
                .addGap(18, 18, 18)
                .addComponent(jBModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBEliminar)
                .addGap(72, 72, 72))
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBEliminar)
                    .addComponent(JBNuevo)
                    .addComponent(jBModificar))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBModificarActionPerformed
        JFAgregarUsuario jfAgregarUsuario=new JFAgregarUsuario(1);
        jfAgregarUsuario.setVisible(true);
        AntiPlagiumPrincipal.getJDesktopPane().add(jfAgregarUsuario);
        jfAgregarUsuario.toFront();
}//GEN-LAST:event_jBModificarActionPerformed

    private void JBNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBNuevoActionPerformed
        JFAgregarUsuario jfAgregarUsuario=new JFAgregarUsuario(0);
        jfAgregarUsuario.setVisible(true);
        AntiPlagiumPrincipal.getJDesktopPane().add(jfAgregarUsuario);
        jfAgregarUsuario.toFront();
}//GEN-LAST:event_JBNuevoActionPerformed

    private void jBEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEliminarActionPerformed
        JFEliminarUsuario jfEliminarUsuario=new JFEliminarUsuario();
        jfEliminarUsuario.setVisible(true);
        AntiPlagiumPrincipal.getJDesktopPane().add(jfEliminarUsuario);
        jfEliminarUsuario.toFront();
}//GEN-LAST:event_jBEliminarActionPerformed

    private void jCBAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBAreaActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jCBAreaActionPerformed

    private void jCBRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBRolActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jCBRolActionPerformed

    private void jTFUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFUsuarioActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jTFUsuarioActionPerformed

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        
    }//GEN-LAST:event_jMenu2MouseClicked


    private void jMenu5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu5MouseClicked
        
    }//GEN-LAST:event_jMenu5MouseClicked

    private void jMenu1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseReleased
        JFAgregarUsuario jfAgregarUsuario=new JFAgregarUsuario(0);
        jfAgregarUsuario.setVisible(true);
        AntiPlagiumPrincipal.getJDesktopPane().add(jfAgregarUsuario);
        jfAgregarUsuario.toFront();
    }//GEN-LAST:event_jMenu1MouseReleased

    private void jMenu2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseReleased
        JFAgregarUsuario jfAgregarUsuario=new JFAgregarUsuario(1);
        jfAgregarUsuario.setVisible(true);
        AntiPlagiumPrincipal.getJDesktopPane().add(jfAgregarUsuario);
        jfAgregarUsuario.toFront();
    }//GEN-LAST:event_jMenu2MouseReleased

    private void jMenu5MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu5MouseReleased
        JFEliminarUsuario jfEliminarUsuario = new JFEliminarUsuario();
        jfEliminarUsuario.setVisible(true);
        AntiPlagiumPrincipal.getJDesktopPane().add(jfEliminarUsuario);
        jfEliminarUsuario.toFront();
    }//GEN-LAST:event_jMenu5MouseReleased

    private void jBConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBConsultarActionPerformed
        try {
            
            usuarioBL = new UsuarioBL();
            usuarioBL.AbrirConexion();
            String usuario=jTFUsuario.getText();
            String nombreCompleto=JTFNombreCompleto.getText();
            int idRol=jCBRol.getSelectedIndex()-1;
            int idArea=jCBArea.getSelectedIndex()-1;
            SimpleDateFormat formato=new SimpleDateFormat("yyyy-MM-dd");
            String cadenaFechaI=formato.format(cmbCalendarioInicio.getDate());
            String cadenaFechaF=formato.format(cmbCalendarioFin.getDate());

            ResultSet rs = usuarioBL.getListaUsuarios(usuario,nombreCompleto,cadenaFechaI,cadenaFechaF,idRol,idArea);

            if (rs != null) {


                    DefaultTableModel modelo = (DefaultTableModel) jTListaUsuarios.getModel();
                    while (modelo.getRowCount()>0){
                        modelo.removeRow(0);
                    }
                    ResultSetMetaData rsmd = rs.getMetaData();
                    int numeroColum = rsmd.getColumnCount();
                    while (rs.next()) {
                        Object[] objetos = new Object[numeroColum];
                        for (int i = 0; i < numeroColum; i++) {
                            objetos[i] = rs.getObject(i + 1);
                        }
                        modelo.addRow(objetos);
                    }

            }

            usuarioBL.CerrarConexion();
            
        } catch (SQLException ex) {
            Logger.getLogger(JFAdministrarUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JFAdministrarUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jBConsultarActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBNuevo;
    private javax.swing.JTextField JTFNombreCompleto;
    private javax.swing.JButton jBConsultar;
    private javax.swing.JButton jBEliminar;
    private javax.swing.JButton jBModificar;
    private javax.swing.JComboBox jCBArea;
    private javax.swing.JComboBox jCBRol;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPFechaFin;
    private javax.swing.JPanel jPFechaInicio;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFUsuario;
    private javax.swing.JTable jTListaUsuarios;
    // End of variables declaration//GEN-END:variables

}
