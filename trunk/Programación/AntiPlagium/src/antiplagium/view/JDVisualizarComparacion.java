/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JDVisualizarComparacion.java
 *
 * Created on 03/06/2010, 06:56:17 PM
 */
package antiplagium.view;

import antiplagium.BE.DocumentoBE;
import antiplagium.BE.GestorDocumentosBE;
import antiplagium.BE.ResultadoDeteccionBE;
import antiplagium.BE.Utilitario;
import antiplagium.BL.DetectorBL;
import antiplagium.BL.ResultadoDeteccionBL;
import java.awt.Color;
import java.awt.Point;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

/**
 *
 * @author a20062010
 */
public class JDVisualizarComparacion extends javax.swing.JDialog {

    private DocumentoBE doc1;
    private GestorDocumentosBE docs = new GestorDocumentosBE();
    private ArrayList<DetectorBL> detectores = new ArrayList<DetectorBL>();
    private int docActual = 0;
    private ArrayList<ResultadoDeteccionBE> listResultado;
    public JDVisualizarComparacion(DocumentoBE doc, GestorDocumentosBE listaDoc) {
        this.doc1 = doc;
        this.docs = listaDoc;
        initComponents();
        if (this.docs.cantElementos()==1) this.btnDocSgte.setEnabled(false);
        this.etiquetarValoresIniciales();

        this.realizarComparacion();

        this.actualizar();
    }

    public void etiquetarValoresIniciales() {
        this.txtDoc1.setBackground(Color.white);
        this.txtDoc2.setBackground(Color.white);
        this.lblDoc1.setText(doc1.getNombre());
        this.lblDoc2.setText(docs.get(0).getNombre());

       // this.txtDoc1.setText(doc1.getContenido());
      //  this.txtDoc2.setText(docs.get(0).getContenido());
        //this.cargarContenidos();

        this.lblTotalDocs.setText("de " + docs.cantElementos());

    }

