package antiplagium.view;

public class AntiPlagiumPrincipal extends JFBase {

    /** Creates new form AntiPlagiumPrincipal */
    public AntiPlagiumPrincipal() {        
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPPrincipal = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        JMIAdministrarUsuarios = new javax.swing.JMenuItem();
        JMIAdministrarGrupos = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JPPrincipal.setBackground(new java.awt.Color(217, 211, 211));

        javax.swing.GroupLayout JPPrincipalLayout = new javax.swing.GroupLayout(JPPrincipal);
        JPPrincipal.setLayout(JPPrincipalLayout);
        JPPrincipalLayout.setHorizontalGroup(
            JPPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 944, Short.MAX_VALUE)
        );
        JPPrincipalLayout.setVerticalGroup(
            JPPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 472, Short.MAX_VALUE)
        );

        jMenuBar1.setBackground(new java.awt.Color(0, 153, 153));

        jMenu1.setBackground(new java.awt.Color(0, 153, 153));
        jMenu1.setText("Usuarios");

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
            .addComponent(JPPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JMIAdministrarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIAdministrarUsuariosActionPerformed
        JFAministrarUsuarios frmUsuarios= new JFAministrarUsuarios();
        frmUsuarios.setVisible(true);
}//GEN-LAST:event_JMIAdministrarUsuariosActionPerformed

    private void JMIAdministrarGruposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIAdministrarGruposActionPerformed
        JFAdministrarRoles jfAdministrarRoles = new JFAdministrarRoles();
        jfAdministrarRoles.setVisible(true);
        //JPPrincipal.add(jfAdministrarRoles);
}//GEN-LAST:event_JMIAdministrarGruposActionPerformed

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
    private javax.swing.JMenuItem JMIAdministrarGrupos;
    private javax.swing.JMenuItem JMIAdministrarUsuarios;
    private javax.swing.JPanel JPPrincipal;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    // End of variables declaration//GEN-END:variables

}
