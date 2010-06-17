/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Documento2.java
 *
 * Created on 01/05/2010, 03:23:51 PM
 */

package antiplagium.view;

import antiplagium.BE.CategoriaBE;
import antiplagium.BE.DocumentoBE;
import antiplagium.BE.UsuarioBE;
import antiplagium.BE.Utilitario;
import antiplagium.BL.CategoriaBL;
import antiplagium.BL.DocumentoBL;
import antiplagium.BL.UsuarioBL;
import antiplagium.DAO.CategoriaDAO;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.postgresql.core.Logger;

/**
 *
 * @author PATTY
 */
public class BuscarDocumento extends JDialog {

    private ArrayList<DocumentoBE> arrDocumentos = new ArrayList<DocumentoBE>();
    private CategoriaBL categoriaBl;
    private UsuarioBE objUsuario;
    private ArrayList<CategoriaBE> listaCategorias;
    public DocumentoBE docSel=null;

    /** Creates new form Documento2 */
    public BuscarDocumento() throws FileNotFoundException, IOException, SQLException {
        initComponents();
        this.cboEstado.addItem("Todos");
        this.cboEstado.addItem("activo");
        this.cboEstado.addItem("inactivo");
        this.btnAceptar.setVisible(false);
        categoriaBl=new CategoriaBL();
        CategoriaBE tmp = new CategoriaBE();
        tmp.setIdCategoria(0);
        tmp.setNombre("Todas");
        listaCategorias=categoriaBl.buscarCategoria("", "");
        listaCategorias.add(0 , tmp);
        int cantidadCategorias=listaCategorias.size();
        for(int i=0;i<cantidadCategorias;i++){
            cboCategoria.addItem(listaCategorias.get(i).getNombre());
        }
    }

