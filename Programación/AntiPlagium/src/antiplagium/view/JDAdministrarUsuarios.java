package antiplagium.view;

//import org.freixas.jcalendar.JCalendarCombo;

import antiplagium.*;
import antiplagium.BE.CategoriaBE;
import antiplagium.BE.EstadoBE;
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
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.xml.bind.ParseConversionEvent;
import org.freixas.jcalendar.JCalendarCombo;
import sun.swing.table.DefaultTableCellHeaderRenderer;

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

            jBSeleccionar.setVisible(false);
            jBCerrar.setVisible(false);

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


                ArrayList<EstadoBE> registrosEstado = estadoBl.ObtenerEstados();
                if (registrosEstado != null) {
                    //System.out.println(registrosEstado.size());
                    jCBEstado.addItem("Todos");
                    int numeroReg = registrosEstado.size();
                    for (int i = 0; i <= numeroReg - 1; i++) {
                        jCBEstado.addItem(registrosEstado.get(i).getNombre());
                    }
                }

               // if(nick.compareTo("")!=0){
                if (nick!=null){
                    jTFUsuario.setText(nick);

                    jMEliminar.setVisible(false);
                    jMModificar.setVisible(false);
                    jMNuevo.setVisible(false);
                    JBNuevo.setVisible(false);
                    jBModificar.setVisible(false);
                    jBEliminar.setVisible(false);
                    jBSeleccionar.setVisible(true);
                    jBCerrar.setVisible(true);
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
        jLabel5 = new javax.swing.JLabel();
        jCBEstado = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTListaUsuarios = new javax.swing.JTable();
        jBModificar = new javax.swing.JButton();
        JBNuevo = new javax.swing.JButton();
        jBEliminar = new javax.swing.JButton();
        jBSeleccionar = new javax.swing.JButton();
        jBCerrar = new javax.swing.JButton();
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
                    .addComponent(jCBRol, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTFNombreCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jBConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTFUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jCBEstado, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCBArea, javax.swing.GroupLayout.Alignment.LEADING, 0, 269, Short.MAX_VALUE)))
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jPFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jBConsultar)
                .addContainerGap())
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
        jBModificar.setPreferredSize(new java.awt.Dimension(95, 33));
        jBModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBModificarActionPerformed(evt);
            }
        });

        JBNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/nuevo.png"))); // NOI18N
        JBNuevo.setText("Nuevo");
        JBNuevo.setPreferredSize(new java.awt.Dimension(95, 33));
        JBNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBNuevoActionPerformed(evt);
            }
        });

        jBEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Eliminar - 16.png"))); // NOI18N
        jBEliminar.setText("Eliminar");
        jBEliminar.setPreferredSize(new java.awt.Dimension(95, 33));
        jBEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEliminarActionPerformed(evt);
            }
        });

        jBSeleccionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/aceptar.png"))); // NOI18N
        jBSeleccionar.setText("Seleccionar");
        jBSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSeleccionarActionPerformed(evt);
            }
        });

        jBCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cancelar.png"))); // NOI18N
        jBCerrar.setText("Cerrar");
        jBCerrar.setPreferredSize(new java.awt.Dimension(80, 33));
        jBCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCerrarActionPerformed(evt);
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jBSeleccionar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JBNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBSeleccionar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBModificarActionPerformed
        
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
//            AntiPlagiumPrincipal.getJDesktopPane().add(jfAgregarUsuario);
//            jfAgregarUsuario.toFront();
        }
}//GEN-LAST:event_jBModificarActionPerformed

    private void JBNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBNuevoActionPerformed
        JDAgregarUsuario jfAgregarUsuario=new JDAgregarUsuario(0);
        jfAgregarUsuario.setModal(true);
        jfAgregarUsuario.setLocationRelativeTo(this);
        jfAgregarUsuario.setVisible(true);        
//        AntiPlagiumPrincipal.getJDesktopPane().add(jfAgregarUsuario);
//        jfAgregarUsuario.toFront();
}//GEN-LAST:event_JBNuevoActionPerformed

    private void jBEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEliminarActionPerformed
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
//            AntiPlagiumPrincipal.getJDesktopPane().add(jfEliminarUsuario);
//            jfEliminarUsuario.toFront();
        }
}//GEN-LAST:event_jBEliminarActionPerformed

    private void jCBAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBAreaActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jCBAreaActionPerformed

    private void jCBRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBRolActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jCBRolActionPerformed

    private void jMNuevoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMNuevoMouseReleased
        JDAgregarUsuario jfAgregarUsuario=new JDAgregarUsuario(0);
        jfAgregarUsuario.setModal(true);
        jfAgregarUsuario.setLocationRelativeTo(this);
        jfAgregarUsuario.setVisible(true);
//        AntiPlagiumPrincipal.getJDesktopPane().add(jfAgregarUsuario);
//        jfAgregarUsuario.toFront();
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
//            AntiPlagiumPrincipal.getJDesktopPane().add(jfAgregarUsuario);
//            jfAgregarUsuario.toFront();
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
//            AntiPlagiumPrincipal.getJDesktopPane().add(jfEliminarUsuario);
//            jfEliminarUsuario.toFront();
        }
    }//GEN-LAST:event_jMEliminarMouseReleased

    private void jBConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBConsultarActionPerformed
        ConsultarUsuarios();
    }//GEN-LAST:event_jBConsultarActionPerformed

    private void jBSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSeleccionarActionPerformed

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

    }//GEN-LAST:event_jBSeleccionarActionPerformed

    private void jBCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCerrarActionPerformed
            this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jBCerrarActionPerformed

    private void ConsultarUsuarios(){
        try {

            usuarioBL = new UsuarioBL();
            usuarioBL.AbrirConexion();
            String usuario=jTFUsuario.getText();
            String nombreCompleto=JTFNombreCompleto.getText();
            int idRol=jCBRol.getSelectedIndex()-1;
            int idArea=jCBArea.getSelectedIndex()-1;
            int idEstado=jCBEstado.getSelectedIndex();
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
                                modelo.addRow(objetos);
                            }
                        }
                        else {modelo.addRow(objetos);}

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
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBNuevo;
    private javax.swing.JTextField JTFNombreCompleto;
    private javax.swing.JButton jBCerrar;
    private javax.swing.JButton jBConsultar;
    private javax.swing.JButton jBEliminar;
    private javax.swing.JButton jBModificar;
    private javax.swing.JButton jBSeleccionar;
    private javax.swing.JComboBox jCBArea;
    private javax.swing.JComboBox jCBEstado;
    private javax.swing.JComboBox jCBRol;
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
    private javax.swing.JTextField jTFUsuario;
    private javax.swing.JTable jTListaUsuarios;
    // End of variables declaration//GEN-END:variables

}
