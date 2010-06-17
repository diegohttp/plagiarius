/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * RegistrarCategoria.java
 *
 * Created on 01/05/2010, 04:19:50 PM
 */

package antiplagium.view;

import antiplagium.BE.CategoriaBE;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.freixas.jcalendar.JCalendarCombo;
import antiplagium.BE.Utilitario;
import javax.swing.JOptionPane;
import antiplagium.BL.CategoriaBL;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JFrame;
/**
 *
 * @author PATTY
 */


public class RegistrarCategoria extends JDialog {
    private int TipoOperacion;
    private CategoriaBE objCategoria;
    /** Creates new form RegistrarCategoria */
    public RegistrarCategoria() {
        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        TipoOperacion = 0;
        int idCategoria = 0;
        try {
            idCategoria = Utilitario.generaCodigo("Categoria");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RegistrarCategoria.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RegistrarCategoria.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.jTextField1.setText("" + idCategoria + "");
    }

    public RegistrarCategoria(CategoriaBE objCategoria){
        initComponents();
        TipoOperacion = 1;
        this.jTextField1.setText("" + objCategoria.getIdCategoria() + "");
        this.txtDescCategoria.setText(objCategoria.getDescripcion());
        this.txtNomCategoria.setText(objCategoria.getNombre());
        this.objCategoria = objCategoria;
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        btnLimpiar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtNomCategoria = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtDescCategoria = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar Categoria");
        setModal(true);
        setResizable(false);

        jLabel2.setText("Código:");

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

        jLabel6.setText("Descripción:");

        txtNomCategoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNomCategoriaKeyReleased(evt);
            }
        });

        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/aceptar.png"))); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.setMaximumSize(new java.awt.Dimension(135, 35));
        btnAceptar.setMinimumSize(new java.awt.Dimension(135, 35));
        btnAceptar.setPreferredSize(new java.awt.Dimension(135, 35));
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cancelar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setMaximumSize(new java.awt.Dimension(135, 35));
        btnCancelar.setMinimumSize(new java.awt.Dimension(135, 35));
        btnCancelar.setPreferredSize(new java.awt.Dimension(135, 35));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre:");

        txtDescCategoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDescCategoriaKeyReleased(evt);
            }
        });

        jTextField1.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtNomCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                                .addComponent(txtDescCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(146, 146, 146))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtDescCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
        /* Revisamos si los campos nombre y descripcion son vacios */
        if ((this.txtNomCategoria.getText().compareTo("") == 0)){
            JOptionPane.showMessageDialog(null,"El campo Nombre no puede ser vacio","Error Registro",JOptionPane.ERROR_MESSAGE);
            return;
        }
        else if ( (this.txtDescCategoria.getText().compareTo("") == 0) ){
            JOptionPane.showMessageDialog(null,"El campo Descripción no puede ser vacio","Error Registro",JOptionPane.ERROR_MESSAGE);
            return;
        }
        else {

            boolean boolExito = false;

            CategoriaBL categoriaBL = new CategoriaBL();
                try {
                    CategoriaBE categ = new CategoriaBE(Integer.parseInt(this.jTextField1.getText()),this.txtDescCategoria.getText(),this.txtNomCategoria.getText());
                    if (TipoOperacion==0){
                        boolExito = categoriaBL.registrarCategoria(categ);
                    }
                    else {
                        boolExito = categoriaBL.modificarCategoria(categ);
                    }
                } catch (Exception ex) {
                    Logger.getLogger(RegistrarCategoria.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (boolExito) {
                    if (TipoOperacion==0)
                        JOptionPane.showMessageDialog(this, "La categoria ha sido registrada con éxito", "Modificar Categoria",JOptionPane.INFORMATION_MESSAGE);
                    else
                        JOptionPane.showMessageDialog(this, "La categoria ha sido modificada con éxito", "Modifcar Categoria",JOptionPane.INFORMATION_MESSAGE);
                }
                this.dispose();
        }
}//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
}//GEN-LAST:event_btnCancelarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
       if (this.TipoOperacion == 1){
            txtNomCategoria.setText(this.objCategoria.getNombre());
            txtDescCategoria.setText(this.objCategoria.getDescripcion());
       }
       else {
            txtNomCategoria.setText("");
            txtDescCategoria.setText("");
       }
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void txtNomCategoriaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomCategoriaKeyReleased
        // TODO add your handling code here:
        Character caracter = new Character(evt.getKeyChar());

        if (!Utilitario.esLetra(caracter)) {
                    String texto = "";
                    for (int i = 0; i < this.txtNomCategoria.getText().length(); i++)
                        if (Utilitario.esLetra(new Character(this.txtNomCategoria.getText().charAt(i))))
                            texto += this.txtNomCategoria.getText().charAt(i);
                    this.txtNomCategoria.setText(texto);
            this.txtNomCategoria.getToolkit().beep();
        }
    }//GEN-LAST:event_txtNomCategoriaKeyReleased

    private void txtDescCategoriaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescCategoriaKeyReleased
        // TODO add your handling code here:
        Character caracter = new Character(evt.getKeyChar());

        if (!Utilitario.esAlphanumerico(caracter)) {
                    String texto = "";
                    for (int i = 0; i < this.txtDescCategoria.getText().length(); i++)
                        if (Utilitario.esAlphanumerico(new Character(this.txtDescCategoria.getText().charAt(i))))
                            texto += this.txtDescCategoria.getText().charAt(i);
                    this.txtDescCategoria.setText(texto);
            this.txtDescCategoria.getToolkit().beep();
        }
    }//GEN-LAST:event_txtDescCategoriaKeyReleased

    /**
    * @param args the command line arguments
    */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField txtDescCategoria;
    private javax.swing.JTextField txtNomCategoria;
    // End of variables declaration//GEN-END:variables

}
