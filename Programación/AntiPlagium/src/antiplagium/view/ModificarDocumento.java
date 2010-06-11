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
public class ModificarDocumento extends JDialog {

private CategoriaBL categoriaBl;
private DocumentoBE objDocumento ;
private DocumentoBL objDocumentoBL;
private HashMap<Integer,Integer> idxToId = new HashMap<Integer,Integer>();
    /** Creates new form ModificarDocumento */

    public ModificarDocumento(DocumentoBE objDocumento) throws FileNotFoundException, IOException, SQLException{

        initComponents();
        this.objDocumento = objDocumento;
        objDocumentoBL = new DocumentoBL();
        ArrayList<CategoriaBE> listaCategorias = this.objDocumento.getUsuario().getCategorias();
        int cantidadCategorias=listaCategorias.size();
        for(int i=0;i<cantidadCategorias;i++){
            idxToId.put(listaCategorias.get(i).getIdCategoria(), i);
            ComboCategoria.addItem(listaCategorias.get(i));
        }
        int idx = this.idxToId.get(this.objDocumento.getCategoria().getIdCategoria());
        this.ComboCategoria.setSelectedIndex(idx);
        txtIdDocumento.setText(toString().valueOf(objDocumento.getIdDocumento()));
        txtNombreDoc.setText(objDocumento.getNombre());
        txtPropietario.setText(objDocumento.getUsuario().getNombres());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtIdDocumento = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNombreDoc = new javax.swing.JTextField();
        txtPropietario = new javax.swing.JTextField();
        ComboCategoria = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Id Documento");

        txtIdDocumento.setEditable(false);

        jLabel2.setText("Nombre");

        jLabel3.setText("Categoría");

        jLabel4.setText("Propietario");

        txtPropietario.setEnabled(false);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/guardar.png"))); // NOI18N
        jButton1.setText("Guardar");
        jButton1.setAlignmentY(0.0F);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/salir.png"))); // NOI18N
        jButton2.setText("Salir");
        jButton2.setAlignmentY(0.0F);
        jButton2.setMaximumSize(new java.awt.Dimension(64, 33));
        jButton2.setPreferredSize(new java.awt.Dimension(83, 33));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/limpiar.png"))); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/modDoc.png"))); // NOI18N
        jButton3.setText("Cambiar Texto");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
                        .addComponent(jLabel1)
                        .addComponent(jLabel4)
                        .addComponent(jLabel3))
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ComboCategoria, javax.swing.GroupLayout.Alignment.LEADING, 0, 186, Short.MAX_VALUE)
                    .addComponent(txtPropietario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                    .addComponent(txtNombreDoc, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                    .addComponent(txtIdDocumento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(txtIdDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombreDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(ComboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(txtPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       if (this.txtIdDocumento.getText().compareTo("")==0){
            JOptionPane.showMessageDialog(this, "El campo idDocumento no puede ser vacio", "Error Modificar Documento", JOptionPane.ERROR_MESSAGE);
       }
       else if (this.txtNombreDoc.getText().compareTo("")==0){
            JOptionPane.showMessageDialog(this, "El campo nombre no puede ser vacio", "Error Modificar Documento", JOptionPane.ERROR_MESSAGE);
       }
       else if (this.txtPropietario.getText().compareTo("")==0){
           JOptionPane.showMessageDialog(this, "El campo propietario no puede ser vacio", "Error Modificar Documento", JOptionPane.ERROR_MESSAGE);
       }
       else {
            DocumentoBE nuevo = new DocumentoBE();
            nuevo.setIdDocumento(this.objDocumento.getIdDocumento());
            nuevo.setCategoria((CategoriaBE)this.ComboCategoria.getSelectedItem());
            nuevo.setNombre(this.txtNombreDoc.getText());
            nuevo.setContenido(this.objDocumento.getContenido());
            if (DocumentoBL.modificar(nuevo)){
                JOptionPane.showMessageDialog(this, "El documento fue modificado con exito", "Modificar Documento", JOptionPane.INFORMATION_MESSAGE);
            }
            else {
                JOptionPane.showMessageDialog(this, "Hubo un error al modificar el documento , operación cancelada", "Error Modificar Documento", JOptionPane.ERROR_MESSAGE);
            }
            this.dispose();
       }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        this.txtNombreDoc.setText(this.objDocumento.getNombre());
        int idx = this.idxToId.get(this.objDocumento.getCategoria().getIdCategoria());
        this.ComboCategoria.setSelectedIndex(idx);
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        JFVisualizarDocumento visDoc = new JFVisualizarDocumento(this,objDocumento.getContenido());
        visDoc.setTitle("Texto documento");
        visDoc.setModal(true);
        visDoc.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    public void setContenidoDoc(String texto){
        this.objDocumento.setContenido(texto);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox ComboCategoria;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtIdDocumento;
    private javax.swing.JTextField txtNombreDoc;
    private javax.swing.JTextField txtPropietario;
    // End of variables declaration//GEN-END:variables

}