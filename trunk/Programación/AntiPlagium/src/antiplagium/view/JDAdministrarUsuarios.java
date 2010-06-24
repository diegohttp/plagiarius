package antiplagium.view;

//import org.freixas.jcalendar.JCalendarCombo;

import antiplagium.*;
import antiplagium.BE.CategoriaBE;
import antiplagium.BE.EstadoBE;
import antiplagium.BE.RolBE;
import antiplagium.BE.UsuarioBE;
import antiplagium.BL.CategoriaBL;
import antiplagium.BL.EstadoBL;
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
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.freixas.jcalendar.JCalendarCombo;

/**
 *
 * @author a20050354
 */
public class JDAdministrarUsuarios extends JDialog {

    private JCalendarCombo cmbCalendarioInicio = new JCalendarCombo();
    private JCalendarCombo cmbCalendarioFin= new JCalendarCombo();
    private RolBL rolBL;
    private CategoriaBL categoriaBl;
    private UsuarioBL usuarioBL;
    private EstadoBL estadoBl;
    private UsuarioBE usuarioBESeleccionado=null;
    ArrayList<EstadoBE> registrosEstado=null;

    public UsuarioBE getUsuarioBESeleccionado() {
        return usuarioBESeleccionado;
    }

//    JDesktopPane desktop;
    /** Creates new form JFAministrarUsuarios */
    public JDAdministrarUsuarios(String nick) {


        try {
            //         super("", true, true, false, true);
            //        desktop=new JDesktopPane();
            //        setContentPane(desktop);
            initComponents();
            //JTFNombreCompleto.setText(JFBase.usuarioBE.getApellidoPaterno());
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
            estadoBl=new EstadoBL();

            btnSeleccionar.setVisible(false);
            btnCerrar.setVisible(false);

            try {
                rolBL.AbrirConexion();

                ResultSet registros = rolBL.getListRoles();
                cmbRol.addItem(new RolBE(-1,"Todos","Todos los roles"));
                cmbRol.addItem(new RolBE(0,"Ninguno","Ningun rol"));
                while (registros.next()) {
                    cmbRol.addItem(new RolBE(registros.getInt("idRol"),registros.getString("nombre"),registros.getString("estado")));
                }
               
                rolBL.CerrarConexion();

                ArrayList<CategoriaBE> listaCategorias = categoriaBl.buscarCategoria("", "");
                cmbArea.addItem(new CategoriaBE(-1,"Todos descripcion", "Todos"));
                cmbArea.addItem(new CategoriaBE(0,"Ninguno descripcion", "Ninguno"));
                int cantidadCategorias = listaCategorias.size();
                for (int i = 0; i < cantidadCategorias; i++) {
                    cmbArea.addItem(listaCategorias.get(i));
                }


                registrosEstado = estadoBl.ObtenerEstados(0,"","");
                if (registrosEstado != null) {
                    cmbEstado.addItem(new EstadoBE(0,"Todos", "Todos descripcion"));
                    int numeroReg = registrosEstado.size();
                    for (int i = 0; i <= numeroReg - 1; i++) {
                        cmbEstado.addItem(registrosEstado.get(i));
                    }
                }

               // if(nick.compareTo("")!=0){
                if (nick!=null){
                    txtUsuario.setText(nick);

                    jMEliminar.setVisible(false);
                    jMModificar.setVisible(false);
                    jMNuevo.setVisible(false);
//                    JBNuevo.setVisible(false);
//                    jBModificar.setVisible(false);
//                    jBEliminar.setVisible(false);
                    btnSeleccionar.setVisible(true);
                    btnCerrar.setVisible(true);
                }

                ConsultarUsuarios();

            } catch (FileNotFoundException ex) {
                Logger.getLogger(JDAdministrarUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(JDAdministrarUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(JDAdministrarUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(JDAdministrarUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            }


        } catch (ParseException ex) {
            Logger.getLogger(JDAdministrarUsuarios.class.getName()).log(Level.SEVERE, null, ex);
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
        txtUsuario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cmbRol = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cmbArea = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jPFechaInicio = new javax.swing.JPanel();
        jPFechaFin = new javax.swing.JPanel();
        btnConsultar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtNombreCompleto = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cmbEstado = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTListaUsuarios = new javax.swing.JTable();
        btnSeleccionar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMNuevo = new javax.swing.JMenu();
        jMModificar = new javax.swing.JMenu();
        jMEliminar = new javax.swing.JMenu();

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Administrar Usuarios");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtros"));

        jLabel2.setText("Nombre deUsuario");

        jLabel3.setText("Rol");

        cmbRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbRolActionPerformed(evt);
            }
        });

        jLabel4.setText("Fecha incio");

        jLabel9.setText("Fecha fin");

        cmbArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbAreaActionPerformed(evt);
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

        btnConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/buscar.png"))); // NOI18N
        btnConsultar.setText("Buscar");
        btnConsultar.setPreferredSize(new java.awt.Dimension(135, 35));
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombres y Apellidos");

        jLabel5.setText("Estado");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbRol, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(cmbEstado, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmbArea, javax.swing.GroupLayout.Alignment.LEADING, 0, 269, Short.MAX_VALUE)))
                .addGap(39, 39, 39))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jPFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jPFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista de Usuarios"));

        jTListaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre Usuario", "Nombre Completo", "Rol", "Fecha Caducidad", "Area Academica", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTListaUsuarios);
        jTListaUsuarios.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTListaUsuarios.getColumnModel().getColumn(1).setPreferredWidth(150);
        jTListaUsuarios.getColumnModel().getColumn(2).setPreferredWidth(250);
        jTListaUsuarios.getColumnModel().getColumn(3).setPreferredWidth(120);
        jTListaUsuarios.getColumnModel().getColumn(4).setPreferredWidth(120);
        jTListaUsuarios.getColumnModel().getColumn(5).setPreferredWidth(150);
        jTListaUsuarios.getColumnModel().getColumn(6).setPreferredWidth(120);

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnSeleccionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/aceptar.png"))); // NOI18N
        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.setPreferredSize(new java.awt.Dimension(135, 35));
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });

        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cancelar.png"))); // NOI18N
        btnCerrar.setText("Cancelar");
        btnCerrar.setPreferredSize(new java.awt.Dimension(135, 35));
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        jMenuBar1.setBackground(new java.awt.Color(0, 153, 153));

        jMNuevo.setBackground(new java.awt.Color(0, 153, 153));
        jMNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/nuevo.png"))); // NOI18N
        jMNuevo.setText("Nuevo");
        jMNuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jMNuevoMouseReleased(evt);
            }
        });
        jMenuBar1.add(jMNuevo);

        jMModificar.setBackground(new java.awt.Color(0, 153, 153));
        jMModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/modificar.png"))); // NOI18N
        jMModificar.setText("Modificar");
        jMModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jMModificarMouseReleased(evt);
            }
        });
        jMenuBar1.add(jMModificar);

        jMEliminar.setBackground(new java.awt.Color(0, 153, 153));
        jMEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Eliminar - 16.png"))); // NOI18N
        jMEliminar.setText("Eliminar");
        jMEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jMEliminarMouseReleased(evt);
            }
        });
        jMenuBar1.add(jMEliminar);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAreaActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_cmbAreaActionPerformed

    private void cmbRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbRolActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_cmbRolActionPerformed

    private void jMNuevoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMNuevoMouseReleased
        JDAgregarUsuario jfAgregarUsuario=new JDAgregarUsuario(0);
        jfAgregarUsuario.setModal(true);
        jfAgregarUsuario.setLocationRelativeTo(this);
        jfAgregarUsuario.setVisible(true);
        ConsultarUsuarios();
    }//GEN-LAST:event_jMNuevoMouseReleased

    private void jMModificarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMModificarMouseReleased
       int iFila=-1;
        iFila=jTListaUsuarios.getSelectedRow();

        System.out.println("numero de fila"+iFila);

        if (iFila==-1){
            JOptionPane.showMessageDialog(this, "Debe seleccionar un registro usuario a modificar.", "Seleccionar registro",JOptionPane.ERROR_MESSAGE);
        }
        else{
            int idUsuario=(Integer)jTListaUsuarios.getValueAt(iFila, 0);
            JDAgregarUsuario jfAgregarUsuario=new JDAgregarUsuario(idUsuario);
            jfAgregarUsuario.setModal(true);
            jfAgregarUsuario.setLocationRelativeTo(this);
            jfAgregarUsuario.setVisible(true);
            ConsultarUsuarios();
        }
    }//GEN-LAST:event_jMModificarMouseReleased

    private void jMEliminarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMEliminarMouseReleased
        int iFila=-1;
        iFila=jTListaUsuarios.getSelectedRow();

        System.out.println("numero de fila"+iFila);

        if (iFila==-1){
            JOptionPane.showMessageDialog(this, "Debe seleccionar un registro usuario a modificar.", "Seleccionar registro",JOptionPane.ERROR_MESSAGE);
        }
        else{
            int idUsuario=(Integer)jTListaUsuarios.getValueAt(iFila, 0);
            JDEliminarUsuario jfEliminarUsuario = new JDEliminarUsuario(idUsuario);
            jfEliminarUsuario.setModal(true);
            jfEliminarUsuario.setLocationRelativeTo(this);
            jfEliminarUsuario.setVisible(true);
            ConsultarUsuarios();
        }
    }//GEN-LAST:event_jMEliminarMouseReleased

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        ConsultarUsuarios();
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed

        boolean selecciona=false;

        DefaultTableModel modelo= (DefaultTableModel)jTListaUsuarios.getModel();
        int[] filasSeleccionadas=  jTListaUsuarios.getSelectedRows();

        if (filasSeleccionadas.length==0){
            JOptionPane.showMessageDialog(this,"Debe seleccionar una fila o registro de la lista de usuarios","Error", JOptionPane.ERROR_MESSAGE);
        }
        else if(filasSeleccionadas.length>1){
            JOptionPane.showMessageDialog(this,"Debe seleccionar solo una fila o registro de la lista usuaios","Error", JOptionPane.ERROR_MESSAGE);
        }
        else if(filasSeleccionadas.length==1){
            usuarioBESeleccionado=usuarioBL.getUsuarioBE(Integer.parseInt(jTListaUsuarios.getValueAt(jTListaUsuarios.getSelectedRow(),0).toString()));
            this.setVisible(false);
        }

    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
            this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void ConsultarUsuarios(){
       try {

            usuarioBL = new UsuarioBL();
            usuarioBL.AbrirConexion();
            String usuario=txtUsuario.getText();
            String nombreCompleto=txtNombreCompleto.getText();

            //int idRol=jCBRol.getSelectedIndex()-1; MAL ERROR EN LA PRESENTACION
            RolBE rolBE=(RolBE)cmbRol.getSelectedItem();
            int idRol=rolBE.getIdRol();

            //int idArea=jCBArea.getSelectedIndex()-1; MAL ERROR EN LA PRESENTACION
            CategoriaBE categoriaBE=(CategoriaBE)cmbArea.getSelectedItem();
            int idArea=categoriaBE.getIdCategoria();

            //int idEstado=jCBEstado.getSelectedIndex(); MAL ERROR EN LA PRESENTACION
            EstadoBE estadoBE=(EstadoBE)cmbEstado.getSelectedItem();
            int idEstado=estadoBE.getIdEstado();

            SimpleDateFormat formato=new SimpleDateFormat("yyyy-MM-dd");
            String cadenaFechaI=formato.format(cmbCalendarioInicio.getDate());
            String cadenaFechaF=formato.format(cmbCalendarioFin.getDate());

            ResultSet rs = usuarioBL.getListaUsuarios(usuario,nombreCompleto,cadenaFechaI,cadenaFechaF,idRol,idArea,idEstado);

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

                        if (modelo.getRowCount()!=0){
                            if (Integer.parseInt(objetos[0].toString())!=Integer.parseInt(modelo.getValueAt(modelo.getRowCount()-1,0).toString()) ){
                                                        int idUsuario=Integer.parseInt(objetos[0].toString());
                        UsuarioBE usuariobe=usuarioBL.getUsuarioBE(idUsuario);
                        if(usuariobe.getFechaCese()==null){
                            formato=new SimpleDateFormat("yyyy-MM-dd");
                            String cadenaFechaVencimiento=formato.format(usuariobe.getFechaVencimiento());
                            int resultado=cadenaFechaVencimiento.compareTo(formato.format(new Date( System.currentTimeMillis())));
                            if (resultado<=0){
                                CesarUsuario(usuariobe);
                        }
                }

                                modelo.addRow(objetos);
                            }
                        }
                        else {
                                                    int idUsuario=Integer.parseInt(objetos[0].toString());
                        UsuarioBE usuariobe=usuarioBL.getUsuarioBE(idUsuario);
                        if(usuariobe.getFechaCese()==null){
                            formato=new SimpleDateFormat("yyyy-MM-dd");
                            String cadenaFechaVencimiento=formato.format(usuariobe.getFechaVencimiento());
                            int resultado=cadenaFechaVencimiento.compareTo(formato.format(new Date( System.currentTimeMillis())));
                            if (resultado<=0){
                                CesarUsuario(usuariobe);
                        }
                }

                            modelo.addRow(objetos);
                        }

                        //modelo.addRow(objetos);
                    }

            }

            usuarioBL.CerrarConexion();

        } catch (SQLException ex) {
            Logger.getLogger(JDAdministrarUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JDAdministrarUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void CesarUsuario(UsuarioBE usuarioBEO){

        Boolean rpta;
        usuarioBEO.setFechaCese(new Date( System.currentTimeMillis()));
        //usuarioBE.setTipoCeseBE(null);
        for (int i=0;i<registrosEstado.size();i++){
            if (registrosEstado.get(i).getNombre().compareTo("Inactivo")==0){
                usuarioBEO.setEstadoBE(registrosEstado.get(i));
            }
        }
        rpta=usuarioBL.ElminarUsuario(usuarioBEO);

//        if(rpta==true){
//            JOptionPane.showMessageDialog(this,"El usuario ha sido eliminado con exito.", "Informe", JOptionPane.INFORMATION_MESSAGE);
//        }
//        else{
//            JOptionPane.showMessageDialog(this,"Error. Usuario no eliminado", "Error", JOptionPane.ERROR_MESSAGE);
//        }

        if (rpta==false) {
            JOptionPane.showMessageDialog(this,"La fecha de vencimiento de la cuenta de usuario ha pasado su limite.", "Error", JOptionPane.ERROR_MESSAGE);
        }


    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JComboBox cmbArea;
    private javax.swing.JComboBox cmbEstado;
    private javax.swing.JComboBox cmbRol;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMEliminar;
    private javax.swing.JMenu jMModificar;
    private javax.swing.JMenu jMNuevo;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPFechaFin;
    private javax.swing.JPanel jPFechaInicio;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTListaUsuarios;
    private javax.swing.JTextField txtNombreCompleto;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

}
