/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JFInicioSesion.java
 *
 * Created on 23/05/2010, 09:22:54 PM
 */

package antiplagium.view;

import Utilitarios.EnviarCorreo;

import antiplagium.BE.GestorError;
import antiplagium.BE.GestorTiposOperacion;

import antiplagium.BE.UsuarioBE;
import antiplagium.BL.RegistroOperacionBL;
import antiplagium.BL.UsuarioBL;
import antiplagium.DAL.ConexionJDBC;
import java.awt.Color;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;


public class JFInicioSesion extends javax.swing.JFrame {
    private UsuarioBL usuarioBL;
    private int autenticoUsuario;
    private JPasswordField jPFContrasena;
    private UsuarioBE usuarioBE;    

 
    public JFInicioSesion() {
        initComponents();
        jPError.setVisible(false);
        jPFContrasena=new JPasswordField();
        jPFContrasena.setSize(176, 26);
        jPContrasena.add(jPFContrasena);

        try
        {
            //GestorError.populate("XML/Errores.xml");
            //GestorTiposOperacion.populate("src/XML/TiposOperaciones.xml");
        }
        catch (Exception e)
        {
            JOptionPane.showConfirmDialog(null, e.getMessage(), "Error", JOptionPane.DEFAULT_OPTION);
            //JOptionPane.showConfirmDialog(null, "El programa no se pudo iniciar", "Error", JOptionPane.DEFAULT_OPTION);
            return;
        }

    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPError = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombreUsuario = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPContrasena = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Iniciar Sesion");
        setName("jfInicioSesion"); // NOI18N
        setResizable(false);

        jLabel4.setFont(new java.awt.Font("DejaVu Sans", 1, 10));
        jLabel4.setForeground(new java.awt.Color(244, 15, 15));
        jLabel4.setText("El nombre de usuario o la contraseña son incorrectas.");
        jLabel4.setAlignmentY(0.0F);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/icon_err.gif"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("DejaVu Sans", 1, 10));
        jLabel5.setForeground(new java.awt.Color(244, 15, 15));
        jLabel5.setText("Inténtelo de nuevo.");
        jLabel5.setAlignmentY(0.0F);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(38, 38, 38))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPErrorLayout = new javax.swing.GroupLayout(jPError);
        jPError.setLayout(jPErrorLayout);
        jPErrorLayout.setHorizontalGroup(
            jPErrorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPErrorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPErrorLayout.setVerticalGroup(
            jPErrorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
        );

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setAlignmentX(0.0F);
        jPanel1.setAlignmentY(0.0F);

        jLabel1.setText("Nombre de usuario:");

        jLabel2.setText("Contraseña:");

        txtNombreUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreUsuarioActionPerformed(evt);
            }
        });

        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/aceptar.png"))); // NOI18N
        btnAceptar.setText("Acceder");
        btnAceptar.setPreferredSize(new java.awt.Dimension(135, 35));
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        btnAceptar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btnAceptarKeyReleased(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cancelar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setPreferredSize(new java.awt.Dimension(135, 35));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("DejaVu Sans", 1, 10));
        jLabel3.setText("¿No puede acceder a su cuenta?");
        jLabel3.setToolTipText("");
        jLabel3.setName("JLContrasena"); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel3MouseEntered(evt);
            }
        });

        jPContrasena.setPreferredSize(new java.awt.Dimension(100, 14));

        javax.swing.GroupLayout jPContrasenaLayout = new javax.swing.GroupLayout(jPContrasena);
        jPContrasena.setLayout(jPContrasenaLayout);
        jPContrasenaLayout.setHorizontalGroup(
            jPContrasenaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 176, Short.MAX_VALUE)
        );
        jPContrasenaLayout.setVerticalGroup(
            jPContrasenaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 26, Short.MAX_VALUE)
        );

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Parents20.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(94, 94, 94)
                        .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel3)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPError, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPError, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreUsuarioActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_txtNombreUsuarioActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        this.IniciarSesion();
            
}//GEN-LAST:event_btnAceptarActionPerformed

    private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseEntered

        jLabel3.setForeground(Color.BLUE);
}//GEN-LAST:event_jLabel3MouseEntered

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAceptarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAceptarKeyReleased
        this.IniciarSesion();
    }//GEN-LAST:event_btnAceptarKeyReleased

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        JDRecuperarUsuarioContrasena jDResstablecerContrasena=new JDRecuperarUsuarioContrasena();
        jDResstablecerContrasena.setModal(true);
        jDResstablecerContrasena.setLocationRelativeTo(this);
        jDResstablecerContrasena.setVisible(true);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void IniciarSesion(){
        usuarioBL=new UsuarioBL();
        String nombreUsuario="";
        String contrasena="";
        String correoE="";        

        nombreUsuario=txtNombreUsuario.getText();

        int a=jPFContrasena.getPassword().length;
        for(int i=0;i<a;i++){
          contrasena+=jPFContrasena.getPassword()[i];
         //System.out.println(jPFContrasena.getPassword()[i]);
        }

        autenticoUsuario=usuarioBL.AutenticarUsuario(nombreUsuario,contrasena,correoE);

        if (autenticoUsuario>0) {
              //EnviarCorreo env=new EnviarCorreo("delpiero2906");
              usuarioBE=usuarioBL.getUsuarioBE(autenticoUsuario);
              if(usuarioBE.getEstadoBE().getNombre().compareTo("Inactivo")!=0){
                  this.setVisible(false);
                  AntiPlagiumPrincipal principal = new AntiPlagiumPrincipal(usuarioBE);
                  principal.setLocationRelativeTo(null);
                  principal.setVisible(true);
                  this.dispose();
              }
              else{
                JOptionPane.showMessageDialog(this,"USUARIO INACTIVO", "ERROR", JOptionPane.ERROR_MESSAGE);
              
              }

        try
        {
            RegistroOperacionBL op = new RegistroOperacionBL();
            op.AbrirConexion();
            String descripcionOperacion = descripcionOperacion();
            JFBase.setOperacion(this.getName(), GestorTiposOperacion.getTipoOperacion("ingreso"), descripcionOperacion);
            JFBase.registrarOperacion();
            op.CerrarConexion();
        }
        catch (ClassNotFoundException ex)
        {
            JOptionPane.showMessageDialog(this, ex.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        catch (SQLException excepcionSQL)
        {
            JOptionPane.showMessageDialog(this, excepcionSQL.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
             
        }
        else{
            jPError.setVisible(true);
        }
    }

    private String descripcionOperacion()
    {
          return "Inicio de sesión";
//        "Usuarigutio: " + AntiPlagiumPrincipal.usuarioBE.getNombreUsuario() + "\n" +
//        "Fecha:   " + AntiPlagiumPrincipal.operacionBE.getFechaOperacion().toString() + "\n" +
//        "Tipo Operacion: " + GestorTiposOperacion.getTipoOperacion("ingreso") + "\n" ;
    }

      
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPContrasena;
    private javax.swing.JPanel jPError;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField txtNombreUsuario;
    // End of variables declaration//GEN-END:variables

}
