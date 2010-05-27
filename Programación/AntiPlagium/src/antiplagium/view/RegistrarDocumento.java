/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * RegistrarDocumento.java
 *
 * Created on 01/05/2010, 03:58:24 PM
 */
package antiplagium.view;

import antiplagium.BE.Utilitario;
import antiplagium.BL.DocumentoBL;
import antiplagium.DAO.DocumentoDAO;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
//import org.freixas.jcalendar.JCalendarCombo;

/**
 *
 * @author PATTY
 */
public class RegistrarDocumento extends JFrame {


    //    private JCalendarCombo cmbFechaInicio;
    /** Creates new form RegistrarDocumento */
    public RegistrarDocumento() {

        //    cmbFechaInicio=new JCalendarCombo();

        initComponents();

        //  cmbFechaInicio.setSize(220,25);
        //   jPanel3.add(cmbFechaInicio);

    }

    private void cargarArchivo(int numDoc, String nomArch) {
        switch (numDoc) {
            case 1:
                this.txtRuta11.setText(nomArch);
                break;
            case 2:
                this.txtRuta22.setText(nomArch);
                break;
            case 3:
                this.txtRuta33.setText(nomArch);
                break;
            case 4:
                this.txtRuta44.setText(nomArch);
                break;
            case 5:
                this.txtRuta55.setText(nomArch);
                break;
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

        btnLimpiar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombreDoc1 = new javax.swing.JTextField();
        txtRuta11 = new javax.swing.JTextField();
        btnBuscar1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtNombreDoc2 = new javax.swing.JTextField();
        txtRuta22 = new javax.swing.JTextField();
        btnBuscar2 = new javax.swing.JButton();
        txtNombreDoc3 = new javax.swing.JTextField();
        txtRuta33 = new javax.swing.JTextField();
        btnBuscar3 = new javax.swing.JButton();
        txtNombreDoc4 = new javax.swing.JTextField();
        txtRuta44 = new javax.swing.JTextField();
        btnBuscar4 = new javax.swing.JButton();
        txtNombreDoc5 = new javax.swing.JTextField();
        txtRuta55 = new javax.swing.JTextField();
        btnBuscar5 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtPropietario = new javax.swing.JTextField();

        setTitle("Registrar Documento");
        setMinimumSize(new java.awt.Dimension(447, 447));

        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/limpiar.png"))); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/aceptar.png"))); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cancelar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Documentos"));

        jLabel1.setText("Nombre:");

        txtNombreDoc1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreDoc1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreDoc1KeyReleased(evt);
            }
        });

        txtRuta11.setEnabled(false);

        btnBuscar1.setText("Buscar");
        btnBuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscar1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Ruta:");

        txtNombreDoc2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreDoc2KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreDoc2KeyReleased(evt);
            }
        });

        txtRuta22.setEnabled(false);

        btnBuscar2.setText("Buscar");
        btnBuscar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscar2ActionPerformed(evt);
            }
        });

        txtNombreDoc3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreDoc3KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreDoc3KeyReleased(evt);
            }
        });

        txtRuta33.setEnabled(false);

        btnBuscar3.setText("Buscar");
        btnBuscar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscar3ActionPerformed(evt);
            }
        });

        txtNombreDoc4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreDoc4KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreDoc4KeyReleased(evt);
            }
        });

        txtRuta44.setEnabled(false);

        btnBuscar4.setText("Buscar");
        btnBuscar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscar4ActionPerformed(evt);
            }
        });

        txtNombreDoc5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreDoc5KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreDoc5KeyReleased(evt);
            }
        });

        txtRuta55.setEnabled(false);

        btnBuscar5.setText("Buscar");
        btnBuscar5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscar5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(txtNombreDoc1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(txtRuta11, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBuscar1)
                                .addGap(57, 57, 57))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addContainerGap(379, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtNombreDoc2, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(txtRuta22, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar2)
                        .addGap(57, 57, 57))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtNombreDoc3, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(txtRuta33, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar3)
                        .addGap(57, 57, 57))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtNombreDoc4, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(txtRuta44, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar4)
                        .addGap(57, 57, 57))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtNombreDoc5, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(txtRuta55, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar5)
                        .addGap(57, 57, 57))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreDoc1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRuta11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreDoc2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRuta22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreDoc3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRuta33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreDoc4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRuta44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreDoc5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRuta55, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos generales"));

        jLabel6.setText("Propietario:");

        jLabel12.setText("Categoría:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ingenieria Informatica", "Derecho", "Filosofia", "Arte" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel13.setText("Fecha de registro:");

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setPreferredSize(new java.awt.Dimension(220, 25));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 185, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );

        txtPropietario.setEnabled(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPropietario, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE))
                .addGap(24, 24, 24)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(93, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(540, Short.MAX_VALUE)
                .addComponent(btnLimpiar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAceptar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar)
                .addGap(48, 48, 48))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        DocumentoBL doc1=null,doc2=null,doc3=null,doc4=null,doc5=null;
        if (this.txtRuta11.getText().compareToIgnoreCase("") != 0) {
            if (this.txtNombreDoc1.getText().compareTo("") == 0) {
                JOptionPane.showMessageDialog(null, "Se debe indicar un nombre para el archivo 1.");
            } else {
                File file1 = new File(this.txtRuta11.getText());
                String contenido = DocumentoBL.obtenerContenido(file1);
                doc1 = new DocumentoBL(contenido);
            }
        }

        if (this.txtRuta22.getText().compareToIgnoreCase("") != 0) {
            if (this.txtNombreDoc2.getText().compareTo("") == 0) {
                JOptionPane.showMessageDialog(null, "Se debe indicar un nombre para el archivo 2.");
            } else {
                File file1 = new File(this.txtRuta22.getText());
                String contenido = DocumentoBL.obtenerContenido(file1);
                doc2 = new DocumentoBL(contenido);
            }
        }

        if (this.txtRuta33.getText().compareToIgnoreCase("") != 0) {
            if (this.txtNombreDoc3.getText().compareTo("") == 0) {
                JOptionPane.showMessageDialog(null, "Se debe indicar un nombre para el archivo 3.");
            } else {
                File file1 = new File(this.txtRuta33.getText());
                String contenido = DocumentoBL.obtenerContenido(file1);
                doc3 = new DocumentoBL(contenido);
            }
        }

        if (this.txtRuta44.getText().compareToIgnoreCase("") != 0) {
            if (this.txtNombreDoc4.getText().compareTo("") == 0) {
                JOptionPane.showMessageDialog(null, "Se debe indicar un nombre para el archivo 4.");
            } else {
                File file1 = new File(this.txtRuta44.getText());
                String contenido = DocumentoBL.obtenerContenido(file1);
                doc4 = new DocumentoBL(contenido);
            }
        }

        if (this.txtRuta55.getText().compareToIgnoreCase("") != 0) {
            if (this.txtNombreDoc5.getText().compareTo("") == 0) {
                JOptionPane.showMessageDialog(null, "Se debe indicar un nombre para el archivo 5.");
            } else {
                File file1 = new File(this.txtRuta55.getText());
                String contenido = DocumentoBL.obtenerContenido(file1);
                doc5 = new DocumentoBL(contenido);
            }
        }
        DocumentoDAO docDao = new DocumentoDAO();
        if (doc1!=null){
            try {
                docDao.registrar(doc1);
            } catch (Exception ex) {
                Logger.getLogger(RegistrarDocumento.class.getName()).log(Level.SEVERE, null, ex);
            }
        } //SERIALIZAR
        if (doc2!=null){
            try {
                docDao.registrar(doc2);
            } catch (Exception ex) {
                Logger.getLogger(RegistrarDocumento.class.getName()).log(Level.SEVERE, null, ex);
            }
        } //SERIALIZAR
        if (doc3!=null){
            try {
                docDao.registrar(doc3);
            } catch (Exception ex) {
                Logger.getLogger(RegistrarDocumento.class.getName()).log(Level.SEVERE, null, ex);
            }
        } //SERIALIZAR
        if (doc4!=null){
            try {
                docDao.registrar(doc4);
            } catch (Exception ex) {
                Logger.getLogger(RegistrarDocumento.class.getName()).log(Level.SEVERE, null, ex);
            }
        } //SERIALIZAR
        if (doc5!=null){
            try {
                docDao.registrar(doc5);
            } catch (Exception ex) {
                Logger.getLogger(RegistrarDocumento.class.getName()).log(Level.SEVERE, null, ex);
            }
        } //SERIALIZAR
}//GEN-LAST:event_btnAceptarActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jComboBox1ActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);

}//GEN-LAST:event_btnCancelarActionPerformed


    //Cargando el archivo txt!!!!
    private void btnBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar1ActionPerformed

        JFileChooser chooser = new JFileChooser();
        chooser.setApproveButtonText("Cargar");
        //chooser.addChoosableFileFilter(new TxTFilter());
        int retVal = chooser.showOpenDialog(this);
        if (retVal == chooser.APPROVE_OPTION) {
            String nomArch = chooser.getSelectedFile().getAbsolutePath();
            this.cargarArchivo(1, nomArch);

        }

    }//GEN-LAST:event_btnBuscar1ActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        this.txtRuta11.setText("");
        this.txtRuta22.setText("");
        this.txtRuta33.setText("");
        this.txtRuta44.setText("");
        this.txtRuta55.setText("");

        this.txtNombreDoc1.setText("");
        this.txtNombreDoc2.setText("");
        this.txtNombreDoc3.setText("");
        this.txtNombreDoc4.setText("");
        this.txtNombreDoc5.setText("");


    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void txtNombreDoc1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreDoc1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreDoc1KeyPressed

    private void txtNombreDoc1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreDoc1KeyReleased
        // TODO add your handling code here:
       /* Character caracter = new Character(evt.getKeyChar());
        if (Utilitario.esAlphanumerico(caracter)) {
        String texto = "";
        for (int i = 0; i < this.txtNombreDoc.getText().length(); i++)
        if (Utilitario.esAlphanumerico(new Character(this.txtNombreDoc.getText().charAt(i))))
        texto += this.txtNombreDoc.getText().charAt(i);
        this.txtNombreDoc.setText(texto);
        this.txtNombreDoc.getToolkit().beep();
        }*/
    }//GEN-LAST:event_txtNombreDoc1KeyReleased

    private void txtNombreDoc2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreDoc2KeyPressed
        // TODO add your handling code here:
}//GEN-LAST:event_txtNombreDoc2KeyPressed

    private void txtNombreDoc2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreDoc2KeyReleased
        // TODO add your handling code here:
}//GEN-LAST:event_txtNombreDoc2KeyReleased

    private void btnBuscar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar2ActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setApproveButtonText("Cargar");
        //chooser.addChoosableFileFilter(new TxTFilter());
        int retVal = chooser.showOpenDialog(this);
        if (retVal == chooser.APPROVE_OPTION) {
            String nomArch = chooser.getSelectedFile().getAbsolutePath();
            this.cargarArchivo(2, nomArch);

        }
    }//GEN-LAST:event_btnBuscar2ActionPerformed

    private void txtNombreDoc3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreDoc3KeyPressed
        // TODO add your handling code here:
}//GEN-LAST:event_txtNombreDoc3KeyPressed

    private void txtNombreDoc3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreDoc3KeyReleased
        // TODO add your handling code here:
}//GEN-LAST:event_txtNombreDoc3KeyReleased

    private void btnBuscar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar3ActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setApproveButtonText("Cargar");
        //chooser.addChoosableFileFilter(new TxTFilter());
        int retVal = chooser.showOpenDialog(this);
        if (retVal == chooser.APPROVE_OPTION) {
            String nomArch = chooser.getSelectedFile().getAbsolutePath();
            this.cargarArchivo(3, nomArch);

        }
    }//GEN-LAST:event_btnBuscar3ActionPerformed

    private void txtNombreDoc4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreDoc4KeyPressed
        // TODO add your handling code here:
}//GEN-LAST:event_txtNombreDoc4KeyPressed

    private void txtNombreDoc4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreDoc4KeyReleased
        // TODO add your handling code here:
}//GEN-LAST:event_txtNombreDoc4KeyReleased

    private void btnBuscar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar4ActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setApproveButtonText("Cargar");
        //chooser.addChoosableFileFilter(new TxTFilter());
        int retVal = chooser.showOpenDialog(this);
        if (retVal == chooser.APPROVE_OPTION) {
            String nomArch = chooser.getSelectedFile().getAbsolutePath();
            this.cargarArchivo(4, nomArch);

        }
    }//GEN-LAST:event_btnBuscar4ActionPerformed

    private void txtNombreDoc5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreDoc5KeyPressed
        // TODO add your handling code here:
}//GEN-LAST:event_txtNombreDoc5KeyPressed

    private void txtNombreDoc5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreDoc5KeyReleased
        // TODO add your handling code here:
}//GEN-LAST:event_txtNombreDoc5KeyReleased

    private void btnBuscar5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar5ActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setApproveButtonText("Cargar");
        //chooser.addChoosableFileFilter(new TxTFilter());
        int retVal = chooser.showOpenDialog(this);
        if (retVal == chooser.APPROVE_OPTION) {
            String nomArch = chooser.getSelectedFile().getAbsolutePath();
            this.cargarArchivo(5, nomArch);

        }
    }//GEN-LAST:event_btnBuscar5ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnBuscar1;
    private javax.swing.JButton btnBuscar2;
    private javax.swing.JButton btnBuscar3;
    private javax.swing.JButton btnBuscar4;
    private javax.swing.JButton btnBuscar5;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField txtNombreDoc1;
    private javax.swing.JTextField txtNombreDoc2;
    private javax.swing.JTextField txtNombreDoc3;
    private javax.swing.JTextField txtNombreDoc4;
    private javax.swing.JTextField txtNombreDoc5;
    private javax.swing.JTextField txtPropietario;
    private javax.swing.JTextField txtRuta11;
    private javax.swing.JTextField txtRuta22;
    private javax.swing.JTextField txtRuta33;
    private javax.swing.JTextField txtRuta44;
    private javax.swing.JTextField txtRuta55;
    // End of variables declaration//GEN-END:variables
}
