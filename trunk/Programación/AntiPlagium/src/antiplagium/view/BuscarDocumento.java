/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Documento2.java
 *
 * Created on 01/05/2010, 03:23:51 PM
 */

package antiplagium.view;

import antiplagium.BE.CategoriaBE;
import antiplagium.BE.DocumentoBE;
import antiplagium.BE.UsuarioBE;
import antiplagium.BE.Utilitario;
import antiplagium.BL.CategoriaBL;
import antiplagium.BL.DocumentoBL;
import antiplagium.DAO.CategoriaDAO;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.postgresql.core.Logger;

/**
 *
 * @author PATTY
 */
public class BuscarDocumento extends JDialog {

    private ArrayList<DocumentoBE> arrDocumentos = new ArrayList<DocumentoBE>();
    private CategoriaBL categoriaBl;
    private UsuarioBE objUsuario;

    public DocumentoBE docSel=null;

    /** Creates new form Documento2 */
    public BuscarDocumento() throws FileNotFoundException, IOException, SQLException {
        initComponents();
        categoriaBl=new CategoriaBL();
        CategoriaBE tmp = new CategoriaBE();
        tmp.setIdCategoria(0);
        tmp.setNombre("Todas");
        ArrayList<CategoriaBE> listaCategorias=categoriaBl.buscarCategoria("", "");
        listaCategorias.add(0 , tmp);
        int cantidadCategorias=listaCategorias.size();

        for(int i=0;i<cantidadCategorias;i++){
            cboCategoria.addItem(listaCategorias.get(i).getNombre());
        }
    }

