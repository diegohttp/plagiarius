package antiplagium.view;

import antiplagium.BE.RolBE;
import antiplagium.BL.*;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;

public class JFAgregarRol extends JIFBase {

    ResultSet tablaPrivilegios;
    DefaultTableModel modeloTablaPrivilegios;

    public JFAgregarRol() {
        initComponents();
        onLoad();
    }

    private void onLoad()
    {
       PrivilegioBL privilegioBL = new PrivilegioBL();

       modeloTablaPrivilegios = new DefaultTableModel(){
       @Override
              public boolean isCellEditable(int row, int col){
                  if (col == 3) return true;
                  return false;
              }
       };
       modeloTablaPrivilegios.addColumn("idPrivilegio");
       modeloTablaPrivilegios.addColumn("nombre");
       modeloTablaPrivilegios.addColumn("descripcion");              

        try
        {
            privilegioBL.AbrirConexion();
            tablaPrivilegios = privilegioBL.getListPrivilegios();

            if (tablaPrivilegios != null)
            {
                int numFilas = 0;
                while (tablaPrivilegios.next()) {

                    Object[] fila = new Object[4];

                    fila[0] = tablaPrivilegios.getObject("idPrivilegio");
                    fila[1] = tablaPrivilegios.getObject("nombre").toString().trim();
                    fila[2] = tablaPrivilegios.getObject("descripcion").toString().trim();                    
                    
                    numFilas++;
                    modeloTablaPrivilegios.addRow(fila);
                }
                
                Boolean[] columna = new Boolean[numFilas];
                for (int i=0; i<numFilas; i++)
                {
                    columna[i] = new Boolean(true);
                }
                modeloTablaPrivilegios.addColumn("selected", columna);
                JTPrivilegios.setModel(modeloTablaPrivilegios);
                JTPrivilegios.getColumn("selected").setCellRenderer(new MultiRenderer());
                JTPrivilegios.getColumn("selected").setCellEditor(new CheckBoxCellEditor());
                JTPrivilegios.updateUI();
            }
            privilegioBL.CerrarConexion();
        }
        catch (ClassNotFoundException ex)
        {
            JOptionPane.showMessageDialog(this, ex.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        catch (SQLException excepcionSQL)
        {
            JOptionPane.showMessageDialog(this, excepcionSQL.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    class MultiRenderer extends DefaultTableCellRenderer {

        private static final long serialVersionUID = 1L;
        JCheckBox checkBox = new JCheckBox();

        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
            if (value instanceof Boolean) { // Boolean
                checkBox.setSelected(((Boolean) value).booleanValue());
                checkBox.setHorizontalAlignment(JLabel.CENTER);
                return checkBox;
            }
            String str = (value == null) ? "" : value.toString();
            return super.getTableCellRendererComponent(table, str, isSelected,
                    hasFocus, row, column);
        }
    }

//    class MultiEditor implements TableCellEditor {
//
//        private final static int BOOLEAN = 1;
//        private final static int STRING = 2;
//        private final static int NUM_EDITOR = 3;
//        DefaultCellEditor[] cellEditors;
//        int flg;

//        public MultiEditor() {
//            cellEditors = new DefaultCellEditor[NUM_EDITOR];
//            // ----------------------------------------------------
//            JCheckBox checkBox = new JCheckBox();
//            checkBox.setHorizontalAlignment(JLabel.CENTER);
//            cellEditors[BOOLEAN] = new DefaultCellEditor(checkBox);
//            // ----------------------------------------------------
//            JTextField textField = new JTextField();
//            cellEditors[STRING] = new DefaultCellEditor(textField);
//            // ----------------------------------------------------
//            flg = BOOLEAN;
//        }
//
//        public Component getTableCellEditorComponent(JTable table, Object value,
//                boolean isSelected, int row, int column) {
//            System.err.println("getTableCellEditorComponent called:");
//            System.err.println("   isSelected: " + isSelected);
//            System.err.println("   row: " + row);
//            System.err.println("   col: " + column);
//
//            if (value instanceof Boolean) { // Boolean
//                System.err.println("   Boolean");
//                flg = BOOLEAN;
//                return cellEditors[BOOLEAN].getTableCellEditorComponent(table,
//                        value, isSelected, row, column);
//            } else if (value instanceof String) { // String
//                System.err.println("   String");
//                flg = STRING;
//                return cellEditors[STRING].getTableCellEditorComponent(table,
//                        value, isSelected, row, column);
//            } else {
//                System.err.println("   Trouble!");
//            }
//            return null;
//        }
//
//        public Object getCellEditorValue() {
//            System.err.println("getCellEditorValue called");
//            System.err.println("   flg = " + flg);
//            switch (flg) {
//                case BOOLEAN:
//                case STRING:
//                    return cellEditors[flg].getCellEditorValue();
//                default:
//                    return null;
//            }
//        }
//
//        public Component getComponent() {
//            return cellEditors[flg].getComponent();
//        }
//
//        public boolean stopCellEditing() {
//            return cellEditors[flg].stopCellEditing();
//        }
//
//        public void cancelCellEditing() {
//            cellEditors[flg].cancelCellEditing();
//        }
//
//        public boolean isCellEditable(EventObject anEvent) {
//            return cellEditors[flg].isCellEditable(anEvent);
//        }
//
//        public boolean shouldSelectCell(EventObject anEvent) {
//            return cellEditors[flg].shouldSelectCell(anEvent);
//        }
//
//        public void addCellEditorListener(CellEditorListener l) {
//            cellEditors[flg].addCellEditorListener(l);
//        }
//
//        public void removeCellEditorListener(CellEditorListener l) {
//            cellEditors[flg].removeCellEditorListener(l);
//        }
//
//        public void setClickCountToStart(int n) {
//            cellEditors[flg].setClickCountToStart(n);
//        }
//
//        public int getClickCountToStart() {
//            return cellEditors[flg].getClickCountToStart();
//        }
//    }

    class CheckBoxCellEditor extends AbstractCellEditor implements TableCellEditor {

        protected JCheckBox checkBox;

        public CheckBoxCellEditor() {
            checkBox = new JCheckBox();
            checkBox.setHorizontalAlignment(SwingConstants.CENTER);
            checkBox.setBackground(Color.white);
        }

        public Component getTableCellEditorComponent(
                JTable table,
                Object value,
                boolean isSelected,
                int row,
                int column) {

            checkBox.setSelected(((Boolean) value).booleanValue());

            //            Component c = table.getDefaultRenderer(String.class).getTableCellRendererComponent(table, value, isSelected, false, row, column);
            //            if (c != null) {
            //                checkBox.setBackground(c.getBackground());
            //            }

            return checkBox;
        }

        public Object getCellEditorValue() {
            return Boolean.valueOf(checkBox.isSelected());
        }
    }





    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JBGuardar = new javax.swing.JButton();
        JPGrupo = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        JBCancelar = new javax.swing.JButton();
        JPPrivilegios = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTPrivilegios = new javax.swing.JTable();

        setClosable(false);
        setTitle("Agregar Rol");

        JBGuardar.setIcon(new javax.swing.ImageIcon("D:\\PUCP\\2010-I\\DP1\\GoogleCode\\Programación\\AntiPlagium\\Iconos\\guardar.png")); // NOI18N
        JBGuardar.setText("Guardar");
        JBGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBGuardarActionPerformed(evt);
            }
        });

        JPGrupo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nuevo Rol", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 0, 12))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial", 0, 11));
        jLabel2.setText("Nombre del Rol");

        javax.swing.GroupLayout JPGrupoLayout = new javax.swing.GroupLayout(JPGrupo);
        JPGrupo.setLayout(JPGrupoLayout);
        JPGrupoLayout.setHorizontalGroup(
            JPGrupoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPGrupoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(111, 111, 111))
        );
        JPGrupoLayout.setVerticalGroup(
            JPGrupoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPGrupoLayout.createSequentialGroup()
                .addGroup(JPGrupoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JBCancelar.setIcon(new javax.swing.ImageIcon("D:\\PUCP\\2010-I\\DP1\\GoogleCode\\Programación\\AntiPlagium\\Iconos\\salir.png")); // NOI18N
        JBCancelar.setText("Salir");
        JBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBCancelarActionPerformed(evt);
            }
        });

        JPPrivilegios.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Privilegios", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 0, 12))); // NOI18N

        JTPrivilegios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idPrivilegio", "nombre", "descripcion", "selected"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(JTPrivilegios);
        JTPrivilegios.getColumnModel().getColumn(0).setResizable(false);
        JTPrivilegios.getColumnModel().getColumn(1).setResizable(false);
        JTPrivilegios.getColumnModel().getColumn(2).setResizable(false);
        JTPrivilegios.getColumnModel().getColumn(3).setResizable(false);
        JTPrivilegios.getColumnModel().getColumn(3).setPreferredWidth(25);

        javax.swing.GroupLayout JPPrivilegiosLayout = new javax.swing.GroupLayout(JPPrivilegios);
        JPPrivilegios.setLayout(JPPrivilegiosLayout);
        JPPrivilegiosLayout.setHorizontalGroup(
            JPPrivilegiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPPrivilegiosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
                .addContainerGap())
        );
        JPPrivilegiosLayout.setVerticalGroup(
            JPPrivilegiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPPrivilegiosLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JPPrivilegios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(JBGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JBCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(JPGrupo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(JPGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JPPrivilegios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBCancelar)
                    .addComponent(JBGuardar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBCancelarActionPerformed
             this.dispose();
    }//GEN-LAST:event_JBCancelarActionPerformed

    private void JBGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBGuardarActionPerformed

        RolBL rolBL = new RolBL();
        RolBE rolBE = new RolBE();

        rolBE.setNombre(jTextField1.getText());

        try
        {
            rolBL.AbrirConexion();

            rolBL.insertRol(rolBE);
            
            rolBL.CerrarConexion();
        }
        catch(ClassNotFoundException ex)
        {
            JOptionPane.showMessageDialog(this, ex.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        catch (SQLException excepcionSQL)
        {
            JOptionPane.showMessageDialog(this, excepcionSQL.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }


//        PrivilegioBL privilegioBL = new PrivilegioBL();
//        PrivilegioBE privilegioBE = new PrivilegioBE();




    }//GEN-LAST:event_JBGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBCancelar;
    private javax.swing.JButton JBGuardar;
    private javax.swing.JPanel JPGrupo;
    private javax.swing.JPanel JPPrivilegios;
    private javax.swing.JTable JTPrivilegios;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

}
