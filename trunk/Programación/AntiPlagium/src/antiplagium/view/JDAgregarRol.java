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
       
       modeloTablaPrivilegios = (DefaultTableModel)tbPrivilegios.getModel();
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
            JOptionPane.showMessageDialog(this, "Error en base de datos", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        catch (SQLException excepcionSQL)
        {
            JOptionPane.showMessageDialog(this, "Error en base de datos", "ERROR", JOptionPane.ERROR_MESSAGE);
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

        btnGuardar = new javax.swing.JButton();
        pnGrupo = new javax.swing.JPanel();
        lblNombreRol = new javax.swing.JLabel();
        txtNombreRol = new javax.swing.JTextField();
        lblEstado = new javax.swing.JLabel();
        cboEstado = new javax.swing.JComboBox();
        btnCancelar = new javax.swing.JButton();
        pnPrivilegios = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbPrivilegios = new javax.swing.JTable();

        setTitle("Agregar Rol");
        setName("jDAgregarRol"); // NOI18N

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/aceptar.png"))); // NOI18N
        btnGuardar.setText("Aceptar");
        btnGuardar.setMaximumSize(new java.awt.Dimension(135, 35));
        btnGuardar.setMinimumSize(new java.awt.Dimension(135, 35));
        btnGuardar.setPreferredSize(new java.awt.Dimension(135, 35));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        pnGrupo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Rol", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 0, 12))); // NOI18N
        pnGrupo.setPreferredSize(new java.awt.Dimension(406, 80));

        lblNombreRol.setFont(new java.awt.Font("Arial", 0, 11));
        lblNombreRol.setText("Nombre del Rol");

        txtNombreRol.setName("txtNombreRol"); // NOI18N
        txtNombreRol.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreRolKeyReleased(evt);
            }
        });

        lblEstado.setFont(new java.awt.Font("Arial", 0, 11));
        lblEstado.setText("Estado");

        javax.swing.GroupLayout pnGrupoLayout = new javax.swing.GroupLayout(pnGrupo);
        pnGrupo.setLayout(pnGrupoLayout);
        pnGrupoLayout.setHorizontalGroup(
            pnGrupoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnGrupoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnGrupoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnGrupoLayout.createSequentialGroup()
                        .addComponent(lblNombreRol, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombreRol, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(102, 102, 102))
                    .addGroup(pnGrupoLayout.createSequentialGroup()
                        .addComponent(lblEstado, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(213, 213, 213))))
        );
        pnGrupoLayout.setVerticalGroup(
            pnGrupoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnGrupoLayout.createSequentialGroup()
                .addGroup(pnGrupoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreRol)
                    .addComponent(txtNombreRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnGrupoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEstado)
                    .addComponent(cboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cancelar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setMinimumSize(new java.awt.Dimension(135, 35));
        btnCancelar.setPreferredSize(new java.awt.Dimension(135, 35));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        pnPrivilegios.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Privilegios", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 0, 12))); // NOI18N

        tbPrivilegios.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbPrivilegios);
        tbPrivilegios.getColumnModel().getColumn(0).setMinWidth(40);
        tbPrivilegios.getColumnModel().getColumn(0).setPreferredWidth(40);
        tbPrivilegios.getColumnModel().getColumn(0).setMaxWidth(40);
        tbPrivilegios.getColumnModel().getColumn(1).setMinWidth(130);
        tbPrivilegios.getColumnModel().getColumn(1).setPreferredWidth(130);
        tbPrivilegios.getColumnModel().getColumn(1).setMaxWidth(130);
        tbPrivilegios.getColumnModel().getColumn(2).setMinWidth(160);
        tbPrivilegios.getColumnModel().getColumn(2).setPreferredWidth(160);
        tbPrivilegios.getColumnModel().getColumn(2).setMaxWidth(160);
        tbPrivilegios.getColumnModel().getColumn(3).setMinWidth(25);
        tbPrivilegios.getColumnModel().getColumn(3).setPreferredWidth(25);
        tbPrivilegios.getColumnModel().getColumn(3).setMaxWidth(25);

        javax.swing.GroupLayout pnPrivilegiosLayout = new javax.swing.GroupLayout(pnPrivilegios);
        pnPrivilegios.setLayout(pnPrivilegiosLayout);
        pnPrivilegiosLayout.setHorizontalGroup(
            pnPrivilegiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPrivilegiosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnPrivilegiosLayout.setVerticalGroup(
            pnPrivilegiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPrivilegiosLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnPrivilegios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnGrupo, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnPrivilegios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, Short.MAX_VALUE))
                .addGap(13, 13, 13))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
             this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        if (txtNombreRol.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Nombre del Rol debe tener al menos un caracter", "ERROR", JOptionPane.ERROR_MESSAGE);           
            return;
        }

        if (txtNombreRol.getText().length() > 15)
        {
                JOptionPane.showMessageDialog(this, "Nombre del Rol debe tener un máximo de 15 caracteres", "ERROR", JOptionPane.ERROR_MESSAGE);           
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

            if (esModificar) JOptionPane.showMessageDialog(this, "El rol ha sido modificado con exito", "Rol", JOptionPane.INFORMATION_MESSAGE);
            else JOptionPane.showMessageDialog(this, "El rol ha sido creado con exito", "Rol", JOptionPane.INFORMATION_MESSAGE);
        }
        catch(ClassNotFoundException ex)
        {
            JOptionPane.showMessageDialog(this, "Error en base de datos", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        catch (SQLException excepcionSQL)
        {
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

        
        this.dispose();
    }//GEN-LAST:event_btnGuardarActionPerformed

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
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox cboEstado;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblNombreRol;
    private javax.swing.JPanel pnGrupo;
    private javax.swing.JPanel pnPrivilegios;
    private javax.swing.JTable tbPrivilegios;
    private javax.swing.JTextField txtNombreRol;
    // End of variables declaration//GEN-END:variables

}
