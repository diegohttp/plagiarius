package antiplagium.view;

import antiplagium.BE.*;
import antiplagium.BL.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;

public class JDAdministrarRoles extends JDialog {
    
    DefaultTableModel modeloTablaPrivilegios;
    ResultSet tablaPrivilegios = null;
    ResultSet tablaRoles = null;
    String descripcionOperacion;

    ArrayList<RolBE> listaRolesBE = new ArrayList<RolBE>();

    public JDAdministrarRoles()
    {
        initComponents();
        this.onLoad();
    }

    private void onLoad()
    {
        RolBL rolBL = new RolBL();
        PrivilegioBL privilegioBL = new PrivilegioBL();
        modeloTablaPrivilegios = (DefaultTableModel) JTPrivilegios.getModel();

        try
        {            
            privilegioBL.AbrirConexion();
            tablaPrivilegios = privilegioBL.getListPrivilegios();
            if (tablaPrivilegios != null)
            {
                while (tablaPrivilegios.next())
                {
                    Object[] fila = new Object[4];
                    fila[0] = tablaPrivilegios.getObject("idPrivilegio");
                    fila[1] = tablaPrivilegios.getObject("nombre").toString().trim();
                    fila[2] = tablaPrivilegios.getObject("descripcion").toString().trim();
                    fila[3] = false;
                    modeloTablaPrivilegios.addRow(fila);
                }
            }
            privilegioBL.CerrarConexion();

            rolBL.AbrirConexion();
            tablaRoles = rolBL.getAllListRoles();
            while (tablaRoles.next())
            {
                cboRol.addItem(new RolBE(tablaRoles.getInt("idRol"), tablaRoles.getString("nombre"), tablaRoles.getString("estado")));
            }
            rolBL.CerrarConexion();

        } catch (ClassNotFoundException ex) {
            //GestorError.showError("base_de_datos");
            JOptionPane.showMessageDialog(this, "Error en base de datos", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        } catch (SQLException excepcionSQL) {
            //GestorError.showError("base_de_datos");
            JOptionPane.showMessageDialog(this, "Error en base de datos", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        finally
        {
            try
            {
                privilegioBL.CerrarConexion();
            }
            catch (SQLException ex)
            {
                JOptionPane.showMessageDialog(this, ex.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cboRol = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        textEstado = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTPrivilegios = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuNuevo = new javax.swing.JMenu();
        jMenuModificar = new javax.swing.JMenu();
        jMenuEliminar = new javax.swing.JMenu();

        setTitle("Administrar Roles");
        setName("jdAdministrarUsuario"); // NOI18N
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Roles"));

        jLabel2.setText("Rol");

        cboRol.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboRolItemStateChanged(evt);
            }
        });

        jLabel3.setText("Estado");
        jLabel3.setName("text"); // NOI18N

        textEstado.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboRol, 0, 191, Short.MAX_VALUE)
                        .addGap(190, 190, 190))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(290, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cboRol, jLabel2});

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Permisos"));

        JTPrivilegios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Privilegio", "Descripcion", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTPrivilegios.setName("JTPrivilegios"); // NOI18N
        jScrollPane1.setViewportView(JTPrivilegios);
        JTPrivilegios.getColumnModel().getColumn(0).setPreferredWidth(20);
        JTPrivilegios.getColumnModel().getColumn(1).setMinWidth(120);
        JTPrivilegios.getColumnModel().getColumn(1).setPreferredWidth(100);
        JTPrivilegios.getColumnModel().getColumn(2).setPreferredWidth(120);
        JTPrivilegios.getColumnModel().getColumn(3).setPreferredWidth(20);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                .addContainerGap())
        );

        jMenuNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/nuevo.png"))); // NOI18N
        jMenuNuevo.setText("Nuevo");
        jMenuNuevo.setName("jMenuNuevo"); // NOI18N
        jMenuNuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuNuevoMousePressed(evt);
            }
        });
        jMenuBar1.add(jMenuNuevo);

        jMenuModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/modificar.png"))); // NOI18N
        jMenuModificar.setText("Modificar");
        jMenuModificar.setName("jMenuModificar"); // NOI18N
        jMenuModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuModificarMousePressed(evt);
            }
        });
        jMenuBar1.add(jMenuModificar);

        jMenuEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Eliminar - 16.png"))); // NOI18N
        jMenuEliminar.setText("Eliminar");
        jMenuEliminar.setName("jMenuEliminar"); // NOI18N
        jMenuEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuEliminarMousePressed(evt);
            }
        });
        jMenuBar1.add(jMenuEliminar);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboRolItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboRolItemStateChanged

        for (int i=0; i<modeloTablaPrivilegios.getRowCount(); i++) modeloTablaPrivilegios.setValueAt(false, i, 3);

        RolBL rolBL = new RolBL();
        ResultSet tablaPrivilegiosXRol = null;
        try
        {
            rolBL.AbrirConexion();
            tablaPrivilegiosXRol = rolBL.getPrivilegiosPorROl(((RolBE)cboRol.getSelectedItem()).getNombre());
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
            if (((RolBE)cboRol.getSelectedItem()).getEstado().compareToIgnoreCase("INA")==0)
            {
                    textEstado.setText("Inactivo");            
            }
            else textEstado.setText("Activo");
            
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
         finally
        {
            try
            {
                rolBL.CerrarConexion();
            }
            catch (SQLException ex)
            {
                JOptionPane.showMessageDialog(this, ex.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_cboRolItemStateChanged

    private void jMenuNuevoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuNuevoMousePressed
        // TODO add your handling code here
         RolBE rolBE = new RolBE();
        JDAgregarRol jfAgregarRol = new JDAgregarRol(rolBE);
        jfAgregarRol.setLocationRelativeTo(this);
        jfAgregarRol.setModal(true);
        jfAgregarRol.setVisible(true);
        if (rolBE.getIdPrivilegio() != 0)
        {
            cboRol.addItem(rolBE);
            cboRol.setSelectedItem(rolBE);
        }
    }//GEN-LAST:event_jMenuNuevoMousePressed

    private void jMenuModificarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuModificarMousePressed
        // TODO add your handling code here
        ArrayList<PrivilegioBE> listaPrivilegios = new ArrayList<PrivilegioBE>();
        for (int i=0; i < modeloTablaPrivilegios.getRowCount(); i++)
        {
            if ((Boolean)modeloTablaPrivilegios.getValueAt(i, 3) == true)
            {
                listaPrivilegios.add(new PrivilegioBE((Integer)modeloTablaPrivilegios.getValueAt(i, 0), (String)modeloTablaPrivilegios.getValueAt(i, 1)));
            }
        }

        RolBE rolBE = (RolBE)cboRol.getSelectedItem();
        JDAgregarRol jfAgregarRol = new JDAgregarRol(rolBE, listaPrivilegios);
        jfAgregarRol.setLocationRelativeTo(this);
        jfAgregarRol.setModal(true);
        jfAgregarRol.setVisible(true);
        cboRol.removeItem(rolBE);
        cboRol.addItem(rolBE);
        cboRol.setSelectedItem(rolBE);
    }//GEN-LAST:event_jMenuModificarMousePressed

    private void jMenuEliminarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuEliminarMousePressed
        // TODO add your handling code here
        RolBL rolBL = new RolBL();
        RolBE rolBE;

        try
        {
            rolBL.AbrirConexion();
            rolBE = (RolBE)cboRol.getSelectedItem();
            rolBL.deleteRol(rolBE);

            descripcionOperacion(rolBE);
            AntiPlagiumPrincipal.setOperacion(this.getName(), GestorTiposOperacion.getTipoOperacion("eliminacion"), descripcionOperacion);
            AntiPlagiumPrincipal.registrarOperacion();
            rolBL.CerrarConexion();
            cboRol.removeItem(rolBE);
        }
        catch (ClassNotFoundException ex)
        {
            //GestorError.showError("base_de_datos");
            JOptionPane.showMessageDialog(this, "Error en base de datos", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        catch (SQLException excepcionSQL)
        {
            //GestorError.showError("base_de_datos");
            JOptionPane.showMessageDialog(this, "Error en base de datos", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        finally
        {
            try
            {
                rolBL.CerrarConexion();
            }
            catch (SQLException ex)
            {
                JOptionPane.showMessageDialog(this, ex.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }

        JOptionPane.showMessageDialog(this, "El rol ha sido modificado a estado Inactivo", "Rol", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jMenuEliminarMousePressed

    private void descripcionOperacion(RolBE rolBE)
    {
        descripcionOperacion = "Usuario: " + AntiPlagiumPrincipal.usuarioBE.getNombreUsuario() + "\n" +
                               "Fecha:   " + AntiPlagiumPrincipal.operacionBE.getFechaOperacion().toString() + "\n" +
                               "Tipo Operacion: " + GestorTiposOperacion.getTipoOperacion("eliminacion") + "\n" ;
        descripcionOperacion += "Registro: " + rolBE.getNombre();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTPrivilegios;
    private javax.swing.JComboBox cboRol;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuEliminar;
    private javax.swing.JMenu jMenuModificar;
    private javax.swing.JMenu jMenuNuevo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField textEstado;
    // End of variables declaration//GEN-END:variables

}