    public BuscarDocumento(UsuarioBE objUsuario) throws FileNotFoundException, IOException, SQLException {
        initComponents();
        this.objUsuario = objUsuario;

        categoriaBl=new CategoriaBL();
        CategoriaBE tmp = new CategoriaBE();
        tmp.setIdCategoria(0);
        tmp.setNombre("Todas");
        ArrayList<CategoriaBE> listaCategorias=categoriaBl.buscarCategoria("", "");
        listaCategorias.add(0 , tmp);
        int cantidadCategorias=listaCategorias.size();

        for(int i=0;i<cantidadCategorias;i++){
            cboCategoria.addItem(listaCategorias.get(i));
        }
    }

   
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtabPaquetes = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        lblCategoria = new javax.swing.JLabel();
        txtNombre = new javax.swing.JFormattedTextField();
        cboCategoria = new javax.swing.JComboBox();
        btnBuscar = new javax.swing.JButton();
        lblIdUsuario = new javax.swing.JLabel();
        txtIdUsuario = new javax.swing.JFormattedTextField();
        lblEstado = new javax.swing.JLabel();
        cboEstado = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        setTitle("Búsqueda Documentos");
        setName(""); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Resultados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jtabPaquetes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre", "Categoría ", "Propietario", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtabPaquetes.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jtabPaquetes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jtabPaquetes);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Búsqueda de Documento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 255))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(0, 0, 255));
        jPanel1.setName("Búsqueda"); // NOI18N
        jPanel1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPanel1FocusGained(evt);
            }
        });

        lblNombre.setText("Nombre:");

        lblCategoria.setText("Categoría:");

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        cboCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboCategoriaActionPerformed(evt);
            }
        });

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/buscar.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setName("btnBuscar"); // NOI18N
        btnBuscar.setPreferredSize(new java.awt.Dimension(97, 33));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        lblIdUsuario.setText("ID Propietario");

        txtIdUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdUsuarioActionPerformed(evt);
            }
        });
        txtIdUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIdUsuarioKeyReleased(evt);
            }
        });

        lblEstado.setText("Estado");

        cboEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "activo", "inactivo" }));
        cboEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboEstadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombre)
                    .addComponent(lblCategoria)
                    .addComponent(lblIdUsuario)
                    .addComponent(lblEstado))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cboEstado, 0, 150, Short.MAX_VALUE)
                        .addContainerGap(234, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtIdUsuario)
                            .addComponent(cboCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombre)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCategoria)
                            .addComponent(cboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblIdUsuario)
                            .addComponent(txtIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEstado)
                            .addComponent(cboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/salir.png"))); // NOI18N
        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/buscar.png"))); // NOI18N
        jButton2.setText("Ver Contenido");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/aceptar.png"))); // NOI18N
        jButton5.setText("Aceptar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/nuevo.png"))); // NOI18N
        jMenu1.setText("Nuevo");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenu1MousePressed(evt);
            }
        });
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/modificar.png"))); // NOI18N
        jMenu2.setText("Modificar");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenu2MousePressed(evt);
            }
        });
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Modificar(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Eliminar - 16.png"))); // NOI18N
        jMenu3.setText("Eliminar");
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenu3MousePressed(evt);
            }
        });
        jMenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu3ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addGap(31, 31, 31)
                .addComponent(jButton1)
                .addGap(33, 33, 33))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton5)
                    .addComponent(jButton2))
                .addGap(26, 26, 26))
        );

        jPanel1.getAccessibleContext().setAccessibleName("Búsqueda");
        jPanel1.getAccessibleContext().setAccessibleDescription("Búsqueda");

        getAccessibleContext().setAccessibleName("Búsqueda");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_txtNombreActionPerformed

    private void cboCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboCategoriaActionPerformed
       
           // TODO add your handling code here:
}//GEN-LAST:event_cboCategoriaActionPerformed




    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        String objEstado;
        CategoriaBE objCategoria = null;
        UsuarioBE objUsuario = null;
        /* Si la categoria es todas el objeto debe ser nulo, no especificado */
        objCategoria= (CategoriaBE) this.cboCategoria.getSelectedItem();
        if (objCategoria.getNombre().compareTo("Todas") == 0){
            objCategoria = null;
        }
        /* Si se especifico un IdUsuario se crea el usuario */
        if (this.txtIdUsuario.getText().compareTo("") != 0){
            objUsuario = new UsuarioBE();
            objUsuario.setIdUsuario(Integer.parseInt(this.txtIdUsuario.getText()));
        }
        DocumentoBE objDocumento = new DocumentoBE();
        objDocumento.setUsuario(objUsuario);
        objDocumento.setCategoria(objCategoria);
        objDocumento.setNombre(this.txtNombre.getText());
        objEstado = (String) this.cboEstado.getSelectedItem();
        objDocumento.setEstado(objEstado);
        try {
            this.arrDocumentos = DocumentoBL.ListarDocs(objDocumento);
            /* Obtenemos el modelo */
            DefaultTableModel tmp = (DefaultTableModel) this.jtabPaquetes.getModel();
            /* Limpiamos la tabla */
            for (int i=tmp.getRowCount() - 1; i >= 0; --i){
                tmp.removeRow(i);
            }
            /* Llenamos la grilla */
            for (int i=0; i < arrDocumentos.size() ; ++i){
                Object [] nuevo={ arrDocumentos.get(i).getIdDocumento() , arrDocumentos.get(i).getNombre() , arrDocumentos.get(i).getCategoria().getIdCategoria() , arrDocumentos.get(i).getUsuario().getIdUsuario() , arrDocumentos.get(i).getEstado()  };
                tmp.addRow(nuevo);
            }
            if (this.arrDocumentos.size() == 0){
                 JOptionPane.showMessageDialog(this, "La búsqueda no encontro ningún resultado", "Buscar Documento", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (FileNotFoundException ex) {
            java.util.logging.Logger.getLogger(BuscarDocumento.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(BuscarDocumento.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(BuscarDocumento.class.getName()).log(Level.SEVERE, null, ex);
        }
               
}//GEN-LAST:event_btnBuscarActionPerformed



    private void jPanel1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPanel1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1FocusGained

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
           RegistrarDocumento regdoc = new RegistrarDocumento(this.objUsuario);
           regdoc.setVisible(true);
            // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenu1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MousePressed
        // TODO add your handling code here:
         RegistrarDocumento regdoc = new RegistrarDocumento(this.objUsuario);
         regdoc.setVisible(true);
         regdoc.setTitle("Registrar Documento");
    }//GEN-LAST:event_jMenu1MousePressed


    //Modificar!

    private void jMenu2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MousePressed
        // TODO add your handling code here:
        int idx = this.jtabPaquetes.getSelectedRow();
        if ( idx < 0){
            JOptionPane.showMessageDialog(this, "Debe seleccionar una fila", "Mensaje",0);
        }
        else {
              //System.out.println(this.arrDocumentos.get(this.jtabPaquetes.getSelectedRow()).getIdDocumento());
              ModificarDocumento vModificarDoc = null;
            try {

                if (this.objUsuario.getIdUsuario() != this.arrDocumentos.get(idx).getUsuario().getIdUsuario()){
                    JOptionPane.showMessageDialog(this, "Debe ser propietario del documento para modificar sus datos", "Error Modificar Documento", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                vModificarDoc = new ModificarDocumento(this.arrDocumentos.get(idx));
            } catch (FileNotFoundException ex) {
                java.util.logging.Logger.getLogger(BuscarDocumento.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                java.util.logging.Logger.getLogger(BuscarDocumento.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(BuscarDocumento.class.getName()).log(Level.SEVERE, null, ex);
            }
              vModificarDoc.setVisible(true);
              vModificarDoc.setTitle("Modificar Documento");
               
            }
    }//GEN-LAST:event_jMenu2MousePressed

    private void txtIdUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdUsuarioActionPerformed

    private void cboEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboEstadoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int idx = this.jtabPaquetes.getSelectedRow();
        if (idx >= 0){
            String contenido = this.arrDocumentos.get(idx).getContenido();
            JFVisualizarDocumento vis = new JFVisualizarDocumento(contenido);
            vis.setModal(true);
            vis.setVisible(true);
        }
        else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un documento antes", "Error Mostrar Contenido", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jMenu3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MousePressed
        // TODO add your handling code here:
        if (this.jtabPaquetes.getSelectedRowCount()!=1)
           JOptionPane.showMessageDialog(null, "Debe seleccionar un documento antes", "Error Eliminar", JOptionPane.ERROR_MESSAGE);
        else
        {
            DocumentoBL objDocumentoBL = new DocumentoBL();
            boolean result = objDocumentoBL.eliminar(this.arrDocumentos.get(this.jtabPaquetes.getSelectedRow()).getIdDocumento());
            if (result)
                    JOptionPane.showMessageDialog(null, "El Documento se elimino con éxito", "Mensaje",0);
        }
        
    }//GEN-LAST:event_jMenu3MousePressed

    private void txtIdUsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdUsuarioKeyReleased
        // TODO add your handling code here:
        Character caracter = new Character(evt.getKeyChar());
        if (!Utilitario.esDigito(caracter)) {
            String texto = "";
            for (int i = 0; i < this.txtIdUsuario.getText().length(); i++)
                if (Utilitario.esDigito(new Character(this.txtIdUsuario.getText().charAt(i))))
                    texto += this.txtIdUsuario.getText().charAt(i);
            this.txtIdUsuario.setText(texto);
            this.txtIdUsuario.getToolkit().beep();
        }
    }//GEN-LAST:event_txtIdUsuarioKeyReleased


    /*Eliminar*/

    private void jMenu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu3ActionPerformed
         

    }//GEN-LAST:event_jMenu3ActionPerformed

    private void Modificar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Modificar
       
    }//GEN-LAST:event_Modificar

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        int idx = this.jtabPaquetes.getSelectedRow();
        if (idx >= 0){
            docSel = this.arrDocumentos.get(idx);

        }
        else {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ningún documento.", "Error", JOptionPane.ERROR_MESSAGE);
        }


        this.setVisible(false);
}//GEN-LAST:event_jButton5ActionPerformed

    public String getNombreDocSeleccionado(){
        return this.selectedDoc;
    }

    /**
    * @param args the command line arguments
    */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JComboBox cboCategoria;
    private javax.swing.JComboBox cboEstado;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    public javax.swing.JMenu jMenu1;
    public javax.swing.JMenu jMenu2;
    public javax.swing.JMenu jMenu3;
    public javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtabPaquetes;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblIdUsuario;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JFormattedTextField txtIdUsuario;
    private javax.swing.JFormattedTextField txtNombre;
    // End of variables declaration//GEN-END:variables
    private String selectedDoc;

}
