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

    private static ArrayList<CategoriaBE> listaCategorias=null;

    private JPasswordField jPFContrasena;
    
    /** Creates new form JFAgregarUsuario1 */
    public JDAgregarUsuario(int idUsuario) {
        try {

            initComponents();
            listaCategorias=new ArrayList<CategoriaBE>();
            jTFCodigo.setEnabled(false);
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
                jCBRol.addItem(new RolBE(registros.getInt("idRol"), registros.getString("nombre"), registros.getString("estado")));
            }
            rolBL.CerrarConexion();


            ArrayList<EstadoBE> registrosEstado = estadoBL.ObtenerEstados(0,"","");
            if (registrosEstado != null) {
                //System.out.println(registrosEstado.size());
                int numeroRegistros = registrosEstado.size();
                for (int i = 0; i <= numeroRegistros - 1; i++) {
                    jCBEstado.addItem(registrosEstado.get(i));
                }
            }

            if (idUsuario >= 1) {
                usuarioBEOringinal=usuarioBL.getUsuarioBE(idUsuario);
                listaCategorias=usuarioBEOringinal.getCategorias();

                MostrarDatos(usuarioBEOringinal);
                this.setTitle("Modificar Usuario");
                this.setBounds(10, 10, 497, 640);

                jCBRol.setEnabled(false);
                cmbFechaInicio.setEnabled(false);
                jCBEstado.setEnabled(false);
                jMenuBar1.setVisible(true);
                jBReestablecerContrasena.setVisible(true);
                jTFNomUsuario.setEnabled(false);
                jBComprobar.setEnabled(false);

                if ((jCBEstado.getSelectedItem().toString()).compareTo("Activo")==0) {
                    jMenu1.setEnabled(false);
                    jMenu1.setVisible(false);
                } else {
                    jMenu2.setEnabled(false);
                    jMenu2.setVisible(false);
                }

            } else {
                usuarioBE=new UsuarioBE();// esta linea esta demas ya que el query tiene nextval
                int idUsuariosiguiente = usuarioBL.getIdUsuarioSiguiente();
                this.setBounds(10, 10, 497, 640);
                jTFCodigo.setText(String.valueOf(idUsuariosiguiente));
                usuarioBE.setIdUsuario(idUsuariosiguiente);// esta linea esta demas ya que el query tiene nextval
                jBReestablecerContrasena.setText("Generar");
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
        jTFCodigo = new javax.swing.JTextField();
        jTFNombres = new javax.swing.JTextField();
        jTFApPat = new javax.swing.JTextField();
        jTFApMat = new javax.swing.JTextField();
        jTFNomUsuario = new javax.swing.JTextField();
        jTFCorreoE = new javax.swing.JTextField();
        jCBRol = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jBVer = new javax.swing.JButton();
        jPContrasena = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jBReestablecerContrasena = new javax.swing.JButton();
        jBComprobar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jCBEstado = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jBGuardar = new javax.swing.JButton();
        jBSalir = new javax.swing.JButton();
        jBLimpiar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agregar Usuario");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Usuario"));

        jTFNombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFNombresKeyReleased(evt);
            }
        });

        jTFNomUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTFNomUsuarioKeyPressed(evt);
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

        jBVer.setFont(new java.awt.Font("DejaVu Sans", 0, 10)); // NOI18N
        jBVer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/buscar.png"))); // NOI18N
        jBVer.setText("Ver Lista");
        jBVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBVerActionPerformed(evt);
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

        jLabel14.setText("0");

        jBReestablecerContrasena.setFont(new java.awt.Font("DejaVu Sans", 0, 10)); // NOI18N
        jBReestablecerContrasena.setText("Reestablecer");
        jBReestablecerContrasena.setPreferredSize(new java.awt.Dimension(79, 32));
        jBReestablecerContrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBReestablecerContrasenaActionPerformed(evt);
            }
        });

        jBComprobar.setFont(new java.awt.Font("DejaVu Sans", 0, 10)); // NOI18N
        jBComprobar.setText("Comprobar");
        jBComprobar.setPreferredSize(new java.awt.Dimension(70, 32));
        jBComprobar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBComprobarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(57, 57, 57)
                            .addComponent(jLabel13)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBVer))
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
                                                .addComponent(jTFNomUsuario)
                                                .addComponent(jPContrasena, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jBComprobar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jBReestablecerContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(jTFCodigo)
                                        .addComponent(jTFNombres, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTFApPat, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTFApMat, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jCBRol, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1, Short.MAX_VALUE))
                                .addComponent(jTFCorreoE, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)))))
                .addGap(38, 38, 38))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTFNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFApPat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFApMat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFNomUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jBComprobar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jPContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBReestablecerContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jBVer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFCorreoE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap())
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

        jLabel10.setText("Fecha Inicio");

        jLabel11.setText("Fecha Fin");

        jLabel12.setText("Estado");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addGap(95, 95, 95)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE))
                    .addComponent(jCBEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCBEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12)))
                .addContainerGap())
        );

        jBGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/guardar.png"))); // NOI18N
        jBGuardar.setText("Guardar");
        jBGuardar.setAlignmentY(0.0F);
        jBGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGuardarActionPerformed(evt);
            }
        });

        jBSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/salir.png"))); // NOI18N
        jBSalir.setText("Salir");
        jBSalir.setAlignmentY(0.0F);
        jBSalir.setPreferredSize(new java.awt.Dimension(83, 33));
        jBSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalirActionPerformed(evt);
            }
        });

        jBLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/limpiar.png"))); // NOI18N
        jBLimpiar.setText("Limpiar");
        jBLimpiar.setAlignmentY(0.0F);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/aceptar.png"))); // NOI18N
        jMenu1.setText("Reactivar");
        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Eliminar - 16.png"))); // NOI18N
        jMenu2.setText("Suspender");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(jBGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBLimpiar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(jBGuardar)
                    .addComponent(jBSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBLimpiar))
                .addGap(169, 169, 169))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGuardarActionPerformed
        this.Guardar();
    }//GEN-LAST:event_jBGuardarActionPerformed

    private void Guardar(){
         //        String estado, RolBE idRol, ArrayList<CategoriaBE> categorias,TipoCeseBE idTipoCese
        UsuarioBL usuarioBL=new UsuarioBL();

        boolean r = false;

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

        EstadoBE estadoBE=(EstadoBE)jCBEstado.getSelectedItem();
        RolBE rolBE=(RolBE)jCBRol.getSelectedItem();

        int idTipoCese=0;
        int idUsuario=Integer.parseInt(jTFCodigo.getText().trim());

        TipoCeseBE tipoCeseBE = new TipoCeseBE();
        tipoCeseBE.setIdTipoCEse(idTipoCese);

        String contrasena="";
        int a=jPFContrasena.getPassword().length;
        for(int i=0;i<a;i++){
             contrasena+=jPFContrasena.getPassword()[i];
        }

        usuarioBE = usuarioBL.FormarUsuarioBE(idUsuario,jTFNombres.getText(),
                                          jTFApPat.getText(),jTFApMat.getText(),
                                          jTFNomUsuario.getText(),contrasena,
                                          fechaI,fechaF,
                                          fechaC,estadoBE,rolBE,
                                          listaCategorias,tipoCeseBE,jTFCorreoE.getText());

        if(usuarioBE!=null){
            if(usuarioBEOringinal!=null){
                r=usuarioBL.actualizarUsuario(usuarioBE, usuarioBEOringinal);
            }
            else{
                r=usuarioBL.guardarUsuario(usuarioBE);
            }
        }

        if (r==false){
            String cad="";
            cad=usuarioBL.getCadenaError();
            if(usuarioBEOringinal==null){
                int nombreUsuarioDisponible=usuarioBL.AutenticarUsuario(jTFNomUsuario.getText(), "","");
                if (nombreUsuarioDisponible!=0){
                      cad+="Nombre de usuario ya existe.\n";
                }
            }
            JOptionPane.showMessageDialog(this,cad, "Mensaje derror", JOptionPane.ERROR_MESSAGE);
        }
        else {
            EnviarCorreo enviar=new EnviarCorreo(usuarioBE, 4);
            JOptionPane.showMessageDialog(this, "Usuario registrado con exito");
            this.dispose();
        }

    }

    private void jTFNombresKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFNombresKeyReleased
            Character caracter = new Character(evt.getKeyChar());

        if (!Utilitario.esLetra(caracter)) {
                    String texto = "";
                    for (int i = 0; i < this.jTFNombres.getText().length(); i++)
                        if (Utilitario.esLetra(new Character(this.jTFNombres.getText().charAt(i))))
                            texto += this.jTFNombres.getText().charAt(i);
                    this.jTFNombres.setText(texto);
            this.jTFNombres.getToolkit().beep();
        }
    }//GEN-LAST:event_jTFNombresKeyReleased

    private void jBVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBVerActionPerformed

        ArrayList<CategoriaBE> listaCat=new ArrayList<CategoriaBE>();
        for(int i=0;i<listaCategorias.size();i++){
            listaCat.add(listaCategorias.get(i));
        }
        JDCategoriaXUsuario jfCategoriaXUsuario=new JDCategoriaXUsuario(Integer.parseInt(jTFCodigo.getText()),listaCat);
        jfCategoriaXUsuario.setModal(true);
        jfCategoriaXUsuario.setLocationRelativeTo(this);
        jfCategoriaXUsuario.setVisible(true);

 //       System.out.println("UUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUU");
