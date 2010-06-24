/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ModificarDocumento.java
 *
 * Created on 01/06/2010, 07:49:15 PM
 */

package antiplagium.view;

import antiplagium.BE.CategoriaBE;
import antiplagium.BE.DocumentoBE;
import antiplagium.BL.CategoriaBL;
import antiplagium.BL.DocumentoBL;
import java.awt.BorderLayout;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author PATTY
 */
public class JDModificarDocumento extends JDialog {

private CategoriaBL objCategoriaBL;
private DocumentoBE objDocumento ;
private DocumentoBL objDocumentoBL;
private HashMap<Integer,Integer> hsmpIdxToId = new HashMap<Integer,Integer>();
private ArrayList<CategoriaBE> alstCategorias;
    /** Creates new form ModificarDocumento */

    public JDModificarDocumento(DocumentoBE objDocumento,ArrayList<CategoriaBE> listaCategorias) throws FileNotFoundException, IOException, SQLException{
        initComponents();
        this.objDocumento = objDocumento;
        objDocumentoBL = new DocumentoBL();
        alstCategorias = listaCategorias;
        int cantidadCategorias = alstCategorias.size();
        for(int i=0;i<cantidadCategorias;i++){
            hsmpIdxToId.put(alstCategorias.get(i).getIdCategoria(), i);
            cboCategoria.addItem(listaCategorias.get(i));
        }
        /* Falta llenar la matriz de Documentos */
        int idx = this.hsmpIdxToId.get(this.objDocumento.getCategoria().getIdCategoria());
        cboCategoria.setSelectedIndex(idx);
        txtIdDocumento.setText(toString().valueOf(objDocumento.getIdDocumento()));
        txtNombreDoc.setText(objDocumento.getNombre());
        txtPropietario.setText(objDocumento.getUsuario().getNombres());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblIdDocumento = new javax.swing.JLabel();
        txtIdDocumento = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        lblCategoria = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        txtNombreDoc = new javax.swing.JTextField();
        txtPropietario = new javax.swing.JTextField();
        cboCategoria = new javax.swing.JComboBox();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnModificarTexto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        lblIdDocumento.setText("Id Documento");

        txtIdDocumento.setEditable(false);

        lblNombre.setText("Nombre");

        lblCategoria.setText("Categoría");

        lblUsuario.setText("Propietario");

        txtPropietario.setEnabled(false);

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/guardar.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setAlignmentY(0.0F);
        btnGuardar.setMaximumSize(new java.awt.Dimension(135, 35));
        btnGuardar.setMinimumSize(new java.awt.Dimension(135, 35));
        btnGuardar.setPreferredSize(new java.awt.Dimension(135, 35));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/salir.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setAlignmentY(0.0F);
        btnCancelar.setMaximumSize(new java.awt.Dimension(135, 35));
        btnCancelar.setMinimumSize(new java.awt.Dimension(135, 35));
        btnCancelar.setPreferredSize(new java.awt.Dimension(135, 35));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/limpiar.png"))); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.setMaximumSize(new java.awt.Dimension(135, 35));
        btnLimpiar.setMinimumSize(new java.awt.Dimension(135, 35));
        btnLimpiar.setPreferredSize(new java.awt.Dimension(135, 35));
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnModificarTexto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/modDoc.png"))); // NOI18N
        btnModificarTexto.setText("Modificar Texto");
        btnModificarTexto.setMaximumSize(new java.awt.Dimension(135, 35));
        btnModificarTexto.setMinimumSize(new java.awt.Dimension(135, 35));
        btnModificarTexto.setPreferredSize(new java.awt.Dimension(135, 35));
        btnModificarTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarTextoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombre)
                            .addComponent(lblIdDocumento)
                            .addComponent(lblCategoria)
                            .addComponent(lblUsuario))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIdDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cboCategoria, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtNombreDoc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                                .addComponent(txtPropietario, javax.swing.GroupLayout.Alignment.TRAILING))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(btnModificarTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIdDocumento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCategoria))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUsuario))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificarTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
       if (txtIdDocumento.getText().compareTo("")==0){
            JOptionPane.showMessageDialog(this, "El campo idDocumento no puede ser vacio", "Error Modificar Documento", JOptionPane.ERROR_MESSAGE);
       }
       else if (txtNombreDoc.getText().compareTo("")==0){
            JOptionPane.showMessageDialog(this, "El campo nombre no puede ser vacio", "Error Modificar Documento", JOptionPane.ERROR_MESSAGE);
       }
       else if (txtPropietario.getText().compareTo("")==0){
           JOptionPane.showMessageDialog(this, "El campo propietario no puede ser vacio", "Error Modificar Documento", JOptionPane.ERROR_MESSAGE);
       }
       else {
            DocumentoBE objDocumentoNuevo = new DocumentoBE();
            objDocumentoNuevo.setIdDocumento(objDocumento.getIdDocumento());
            objDocumentoNuevo.setCategoria((CategoriaBE)cboCategoria.getSelectedItem());
            objDocumentoNuevo.setNombre(txtNombreDoc.getText());
            objDocumentoNuevo.setContenido(objDocumento.getContenido());
            if (DocumentoBL.modificar(objDocumentoNuevo)){
                JOptionPane.showMessageDialog(this, "El documento fue modificado con exito", "Modificar Documento", JOptionPane.INFORMATION_MESSAGE);
            }
            else {
                JOptionPane.showMessageDialog(this, "Hubo un error al modificar el documento , operación cancelada", "Error Modificar Documento", JOptionPane.ERROR_MESSAGE);
            }
            this.dispose();
       }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        txtNombreDoc.setText(objDocumento.getNombre());
        int idx = hsmpIdxToId.get(objDocumento.getCategoria().getIdCategoria());
        cboCategoria.setSelectedIndex(idx);
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnModificarTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarTextoActionPerformed
        // TODO add your handling code here:
        JDVisualizarDocumento visualizarDocumento = new JDVisualizarDocumento(this,objDocumento.getContenido());
        visualizarDocumento.setTitle("Texto documento");
        visualizarDocumento.setModal(true);
        visualizarDocumento.setLocationRelativeTo(this);
        visualizarDocumento.setVisible(true);
        //visualizarDocumento.btnSalir.setText("Cancelar"); COMENTADO X SUBIR CON ERROR
    }//GEN-LAST:event_btnModificarTextoActionPerformed

    public void setContenidoDoc(String texto){
        this.objDocumento.setContenido(texto);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificarTexto;
    private javax.swing.JComboBox cboCategoria;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblIdDocumento;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JTextField txtIdDocumento;
    private javax.swing.JTextField txtNombreDoc;
    private javax.swing.JTextField txtPropietario;
    // End of variables declaration//GEN-END:variables

}
