/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JDCargaDocumentos.java
 *
 * Created on 10-jun-2010, 10:21:49
 */

package antiplagium.view;

import antiplagium.BE.CategoriaBE;
import antiplagium.BE.DocumentoBE;
import antiplagium.BE.GestorTiposOperacion;
import antiplagium.BE.UsuarioBE;
import antiplagium.BE.Utilitario;
import antiplagium.BL.DocumentoBL;
import antiplagium.DAL.ConexionJDBC;
import java.awt.Rectangle;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Renzo
 */
public class JDCargaDocumentos extends javax.swing.JDialog {
    /** Creates new form JDCargaDocumentos */
    private ArrayList<File> nomArch;
     
    public JDCargaDocumentos(ArrayList<File> nomArch, CategoriaBE cat, UsuarioBE us) {
        add(new PanelDocumento());
        initComponents();
        taDatosProgreso.setEditable(false);
        this.nomArch = nomArch;
    }

    public void cargarDocumentos(ArrayList<CategoriaBE> listaCategoria,UsuarioBE objUsuario){
        /* Al finalizar la descarga habilitamos el cerrado de la ventana */
        setVisible(true);
        this.pgbCargaDocumentos.setMaximum(100);
        int paso= 100/this.nomArch.size();
        String resultado;
        int valorActual = 0;
        for (int i = 0; i < nomArch.size(); ++i){
            DocumentoBE doc = null;
            try {
                int idDoc = Utilitario.generaCodigo("Documento");
                doc = new DocumentoBE(idDoc, "activo" , nomArch.get(i).getName() , objUsuario, null);
                doc.setContenido(DocumentoBL.obtenerContenido(nomArch.get(i)));
                try {
                    DocumentoBL.registrar(doc);
                    /* Si es exitosos */
                    resultado = "El archivo " + nomArch.get(i).getName() + " fue registrado con exito";
                } catch (Exception ex) {
                    resultado = "Error al registrar " + nomArch.get(i).getName() + " el archivo no fue registrado";
                    Logger.getLogger(JDRegistrarDocumento.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.taDatosProgreso.setText(this.taDatosProgreso.getText() + "\n" + resultado);
                valorActual += paso;
                this.pgbCargaDocumentos.setValue(valorActual);
                Rectangle rect = this.pgbCargaDocumentos.getBounds();
		rect.x = 0;
		rect.y = 0;
		this.pgbCargaDocumentos.paintImmediately( rect );
                rect = this.pnlDatosProgreso.getBounds();
                rect.x = 0;
                rect.y = 0;
                this.pnlDatosProgreso.paintImmediately(rect);
                /*try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(JDCargaDocumentos.class.getName()).log(Level.SEVERE, null, ex);
                }*/
            } catch (FileNotFoundException ex) {
                Logger.getLogger(JDRegistrarDocumento.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(JDRegistrarDocumento.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.btnAceptar.setEnabled(true);
    }

    public void cargarDocumentos(CategoriaBE objCategoria,UsuarioBE objUsuario){
        /* Al finalizar la descarga habilitamos el cerrado de la ventana */
        this.pgbCargaDocumentos.setMaximum(100);
        int paso= 100/this.nomArch.size();
        String resultado = "";
        int valorActual = 0;
        for (int i = 0; i < nomArch.size(); ++i){
            DocumentoBE doc = null;
            try {
                int idDoc = Utilitario.generaCodigo("Documento");
                doc = new DocumentoBE(idDoc, "activo" , nomArch.get(i).getName() , objUsuario, null);
                doc.setContenido(DocumentoBL.obtenerContenido(nomArch.get(i)));
                doc.setCategoria(objCategoria);

                try {
                    ConexionJDBC.abrirConexion();
                    if (DocumentoBL.registrar(doc)){
                        resultado = "El archivo " + nomArch.get(i).getName() + " fue registrado con exito";
                        String descripcion = GestorTiposOperacion.getTipoOperacion("registra") + "\n";
                        descripcion += "Registro nuevo:\n" + doc.getNombre() + "\n";
                        descripcion += "Estado: " + doc.getEstado();
                        JFBase.setOperacion(this.getName(), GestorTiposOperacion.getTipoOperacion("registra"), descripcion);
                        JFBase.registrarOperacion();
                        ConexionJDBC.cerrarConexion();
                    }
                    else {
                        resultado = "Error al registrar " + nomArch.get(i).getName() + " el archivo no fue registrado";
                    }
                } catch (Exception ex) {
                    Logger.getLogger(JDRegistrarDocumento.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.taDatosProgreso.setText(this.taDatosProgreso.getText() + "\n" + resultado);
                valorActual += paso;
                this.pgbCargaDocumentos.setValue(valorActual);
                Rectangle rect = this.pgbCargaDocumentos.getBounds();
		rect.x = 0;
		rect.y = 0;
		this.pgbCargaDocumentos.paintImmediately( rect );
                rect = this.pnlDatosProgreso.getBounds();
                rect.x = 0;
                rect.y = 0;
                this.pnlDatosProgreso.paintImmediately(rect);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(JDRegistrarDocumento.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(JDRegistrarDocumento.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //PanelDocumento.fin=true;
        this.pgbCargaDocumentos.setValue(100);
        this.btnAceptar.setEnabled(true);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pgbCargaDocumentos = new javax.swing.JProgressBar();
        lblProgreso = new javax.swing.JLabel();
        pnlDatosProgreso = new javax.swing.JPanel();
        scpDatosProgreso = new javax.swing.JScrollPane();
        taDatosProgreso = new javax.swing.JTextArea();
        btnAceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CargarDocumentos");
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        setResizable(false);

        lblProgreso.setText("Progreso");

        pnlDatosProgreso.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Progreso", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), java.awt.Color.blue)); // NOI18N

        taDatosProgreso.setColumns(20);
        taDatosProgreso.setFont(new java.awt.Font("Calisto MT", 0, 14));
        taDatosProgreso.setRows(5);
        scpDatosProgreso.setViewportView(taDatosProgreso);

        javax.swing.GroupLayout pnlDatosProgresoLayout = new javax.swing.GroupLayout(pnlDatosProgreso);
        pnlDatosProgreso.setLayout(pnlDatosProgresoLayout);
        pnlDatosProgresoLayout.setHorizontalGroup(
            pnlDatosProgresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDatosProgresoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scpDatosProgreso, javax.swing.GroupLayout.DEFAULT_SIZE, 627, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlDatosProgresoLayout.setVerticalGroup(
            pnlDatosProgresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDatosProgresoLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(scpDatosProgreso, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/aceptar.png"))); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.setEnabled(false);
        btnAceptar.setMaximumSize(new java.awt.Dimension(135, 35));
        btnAceptar.setMinimumSize(new java.awt.Dimension(135, 35));
        btnAceptar.setPreferredSize(new java.awt.Dimension(135, 35));
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(lblProgreso)
                            .addGap(18, 18, 18)
                            .addComponent(pgbCargaDocumentos, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(pnlDatosProgreso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(266, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pgbCargaDocumentos, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblProgreso))
                .addGap(26, 26, 26)
                .addComponent(pnlDatosProgreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed

    /**
    * @param args the command line arguments
    */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JLabel lblProgreso;
    private javax.swing.JProgressBar pgbCargaDocumentos;
    private javax.swing.JPanel pnlDatosProgreso;
    private javax.swing.JScrollPane scpDatosProgreso;
    private javax.swing.JTextArea taDatosProgreso;
    // End of variables declaration//GEN-END:variables

}
