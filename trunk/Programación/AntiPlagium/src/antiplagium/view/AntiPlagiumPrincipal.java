package antiplagium.view;

import javax.swing.JDesktopPane;

public class AntiPlagiumPrincipal extends JFBase {

//    JDesktopPane desktop;
    /** Creates new form AntiPlagiumPrincipal */
    public AntiPlagiumPrincipal() {        
        initComponents();
//        desktop=new JDesktopPane();
//        setContentPane(desktop);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JDPPrincipal = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        JMIAdministrarUsuarios = new javax.swing.JMenuItem();
        JMIAdministrarGrupos = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        JDPPrincipal.setBackground(new java.awt.Color(153, 153, 153));

        jMenuBar1.setBackground(new java.awt.Color(0, 153, 153));

        jMenu1.setBackground(new java.awt.Color(0, 153, 153));
        jMenu1.setText("Usuarios");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        JMIAdministrarUsuarios.setText("Administrar Usuarios");
        JMIAdministrarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIAdministrarUsuariosActionPerformed(evt);
            }
        });
        jMenu1.add(JMIAdministrarUsuarios);

        JMIAdministrarGrupos.setText("Administrar Roles");
        JMIAdministrarGrupos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIAdministrarGruposActionPerformed(evt);
            }
        });
        jMenu1.add(JMIAdministrarGrupos);

        jMenuItem1.setText("Log de Usuarios");
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setBackground(new java.awt.Color(0, 153, 153));
        jMenu2.setText("Documentos");
        jMenuBar1.add(jMenu2);

        jMenu3.setBackground(new java.awt.Color(0, 153, 153));
        jMenu3.setText("Detección");
        jMenuBar1.add(jMenu3);

        jMenu4.setBackground(new java.awt.Color(0, 153, 153));
        jMenu4.setText("Reportes");
        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JDPPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 943, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JDPPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE))
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
        JFAdministrarRoles jfAdministrarRoles = new JFAdministrarRoles();
        jfAdministrarRoles.setVisible(true);
        JDPPrincipal.add(jfAdministrarRoles);
        
}//GEN-LAST:event_JMIAdministrarGruposActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
     // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1ActionPerformed

    public static  JDesktopPane  getJDesktopPane(){
      return JDPPrincipal;
    }
    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AntiPlagiumPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane JDPPrincipal;
    private javax.swing.JMenuItem JMIAdministrarGrupos;
    private javax.swing.JMenuItem JMIAdministrarUsuarios;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    // End of variables declaration//GEN-END:variables

}
