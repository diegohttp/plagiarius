package antiplagium.view;

import antiplagium.BE.*;
import antiplagium.BL.RegistroOperacionBL;
import antiplagium.BL.SeguridadBL;
import antiplagium.view.Reportes.ComparacionesDeteccion;
import antiplagium.view.Reportes.ListarDocs;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.*;
import java.awt.Component;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.util.Date;
import java.util.Vector;
import javax.swing.*;


public class AntiPlagiumPrincipal extends JFBase {
       
    public AntiPlagiumPrincipal(UsuarioBE usuarioBE) {
        super(usuarioBE);
        this.usuarioBE = usuarioBE;
        this.add(new PanelAnimado());

        initComponents();

        int ancho = Toolkit.getDefaultToolkit().getScreenSize().width;
        int alto = Toolkit.getDefaultToolkit().getScreenSize().height;

        this.setSize(ancho, alto - 40);
        
        JMenuBar menu = this.getJMenuBar();
        JRootPane jroot = this.getRootPane();
        Component[] componentesMenu = jroot.getJMenuBar().getComponents();
        Component[] componentesMenuInterno;

        for (int i = 0; i < componentesMenu.length; i++) {
            (componentesMenu[i]).setVisible(false);

            componentesMenuInterno = menu.getMenu(i).getMenuComponents();
            for (int j = 0; j < componentesMenuInterno.length; j++) {
                ((JMenuItem) componentesMenuInterno[j]).setVisible(false);
            }
        }

        operacionBE = new RegistroOperacionBE((usuarioBE.getIdUsuario()), new Date(System.currentTimeMillis()));
        aplicarSeguridad(menu, usuarioBE.getRolBE().getIdRol());
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JDPPrincipal = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        JMUsuarios = new javax.swing.JMenu();
        JMIAdministrarUsuarios = new javax.swing.JMenuItem();
        JMIAdministrarGrupos = new javax.swing.JMenuItem();
        JMLogUsuario = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        JMReportes = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(java.awt.Color.lightGray);
        setBounds(new java.awt.Rectangle(0, 0, 1000, 700));
        setIconImages(null);
        setMinimumSize(new java.awt.Dimension(1000, 700));
        setName("JFAntiPlagiumPrincipal"); // NOI18N
        setResizable(false);

        JDPPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        JDPPrincipal.setMaximumSize(new java.awt.Dimension(10, 10));
        JDPPrincipal.setMinimumSize(new java.awt.Dimension(10, 10));

        jMenuBar1.setBackground(new java.awt.Color(0, 153, 153));
        jMenuBar1.setPreferredSize(new java.awt.Dimension(536, 34));

        jMenu1.setText("S e s i o n");
        jMenu1.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jMenu1.setName("JMSesion"); // NOI18N

        jMenuItem5.setText("Cerrar Sesion");
        jMenuItem5.setName("JMICerrarSesion"); // NOI18N
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuBar1.add(jMenu1);

        JMUsuarios.setBackground(new java.awt.Color(0, 153, 153));
        JMUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Seguridad1.png"))); // NOI18N
        JMUsuarios.setText("Seguridad");
        JMUsuarios.setFont(new java.awt.Font("Matisse ITC", 1, 14));
        JMUsuarios.setName("JMUsuarios"); // NOI18N

        JMIAdministrarUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/People.png"))); // NOI18N
        JMIAdministrarUsuarios.setText("Administrar Usuarios");
        JMIAdministrarUsuarios.setName("JMIAdministrarUsuarios"); // NOI18N
        JMIAdministrarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIAdministrarUsuariosActionPerformed(evt);
            }
        });
        JMUsuarios.add(JMIAdministrarUsuarios);

        JMIAdministrarGrupos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Boss.png"))); // NOI18N
        JMIAdministrarGrupos.setText("Administrar Roles");
        JMIAdministrarGrupos.setName("JMIAdministrarRoles"); // NOI18N
        JMIAdministrarGrupos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIAdministrarGruposActionPerformed(evt);
            }
        });
        JMUsuarios.add(JMIAdministrarGrupos);

        JMLogUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/List.png"))); // NOI18N
        JMLogUsuario.setText("Log de Usuarios");
        JMLogUsuario.setName("JMILogDeUsuarios"); // NOI18N
        JMLogUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMLogUsuarioActionPerformed(evt);
            }
        });
        JMUsuarios.add(JMLogUsuario);

        jMenuBar1.add(JMUsuarios);

        jMenu2.setBackground(new java.awt.Color(0, 153, 153));
        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Copy.png"))); // NOI18N
        jMenu2.setText("D o c u m e n t o s");
        jMenu2.setFont(new java.awt.Font("Matisse ITC", 1, 14));
        jMenu2.setName("JMDocumentos"); // NOI18N

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Folder.png"))); // NOI18N
        jMenuItem2.setText("Gestionar Categoría");
        jMenuItem2.setName("JMIGestionarCategoria"); // NOI18N
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/documento.png"))); // NOI18N
        jMenuItem3.setText("Gestionar Documento");
        jMenuItem3.setName("JMIGestionarDocumento"); // NOI18N
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        jMenu3.setBackground(new java.awt.Color(0, 153, 153));
        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Mostrar.png"))); // NOI18N
        jMenu3.setText("D e t e c c i ó n");
        jMenu3.setFont(new java.awt.Font("Matisse ITC", 1, 14));
        jMenu3.setName("JMDeteccion"); // NOI18N
        jMenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu3ActionPerformed(evt);
            }
        });

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Eye.png"))); // NOI18N
        jMenuItem4.setText("Comparar documentos");
        jMenuItem4.setName("JMICompararDocumentos"); // NOI18N
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jMenuBar1.add(jMenu3);

        JMReportes.setBackground(new java.awt.Color(0, 153, 153));
        JMReportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Reportes2.png"))); // NOI18N
        JMReportes.setText("R e p o r t e s");
        JMReportes.setFont(new java.awt.Font("Matisse ITC", 1, 14));
        JMReportes.setName("JMReportes"); // NOI18N

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Report.png"))); // NOI18N
        jMenuItem1.setText("Comparaciones Documentos");
        jMenuItem1.setName("JMIReporteComparaciones"); // NOI18N
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        JMReportes.add(jMenuItem1);

        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Report.png"))); // NOI18N
        jMenuItem6.setText("Documentos");
        jMenuItem6.setName("JMIReporteDocumentos"); // NOI18N
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        JMReportes.add(jMenuItem6);

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
                .addComponent(JDPPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JMIAdministrarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIAdministrarUsuariosActionPerformed
        JDAdministrarUsuarios jfUsuarios = new JDAdministrarUsuarios(null);
        jfUsuarios.setModal(true);
        jfUsuarios.setLocationRelativeTo(this);
        jfUsuarios.setVisible(true);

//        desktop.add(jfUsuarios);
//        JDPPrincipal.add(jfUsuarios);

}//GEN-LAST:event_JMIAdministrarUsuariosActionPerformed

    private void JMIAdministrarGruposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIAdministrarGruposActionPerformed
        JDAdministrarRoles jfAdministrarRoles = new JDAdministrarRoles();
        jfAdministrarRoles.setModal(true);
        jfAdministrarRoles.setLocationRelativeTo(this);
        jfAdministrarRoles.setVisible(true);
}//GEN-LAST:event_JMIAdministrarGruposActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        JDAdministrarCategoria admCategoria = new JDAdministrarCategoria();
        admCategoria.setModal(true);
        admCategoria.setLocationRelativeTo(this);
        admCategoria.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        try {
            /* Codigo agregado solo para pruebas */
            UsuarioBE objUsuario = AntiPlagiumPrincipal.usuarioBE;
            /* Eliminar luego de probar */
            JDBuscarDocumento buscardoc = new JDBuscarDocumento(objUsuario,2);
            buscardoc.setModal(true);
            buscardoc.setLocationRelativeTo(this);
            buscardoc.setVisible(true);
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
        JDCompararDocumentos frmCompararDocumentos = new JDCompararDocumentos();
        frmCompararDocumentos.setVisible(true);
    //JDPPrincipal.add(frmCompararDocumentos);
    }//GEN-LAST:event_jMenuItem4MouseClicked

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        JDCompararDocumentos frmCompararDocumentos = new JDCompararDocumentos();
        frmCompararDocumentos.setModal(true);
        frmCompararDocumentos.setLocationRelativeTo(this);
        frmCompararDocumentos.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu3ActionPerformed
    }//GEN-LAST:event_jMenu3ActionPerformed

    private void JMLogUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMLogUsuarioActionPerformed
        JDLogDeUsuarios jdLogDeUsuarios = new JDLogDeUsuarios();
        jdLogDeUsuarios.setLocationRelativeTo(this);
        jdLogDeUsuarios.setModal(false);
        jdLogDeUsuarios.setVisible(true);
    }//GEN-LAST:event_JMLogUsuarioActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        try {
            ComparacionesDeteccion frmComparacion = new ComparacionesDeteccion();
            frmComparacion.setVisible(true);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AntiPlagiumPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AntiPlagiumPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AntiPlagiumPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed

        ListarDocs frmListarDocs = new ListarDocs();
        frmListarDocs.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
       this.dispose();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    public static JDesktopPane getJDesktopPane() {
        return JDPPrincipal;
    }    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane JDPPrincipal;
    private javax.swing.JMenuItem JMIAdministrarGrupos;
    private javax.swing.JMenuItem JMIAdministrarUsuarios;
    private javax.swing.JMenuItem JMLogUsuario;
    private javax.swing.JMenu JMReportes;
    private javax.swing.JMenu JMUsuarios;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    // End of variables declaration//GEN-END:variables
}
