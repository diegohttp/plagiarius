package antiplagium.view;

import antiplagium.BE.CategoriaBE;
import antiplagium.BE.UsuarioBE;
import java.awt.Dimension;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import antiplagium.DAL.*;
import java.awt.MenuBar;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JMenuBar;

public class AntiPlagiumPrincipal extends JFBase
{

    private Dimension dim;

    public AntiPlagiumPrincipal() {        
        initComponents();        
//      ConexionJDBC.conexion();
        JMenuBar menu = this.getJMenuBar();
        aplicarSeguridad(menu);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JDPPrincipal = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        JMUsuarios = new javax.swing.JMenu();
        JMIAdministrarUsuarios = new javax.swing.JMenuItem();
        JMIAdministrarGrupos = new javax.swing.JMenuItem();
        JMLogUsuario = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        JMReportes = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(java.awt.Color.lightGray);
        setBounds(new java.awt.Rectangle(0, 0, 1000, 700));
        setMinimumSize(new java.awt.Dimension(1000, 700));
        setName("JFAntiPlagiumPrincipal"); // NOI18N
        setResizable(false);

        JDPPrincipal.setBackground(java.awt.Color.lightGray);
        JDPPrincipal.setMaximumSize(new java.awt.Dimension(10, 10));
        JDPPrincipal.setMinimumSize(new java.awt.Dimension(10, 10));

        jMenuBar1.setBackground(new java.awt.Color(0, 153, 153));

        JMUsuarios.setBackground(new java.awt.Color(0, 153, 153));
        JMUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Parents20.png"))); // NOI18N
        JMUsuarios.setText("Usuarios");
        JMUsuarios.setName("JMUsuarios"); // NOI18N

        JMIAdministrarUsuarios.setText("Administrar Usuarios");
        JMIAdministrarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIAdministrarUsuariosActionPerformed(evt);
            }
        });
        JMUsuarios.add(JMIAdministrarUsuarios);

        JMIAdministrarGrupos.setText("Administrar Roles");
        JMIAdministrarGrupos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIAdministrarGruposActionPerformed(evt);
            }
        });
        JMUsuarios.add(JMIAdministrarGrupos);

        JMLogUsuario.setText("Log de Usuarios");
        JMLogUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMLogUsuarioActionPerformed(evt);
            }
        });
        JMUsuarios.add(JMLogUsuario);

        jMenuBar1.add(JMUsuarios);

        jMenu2.setBackground(new java.awt.Color(0, 153, 153));
        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Copy.png"))); // NOI18N
        jMenu2.setText("Documentos");
        jMenu2.setName("JMDocumentos"); // NOI18N

        jMenuItem2.setText("Gestionar Categoría");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem3.setText("Gestionar Documento");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        jMenu3.setBackground(new java.awt.Color(0, 153, 153));
        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Mostrar.png"))); // NOI18N
        jMenu3.setText("Detección");
        jMenu3.setName("JMDeteccion"); // NOI18N
        jMenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu3ActionPerformed(evt);
            }
        });

        jMenuItem4.setText("Comparar documentos");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jMenuItem5.setText("Mostrar resultados");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem5);

        jMenuBar1.add(jMenu3);

        JMReportes.setBackground(new java.awt.Color(0, 153, 153));
        JMReportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Report.png"))); // NOI18N
        JMReportes.setText("Reportes");
        JMReportes.setName("JMReportes"); // NOI18N
        jMenuBar1.add(JMReportes);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JDPPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 885, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JDPPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JMIAdministrarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIAdministrarUsuariosActionPerformed
        JFAdministrarUsuarios jfUsuarios= new JFAdministrarUsuarios();
        jfUsuarios.setVisible(true);
//        desktop.add(jfUsuarios);
        JDPPrincipal.add(jfUsuarios);

}//GEN-LAST:event_JMIAdministrarUsuariosActionPerformed

    private void JMIAdministrarGruposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIAdministrarGruposActionPerformed
        JFAdministrarRoles jfAdministrarRoles = new JFAdministrarRoles(JDPPrincipal);
        jfAdministrarRoles.setVisible(true);
        JDPPrincipal.add(jfAdministrarRoles);
        
}//GEN-LAST:event_JMIAdministrarGruposActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
         JFAdministrarCategoria admCategoria = new JFAdministrarCategoria();
         admCategoria.setVisible(true);
        //RegistrarCategoria registrarCategoria = new  RegistrarCategoria();
         //registrarCategoria.setVisible(true);
         //JDPPrincipal.add(registrarCategoria);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        try {
            /* Codigo agregado solo para pruebas */
            ArrayList<CategoriaBE> aCategoria = new ArrayList<CategoriaBE>();
            aCategoria.add(new CategoriaBE());
            aCategoria.get(0).setIdCategoria(4);
            aCategoria.get(0).setNombre("Filosofia");
            aCategoria.add(new CategoriaBE());
            aCategoria.get(1).setIdCategoria(5);
            aCategoria.get(1).setNombre("Derecho");
            UsuarioBE objUsuario = new UsuarioBE();
            objUsuario.setIdUsuario(1);
            objUsuario.setNombres("Piere");
            objUsuario.setCategorias(aCategoria);
            objUsuario.setApellidoPaterno("Cordero");
            objUsuario.setApellidoMaterno("Principe");
            /* Eliminar luego de probar */
            BuscarDocumento buscardoc = new BuscarDocumento(objUsuario);
            buscardoc.setModal(false);
            buscardoc.setVisible(true);
            //JDPPrincipal.add(buscardoc);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AntiPlagiumPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AntiPlagiumPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AntiPlagiumPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed


    private void jMenuItem4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem4MouseClicked
        // TODO add your handling code here:
        JFCompararDocumentos frmCompararDocumentos = new JFCompararDocumentos();
        frmCompararDocumentos.setVisible(true);
        //JDPPrincipal.add(frmCompararDocumentos);
    }//GEN-LAST:event_jMenuItem4MouseClicked

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        JFCompararDocumentos frmCompararDocumentos = new JFCompararDocumentos();
        frmCompararDocumentos.setModal(true);
       // AntiPlagiumPrincipal.JDPPrincipal.add(frmCompararDocumentos);
        frmCompararDocumentos.setVisible(true);
        //JDPPrincipal.add(frmCompararDocumentos);
    }//GEN-LAST:event_jMenuItem4ActionPerformed


    private void jMenu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu3ActionPerformed
        
    
    }//GEN-LAST:event_jMenu3ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        JFMostrarResultados frmRes = new  JFMostrarResultados();
         frmRes.setVisible(true);
         JDPPrincipal.add(frmRes);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void JMLogUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMLogUsuarioActionPerformed
        JFLogDeUsuarios jfLogDeUsuarios = new JFLogDeUsuarios();
        jfLogDeUsuarios.setVisible(true);
        JDPPrincipal.add(jfLogDeUsuarios);
    }//GEN-LAST:event_JMLogUsuarioActionPerformed

   public static  JDesktopPane  getJDesktopPane(){
      return JDPPrincipal;
    }
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane JDPPrincipal;
    private javax.swing.JMenuItem JMIAdministrarGrupos;
    private javax.swing.JMenuItem JMIAdministrarUsuarios;
    private javax.swing.JMenuItem JMLogUsuario;
    private javax.swing.JMenu JMReportes;
    private javax.swing.JMenu JMUsuarios;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    // End of variables declaration//GEN-END:variables

}
