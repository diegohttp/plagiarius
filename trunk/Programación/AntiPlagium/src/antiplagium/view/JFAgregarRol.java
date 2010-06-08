package antiplagium.view;

import antiplagium.BE.RolBE;
import antiplagium.BL.*;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.*;
import javax.swing.table.*;

public class JFAgregarRol extends JIFBase {

    ResultSet tablaPrivilegios;
    DefaultTableModel modeloTablaPrivilegios;
    ArrayList<Integer> listaPrivilegios;
    Boolean esModificar;

    RolBE rolBE;

    public JFAgregarRol() {
        initComponents();
        this.rolBE = new RolBE();
        onLoad();
        esModificar = false;
    }

    public JFAgregarRol(RolBE rolBE, ArrayList<Integer> listaPrivilegios)
    {
        initComponents();
        this.rolBE = rolBE;
        this.listaPrivilegios = listaPrivilegios;
        onLoad();
        onLoadModificar();
        esModificar = true;
    }

    private void onLoad()
    {
       PrivilegioBL privilegioBL = new PrivilegioBL();
       
       modeloTablaPrivilegios = (DefaultTableModel)JTPrivilegios.getModel();       
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

    private void onLoadModificar()
    {
        JTFNombreRol.setText(rolBE.getNombre());
        Iterator<Integer> it = listaPrivilegios.iterator();
        while (it.hasNext())
        {
            int val2 = it.next().intValue();
            for (int i = 0; i < modeloTablaPrivilegios.getRowCount(); i++) {
                int val1 = ((Integer) modeloTablaPrivilegios.getValueAt(i, 0)).intValue();            
                if (val1 == val2)
                {
                    modeloTablaPrivilegios.setValueAt(true, i, 3);
                }
            }
        }        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JBGuardar = new javax.swing.JButton();
        JPGrupo = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        JTFNombreRol = new javax.swing.JTextField();
        JBCancelar = new javax.swing.JButton();
        JPPrivilegios = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTPrivilegios = new javax.swing.JTable();

        setTitle("Agregar Rol");

        JBGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/guardar.png"))); // NOI18N
        JBGuardar.setText("Guardar");
        JBGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBGuardarActionPerformed(evt);
            }
        });

        JPGrupo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nuevo Rol", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 0, 12))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial", 0, 11));
        jLabel2.setText("Nombre del Rol");

        javax.swing.GroupLayout JPGrupoLayout = new javax.swing.GroupLayout(JPGrupo);
        JPGrupo.setLayout(JPGrupoLayout);
        JPGrupoLayout.setHorizontalGroup(
            JPGrupoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPGrupoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTFNombreRol, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102))
        );
        JPGrupoLayout.setVerticalGroup(
            JPGrupoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPGrupoLayout.createSequentialGroup()
                .addGroup(JPGrupoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(JTFNombreRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JBCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/salir.png"))); // NOI18N
        JBCancelar.setText("Salir");
        JBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBCancelarActionPerformed(evt);
            }
        });

        JPPrivilegios.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Privilegios", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 0, 12))); // NOI18N

        JTPrivilegios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "descripcion", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(JTPrivilegios);
        JTPrivilegios.getColumnModel().getColumn(0).setMinWidth(40);
        JTPrivilegios.getColumnModel().getColumn(0).setPreferredWidth(40);
        JTPrivilegios.getColumnModel().getColumn(0).setMaxWidth(40);
        JTPrivilegios.getColumnModel().getColumn(1).setMinWidth(120);
        JTPrivilegios.getColumnModel().getColumn(1).setPreferredWidth(120);
        JTPrivilegios.getColumnModel().getColumn(1).setMaxWidth(120);
        JTPrivilegios.getColumnModel().getColumn(2).setMinWidth(160);
        JTPrivilegios.getColumnModel().getColumn(2).setPreferredWidth(160);
        JTPrivilegios.getColumnModel().getColumn(2).setMaxWidth(160);
        JTPrivilegios.getColumnModel().getColumn(3).setMinWidth(25);
        JTPrivilegios.getColumnModel().getColumn(3).setPreferredWidth(25);
        JTPrivilegios.getColumnModel().getColumn(3).setMaxWidth(25);

        javax.swing.GroupLayout JPPrivilegiosLayout = new javax.swing.GroupLayout(JPPrivilegios);
        JPPrivilegios.setLayout(JPPrivilegiosLayout);
        JPPrivilegiosLayout.setHorizontalGroup(
            JPPrivilegiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPPrivilegiosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
                .addContainerGap())
        );
        JPPrivilegiosLayout.setVerticalGroup(
            JPPrivilegiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPPrivilegiosLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JPPrivilegios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(JBGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JBCancelar))
                    .addComponent(JPGrupo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(JPGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JPPrivilegios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBCancelar)
                    .addComponent(JBGuardar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBCancelarActionPerformed
             this.dispose();
    }//GEN-LAST:event_JBCancelarActionPerformed

    private void JBGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBGuardarActionPerformed

        RolBL rolBL = new RolBL();        
        ArrayList<Integer> listaIDPrivilegios = new ArrayList<Integer>();

        rolBE.setNombre(JTFNombreRol.getText());
        for (int i = 0; i<modeloTablaPrivilegios.getRowCount(); i++)
        {
            if ((Boolean)modeloTablaPrivilegios.getValueAt(i, 3) == true )
            {
                listaIDPrivilegios.add((Integer)modeloTablaPrivilegios.getValueAt(i, 0));
            }
        }
        try
        {
            rolBL.AbrirConexion();
            if (esModificar) rolBL.updateRol(rolBE, listaIDPrivilegios);
            else rolBL.insertRol(rolBE, listaIDPrivilegios);
            rolBL.CerrarConexion();
        }
        catch(ClassNotFoundException ex)
        {
            JOptionPane.showMessageDialog(this, ex.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        catch (SQLException excepcionSQL)
        {
            JOptionPane.showMessageDialog(this, excepcionSQL.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        this.dispose();
    }//GEN-LAST:event_JBGuardarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBCancelar;
    private javax.swing.JButton JBGuardar;
    private javax.swing.JPanel JPGrupo;
    private javax.swing.JPanel JPPrivilegios;
    private javax.swing.JTextField JTFNombreRol;
    private javax.swing.JTable JTPrivilegios;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
