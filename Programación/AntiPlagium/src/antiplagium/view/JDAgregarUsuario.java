/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JFAgregarUsuario1.java
 *
 * Created on 25/05/2010, 06:55:01 PM
 */

package antiplagium.view;

import Utilitarios.EnviarCorreo;
import antiplagium.BE.CategoriaBE;
import antiplagium.BE.EstadoBE;
import antiplagium.BE.RolBE;
import antiplagium.BE.TipoCeseBE;
import antiplagium.BE.UsuarioBE;
import antiplagium.BE.Utilitario;
import antiplagium.BL.EstadoBL;
import antiplagium.BL.RolBL;
import antiplagium.BL.UsuarioBL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import org.freixas.jcalendar.JCalendarCombo;
import org.omg.CORBA.Current;

/**
 *
 * @author piere
 */
public class JDAgregarUsuario extends JDialog {

    private EstadoBL estadoBL;
    private RolBL rolBL;
    private UsuarioBL usuarioBL;

    private JCalendarCombo cmbFechaInicio;
    private JCalendarCombo cmbFechaFin;
    private int opcion;
    private int codigoUsuario;

    private UsuarioBE usuarioBE=null;
    private UsuarioBE usuarioBEOringinal=null;

    //private static ArrayList<CategoriaBE> listaCategorias=null;
    private ArrayList<CategoriaBE> listaCategorias=null;
    ArrayList<EstadoBE> registrosEstado=null;

    private JPasswordField jPFContrasena;
    