    public BuscarDocumento(UsuarioBE objUsuario) throws FileNotFoundException, IOException, SQLException {
        initComponents();
        this.cboEstado.addItem("Todos");
        this.cboEstado.addItem("activo");
        this.cboEstado.addItem("inactivo");
        this.objUsuario = objUsuario;
        categoriaBl=new CategoriaBL();
        CategoriaBE tmp = new CategoriaBE();
        tmp.setIdCategoria(0);
        tmp.setNombre("Todas");
        listaCategorias=categoriaBl.buscarCategoria("", "");
        listaCategorias.add(0 , tmp);
        int cantidadCategorias=listaCategorias.size();
        for(int i=0;i<cantidadCategorias;i++){
            cboCategoria.addItem(listaCategorias.get(i));
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

        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtabPaquetes = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        lblCategoria = new javax.swing.JLabel();
        txtNombre = new javax.swing.JFormattedTextField();
        cboCategoria = new javax.swing.JComboBox();
        btnBuscar = new javax.swing.JButton();
        lblIdUsuario = new javax.swing.JLabel();
        txtIdUsuario = new javax.swing.JFormattedTextField();
        lblEstado = new javax.swing.JLabel();
        cboEstado = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList1);

        setTitle("Búsqueda Documentos");
        setName(""); // NOI18N
        setResizable(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Resultados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jtabPaquetes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre", "Categoría ", "Propietario", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtabPaquetes.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jtabPaquetes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jtabPaquetes);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Búsqueda de Documento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 255))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(0, 0, 255));
        jPanel1.setName("Búsqueda"); // NOI18N
        jPanel1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPanel1FocusGained(evt);
            }
        });

        lblNombre.setText("Nombre:");

        lblCategoria.setText("Categoría:");

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/buscar.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setMaximumSize(new java.awt.Dimension(135, 35));
        btnBuscar.setMinimumSize(new java.awt.Dimension(135, 35));
        btnBuscar.setName("btnBuscar"); // NOI18N
        btnBuscar.setPreferredSize(new java.awt.Dimension(135, 35));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        lblIdUsuario.setText("ID Propietario");

        txtIdUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIdUsuarioKeyReleased(evt);
            }
        });

        lblEstado.setText("Estado");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombre)
                            .addComponent(lblCategoria)
                            .addComponent(lblIdUsuario)
                            .addComponent(lblEstado))
                        .addGap(54, 54, 54)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(cboCategoria, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtIdUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                            .addComponent(cboEstado, 0, 338, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCategoria))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIdUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEstado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/salir.png"))); // NOI18N
        jButton1.setText("Salir");
        jButton1.setMaximumSize(new java.awt.Dimension(135, 35));
        jButton1.setMinimumSize(new java.awt.Dimension(135, 35));
        jButton1.setPreferredSize(new java.awt.Dimension(135, 35));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/buscar.png"))); // NOI18N
        jButton2.setText("Ver Contenido");
        jButton2.setMaximumSize(new java.awt.Dimension(135, 35));
        jButton2.setMinimumSize(new java.awt.Dimension(135, 35));
        jButton2.setPreferredSize(new java.awt.Dimension(135, 35));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
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

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/nuevo.png"))); // NOI18N
        jMenu1.setText("Nuevo");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenu1MousePressed(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/modificar.png"))); // NOI18N
        jMenu2.setText("Modificar");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenu2MousePressed(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Eliminar - 16.png"))); // NOI18N
        jMenu3.setText("Eliminar");
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenu3MousePressed(evt);
            }
        });
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                        .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jPanel1.getAccessibleContext().setAccessibleName("Búsqueda");
        jPanel1.getAccessibleContext().setAccessibleDescription("Búsqueda");

        getAccessibleContext().setAccessibleName("Búsqueda");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        String objEstado;
        CategoriaBE objCategoria = null;
        UsuarioBE objUsuario = null;
        /* Si la categoria es todas el objeto debe ser nulo, no especificado */
        objCategoria= (CategoriaBE) this.cboCategoria.getSelectedItem();
        if (objCategoria.getNombre().compareTo("Todas") == 0){
            objCategoria = null;
        }
        /* Si se especifico un IdUsuario se crea el usuario */
        if (this.txtIdUsuario.getText().compareTo("") != 0){
            objUsuario = new UsuarioBE();
            objUsuario.setIdUsuario(Integer.parseInt(this.txtIdUsuario.getText()));
        }
        DocumentoBE objDocumento = new DocumentoBE();
        objDocumento.setUsuario(objUsuario);
        objDocumento.setCategoria(objCategoria);
        objDocumento.setNombre(this.txtNombre.getText());
        objEstado = (String) this.cboEstado.getSelectedItem();
        if (objEstado.compareTo("Todos") == 0)
            objEstado = "";
        objDocumento.setEstado(objEstado);
        try {
            this.arrDocumentos = DocumentoBL.ListarDocs(objDocumento);
            /* Obtenemos el modelo */
            DefaultTableModel tmp = (DefaultTableModel) this.jtabPaquetes.getModel();
            /* Limpiamos la tabla */
            for (int i=tmp.getRowCount() - 1; i >= 0; --i){
                tmp.removeRow(i);
            }
            /* Llenamos la grilla */
            int cnt = 0;
            UsuarioBL objUsuarioBL = new UsuarioBL();
            for (int i=0; i < arrDocumentos.size() ; ++i){
                if (objEstado.equals("") || arrDocumentos.get(i).getEstado().compareTo(objEstado)==0){
                   UsuarioBE tmpUsuario = objUsuarioBL.getUsuarioBE( this.arrDocumentos.get(i).getUsuario().getIdUsuario() );
                   this.arrDocumentos.get(i).setUsuario(tmpUsuario);
                   Object [] nuevo={ arrDocumentos.get(i).getIdDocumento() , arrDocumentos.get(i).getNombre() , arrDocumentos.get(i).getCategoria().getNombre() , arrDocumentos.get(i).getUsuario().getNombres() , arrDocumentos.get(i).getEstado()  };
                   tmp.addRow(nuevo);
                   cnt++;
                }
            }
            if (cnt == 0){
                 JOptionPane.showMessageDialog(this, "La búsqueda no encontro ningún resultado", "Buscar Documento", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (FileNotFoundException ex) {
            java.util.logging.Logger.getLogger(BuscarDocumento.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(BuscarDocumento.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(BuscarDocumento.class.getName()).log(Level.SEVERE, null, ex);
        }
               
}//GEN-LAST:event_btnBuscarActionPerformed



    private void jPanel1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPanel1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1FocusGained

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenu1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MousePressed
        JDRegistrarDocumento reg = new JDRegistrarDocumento(this.objUsuario,this.listaCategorias);
        reg.setTitle("Registrar Documento");
        reg.setModal(true);
        reg.setLocationRelativeTo(this);
        reg.setVisible(true);
    }//GEN-LAST:event_jMenu1MousePressed

    private void jMenu2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MousePressed
        int idx = this.jtabPaquetes.getSelectedRow();
        if ( idx < 0){
            JOptionPane.showMessageDialog(this, "Debe seleccionar una fila", "Mensaje",0);
        }
        else {
              ModificarDocumento vModificarDoc = null;
            try {
                if (this.objUsuario.getIdUsuario() != this.arrDocumentos.get(idx).getUsuario().getIdUsuario()){
                    JOptionPane.showMessageDialog(this, "Debe ser propietario del documento para modificar sus datos", "Error Modificar Documento", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                //this.arrDocumentos.get(idx).setUsuario(objUsuario);
                vModificarDoc = new ModificarDocumento(this.arrDocumentos.get(idx),this.listaCategorias);
            } catch (FileNotFoundException ex) {
                java.util.logging.Logger.getLogger(BuscarDocumento.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                java.util.logging.Logger.getLogger(BuscarDocumento.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(BuscarDocumento.class.getName()).log(Level.SEVERE, null, ex);
            }
            vModificarDoc.setTitle("Modificar Documento");
            vModificarDoc.setModal(true);
            vModificarDoc.setLocationRelativeTo(this);
            vModificarDoc.setVisible(true);
        }
    }//GEN-LAST:event_jMenu2MousePressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int idx = this.jtabPaquetes.getSelectedRow();
        if (idx >= 0){
            String contenido = this.arrDocumentos.get(idx).getContenido();
            JFVisualizarDocumento vis = new JFVisualizarDocumento(contenido);
            vis.setModal(true);
            vis.setLocationRelativeTo(this);
            vis.setTitle("Mostrar Contenido");
            vis.setVisible(true);
        }
        else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un documento antes", "Error Mostrar Contenido", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jMenu3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MousePressed
        // TODO add your handling code here:
        if (this.jtabPaquetes.getSelectedRowCount()!=1)
           JOptionPane.showMessageDialog(this, "Debe seleccionar un documento antes", "Error Eliminar", JOptionPane.ERROR_MESSAGE);
        else
        {
            DocumentoBL objDocumentoBL = new DocumentoBL();
            boolean result = objDocumentoBL.eliminar(this.arrDocumentos.get(this.jtabPaquetes.getSelectedRow()).getIdDocumento());
            if (result)
                    JOptionPane.showMessageDialog(null, "El Documento se elimino con éxito", "Mensaje",0);
        }
        
    }//GEN-LAST:event_jMenu3MousePressed

    private void txtIdUsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdUsuarioKeyReleased
        // TODO add your handling code here:
        Character caracter = new Character(evt.getKeyChar());
        if (!Utilitario.esDigito(caracter)) {
            String texto = "";
            for (int i = 0; i < this.txtIdUsuario.getText().length(); i++)
                if (Utilitario.esDigito(new Character(this.txtIdUsuario.getText().charAt(i))))
                    texto += this.txtIdUsuario.getText().charAt(i);
            this.txtIdUsuario.setText(texto);
            this.txtIdUsuario.getToolkit().beep();
        }
    }//GEN-LAST:event_txtIdUsuarioKeyReleased


    /*Eliminar*/

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        int idx = this.jtabPaquetes.getSelectedRow();
        if (idx >= 0){
            docSel = this.arrDocumentos.get(idx);

        }
        else {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ningún documento.", "Error", JOptionPane.ERROR_MESSAGE);
        }


        this.setVisible(false);
}//GEN-LAST:event_btnAceptarActionPerformed

    public String getNombreDocSeleccionado(){
        return this.selectedDoc;
    }

    /**
    * @param args the command line arguments
    */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JComboBox cboCategoria;
    private javax.swing.JComboBox cboEstado;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JList jList1;
    public javax.swing.JMenu jMenu1;
    public javax.swing.JMenu jMenu2;
    public javax.swing.JMenu jMenu3;
    public javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jtabPaquetes;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblIdUsuario;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JFormattedTextField txtIdUsuario;
    private javax.swing.JFormattedTextField txtNombre;
    // End of variables declaration//GEN-END:variables
    private String selectedDoc;

}
