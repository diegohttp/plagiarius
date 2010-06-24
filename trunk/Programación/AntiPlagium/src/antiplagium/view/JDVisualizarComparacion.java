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
import java.util.Locale;
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

    private DocumentoBE objDocumento1;
    private GestorDocumentosBE gstDocumentos = new GestorDocumentosBE();
    private ArrayList<DetectorBL> alstDetectores = new ArrayList<DetectorBL>();
    private int numDocumentoActual = 0;
    private ArrayList<ResultadoDeteccionBE> alstResultados;

    public JDVisualizarComparacion(DocumentoBE doc, GestorDocumentosBE listaDoc) {
        this.objDocumento1 = doc;
        this.gstDocumentos = listaDoc;

        PanelLupa objPanelLupa = new PanelLupa();
        PanelBarras objPanelBarras = new PanelBarras(null);
        this.add(objPanelLupa);
        this.add(objPanelBarras);
        initComponents();
        objPanelLupa.setLocation(this.lblTiempo.getLocation().x, this.lblTiempo.getLocation().y - 110);
        objPanelBarras.setLocation(objPanelLupa.getLocation().x+objPanelLupa.anchoPanel+10, objPanelLupa.getLocation().y);
        if (this.gstDocumentos.cantElementos() == 1) {
            this.btnDocSgte.setEnabled(false);
        }
        this.etiquetarValoresIniciales();
        Thread hiloComp = new Thread() {

            public void run() {
                realizarComparacion();

                actualizar();
            }
        };
        hiloComp.start();
        this.setModal(true);
        this.setVisible(true);
        


    }

    public void etiquetarValoresIniciales() {
        this.txtDoc1.setBackground(Color.white);
        this.txtDoc2.setBackground(Color.white);
        this.lblDoc1.setText(objDocumento1.getNombre());
        this.lblDoc2.setText(gstDocumentos.get(0).getNombre());
        this.lblTotalDocs.setText("de " + gstDocumentos.cantElementos());

    }

    public void realizarComparacion() {
        this.lblTiempo.setText("Realizando comparación...");
        this.objDocumento1.armarEstructura();

        long tInicio = System.currentTimeMillis();
        alstResultados = new ArrayList<ResultadoDeteccionBE>();
        for (int i = 0; i < this.gstDocumentos.cantElementos(); i++) {
            DetectorBL dec = new DetectorBL();
            gstDocumentos.get(i).armarEstructura();
            dec.comparar(objDocumento1, gstDocumentos.get(i));
            this.alstDetectores.add(dec);

            ResultadoDeteccionBE objResDeteccion = new ResultadoDeteccionBE();
            objResDeteccion.setDocumento1(objDocumento1);
            objResDeteccion.setDocumento2(gstDocumentos.get(i));
            objResDeteccion.setFecha(new Date());
            objResDeteccion.setPorcentajePlagio(dec.getResultado());
            if (objResDeteccion.getPorcentajePlagio() < 50) {
                objResDeteccion.setResultado("No Plagio");
            } else if (objResDeteccion.getPorcentajePlagio() < 70) {
                objResDeteccion.setResultado("No Plagio");
            } else {
                objResDeteccion.setResultado("Plagio");
            }
            int id = 1;
            try {
                id = Utilitario.generaCodigo("ResultadoDeteccion");
                objResDeteccion.setidDeteccion(id);
                ResultadoDeteccionBL.registrar(objResDeteccion);
                this.alstResultados.add(objResDeteccion);
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
        this.lblDoc2.setText(gstDocumentos.get(numDocumentoActual).getNombre());
        int resultado = alstDetectores.get(numDocumentoActual).getResultado();
        this.lblPorc.setText("Porcentaje de similitud: " + resultado + " %");

        if (resultado < 50) {
            this.lblNivel.setText("Bajo");
        } else if (resultado < 70) {
            this.lblNivel.setText("Medio");
        } else {
            this.lblNivel.setText("Alto");
        }

        this.txtNumDoc.setText("" + (numDocumentoActual + 1));
        this.lblMayor.setText("Mayor porcentaje detectado: " + this.obtenerMayorPorcentaje().x + " %");
        this.lblEnDoc.setText("En el documento número " + (this.obtenerMayorPorcentaje().y + 1));

        this.cargarContenidos();
    }

    public Point obtenerMayorPorcentaje() {
        int mayor = 0;
        int posMayor = 0;
        for (int i = 0; i < alstDetectores.size(); i++) {
            if (mayor < alstDetectores.get(i).getResultado()) {
                mayor = alstDetectores.get(i).getResultado();
                posMayor = i;
            }
        }
        return new Point(mayor, posMayor);
    }

    public void cargarContenidos() {

        this.txtDoc1.setText("");
        this.txtDoc2.setText("");
        DetectorBL detector = this.alstDetectores.get(this.numDocumentoActual);
        int[] listaOraciones1 = new int[detector.listaConexiones.size()];
        int[] listaOraciones2 = new int[detector.listaConexiones.size()];

        for (int i = 0; i < detector.listaConexiones.size(); i++) {
            listaOraciones1[i] = detector.listaConexiones.get(i).getOracionesConectadas().x;
            listaOraciones2[i] = detector.listaConexiones.get(i).getOracionesConectadas().y;
        }

        String[] contenido1Previo = objDocumento1.getContenido().split("\n");
        String[] contenido2Previo = gstDocumentos.get(numDocumentoActual).getContenido().split("\n");

        String[] contenido1 = this.removerVacios(contenido1Previo);
        String[] contenido2 = this.removerVacios(contenido2Previo);

        SimpleAttributeSet attrNegrita = new SimpleAttributeSet();
        StyleConstants.setBold(attrNegrita, false);
        StyleConstants.setItalic(attrNegrita, true);
        StyleConstants.setForeground(attrNegrita, Color.white);
        StyleConstants.setBackground(attrNegrita, Color.blue);

        SimpleAttributeSet attrNormal = new SimpleAttributeSet();
        StyleConstants.setBold(attrNormal, false);
        StyleConstants.setForeground(attrNormal, Color.black);

        for (int i = 0; i < contenido1.length; i++) {
            if (contenido1[i] == null) {
                break;
            }
            if (contiene(listaOraciones1, i)) {
                try {
                    this.txtDoc1.getStyledDocument().insertString(this.txtDoc1.getStyledDocument().getLength(), contenido1[i] + "\n", attrNegrita);
                } catch (BadLocationException ex) {
                    System.out.println(ex);
                }
            } else {
                try {
                    this.txtDoc1.getStyledDocument().insertString(this.txtDoc1.getStyledDocument().getLength(), contenido1[i] + "\n", attrNormal);
                } catch (BadLocationException ex) {
                    System.out.println(ex);
                }
            }
        }

        for (int i = 0; i < contenido2.length; i++) {
            if (contenido2[i] == null) {
                break;
            }
            if (contiene(listaOraciones2, i)) {
                try {
                    this.txtDoc2.getStyledDocument().insertString(this.txtDoc2.getStyledDocument().getLength(), contenido2[i] + "\n", attrNegrita);
                } catch (BadLocationException ex) {
                    System.out.println(ex);
                }
            } else {
                try {
                    this.txtDoc2.getStyledDocument().insertString(this.txtDoc2.getStyledDocument().getLength(), contenido2[i] + "\n", attrNormal);
                } catch (BadLocationException ex) {
                    System.out.println(ex);
                }
            }
        }




    }

    public String[] removerVacios(String[] arr) {
        String[] aux = new String[arr.length];
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].compareTo("") != 0) {
                aux[j] = arr[i];
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

        pnlDoc1 = new javax.swing.JPanel();
        pnlDoc2Interior = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDoc1 = new javax.swing.JTextPane();
        lblDoc1 = new javax.swing.JLabel();
        pnlDoc2 = new javax.swing.JPanel();
        pnlDoc1Interior = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDoc2 = new javax.swing.JTextPane();
        lblDoc2 = new javax.swing.JLabel();
        lblPorc = new javax.swing.JLabel();
        lblTiempo = new javax.swing.JLabel();
        lblNivel = new javax.swing.JLabel();
        txtNumDoc = new javax.swing.JTextField();
        btnDocAnterior = new javax.swing.JButton();
        lblTotalDocs = new javax.swing.JLabel();
        btnDocSgte = new javax.swing.JButton();
        lblEnDoc = new javax.swing.JLabel();
        lblMayor = new javax.swing.JLabel();
        lblTitulo1 = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();

        setTitle("Resultados de comparación");

        pnlDoc1.setBorder(javax.swing.BorderFactory.createTitledBorder("Documento comparado"));

        pnlDoc2Interior.setBackground(new java.awt.Color(153, 143, 134));
        pnlDoc2Interior.setBorder(new javax.swing.border.MatteBorder(null));
        pnlDoc2Interior.setForeground(new java.awt.Color(133, 114, 114));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtDoc1.setEditable(false);
        jScrollPane1.setViewportView(txtDoc1);

        javax.swing.GroupLayout pnlDoc2InteriorLayout = new javax.swing.GroupLayout(pnlDoc2Interior);
        pnlDoc2Interior.setLayout(pnlDoc2InteriorLayout);
        pnlDoc2InteriorLayout.setHorizontalGroup(
            pnlDoc2InteriorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDoc2InteriorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlDoc2InteriorLayout.setVerticalGroup(
            pnlDoc2InteriorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDoc2InteriorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlDoc1Layout = new javax.swing.GroupLayout(pnlDoc1);
        pnlDoc1.setLayout(pnlDoc1Layout);
        pnlDoc1Layout.setHorizontalGroup(
            pnlDoc1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDoc1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlDoc2Interior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlDoc1Layout.setVerticalGroup(
            pnlDoc1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDoc1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlDoc2Interior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
        );

        lblDoc1.setFont(new java.awt.Font("Comic Sans MS", 1, 14));
        lblDoc1.setText("Doc1");

        pnlDoc2.setBorder(javax.swing.BorderFactory.createTitledBorder("Documento de referencia"));

        pnlDoc1Interior.setBackground(new java.awt.Color(153, 143, 134));
        pnlDoc1Interior.setBorder(new javax.swing.border.MatteBorder(null));
        pnlDoc1Interior.setForeground(new java.awt.Color(133, 114, 114));

        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtDoc2.setEditable(false);
        jScrollPane2.setViewportView(txtDoc2);

        javax.swing.GroupLayout pnlDoc1InteriorLayout = new javax.swing.GroupLayout(pnlDoc1Interior);
        pnlDoc1Interior.setLayout(pnlDoc1InteriorLayout);
        pnlDoc1InteriorLayout.setHorizontalGroup(
            pnlDoc1InteriorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDoc1InteriorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlDoc1InteriorLayout.setVerticalGroup(
            pnlDoc1InteriorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDoc1InteriorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlDoc2Layout = new javax.swing.GroupLayout(pnlDoc2);
        pnlDoc2.setLayout(pnlDoc2Layout);
        pnlDoc2Layout.setHorizontalGroup(
            pnlDoc2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDoc2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlDoc1Interior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(72, Short.MAX_VALUE))
        );
        pnlDoc2Layout.setVerticalGroup(
            pnlDoc2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDoc2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlDoc1Interior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75))
        );

        lblDoc2.setFont(new java.awt.Font("Comic Sans MS", 1, 14));
        lblDoc2.setText("Doc2");

        lblPorc.setText("Porcentaje de similitud:");

        lblTiempo.setText("Tiempo total de comparación:");

        lblNivel.setFont(new java.awt.Font("Arial", 1, 12));
        lblNivel.setText("Alto");

        txtNumDoc.setEnabled(false);

        btnDocAnterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/arriba.png"))); // NOI18N
        btnDocAnterior.setEnabled(false);
        btnDocAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDocAnteriorActionPerformed(evt);
            }
        });

        lblTotalDocs.setText("jLabel1");

        btnDocSgte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/abajo.png"))); // NOI18N
        btnDocSgte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDocSgteActionPerformed(evt);
            }
        });

        lblEnDoc.setFont(new java.awt.Font("DejaVu Sans", 1, 13));
        lblEnDoc.setText("En el documento numero 0");

        lblMayor.setFont(new java.awt.Font("DejaVu Sans", 1, 13));
        lblMayor.setText("Mayor porcentaje detectado:");

        lblTitulo1.setFont(new java.awt.Font("Comic Sans MS", 1, 14));
        lblTitulo1.setText("Resultados de comparaciones...");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDoc1)
                            .addComponent(lblTitulo1))
                        .addGap(270, 270, 270))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTiempo)
                            .addComponent(pnlDoc1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDoc2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(pnlDoc2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtNumDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(lblTotalDocs))
                            .addComponent(btnDocAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDocSgte, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(559, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEnDoc)
                    .addComponent(lblPorc)
                    .addComponent(lblMayor))
                .addGap(73, 73, 73)
                .addComponent(lblNivel)
                .addGap(343, 343, 343))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblTitulo1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDoc1)
                            .addComponent(lblDoc2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pnlDoc1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
                            .addComponent(pnlDoc2, javax.swing.GroupLayout.Alignment.TRAILING, 0, 422, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(269, 269, 269)
                        .addComponent(btnDocAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNumDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTotalDocs))
                        .addGap(18, 18, 18)
                        .addComponent(btnDocSgte, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(lblMayor))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblPorc)
                                .addComponent(lblNivel)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblEnDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addComponent(lblTiempo)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDocAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDocAnteriorActionPerformed
        this.numDocumentoActual--;
        this.btnDocSgte.setEnabled(true);
        if (numDocumentoActual == 0) {
            this.btnDocAnterior.setEnabled(false);
        }
        this.actualizar();
}//GEN-LAST:event_btnDocAnteriorActionPerformed

    private void btnDocSgteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDocSgteActionPerformed
        this.numDocumentoActual++;
        this.btnDocAnterior.setEnabled(true);
        if (numDocumentoActual == gstDocumentos.cantElementos() - 1) {
            this.btnDocSgte.setEnabled(false);
        }
        this.actualizar();
}//GEN-LAST:event_btnDocSgteActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
        PanelLupa.fin = true;
        this.setVisible(false);
    }//GEN-LAST:event_btnAceptarActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnDocAnterior;
    private javax.swing.JButton btnDocSgte;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblDoc1;
    private javax.swing.JLabel lblDoc2;
    private javax.swing.JLabel lblEnDoc;
    private javax.swing.JLabel lblMayor;
    private javax.swing.JLabel lblNivel;
    private javax.swing.JLabel lblPorc;
    private javax.swing.JLabel lblTiempo;
    private javax.swing.JLabel lblTitulo1;
    private javax.swing.JLabel lblTotalDocs;
    private javax.swing.JPanel pnlDoc1;
    private javax.swing.JPanel pnlDoc1Interior;
    private javax.swing.JPanel pnlDoc2;
    private javax.swing.JPanel pnlDoc2Interior;
    private javax.swing.JTextPane txtDoc1;
    private javax.swing.JTextPane txtDoc2;
    private javax.swing.JTextField txtNumDoc;
    // End of variables declaration//GEN-END:variables
}
