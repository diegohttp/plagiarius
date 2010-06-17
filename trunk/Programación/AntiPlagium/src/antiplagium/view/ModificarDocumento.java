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
private ArrayList<CategoriaBE> listaCategorias;
private ArrayList<Boolean> catSeleccionada = new ArrayList<Boolean>();
    /** Creates new form ModificarDocumento */

    public ModificarDocumento(DocumentoBE objDocumento,ArrayList<CategoriaBE> listaCategorias) throws FileNotFoundException, IOException, SQLException{

        initComponents();
        this.objDocumento = objDocumento;
        objDocumentoBL = new DocumentoBL();
        this.listaCategorias = listaCategorias;
        int cantidadCategorias= this.listaCategorias.size();
        for(int i=0;i<cantidadCategorias;i++){
            idxToId.put(this.listaCategorias.get(i).getIdCategoria(), i);
            ComboCategoria.addItem(listaCategorias.get(i));
        }
        /* Falta llenar la matriz de Documentos */
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
        setResizable(false);

        jLabel1.setText("Id Documento");

        txtIdDocumento.setEditable(false);

        jLabel2.setText("Nombre");

        jLabel3.setText("Categoría");

        jLabel4.setText("Propietario");

        txtPropietario.setEnabled(false);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/guardar.png"))); // NOI18N
        jButton1.setText("Guardar");
        jButton1.setAlignmentY(0.0F);
        jButton1.setMaximumSize(new java.awt.Dimension(135, 35));
        jButton1.setMinimumSize(new java.awt.Dimension(135, 35));
        jButton1.setPreferredSize(new java.awt.Dimension(135, 35));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/salir.png"))); // NOI18N
        jButton2.setText("Cancelar");
        jButton2.setAlignmentY(0.0F);
        jButton2.setMaximumSize(new java.awt.Dimension(135, 35));
        jButton2.setMinimumSize(new java.awt.Dimension(135, 35));
        jButton2.setPreferredSize(new java.awt.Dimension(135, 35));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
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

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/modDoc.png"))); // NOI18N
        jButton3.setText("Modificar Texto");
        jButton3.setMaximumSize(new java.awt.Dimension(135, 35));
        jButton3.setMinimumSize(new java.awt.Dimension(135, 35));
        jButton3.setPreferredSize(new java.awt.Dimension(135, 35));
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIdDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(ComboCategoria, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtNombreDoc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                                .addComponent(txtPropietario, javax.swing.GroupLayout.Alignment.TRAILING))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
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
        visDoc.setLocationRelativeTo(this);
        visDoc.setVisible(true);
        //visDoc.btnSalir.setText("Cancelar"); COMENTADO X SUBIR CON ERROR
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
