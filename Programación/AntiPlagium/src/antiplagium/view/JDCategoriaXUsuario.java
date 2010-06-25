/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JFCategoriaXUsuario.java
 *
 * Created on 03/06/2010, 01:21:05 PM
 */

package antiplagium.view;

import antiplagium.BE.CategoriaBE;
import antiplagium.BL.CategoriaBL;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author piere
 */
public class JDCategoriaXUsuario extends JDialog {

    private int idUsuario;
    private ArrayList<CategoriaBE> listaCategorias;

    /** Creates new form JFCategoriaXUsuario */
    public JDCategoriaXUsuario(int idUsuario,ArrayList<CategoriaBE> listaCat) {
        this.idUsuario=idUsuario;
        this.listaCategorias=listaCat;
        if(listaCategorias==null) listaCategorias=new ArrayList<CategoriaBE>();
        initComponents();
        CargarTabla();
        

    }

    public void CargarTabla(){
        DefaultTableModel modelo = (DefaultTableModel) jTCategorias.getModel();

        while (modelo.getRowCount()>0){
            modelo.removeRow(0);
        }

//        ResultSetMetaData rsmd = rs.getMetaData();
//        int numeroColum = rsmd.getColumnCount();
        int numeroColum=3;
        int tamano=0;
        if (listaCategorias!=null){
            tamano=listaCategorias.size();
        }

        int i=0;
        while(tamano>i){
            Object[] objetos = new Object[numeroColum];
            objetos[0] = listaCategorias.get(i).getIdCategoria();
            objetos[1] = listaCategorias.get(i).getNombre();
            objetos[2] = listaCategorias.get(i).getDescripcion();
            modelo.addRow(objetos);
            i++;
        }
    }

    public void setListaCategorias(ArrayList<Integer> lista){

        CategoriaBL categoriaBL=new CategoriaBL();
        Boolean vacia=true;
        if (listaCategorias.size()>=0) vacia=false;

        for(int i=0;i<lista.size();i++){
            //System.out.println(lista.get(i));
            Boolean seEncuentra=false;
            if (vacia==false){
                for(int j=0;j<listaCategorias.size();j++){
                    if(lista.get(i)==listaCategorias.get(j).getIdCategoria()){
                        seEncuentra=true;
                        break;
                    }
                }
            }
            if(seEncuentra==false){
                CategoriaBE categoriaBE = categoriaBL.buscarIdCategoria(lista.get(i));
                listaCategorias.add(categoriaBE);
            }
        }
        CargarTabla();
    }

    public ArrayList<CategoriaBE> getListaCategorias (){
        return listaCategorias;
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTCategorias = new javax.swing.JTable();
        jBAgregar = new javax.swing.JButton();
        jBEliminar = new javax.swing.JButton();
        jBGuardar = new javax.swing.JButton();
        jBCancelar = new javax.swing.JButton();

        setTitle("Categorias Asignadas");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Categorias Asignadas"));

        jTCategorias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Descripcion", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTCategorias);

        jBAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/nuevo.png"))); // NOI18N
        jBAgregar.setText("Agregar");
        jBAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAgregarActionPerformed(evt);
            }
        });

        jBEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Eliminar - 16.png"))); // NOI18N
        jBEliminar.setText("Eliminar");
        jBEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEliminarActionPerformed(evt);
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
                        .addComponent(jBAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBEliminar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBAgregar)
                    .addComponent(jBEliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jBGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/aceptar.png"))); // NOI18N
        jBGuardar.setText("Aceptar");
        jBGuardar.setPreferredSize(new java.awt.Dimension(135, 35));
        jBGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGuardarActionPerformed(evt);
            }
        });

        jBCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cancelar.png"))); // NOI18N
        jBCancelar.setText("Cancelar");
        jBCancelar.setPreferredSize(new java.awt.Dimension(135, 35));
        jBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents



    private void jBAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAgregarActionPerformed

        JDAdministrarCategoria jfAdministrarCategoria=new JDAdministrarCategoria(null);
        jfAdministrarCategoria.setModal(true);
        jfAdministrarCategoria.setLocationRelativeTo(this);
        //JFAdministrarCategoria jfAdministrarCategoria=new JFAdministrarCategoria();
        jfAdministrarCategoria.setVisible(true);
        if (jfAdministrarCategoria.getIdsCategorias()!=null){
            this.setListaCategorias(jfAdministrarCategoria.getIdsCategorias());
        }
        jfAdministrarCategoria.dispose();

////        AntiPlagiumPrincipal.getJDesktopPane().add(jfAdministrarCategoria);
////        jfAdministrarCategoria.toFront();

    }//GEN-LAST:event_jBAgregarActionPerformed

    private void jBEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEliminarActionPerformed

        DefaultTableModel modelo=(DefaultTableModel)jTCategorias.getModel();
        ArrayList<Integer> idsCategorias=new ArrayList<Integer>();

        if(modelo.getRowCount()>=0){

            for(int i=modelo.getRowCount()-1;i>=0;i--){

                Boolean seleccion=(Boolean)modelo.getValueAt(i, 3);
                //System.out.println("esto es "+seleccion);
                if ((seleccion!=null) && (seleccion!=false)){
                    //idsCategorias.add((Integer)modelo.getValueAt(i, 0));
                    //System.out.println("tamano "+listaCategorias.size()+" valor de i "+i);
                    listaCategorias.remove(i);
                    idsCategorias.add(i);
                }
            }
        }
        else {JOptionPane.showMessageDialog(this,"No existen categorias asignadas. Eliminacion no permitida.", "Mensaje derror", JOptionPane.ERROR_MESSAGE);
        }

        if(idsCategorias.size()==0){
                JOptionPane.showMessageDialog(this,"No existen categorias asignadas. Eliminacion no permitida.", "Mensaje derror", JOptionPane.ERROR_MESSAGE);
            }
        else{

            CargarTabla();

        }

    }//GEN-LAST:event_jBEliminarActionPerformed

    private void jBGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGuardarActionPerformed
       //JDAgregarUsuario.ActualizarListaCategorias(listaCategorias);
       //this.dispose();
        this.setVisible(false);
    }//GEN-LAST:event_jBGuardarActionPerformed

    private void jBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelarActionPerformed
        listaCategorias=null;
        this.dispose();
    }//GEN-LAST:event_jBCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAgregar;
    private javax.swing.JButton jBCancelar;
    private javax.swing.JButton jBEliminar;
    private javax.swing.JButton jBGuardar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTCategorias;
    // End of variables declaration//GEN-END:variables

}