    public void realizarComparacion() {
        this.lblTiempo.setText("Realizando comparación...");

        this.pgbComparacion.setMaximum(100);

        int paso = 100 / this.docs.cantElementos(), valorActual = 0;
        this.pgbComparacion.setValue(valorActual);

        this.doc1.armarEstructura();

        long tInicio = System.currentTimeMillis();
        listResultado = new ArrayList<ResultadoDeteccionBE>();
        for (int i = 0; i < this.docs.cantElementos(); i++) {
            DetectorBL dec = new DetectorBL();
            docs.get(i).armarEstructura();
            dec.comparar(doc1, docs.get(i));
            this.detectores.add(dec);
            valorActual += paso;
            this.pgbComparacion.setValue(valorActual);
            if (i == this.docs.cantElementos() - 1) {
                this.pgbComparacion.setValue(100);
            }
            ResultadoDeteccionBE objResDeteccion = new ResultadoDeteccionBE();
            objResDeteccion.setDocumento1(doc1);
            objResDeteccion.setDocumento2(docs.get(i));
            objResDeteccion.setFecha(new Date());
            objResDeteccion.setPorcentajePlagio(dec.getResultado());
            if (objResDeteccion.getPorcentajePlagio() < 50){
                objResDeteccion.setResultado("No Plagio");
            }
            else if (objResDeteccion.getPorcentajePlagio() < 70){
                objResDeteccion.setResultado("No Plagio");
            }
            else {
                objResDeteccion.setResultado("Plagio");
            }
            int id = 1;
            try {
                id = Utilitario.generaCodigo("ResultadoDeteccion");
                objResDeteccion.setidDeteccion(id);
                ResultadoDeteccionBL.registrar(objResDeteccion);
                this.listResultado.add(objResDeteccion);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(JDVisualizarComparacion.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(JDVisualizarComparacion.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }

        long tFin = System.currentTimeMillis();

        this.lblTiempo.setText("Tiempo total de comparación: " + (tFin - tInicio) + " ms.");
    }

    public void actualizar() {
        this.lblDoc2.setText(docs.get(docActual).getNombre());
     //   this.txtDoc1.setText(doc1.getContenido());
      //  this.txtDoc2.setText(docs.get(docActual).getContenido());
        int res = detectores.get(docActual).getResultado();
        this.lblPorc.setText("Porcentaje de similitud: " + res + " %");

        if (res < 50) {
            this.lblNivel.setText("Bajo");
        } else if (res < 70) {
            this.lblNivel.setText("Medio");
        } else {
            this.lblNivel.setText("Alto");
        }

        this.txtNumDoc.setText("" + (docActual+1));
        this.lblMayor.setText("Mayor porcentaje detectado: "+this.obtenerMayorPorcentaje().x+" %");
        this.lblEnDoc.setText("El el documento número "+(this.obtenerMayorPorcentaje().y+1));

        this.cargarContenidos();
    }
    
    public Point obtenerMayorPorcentaje(){
        int mayor=0;
        int posMayor=0;
        for (int i=0; i<detectores.size(); i++) {
            if  (mayor<detectores.get(i).getResultado()) {
                mayor=detectores.get(i).getResultado();
                posMayor=i;
            }
        }
        return new Point(mayor,posMayor);
    }

    public void cargarContenidos() {
        
        this.txtDoc1.setText("");
        this.txtDoc2.setText("");
        DetectorBL detector = this.detectores.get(this.docActual);
        int[] listaOraciones1 = new int[detector.listaConexiones.size()];
        int[] listaOraciones2 = new int[detector.listaConexiones.size()];

        for (int i = 0; i < detector.listaConexiones.size(); i++) {
            listaOraciones1[i] = detector.listaConexiones.get(i).getOracionesConectadas().x;
            listaOraciones2[i] = detector.listaConexiones.get(i).getOracionesConectadas().y;
        }

        String[] contenido1Previo = doc1.getContenido().split("\n");
        String[] contenido2Previo = docs.get(docActual).getContenido().split("\n");

        String[] contenido1=this.removerVacios(contenido1Previo);
         String[] contenido2=this.removerVacios(contenido2Previo);

        SimpleAttributeSet attrNegrita = new SimpleAttributeSet();
        StyleConstants.setBold(attrNegrita, false);
        StyleConstants.setItalic(attrNegrita, true);
        StyleConstants.setForeground(attrNegrita, Color.white);
        StyleConstants.setBackground(attrNegrita, Color.blue);

        SimpleAttributeSet attrNormal = new SimpleAttributeSet();
        StyleConstants.setBold(attrNormal, false);
        StyleConstants.setForeground(attrNormal, Color.black);

        for (int i = 0; i < contenido1.length; i++) {
            if (contenido1[i]==null) break;
            if (contiene(listaOraciones1, i)) {
                try {
                    this.txtDoc1.getStyledDocument().insertString(this.txtDoc1.getStyledDocument().getLength(), contenido1[i]+"\n", attrNegrita);
                } catch (BadLocationException ex) {
                    System.out.println(ex);
                }
            }
            else {
               try {
                    this.txtDoc1.getStyledDocument().insertString(this.txtDoc1.getStyledDocument().getLength(), contenido1[i]+"\n", attrNormal);
                } catch (BadLocationException ex) {
                    System.out.println(ex);
                }
            }
        }

        for (int i = 0; i < contenido2.length; i++) {
            if (contenido2[i]==null) break;
            if (contiene(listaOraciones2, i)) {
                try {
                    this.txtDoc2.getStyledDocument().insertString(this.txtDoc2.getStyledDocument().getLength(), contenido2[i]+"\n", attrNegrita);
                } catch (BadLocationException ex) {
                    System.out.println(ex);
                }
            }
            else {
               try {
                    this.txtDoc2.getStyledDocument().insertString(this.txtDoc2.getStyledDocument().getLength(), contenido2[i]+"\n", attrNormal);
                } catch (BadLocationException ex) {
                    System.out.println(ex);
                }
            }
        }




    }

    public String[] removerVacios(String[] arr){
        String[] aux= new String[arr.length];
        int j=0;
        for (int i=0; i<arr.length; i++) {
            if (arr[i].compareTo("")!=0) {
                aux[j]=arr[i];
                j++;
            }
        }
        return aux;

    }

    public boolean contiene(int[] arr, int valor) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == valor) {
                return true;
            }
        }
        return false;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDoc1 = new javax.swing.JTextPane();
        pgbComparacion = new javax.swing.JProgressBar();
        lblDoc1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDoc2 = new javax.swing.JTextPane();
        lblDoc2 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        lblPorc = new javax.swing.JLabel();
        lblTiempo = new javax.swing.JLabel();
        lblNivel = new javax.swing.JLabel();
        txtNumDoc = new javax.swing.JTextField();
        btnDocAnterior = new javax.swing.JButton();
        lblTotalDocs = new javax.swing.JLabel();
        btnDocSgte = new javax.swing.JButton();
        lblEnDoc = new javax.swing.JLabel();
        lblMayor = new javax.swing.JLabel();
        lblDoc3 = new javax.swing.JLabel();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Documento comparado"));

        jPanel2.setBackground(new java.awt.Color(153, 143, 134));
        jPanel2.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel2.setForeground(new java.awt.Color(133, 114, 114));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtDoc1.setEditable(false);
        jScrollPane1.setViewportView(txtDoc1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        lblDoc1.setFont(new java.awt.Font("Comic Sans MS", 1, 14));
        lblDoc1.setText("Doc1");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Documento de referencia"));

        jPanel4.setBackground(new java.awt.Color(153, 143, 134));
        jPanel4.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel4.setForeground(new java.awt.Color(133, 114, 114));

        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtDoc2.setEditable(false);
        jScrollPane2.setViewportView(txtDoc2);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        lblDoc2.setFont(new java.awt.Font("Comic Sans MS", 1, 14));
        lblDoc2.setText("Doc2");

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/aceptar.png"))); // NOI18N
        jButton5.setText("Aceptar");
        jButton5.setMaximumSize(new java.awt.Dimension(135, 35));
        jButton5.setMinimumSize(new java.awt.Dimension(135, 35));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        lblPorc.setText("Porcentaje de similitud:");

        lblTiempo.setText("Tiempo total de comparación:");

        lblNivel.setFont(new java.awt.Font("Arial", 1, 12));
        lblNivel.setText("Alto");

        txtNumDoc.setEnabled(false);

        btnDocAnterior.setEnabled(false);
        btnDocAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDocAnteriorActionPerformed(evt);
            }
        });

        lblTotalDocs.setText("jLabel1");

        btnDocSgte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDocSgteActionPerformed(evt);
            }
        });

        lblEnDoc.setFont(new java.awt.Font("DejaVu Sans", 1, 13));
        lblEnDoc.setText("El el documento numero 0");

        lblMayor.setFont(new java.awt.Font("DejaVu Sans", 1, 13));
        lblMayor.setText("Mayor porcentaje detectado:");

        lblDoc3.setFont(new java.awt.Font("Comic Sans MS", 1, 14));
        lblDoc3.setText("Resultados de comparaciones...");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pgbComparacion, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTiempo)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDoc3)
                                    .addComponent(lblDoc1))
                                .addGap(270, 270, 270)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDoc2)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblPorc)
                                            .addComponent(lblMayor)
                                            .addComponent(lblEnDoc))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(73, 73, 73)
                                                .addComponent(lblNivel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 174, Short.MAX_VALUE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtNumDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(4, 4, 4)
                                        .addComponent(lblTotalDocs))
                                    .addComponent(btnDocAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnDocSgte, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(lblDoc3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDoc1)
                            .addComponent(lblDoc2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(pgbComparacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblTiempo)
                                    .addComponent(lblMayor)
                                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblPorc)
                                .addComponent(lblNivel))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(269, 269, 269)
                        .addComponent(btnDocAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNumDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTotalDocs))
                        .addGap(18, 18, 18)
                        .addComponent(btnDocSgte, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEnDoc)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
}//GEN-LAST:event_jButton5ActionPerformed

    private void btnDocAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDocAnteriorActionPerformed
        this.docActual--;
        this.btnDocSgte.setEnabled(true);
        if (docActual == 0) {
            this.btnDocAnterior.setEnabled(false);
        }
        this.actualizar();
}//GEN-LAST:event_btnDocAnteriorActionPerformed

    private void btnDocSgteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDocSgteActionPerformed
        this.docActual++;
        this.btnDocAnterior.setEnabled(true);
        if (docActual == docs.cantElementos() - 1) {
            this.btnDocSgte.setEnabled(false);
        }
        this.actualizar();
}//GEN-LAST:event_btnDocSgteActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDocAnterior;
    private javax.swing.JButton btnDocSgte;
    private javax.swing.JButton jButton5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblDoc1;
    private javax.swing.JLabel lblDoc2;
    private javax.swing.JLabel lblDoc3;
    private javax.swing.JLabel lblEnDoc;
    private javax.swing.JLabel lblMayor;
    private javax.swing.JLabel lblNivel;
    private javax.swing.JLabel lblPorc;
    private javax.swing.JLabel lblTiempo;
    private javax.swing.JLabel lblTotalDocs;
    private javax.swing.JProgressBar pgbComparacion;
    private javax.swing.JTextPane txtDoc1;
    private javax.swing.JTextPane txtDoc2;
    private javax.swing.JTextField txtNumDoc;
    // End of variables declaration//GEN-END:variables
}
