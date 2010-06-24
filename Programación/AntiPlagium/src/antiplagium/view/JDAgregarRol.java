package antiplagium.view;

import antiplagium.BE.*;
import antiplagium.BL.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.*;

public class JDAgregarRol extends JDialog {

    ResultSet tablaPrivilegios;
    DefaultTableModel modeloTablaPrivilegios;
    ArrayList<PrivilegioBE> listaPrivilegiosSinModificar;
    ArrayList<Integer> listaIDPrivilegios;
    ArrayList<PrivilegioBE> listaPrivilegios;
    Boolean esModificar;

    RolBE rolBE;
    String estadoActivo = "Activo";
    String estadoInactivo = "Inactivo";
    String nombreRolInicial;
    String descripcionOperacion;
    String descripcionOperacionModificar;

    public JDAgregarRol(RolBE rolBE)
    {
        initComponents();
        this.rolBE = rolBE;
        this.cboEstado.addItem(estadoActivo);
        this.cboEstado.setEnabled(false);
        onLoad();
        esModificar = false;
    }

    public JDAgregarRol(RolBE rolBE, ArrayList<PrivilegioBE> listaPrivilegios)
    {
        initComponents();
        this.rolBE = rolBE;
        this.cboEstado.addItem(estadoActivo);
        this.cboEstado.addItem(estadoInactivo);
        this.listaPrivilegiosSinModificar = listaPrivilegios;
        
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
        nombreRolInicial = rolBE.getNombre();
        txtNombreRol.setText(rolBE.getNombre());
        if ( rolBE.getEstado().compareToIgnoreCase("ACT")==0) cboEstado.setSelectedItem(estadoActivo);
        else cboEstado.setSelectedItem(estadoInactivo);
        
        descripcionOperacionModificar = "Registro original: " + rolBE.getNombre() + "\n";
        for (PrivilegioBE privilegio : listaPrivilegiosSinModificar)
        {            
            descripcionOperacionModificar += "  - " + privilegio.getNombrePrivilegio() + "\n";
            int idPrivilegio = privilegio.getIdPrivilegio();
            for (int i = 0; i < modeloTablaPrivilegios.getRowCount(); i++)
            {
                int val1 = ((Integer) modeloTablaPrivilegios.getValueAt(i, 0)).intValue();            
                if ( val1 ==  idPrivilegio ) modeloTablaPrivilegios.setValueAt(true, i, 3);
            }
        }        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JBGuardar = new javax.swing.JButton();
        JPGrupo = new javax.swing.JPanel();
        lblNombreRol = new javax.swing.JLabel();
        txtNombreRol = new javax.swing.JTextField();
        lblEstado = new javax.swing.JLabel();
        cboEstado = new javax.swing.JComboBox();
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

        JPGrupo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Rol", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 0, 12))); // NOI18N

        lblNombreRol.setFont(new java.awt.Font("Arial", 0, 11));
        lblNombreRol.setText("Nombre del Rol");

        txtNombreRol.setName("txtNombreRol"); // NOI18N
        txtNombreRol.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreRolKeyReleased(evt);
            }
        });

        lblEstado.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        lblEstado.setText("Estado");

        javax.swing.GroupLayout JPGrupoLayout = new javax.swing.GroupLayout(JPGrupo);
        JPGrupo.setLayout(JPGrupoLayout);
        JPGrupoLayout.setHorizontalGroup(
            JPGrupoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPGrupoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JPGrupoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPGrupoLayout.createSequentialGroup()
                        .addComponent(lblNombreRol, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombreRol, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(119, 119, 119))
                    .addGroup(JPGrupoLayout.createSequentialGroup()
                        .addComponent(lblEstado, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(213, 213, 213))))
        );
        JPGrupoLayout.setVerticalGroup(
            JPGrupoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPGrupoLayout.createSequentialGroup()
                .addGroup(JPGrupoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreRol)
                    .addComponent(txtNombreRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(JPGrupoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEstado)
                    .addComponent(cboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        JTPrivilegios.getColumnModel().getColumn(1).setMinWidth(130);
        JTPrivilegios.getColumnModel().getColumn(1).setPreferredWidth(130);
        JTPrivilegios.getColumnModel().getColumn(1).setMaxWidth(130);
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JPPrivilegiosLayout.setVerticalGroup(
            JPPrivilegiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPPrivilegiosLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JPGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JPPrivilegios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(JBGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JBCancelar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(JPGrupo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JPPrivilegios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JBGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JBCancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBCancelarActionPerformed
             this.dispose();
    }//GEN-LAST:event_JBCancelarActionPerformed

    private void JBGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBGuardarActionPerformed

        if (txtNombreRol.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Nombre del Rol debe tener al menos un caracter", "ERROR", JOptionPane.ERROR_MESSAGE);           
            return;
        }

        RolBL rolBL = new RolBL();
        listaIDPrivilegios = new ArrayList<Integer>();
        listaPrivilegios = new ArrayList<PrivilegioBE>();

        // Damos valores al rolBE
        rolBE.setNombre(txtNombreRol.getText());
        if (((String)cboEstado.getSelectedItem()).compareToIgnoreCase(estadoActivo)==0) rolBE.setEstado("ACT");
        else rolBE.setEstado("INA");

        for (int i = 0; i<modeloTablaPrivilegios.getRowCount(); i++)
        {
           if ((Boolean)modeloTablaPrivilegios.getValueAt(i, 3) == true )
           {
               listaIDPrivilegios.add((Integer)modeloTablaPrivilegios.getValueAt(i, 0));
               listaPrivilegios.add(new PrivilegioBE((Integer)modeloTablaPrivilegios.getValueAt(i, 0), (String)modeloTablaPrivilegios.getValueAt(i, 1)));
           }
        }
        try
        {
            rolBL.AbrirConexion();
            ResultSet tablaRoles = rolBL.getListRoles();
            //valida que no exista otro rol registrado con el mismo nombre
            while (tablaRoles.next())
            {
                if ( rolBE.getNombre().compareToIgnoreCase(tablaRoles.getString("nombre")) == 0 )
                {
                    if (esModificar) 
                    {
                        if (rolBE.getNombre().compareToIgnoreCase(nombreRolInicial) == 0) break;
                    }
                    JOptionPane.showMessageDialog(this, "Nombre de rol ya existe", "ERROR", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            if (esModificar)
            {
                rolBL.updateRol(rolBE, listaPrivilegiosSinModificar, listaIDPrivilegios);
            }
            else rolBL.insertRol(rolBE, listaIDPrivilegios);
            
            if (esModificar)
            {
                descripcionOperacionModificar(txtNombreRol.getText(), listaPrivilegios);
                JFBase.setOperacion(this.getName(), GestorTiposOperacion.getTipoOperacion("modifica"), descripcionOperacion);
            }
            else
            {
                descripcionOperacionGuardar();
                AntiPlagiumPrincipal.setOperacion(this.getName(), GestorTiposOperacion.getTipoOperacion("registra"), descripcionOperacion);
            }
            JFBase.registrarOperacion();
            rolBL.CerrarConexion();
        }
        catch(ClassNotFoundException ex)
        {
            JOptionPane.showMessageDialog(this, ex.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        catch (SQLException excepcionSQL)
        {
            JOptionPane.showMessageDialog(this, excepcionSQL.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        this.dispose();
    }//GEN-LAST:event_JBGuardarActionPerformed

    private void descripcionOperacionGuardar()
    {
        descripcionOperacion = GestorTiposOperacion.getTipoOperacion("registra") + "\n" +
                               rolBE.getNombre() + "\n" + "privilegios: \n";

        for (PrivilegioBE privilegio : listaPrivilegios)
        {
            descripcionOperacion += "   - " + privilegio.getNombrePrivilegio() + "\n";
        }
    }

    private void descripcionOperacionModificar(String nombre, ArrayList<PrivilegioBE>  listaPrivilegios)
    {
        descripcionOperacion = GestorTiposOperacion.getTipoOperacion("modifica") + "\n";

        descripcionOperacion += descripcionOperacionModificar;
        descripcionOperacion += "Registro modificado: \n";
        descripcionOperacion += nombre + ": \n";
        for (PrivilegioBE privilegio : listaPrivilegios)
        {
            descripcionOperacion += "   - " + privilegio.getNombrePrivilegio() + "\n";
        }        
    }

    private void txtNombreRolKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreRolKeyReleased
        Character caracter = new Character(evt.getKeyChar());
        if (!Utilitario.esLetra(caracter))
        {
            String texto = "";
            for (int i = 0; i < txtNombreRol.getText().length(); i++)
                if (Utilitario.esLetra(new Character(txtNombreRol.getText().charAt(i))))
                    texto += txtNombreRol.getText().charAt(i);
            txtNombreRol.setText(texto);
            txtNombreRol.getToolkit().beep();
        }
    }//GEN-LAST:event_txtNombreRolKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBCancelar;
    private javax.swing.JButton JBGuardar;
    private javax.swing.JPanel JPGrupo;
    private javax.swing.JPanel JPPrivilegios;
    private javax.swing.JTable JTPrivilegios;
    private javax.swing.JComboBox cboEstado;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblNombreRol;
    private javax.swing.JTextField txtNombreRol;
    // End of variables declaration//GEN-END:variables

}
