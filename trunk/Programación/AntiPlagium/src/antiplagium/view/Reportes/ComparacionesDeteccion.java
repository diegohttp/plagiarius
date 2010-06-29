/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ComparacionesDeteccion.java
 *
 * Created on 06/06/2010, 11:07:49 AM
 */


package antiplagium.view.Reportes;


import antiplagium.BE.CategoriaBE;
import antiplagium.BE.DocumentoBE;
import antiplagium.BE.ResultadoDeteccionBE;
import antiplagium.BE.UsuarioBE;
import antiplagium.BL.CategoriaBL;
import antiplagium.BL.ResultadoDeteccionBL;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;
import org.freixas.jcalendar.JCalendarCombo;


/**
 *
 * @author PATTY
 */
public class ComparacionesDeteccion extends javax.swing.JFrame {
   private static final String URL_BASEDATOS = "jdbc:postgresql://quilla.lab.inf.pucp.edu.pe:1053/postgres";
    private CategoriaBL categoriaBl;
   JCalendarCombo jcComboDesde;
    JCalendarCombo jcComboHasta;
   //lista de documentos detectados q tnga Doc1 - Doc2 - %plagio - nivel plagio - fecha
   private ArrayList<ResultadoDeteccionBE> arrDocumentosDetectados = new ArrayList<ResultadoDeteccionBE>();



