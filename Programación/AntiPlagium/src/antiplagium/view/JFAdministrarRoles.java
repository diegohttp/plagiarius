package antiplagium.view;

import antiplagium.BL.PrivilegioBL;
import antiplagium.BL.RolBL;
import java.awt.Component;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;

public class JFAdministrarRoles extends JIFBase {

    ResultSet tablaRoles = null;
    ResultSet tablaPrivilegios = null;
    DefaultTableModel modeloTablaPrivilegios = new DefaultTableModel();
    JDesktopPane jdpPrincipal;

    public JFAdministrarRoles(JDesktopPane jdpPrincipal) {
        initComponents();
        this.jdpPrincipal = jdpPrincipal;
        this.onLoad();
    }

    private void onLoad()
    {        
        RolBL rolBL = new RolBL();
        PrivilegioBL privilegioBL = new PrivilegioBL();

        modeloTablaPrivilegios = new DefaultTableModel(){
       @Override
              public boolean isCellEditable(int row, int col){                  
                  return false;
              }
       };
       modeloTablaPrivilegios.addColumn("ID");
       modeloTablaPrivilegios.addColumn("Nombre");
       modeloTablaPrivilegios.addColumn("Descripcion");
       
        try
        {
            rolBL.AbrirConexion();
            tablaRoles = rolBL.getListRoles();
            while (tablaRoles.next()) jcbRol.addItem(tablaRoles.getString("nombre"));
            rolBL.CerrarConexion();

            privilegioBL.AbrirConexion();
            tablaPrivilegios = privilegioBL.getListPrivilegios();
            if (tablaPrivilegios != null)
            {
                int numFilas = 0;
                while (tablaPrivilegios.next()) {

                    Object[] fila = new Object[4];

                    fila[0] = tablaPrivilegios.getObject("idPrivilegio");
                    fila[1] = tablaPrivilegios.getObject("nombre").toString().trim();
                    fila[2] = tablaPrivilegios.getObject("descripcion").toString().trim();

                    numFilas++;
                    modeloTablaPrivilegios.addRow(fila);
                }

                Boolean[] columna = new Boolean[numFilas];
                for (int i=0; i < modeloTablaPrivilegios.getRowCount(); i++) columna[i] = new Boolean(false);

                modeloTablaPrivilegios.addColumn("", columna);
                JTPrivilegios.setModel(modeloTablaPrivilegios);
                JTPrivilegios.getColumnModel().getColumn(0).setPreferredWidth(25);
                JTPrivilegios.getColumnModel().getColumn(1).setPreferredWidth(150);
                JTPrivilegios.getColumnModel().getColumn(2).setPreferredWidth(175);
                JTPrivilegios.getColumnModel().getColumn(3).setPreferredWidth(30);
                JTPrivilegios.getColumn("").setCellRenderer(new MultiRenderer());
                JTPrivilegios.updateUI();
            }
            privilegioBL.CerrarConexion();
        } 
        catch (ClassNotFoundException ex)
        {
            JOptionPane.showMessageDialog(this, ex.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        catch (SQLException excepcionSQL)
        {
            JOptionPane.showMessageDialog(this, excepcionSQL.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }     
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jcbRol = new javax.swing.JComboBox();
        JBBuscar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTPrivilegios = new javax.swing.JTable();
        JBModificar = new javax.swing.JButton();
        JBEliminar = new javax.swing.JButton();
        JBNuevo = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        setResizable(false);
        setTitle("Administrar Roles");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("ROL"));

        jLabel2.setText("Rol");

        JBBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbRol, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JBBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(195, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcbRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Permisos"));

        JTPrivilegios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Privilegio", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(JTPrivilegios);
        JTPrivilegios.getColumnModel().getColumn(0).setResizable(false);
        JTPrivilegios.getColumnModel().getColumn(0).setPreferredWidth(60);
        JTPrivilegios.getColumnModel().getColumn(1).setResizable(false);
        JTPrivilegios.getColumnModel().getColumn(1).setPreferredWidth(140);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JBModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/modificar.png"))); // NOI18N
        JBModificar.setText("Modificar");
        JBModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBModificarActionPerformed(evt);
            }
        });

        JBEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Eliminar - 16.png"))); // NOI18N
        JBEliminar.setText("Eliminar");
        JBEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBEliminarActionPerformed(evt);
            }
        });

        JBNuevo.setFont(new java.awt.Font("Tahoma", 0, 10));
        JBNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/nuevo.png"))); // NOI18N
        JBNuevo.setText("Nuevo");
        JBNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBNuevoActionPerformed(evt);
            }
        });

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/nuevo.png"))); // NOI18N
        jMenu1.setText("Nuevo");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jMenu1MouseReleased(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/modificar.png"))); // NOI18N
        jMenu2.setText("Modificar");
        jMenuBar1.add(jMenu2);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Eliminar - 16.png"))); // NOI18N
        jMenu3.setText("Eliminar");
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(JBNuevo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JBModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JBEliminar))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JBModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JBNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBNuevoActionPerformed
        JFAgregarRol jfAgregarRol = new JFAgregarRol();
        AntiPlagiumPrincipal.JDPPrincipal.add(jfAgregarRol);
        jfAgregarRol.toFront();
        jfAgregarRol.setVisible(true);
}//GEN-LAST:event_JBNuevoActionPerformed

    private void JBEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBEliminarActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_JBEliminarActionPerformed

    private void JBModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBModificarActionPerformed

}//GEN-LAST:event_JBModificarActionPerformed

    private void jMenu1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseReleased
        JFAgregarRol jfAgregarRol = new JFAgregarRol();
        AntiPlagiumPrincipal.JDPPrincipal.add(jfAgregarRol);
        jfAgregarRol.toFront();
        jfAgregarRol.setVisible(true);
    }//GEN-LAST:event_jMenu1MouseReleased

    private void JBBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBBuscarActionPerformed

        for (int i=0; i<modeloTablaPrivilegios.getRowCount(); i++) modeloTablaPrivilegios.setValueAt(false, i, 3);

        RolBL rolBL = new RolBL();
        ResultSet tablaPrivilegiosXRol = null;
        try
        {
            rolBL.AbrirConexion();
            tablaPrivilegiosXRol = rolBL.getPrivilegiosPorROl((String) jcbRol.getSelectedItem());
            if (tablaPrivilegiosXRol != null)
            {
                while(tablaPrivilegiosXRol.next())
                {
                    for(int i=0; i < modeloTablaPrivilegios.getRowCount(); i++)
                    {
                        int val1 = ((Integer)modeloTablaPrivilegios.getValueAt(i, 0)).intValue();
                        int val2 = ((Integer)tablaPrivilegiosXRol.getObject("idPrivilegio")).intValue();
                        if(val1 == val2) modeloTablaPrivilegios.setValueAt(true, i, 3);
                    }
                }
                JTPrivilegios.updateUI();
            }
            rolBL.CerrarConexion();
        }
        catch (ClassNotFoundException ex)
        {
            JOptionPane.showMessageDialog(this, ex.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        catch (SQLException excepcionSQL)
        {
                JOptionPane.showMessageDialog(this, excepcionSQL.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_JBBuscarActionPerformed

    class MultiRenderer extends DefaultTableCellRenderer {

        private static final long serialVersionUID = 1L;
        JCheckBox checkBox = new JCheckBox();

        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
            if (value instanceof Boolean) { // Boolean
                checkBox.setSelected(((Boolean) value).booleanValue());
                checkBox.setHorizontalAlignment(JLabel.CENTER);
                return checkBox;
            }
            String str = (value == null) ? "" : value.toString();
            return super.getTableCellRendererComponent(table, str, isSelected,
                    hasFocus, row, column);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBBuscar;
    private javax.swing.JButton JBEliminar;
    private javax.swing.JButton JBModificar;
    private javax.swing.JButton JBNuevo;
    private javax.swing.JTable JTPrivilegios;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox jcbRol;
    // End of variables declaration//GEN-END:variables

}