    /** Creates new form JFAgregarUsuario1 */
    public JDAgregarUsuario(int idUsuario) {
        try {

            initComponents();
            listaCategorias=new ArrayList<CategoriaBE>();
            txtCodigo.setEnabled(false);
            this.opcion=idUsuario;

            cmbFechaInicio = new JCalendarCombo();
            cmbFechaFin = new JCalendarCombo();
            cmbFechaInicio.setSize(245, 29);
            cmbFechaFin.setSize(245, 29);
            jPanel3.add(cmbFechaInicio);
            jPanel4.add(cmbFechaFin);

            jMenuBar1.setVisible(false);

            jPFContrasena=new JPasswordField();
            jPFContrasena.setSize(120, 29);
            jPContrasena.add(jPFContrasena);
            jPFContrasena.setEnabled(false);


            estadoBL = new EstadoBL();

            usuarioBL = new UsuarioBL();

            rolBL=new RolBL();

            rolBL.AbrirConexion();
            ResultSet registros = rolBL.getListRoles();
            //int cantidadR = registros.getRow();
            while (registros.next()) {
                cmbRol.addItem(new RolBE(registros.getInt("idRol"), registros.getString("nombre"), registros.getString("estado")));
            }
            rolBL.CerrarConexion();


            registrosEstado = estadoBL.ObtenerEstados(0,"","");
            if (registrosEstado != null) {
                //System.out.println(registrosEstado.size());
                int numeroRegistros = registrosEstado.size();
                for (int i = 0; i <= numeroRegistros - 1; i++) {
                    cmbEstado.addItem(registrosEstado.get(i));
                }
            }

            if (idUsuario >= 1) {

                usuarioBEOringinal=usuarioBL.getUsuarioBE(idUsuario);
                listaCategorias=usuarioBEOringinal.getCategorias();

                if(usuarioBEOringinal.getFechaCese()==null){
                    SimpleDateFormat formato=new SimpleDateFormat("yyyy-MM-dd");
                    String cadenaFechaVencimiento=formato.format(usuarioBEOringinal.getFechaVencimiento());
                    int resultado=cadenaFechaVencimiento.compareTo(formato.format(new Date( System.currentTimeMillis())));
                    if (resultado<=0){
                        CesarUsuario(usuarioBEOringinal);
                    }
                }

                MostrarDatos(usuarioBEOringinal);
                this.setTitle("Modificar Usuario");
                this.setBounds(10, 10, 518, 660);

                cmbRol.setEnabled(false);
                cmbFechaInicio.setEnabled(false);
                cmbEstado.setEnabled(false);
                jMenuBar1.setVisible(true);
                btnReestablecerContrasena.setVisible(true);
                txtNomUsuario.setEnabled(false);
                btnComprobar.setEnabled(false);

                if ((cmbEstado.getSelectedItem().toString()).compareTo("Activo")==0) {
                    jMReactivar.setEnabled(false);
                    jMReactivar.setVisible(false);
                } //else {
//                    jMSuspender.setEnabled(false);
//                    jMSuspender.setVisible(false);
                //}

            } else {
                usuarioBE=new UsuarioBE();// esta linea esta demas ya que el query tiene nextval
                int idUsuariosiguiente = usuarioBL.getIdUsuarioSiguiente();
                this.setBounds(10, 10, 518, 660);
                txtCodigo.setText(String.valueOf(idUsuariosiguiente));
                usuarioBE.setIdUsuario(idUsuariosiguiente);// esta linea esta demas ya que el query tiene nextval
                btnReestablecerContrasena.setText("Generar");
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JDAgregarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(JDAgregarUsuario.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel1 = new javax.swing.JPanel();
        txtCodigo = new javax.swing.JTextField();
        txtNombres = new javax.swing.JTextField();
        txtApPat = new javax.swing.JTextField();
        txtApMat = new javax.swing.JTextField();
        txtNomUsuario = new javax.swing.JTextField();
        txtCorreoE = new javax.swing.JTextField();
        cmbRol = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnVerCategorias = new javax.swing.JButton();
        jPContrasena = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        lblCantidadCategorias = new javax.swing.JLabel();
        btnReestablecerContrasena = new javax.swing.JButton();
        btnComprobar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        cmbEstado = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMReactivar = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agregar Usuario");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Usuario"));

        txtNombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombresKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombresKeyReleased(evt);
            }
        });

        txtApPat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtApPatKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtApPatKeyReleased(evt);
            }
        });

        txtApMat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtApMatKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtApMatKeyReleased(evt);
            }
        });

        txtNomUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNomUsuarioKeyPressed(evt);
            }
        });

        jLabel1.setText("Codigo");

        jLabel2.setText("Apellido Materno");

        jLabel3.setText("Nombre Usuario");

        jLabel4.setText("Contrasena");

        jLabel5.setText("Rol");

        jLabel6.setText("Area Academica");

        jLabel7.setText("Correo Electronico");

        jLabel8.setText("Nombres");

        jLabel9.setText("Apellido Paterno");

        btnVerCategorias.setFont(new java.awt.Font("DejaVu Sans", 0, 10)); // NOI18N
        btnVerCategorias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/buscar.png"))); // NOI18N
        btnVerCategorias.setText("Ver Lista");
        btnVerCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerCategoriasActionPerformed(evt);
            }
        });

        jPContrasena.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPContrasena.setPreferredSize(new java.awt.Dimension(251, 29));

        javax.swing.GroupLayout jPContrasenaLayout = new javax.swing.GroupLayout(jPContrasena);
        jPContrasena.setLayout(jPContrasenaLayout);
        jPContrasenaLayout.setHorizontalGroup(
            jPContrasenaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 116, Short.MAX_VALUE)
        );
        jPContrasenaLayout.setVerticalGroup(
            jPContrasenaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        jLabel13.setText("Total asignadas:");

        lblCantidadCategorias.setText("0");

        btnReestablecerContrasena.setFont(new java.awt.Font("DejaVu Sans", 0, 10)); // NOI18N
        btnReestablecerContrasena.setText("Reestablecer");
        btnReestablecerContrasena.setPreferredSize(new java.awt.Dimension(79, 32));
        btnReestablecerContrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReestablecerContrasenaActionPerformed(evt);
            }
        });

        btnComprobar.setFont(new java.awt.Font("DejaVu Sans", 0, 10)); // NOI18N
        btnComprobar.setText("Comprobar");
        btnComprobar.setPreferredSize(new java.awt.Dimension(70, 32));
        btnComprobar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprobarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(57, 57, 57)
                            .addComponent(jLabel13)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(lblCantidadCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnVerCategorias))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7))
                            .addGap(51, 51, 51)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txtNomUsuario)
                                                .addComponent(jPContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(btnComprobar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(btnReestablecerContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(txtCodigo)
                                        .addComponent(txtNombres, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtApPat, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtApMat, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cmbRol, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1, Short.MAX_VALUE))
                                .addComponent(txtCorreoE, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)))))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtApPat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtApMat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(btnComprobar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jPContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReestablecerContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel13)
                    .addComponent(lblCantidadCategorias)
                    .addComponent(btnVerCategorias))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCorreoE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Estado Usuario"));

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setPreferredSize(new java.awt.Dimension(169, 29));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 212, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setPreferredSize(new java.awt.Dimension(142, 29));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 212, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        cmbEstado.setEnabled(false);

        jLabel10.setText("Fecha Inicio");

        jLabel11.setText("Fecha Fin");

        jLabel12.setText("Estado");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addGap(95, 95, 95)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12)))
                .addContainerGap())
        );

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/aceptar.png"))); // NOI18N
        btnGuardar.setText("Aceptar");
        btnGuardar.setAlignmentY(0.0F);
        btnGuardar.setPreferredSize(new java.awt.Dimension(135, 35));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cancelar.png"))); // NOI18N
        btnSalir.setText("Cancelar");
        btnSalir.setAlignmentY(0.0F);
        btnSalir.setPreferredSize(new java.awt.Dimension(135, 35));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/limpiar.png"))); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.setAlignmentY(0.0F);
        btnLimpiar.setPreferredSize(new java.awt.Dimension(135, 35));
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        jMReactivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/good.png"))); // NOI18N
        jMReactivar.setText("Reactivar");
        jMReactivar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jMReactivarMouseReleased(evt);
            }
        });
        jMReactivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMReactivarActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMReactivar);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(169, 169, 169))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        this.Guardar();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void Guardar(){
         //        String estado, RolBE idRol, ArrayList<CategoriaBE> categorias,TipoCeseBE idTipoCese
        UsuarioBL usuarioBL=new UsuarioBL();

        boolean r = false;

        String cadExito="";

        Date fechaI=new Date();
        Date fechaF=new Date();
        Date fechaC=null;

        SimpleDateFormat formato=new SimpleDateFormat("yyyy-MM-dd");
        String cadenaFechaI=formato.format(cmbFechaInicio.getDate());
        String cadenaFechaF=formato.format(cmbFechaFin.getDate());
        try {
            fechaI = formato.parse(cadenaFechaI);
            fechaF = formato.parse(cadenaFechaF);
        } catch (ParseException ex) {
            Logger.getLogger(JDAgregarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }

        EstadoBE estadoBE=(EstadoBE)cmbEstado.getSelectedItem();
        RolBE rolBE=(RolBE)cmbRol.getSelectedItem();

        int idTipoCese=0;
        int idUsuario=Integer.parseInt(txtCodigo.getText().trim());

        TipoCeseBE tipoCeseBE = new TipoCeseBE();
        tipoCeseBE.setIdTipoCEse(idTipoCese);

        String contrasena="";
        int a=jPFContrasena.getPassword().length;
        for(int i=0;i<a;i++){
             contrasena+=jPFContrasena.getPassword()[i];
        }

        if((usuarioBEOringinal!=null)&&(usuarioBEOringinal.getEstadoBE().getNombre().compareTo("Inactivo")==0)){
             String cadenaFechaActual=formato.format(new Date(System.currentTimeMillis()));
            if(cadenaFechaF.compareTo(cadenaFechaActual)<=0){
                JOptionPane.showMessageDialog(this,"Debe ingresar una fecha mayor a la fecha actual para reactivar la cuenta del usuario.","ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        usuarioBE = usuarioBL.FormarUsuarioBE(idUsuario,txtNombres.getText(),
                                          txtApPat.getText(),txtApMat.getText(),
                                          txtNomUsuario.getText(),contrasena,
                                          fechaI,fechaF,
                                          fechaC,estadoBE,rolBE,
                                          listaCategorias,tipoCeseBE,txtCorreoE.getText());

        String cad="";
        cad=usuarioBL.getCadenaError();
        if(usuarioBE!=null){
            if(usuarioBEOringinal!=null){
                r=usuarioBL.actualizarUsuario(usuarioBE, usuarioBEOringinal);
                cadExito="Usuario actualizado con exito";
            }
            else{
                int nombreUsuarioDisponible=usuarioBL.AutenticarUsuario(txtNomUsuario.getText(), "","");
                if (nombreUsuarioDisponible!=0){
                          cad+="Nombre de usuario ya existe.\n";
                }
                else{
                    r=usuarioBL.guardarUsuario(usuarioBE);
                    cadExito="Usuario registrado con exito";
                }
            }
        }



        if (r==false){
            if(usuarioBEOringinal==null){
                int nombreUsuarioDisponible=usuarioBL.AutenticarUsuario(txtNomUsuario.getText(), "","");
                if (nombreUsuarioDisponible!=0){
                          cad+="Nombre de usuario ya existe.\n";
                }
            }
            JOptionPane.showMessageDialog(this,cad, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        else {
            EnviarCorreo enviar=new EnviarCorreo(usuarioBE, 4);
            JOptionPane.showMessageDialog(this, cadExito);
            this.dispose();
        }

    }

    private void txtNombresKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombresKeyReleased
            Character caracter = new Character(evt.getKeyChar());

        if (!Utilitario.esLetra(caracter)) {
                    String texto = "";
                    for (int i = 0; i < this.txtNombres.getText().length(); i++)
                        if (Utilitario.esLetra(new Character(this.txtNombres.getText().charAt(i))))
                            texto += this.txtNombres.getText().charAt(i);
                    this.txtNombres.setText(texto);
            this.txtNombres.getToolkit().beep();
        }
    }//GEN-LAST:event_txtNombresKeyReleased

    private void btnVerCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerCategoriasActionPerformed

        ArrayList<CategoriaBE> listaCat=new ArrayList<CategoriaBE>();
        for(int i=0;i<listaCategorias.size();i++){
            listaCat.add(listaCategorias.get(i));
        }
        JDCategoriaXUsuario jfCategoriaXUsuario=new JDCategoriaXUsuario(Integer.parseInt(txtCodigo.getText()),listaCat);
        jfCategoriaXUsuario.setModal(true);
        jfCategoriaXUsuario.setLocationRelativeTo(this);
        jfCategoriaXUsuario.setVisible(true);
        listaCategorias=jfCategoriaXUsuario.getListaCategorias();
        lblCantidadCategorias.setText(String.valueOf(listaCategorias.size()));

    }//GEN-LAST:event_btnVerCategoriasActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void txtNomUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomUsuarioKeyPressed
       String text = txtNomUsuario.getText();
        int maxLength=15;
        if (text.length() > maxLength) {
            text = text.substring(0, maxLength);
            txtNomUsuario.setText(text);
        }
    }//GEN-LAST:event_txtNomUsuarioKeyPressed

    private void btnReestablecerContrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReestablecerContrasenaActionPerformed
        
      if(btnReestablecerContrasena.getText().compareTo("Reestablecer")==0){
            JDNuevaContrasena jdNuevaContrasena = new JDNuevaContrasena(String.valueOf(jPFContrasena.getPassword()));
            jdNuevaContrasena.setModal(true);
            jdNuevaContrasena.setLocationRelativeTo(this);
            jdNuevaContrasena.setVisible(true);
            //String contrasenaNueva=jdNuevaContrasena.getContrasenaNueva;
            if(jdNuevaContrasena.getContrasenaNueva()!=null){
                    jPFContrasena.setText(jdNuevaContrasena.getContrasenaNueva());
                    jdNuevaContrasena.dispose();
                    usuarioBEOringinal.setPassword(jdNuevaContrasena.getContrasenaNueva());
                    usuarioBL.actualizarContrasena(usuarioBEOringinal);
                    EnviarCorreo enviar=new EnviarCorreo(usuarioBEOringinal,3);
            }


        }
        else if(btnReestablecerContrasena.getText().compareTo("Generar")==0){


                    String caracteres="abcdefghijklmnoprstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
                    String contrasena="";
                    char c=' ';
                    char opcion='0';
                    for(int i=0;i<10;i++){
                        c = caracteres.charAt((int)(Math.random()*61));

                         contrasena+=c;
                    }

                    this.jPFContrasena.setText(contrasena);
                    //JOptionPane.showMessageDialog(this, contrasena);


        }

    }//GEN-LAST:event_btnReestablecerContrasenaActionPerformed

    private void btnComprobarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprobarActionPerformed

               if(txtNomUsuario.getText().compareTo("")!=0){
            int rpta=usuarioBL.AutenticarUsuario(txtNomUsuario.getText(), "","");
            if (rpta!=0){
                txtNomUsuario.setText("");
                JOptionPane.showMessageDialog(this, "Nombre de usuario ya registrado","Advertencia", JOptionPane.INFORMATION_MESSAGE);
            }
            else {
                JOptionPane.showMessageDialog(this, "Nombre de usuario disponible","Informacion", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else {
                JOptionPane.showMessageDialog(this, "Debe ingresar un nombre de usuario.","Advertencia", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_btnComprobarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed

        if(JOptionPane.showConfirmDialog(this, "Esta seguro que desea \"Limpiar Campos\"", "Advertencia", JOptionPane.YES_OPTION)==0){

            txtNombres.setText("");
            txtApPat.setText("");
            txtApMat.setText("");
            txtCorreoE.setText("");
            listaCategorias.clear();
            lblCantidadCategorias.setText(String.valueOf(listaCategorias.size()));

            if (usuarioBEOringinal==null){
                txtNomUsuario.setText("");
                jPFContrasena.setText("");
                cmbRol.setSelectedIndex(0);
                cmbFechaInicio.setDate(new Date(System.currentTimeMillis()));
                cmbFechaFin.setDate(new Date(System.currentTimeMillis()));
            }

        }
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void jMReactivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMReactivarActionPerformed
        Reactivar();
    }//GEN-LAST:event_jMReactivarActionPerformed

    public void Reactivar(){
        JOptionPane.showMessageDialog(this,"Ingrese una nueva fecha de caducidad de la cuenta de usuario.", "Reactivar Usuario", JOptionPane.INFORMATION_MESSAGE);
        cmbFechaFin.setEnabled(true);
        btnGuardar.setVisible(true);
        btnGuardar.setEnabled(true);
        for(int i=0;i<cmbEstado.getModel().getSize();i++){
                if (cmbEstado.getItemAt(i).toString().compareTo("Activo")==0){
                        cmbEstado.setSelectedIndex(i);
                }
        }
    }

    private void jMReactivarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMReactivarMouseReleased
        Reactivar();
    }//GEN-LAST:event_jMReactivarMouseReleased

    private void txtApPatKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApPatKeyReleased
         Character caracter = new Character(evt.getKeyChar());
        if (!Utilitario.esLetra(caracter)) {
                    String texto = "";
                    for (int i = 0; i < this.txtApPat.getText().length(); i++)
                        if (Utilitario.esLetra(new Character(this.txtApPat.getText().charAt(i))))
                            texto += this.txtApPat.getText().charAt(i);
                    this.txtApPat.setText(texto);
            this.txtApPat.getToolkit().beep();
        }


    }//GEN-LAST:event_txtApPatKeyReleased

    private void txtApMatKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApMatKeyReleased
        Character caracter = new Character(evt.getKeyChar());
        if (!Utilitario.esLetra(caracter)) {
                    String texto = "";
                    for (int i = 0; i < this.txtApMat.getText().length(); i++)
                        if (Utilitario.esLetra(new Character(this.txtApMat.getText().charAt(i))))
                            texto += this.txtApMat.getText().charAt(i);
                    this.txtApMat.setText(texto);
            this.txtApMat.getToolkit().beep();
        }

    }//GEN-LAST:event_txtApMatKeyReleased

    private void txtApPatKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApPatKeyPressed
        String text = txtNomUsuario.getText();
        int maxLength=25;
        if (text.length() > maxLength) {
            text = text.substring(0, maxLength);
            txtNomUsuario.setText(text);
        }
    }//GEN-LAST:event_txtApPatKeyPressed

    private void txtApMatKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApMatKeyPressed
        String text = txtNomUsuario.getText();
        int maxLength=30;
        if (text.length() > maxLength) {
            text = text.substring(0, maxLength);
            txtNomUsuario.setText(text);
        }
    }//GEN-LAST:event_txtApMatKeyPressed

    private void txtNombresKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombresKeyPressed
        String text = txtNomUsuario.getText();
        int maxLength=30;
        if (text.length() > maxLength) {
            text = text.substring(0, maxLength);
            txtNomUsuario.setText(text);
        }
    }//GEN-LAST:event_txtNombresKeyPressed

    public void MostrarDatos(UsuarioBE usuarioBEO){
        
        txtCodigo.setText(String.valueOf(usuarioBEO.getIdUsuario()));
        txtNombres.setText(usuarioBEO.getNombres());
        txtApPat.setText(usuarioBEO.getApellidoPaterno());
        txtApMat.setText(usuarioBEO.getApellidoMaterno());
        txtNomUsuario.setText(usuarioBEO.getNombreUsuario());
        jPFContrasena.setText(usuarioBEO.getPassword());

        for(int i=0;i<cmbEstado.getModel().getSize();i++){
            if (usuarioBEO.getEstadoBE().getNombre().compareTo(cmbEstado.getItemAt(i).toString())==0){
                    cmbEstado.setSelectedIndex(i);
            }
        }

        for(int i=0;i<cmbRol.getModel().getSize();i++){
            if (usuarioBEO.getRolBE().getNombre().compareTo(cmbRol.getItemAt(i).toString())==0){
                    cmbRol.setSelectedIndex(i);
            }
        }

        cmbFechaInicio.setDate(usuarioBEO.getFechaRegistro());
        cmbFechaFin.setDate(usuarioBEO.getFechaVencimiento());
        txtCorreoE.setText(usuarioBEO.getEmail());

        lblCantidadCategorias.setText(String.valueOf(listaCategorias.size()));

        if ((usuarioBEO.getEstadoBE().getNombre().compareTo("Inactivo")==0)||(usuarioBEO.getEstadoBE().getNombre().compareTo("Desactivo")==0)){
            txtCodigo.setEnabled(false);
            txtNombres.setEnabled(false);
            txtApPat.setEnabled(false);
            txtApMat.setEnabled(false);
            txtNomUsuario.setEnabled(false);
            jPFContrasena.setEnabled(false);
            cmbEstado.setEnabled(false);
            cmbRol.setEnabled(false);
            cmbFechaInicio.setEnabled(false);
            cmbFechaFin.setEnabled(false);
            txtCorreoE.setEnabled(false);
            btnComprobar.setEnabled(false);
            btnReestablecerContrasena.setEnabled(false);
            btnVerCategorias.setEnabled(false);
            btnGuardar.setVisible(false);
            btnLimpiar.setVisible(false);
            lblCantidadCategorias.setEnabled(false);

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
    /**
    * @param args the command line arguments
    */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnComprobar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnReestablecerContrasena;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnVerCategorias;
    private javax.swing.JComboBox cmbEstado;
    private javax.swing.JComboBox cmbRol;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMReactivar;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPContrasena;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblCantidadCategorias;
    private javax.swing.JTextField txtApMat;
    private javax.swing.JTextField txtApPat;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCorreoE;
    private javax.swing.JTextField txtNomUsuario;
    private javax.swing.JTextField txtNombres;
    // End of variables declaration//GEN-END:variables

}