    /** Creates new form ComppieropiaracionesDeteccion */
    public ComparacionesDeteccion() throws FileNotFoundException, IOException, SQLException {
//        try {
            initComponents();

        jcComboDesde = new JCalendarCombo();
        jcComboHasta = new JCalendarCombo();

        jcComboDesde.setSize(247, 29);
        jcComboHasta.setSize(247, 29);
        jPFechaInicio.add(jcComboDesde);
        jPFechaFin.add(jcComboHasta);


        categoriaBl=new CategoriaBL();
        CategoriaBE tmp = new CategoriaBE();
        tmp.setIdCategoria(0);
        tmp.setNombre("Todas");
        ArrayList<CategoriaBE> listaCategorias=categoriaBl.buscarCategoria("", "");
        listaCategorias.add(0 , tmp);
        int cantidadCategorias=listaCategorias.size();

        for(int i=0;i<cantidadCategorias;i++){
            jcmbCategoria.addItem(listaCategorias.get(i));
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jcmbCategoria = new javax.swing.JComboBox();
        jPFechaInicio = new javax.swing.JPanel();
        jPFechaFin = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jtxtIdUsuario = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTListaDocumentos = new javax.swing.JTable();
        jbtnImprimir = new javax.swing.JButton();
        jbtnBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos de los documentos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12), new java.awt.Color(0, 51, 255))); // NOI18N
        jPanel1.setToolTipText("sss");

        jLabel1.setText("Fecha Inicio:");

        jLabel2.setText("Fecha Fin:");

        jLabel3.setText("Categoría:");

        jcmbCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcmbCategoriaActionPerformed(evt);
            }
        });

        jPFechaInicio.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPFechaInicio.setPreferredSize(new java.awt.Dimension(247, 29));

        javax.swing.GroupLayout jPFechaInicioLayout = new javax.swing.GroupLayout(jPFechaInicio);
        jPFechaInicio.setLayout(jPFechaInicioLayout);
        jPFechaInicioLayout.setHorizontalGroup(
            jPFechaInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 214, Short.MAX_VALUE)
        );
        jPFechaInicioLayout.setVerticalGroup(
            jPFechaInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 21, Short.MAX_VALUE)
        );

        jPFechaFin.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPFechaFin.setPreferredSize(new java.awt.Dimension(247, 29));

        javax.swing.GroupLayout jPFechaFinLayout = new javax.swing.GroupLayout(jPFechaFin);
        jPFechaFin.setLayout(jPFechaFinLayout);
        jPFechaFinLayout.setHorizontalGroup(
            jPFechaFinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 214, Short.MAX_VALUE)
        );
        jPFechaFinLayout.setVerticalGroup(
            jPFechaFinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPFechaFin, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                    .addComponent(jcmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPFechaInicio, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE))
                .addGap(17, 17, 17))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jcmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jPFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPFechaFin, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE))
                .addGap(50, 50, 50))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del propietario", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12), new java.awt.Color(0, 0, 255))); // NOI18N

        jLabel4.setText("Usuario :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel4)
                .addGap(39, 39, 39)
                .addComponent(jtxtIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtxtIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jTListaDocumentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Documento 1", "Documento 2", "Porcentaje Plagio (%)", "Resultado", "Fecha"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Float.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTListaDocumentos);

        jbtnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Report.png"))); // NOI18N
        jbtnImprimir.setText("Imprimir");
        jbtnImprimir.setMaximumSize(new java.awt.Dimension(135, 35));
        jbtnImprimir.setMinimumSize(new java.awt.Dimension(135, 35));
        jbtnImprimir.setPreferredSize(new java.awt.Dimension(135, 35));
        jbtnImprimir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imprimir(evt);
            }
        });
        jbtnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnImprimirActionPerformed(evt);
            }
        });

        jbtnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/buscar.png"))); // NOI18N
        jbtnBuscar.setText("Buscar");
        jbtnBuscar.setMaximumSize(new java.awt.Dimension(135, 35));
        jbtnBuscar.setMinimumSize(new java.awt.Dimension(135, 35));
        jbtnBuscar.setPreferredSize(new java.awt.Dimension(135, 35));
        jbtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(319, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jbtnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(154, 154, 154))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jbtnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(305, 305, 305))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jbtnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 241, Short.MAX_VALUE)
                .addComponent(jbtnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                    .addGap(68, 68, 68)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcmbCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcmbCategoriaActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jcmbCategoriaActionPerformed

    private void jbtnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnImprimirActionPerformed
     
    }//GEN-LAST:event_jbtnImprimirActionPerformed

    private void jbtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBuscarActionPerformed
        CategoriaBE objCategoria = null;
        UsuarioBE objUsuario = null;
        /* Si la categoria es todas el objeto debe ser nulo, no especificado */
        objCategoria= (CategoriaBE) this.jcmbCategoria.getSelectedItem();
        if (objCategoria.getNombre().compareTo("Todas") == 0){
            objCategoria = null;
        }
        // Si se especifico un IdUsuario se crea el usuario */
        if (this.jtxtIdUsuario.getText().compareTo("") != 0){
            objUsuario = new UsuarioBE();
            objUsuario.setIdUsuario(Integer.parseInt(this.jtxtIdUsuario.getText()));
        }
        
        //filtro x fechas
        
        Date fechainicio = jcComboDesde.getDate();
        Date fechafin = jcComboHasta.getDate();

        System.out.println(fechainicio);

        long fechainijava = fechainicio.getTime();
        java.sql.Date sqlFechaini = new java.sql.Date(fechainijava);

        long fechafinjava = fechainicio.getTime();
        java.sql.Date sqlFechafin = new java.sql.Date(fechafinjava);

        System.out.println(sqlFechaini);
        System.out.println(sqlFechafin);

        DocumentoBE objDocumento = new DocumentoBE();
        objDocumento.setUsuario(objUsuario);
        objDocumento.setCategoria(objCategoria);

        ResultadoDeteccionBE objResultado = new ResultadoDeteccionBE();
        objResultado.setDocumento1(objDocumento);

        try {
            this.arrDocumentosDetectados = ResultadoDeteccionBL.obtenerInstancia().ListarDocsDetectados(objResultado, sqlFechaini, sqlFechafin);

//            ArrayList<ResultadoDeteccionBE> listaReporte = new ArrayList<ResultadoDeteccionBE>();

//            for (int i=0; i<arrDocumentosDetectados.size(); i++ ){
//              listaReporte(i).setDocumento1 = arrDocumentosDetectados.get(i).getDocumento1().getIdDocumento();
//              listaReporte.set(i).setDocumento2 = arrDocumentosDetectados.get(i).getDocumento2().getIdDocumento();
//              listaReporte.add(i, arrDocumentosDetectados.get(i).getPorcentajePlagio());
//              .setPorcentaje = arrDocumentosDetectados.get(i).getPorcentajePlagio();
//              listaReporte.set(i).setDocumento1 = arrDocumentosDetectados.get(i).getResultado();
//              listaReporte.set(i).setDocumento1 = arrDocumentosDetectados.get(i).getFecha();
//            }


        } catch (FileNotFoundException ex) {
            Logger.getLogger(ComparacionesDeteccion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ComparacionesDeteccion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ComparacionesDeteccion.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        /* Obtenemos el modelo */
          DefaultTableModel tmp = (DefaultTableModel) this.jTListaDocumentos.getModel();
            /* Limpiamos la tabla */
            for (int i=tmp.getRowCount() - 1; i >= 0; --i){
                tmp.removeRow(i);
            }
            /* Llenamos la grilla */
            for (int i=0; i < arrDocumentosDetectados.size() ; ++i){
             Object [] nuevo={ arrDocumentosDetectados.get(i).getDocumento1().getNombre(), arrDocumentosDetectados.get(i).getDocumento2().getNombre(), arrDocumentosDetectados.get(i).getPorcentajePlagio(), arrDocumentosDetectados.get(i).getResultado(), arrDocumentosDetectados.get(i).getFecha()};
              tmp.addRow(nuevo);
            }
           if (this.arrDocumentosDetectados.size() == 0){
                 JOptionPane.showMessageDialog(this, "La búsqueda no encontro ningún resultado", "Buscar Documento", JOptionPane.INFORMATION_MESSAGE);
            }

           
    }//GEN-LAST:event_jbtnBuscarActionPerformed

    private void imprimir(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imprimir
        Map pars = new HashMap();

//        ResultadoDeteccionBE objResultadoDeteccionBE = new ResultadoDeteccionBE();
//
//        pars.put("P_TITULO", "Reporte de Comparaciones entre documentos");
//        pars.put("P_SUBTITULO", "Antiplagium");
//        pars.put("Documento1", objResultadoDeteccionBE.getDocumento1().getIdDocumento());
//        pars.put("Documento2", objResultadoDeteccionBE.getDocumento2().getIdDocumento());
//        pars.put("PorcentajePlagio",objResultadoDeteccionBE.getPorcentajePlagio());
//        pars.put("Resultado", objResultadoDeteccionBE.getResultado());
//        pars.put("Fecha", objResultadoDeteccionBE.getFecha());
        
        try {
            JasperPrint jasperPrint= Utilitarios.GeneraReportes.gestorReporte("deteccion", pars, this.arrDocumentosDetectados);

            JRViewer v = new JRViewer(jasperPrint);
            JFrame ventana=new JFrame();
            ventana.getContentPane().add(v,BorderLayout.CENTER);
            ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            ventana.setSize(706, 478);

            ventana.setTitle("Vista Previa");
            ventana.setLocation(512-ventana.getWidth()/2,387 - ventana.getHeight()/2 );

            ventana.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se cuenta con un equipo de impresion");
            e.printStackTrace();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_imprimir




    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ComparacionesDeteccion().setVisible(true);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(ComparacionesDeteccion.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(ComparacionesDeteccion.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(ComparacionesDeteccion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPFechaFin;
    private javax.swing.JPanel jPFechaInicio;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTListaDocumentos;
    private javax.swing.JButton jbtnBuscar;
    private javax.swing.JButton jbtnImprimir;
    private javax.swing.JComboBox jcmbCategoria;
    private javax.swing.JTextField jtxtIdUsuario;
    // End of variables declaration//GEN-END:variables

}