//        AntiPlagiumPrincipal.getJDesktopPane().add(jfCategoriaXUsuario);
//        jfCategoriaXUsuario.toFront();

    }//GEN-LAST:event_jBVerActionPerformed


    public static void ActualizarListaCategorias(ArrayList<CategoriaBE> listaCategoriasAct){

        listaCategorias=listaCategoriasAct;

    }

    private void jBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBSalirActionPerformed

    private void jTFNomUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFNomUsuarioKeyPressed
       String text = jTFNomUsuario.getText();
        int maxLength=15;
        if (text.length() > maxLength) {
            text = text.substring(0, maxLength);
            jTFNomUsuario.setText(text);
        }
    }//GEN-LAST:event_jTFNomUsuarioKeyPressed

    private void jBReestablecerContrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBReestablecerContrasenaActionPerformed
        
      if(jBReestablecerContrasena.getText().compareTo("Reestablecer")==0){
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
        else if(jBReestablecerContrasena.getText().compareTo("Generar")==0){

//                    String alfabetoM="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//                    String alfabetom="abcdefghijklmnoprstuvwxyz";
//                    String numeros="0123456789";
                    String caracteres="abcdefghijklmnoprstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
                    String contrasena="";
                    char c=' ';
                    char opcion='0';
                    for(int i=0;i<10;i++){
                        c = caracteres.charAt((int)(Math.random()*61));
//                         opcion = numeros.charAt((int) Math.random() * 3);
//                         if (opcion=='0'){
//                            c = alfabetoM.charAt((int)(Math.random()*26));
//                         }
//                         else if (opcion=='1'){
//                            c = numeros.charAt((int)(Math.random()*10));
//                         }
//                         else if (opcion=='2'){
//                            c = alfabetom.charAt((int)(Math.random()*26));
//                         }
                         contrasena+=c;
                    }

                    this.jPFContrasena.setText(contrasena);
                    //JOptionPane.showMessageDialog(this, contrasena);


        }

    }//GEN-LAST:event_jBReestablecerContrasenaActionPerformed

    private void jBComprobarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBComprobarActionPerformed

               if(jTFNomUsuario.getText().compareTo("")!=0){
            int rpta=usuarioBL.AutenticarUsuario(jTFNomUsuario.getText(), "","");
            if (rpta!=0){
                jTFNomUsuario.setText("");
                JOptionPane.showMessageDialog(this, "Nombre de usuario ya registrado","Advertencia", JOptionPane.INFORMATION_MESSAGE);
            }
            else {
                JOptionPane.showMessageDialog(this, "Nombre de usuario disponible","Informacion", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else {
                JOptionPane.showMessageDialog(this, "Debe ingresar un nombre de usuario.","Advertencia", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_jBComprobarActionPerformed

    public void MostrarDatos(UsuarioBE usuarioBE){
    jTFCodigo.setText(String.valueOf(usuarioBE.getIdUsuario()));
        jTFNombres.setText(usuarioBE.getNombres());
        jTFApPat.setText(usuarioBE.getApellidoPaterno());
        jTFApMat.setText(usuarioBE.getApellidoMaterno());
        jTFNomUsuario.setText(usuarioBE.getNombreUsuario());
        jPFContrasena.setText(usuarioBE.getPassword());


        for(int i=0;i<jCBEstado.getModel().getSize();i++){
            if (usuarioBE.getEstadoBE().getNombre().compareTo(jCBEstado.getItemAt(i).toString())==0){
                    jCBEstado.setSelectedIndex(i);
            }

        }
         for(int i=0;i<jCBRol.getModel().getSize();i++){
            if (usuarioBE.getRolBE().getNombre().compareTo(jCBRol.getItemAt(i).toString())==0){
                    jCBRol.setSelectedIndex(i);
            }

        }

//        jCBRol.setSelectedItem(usuarioBE.getRolBE());
//
//
//        jCBEstado.setSelectedItem(usuarioBE.getEstadoBE());
//

        cmbFechaInicio.setDate(usuarioBE.getFechaRegistro());
        cmbFechaFin.setDate(usuarioBE.getFechaVencimiento());
        jTFCorreoE.setText(usuarioBE.getEmail());
    }


    /**
    * @param args the command line arguments
    */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBComprobar;
    private javax.swing.JButton jBGuardar;
    private javax.swing.JButton jBLimpiar;
    private javax.swing.JButton jBReestablecerContrasena;
    private javax.swing.JButton jBSalir;
    private javax.swing.JButton jBVer;
    private javax.swing.JComboBox jCBEstado;
    private javax.swing.JComboBox jCBRol;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPContrasena;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField jTFApMat;
    private javax.swing.JTextField jTFApPat;
    private javax.swing.JTextField jTFCodigo;
    private javax.swing.JTextField jTFCorreoE;
    private javax.swing.JTextField jTFNomUsuario;
    private javax.swing.JTextField jTFNombres;
    // End of variables declaration//GEN-END:variables

}
