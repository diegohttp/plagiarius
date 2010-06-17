/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JDNuevaContrasena.java
 *
 * Created on 13/06/2010, 02:38:30 PM
 */

package antiplagium.view;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

/**
 *
 * @author piere
 */
public class JDNuevaContrasena extends javax.swing.JDialog {

    private JPasswordField jPFContrasenaActual;
    private JPasswordField jPFContrasenaNueva;
    private JPasswordField jPFConfirmar;

    private String contrasenaNueva=null;
    private String contrasenaOriginal=null;

    public String getContrasenaNueva() {
        return contrasenaNueva;
    }
    /** Creates new form JDNuevaContrasena */
    public JDNuevaContrasena(String contrasena) {
        //super(parent, modal);
        initComponents();
        contrasenaOriginal=contrasena;

        jPFContrasenaActual=new JPasswordField();
        jPFContrasenaActual.setSize(191, 30);
        jPContrasenaAct.add(jPFContrasenaActual);

        jPFContrasenaNueva=new JPasswordField();
        jPFContrasenaNueva.setSize(191, 30);
        jPContrasenaNueva.add(jPFContrasenaNueva);

        jPFConfirmar=new JPasswordField();
        jPFConfirmar.setSize(191, 30);
        jPConfirmarContrasena.add(jPFConfirmar);





    }



    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPContrasenaAct = new javax.swing.JPanel();
        jPContrasenaNueva = new javax.swing.JPanel();
        jPConfirmarContrasena = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Contrasena"));

        jLabel1.setText("Contrasena Nueva");

        jLabel2.setText("Confirmar Contrasena Nueva");

        jLabel3.setText("Contrasena Actual");

        jPContrasenaAct.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPContrasenaAct.setPreferredSize(new java.awt.Dimension(104, 30));

        javax.swing.GroupLayout jPContrasenaActLayout = new javax.swing.GroupLayout(jPContrasenaAct);
        jPContrasenaAct.setLayout(jPContrasenaActLayout);
        jPContrasenaActLayout.setHorizontalGroup(
            jPContrasenaActLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 187, Short.MAX_VALUE)
        );
        jPContrasenaActLayout.setVerticalGroup(
            jPContrasenaActLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 26, Short.MAX_VALUE)
        );

        jPContrasenaNueva.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPContrasenaNueva.setPreferredSize(new java.awt.Dimension(104, 30));

        javax.swing.GroupLayout jPContrasenaNuevaLayout = new javax.swing.GroupLayout(jPContrasenaNueva);
        jPContrasenaNueva.setLayout(jPContrasenaNuevaLayout);
        jPContrasenaNuevaLayout.setHorizontalGroup(
            jPContrasenaNuevaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 187, Short.MAX_VALUE)
        );
        jPContrasenaNuevaLayout.setVerticalGroup(
            jPContrasenaNuevaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 26, Short.MAX_VALUE)
        );

        jPConfirmarContrasena.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPConfirmarContrasena.setPreferredSize(new java.awt.Dimension(104, 30));

        javax.swing.GroupLayout jPConfirmarContrasenaLayout = new javax.swing.GroupLayout(jPConfirmarContrasena);
        jPConfirmarContrasena.setLayout(jPConfirmarContrasenaLayout);
        jPConfirmarContrasenaLayout.setHorizontalGroup(
            jPConfirmarContrasenaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 187, Short.MAX_VALUE)
        );
        jPConfirmarContrasenaLayout.setVerticalGroup(
            jPConfirmarContrasenaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 26, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel2)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPContrasenaAct, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPContrasenaNueva, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPConfirmarContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jPContrasenaAct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jPContrasenaNueva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jPConfirmarContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAceptar)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed

        //char[] contra=jPFContrasenaActual.getPassword();
        String contraAc=String.valueOf(jPFContrasenaActual.getPassword());
        String contraNu=String.valueOf(jPFContrasenaNueva.getPassword());
        String confirma=String.valueOf(jPFConfirmar.getPassword());
        //JOptionPane.showMessageDialog(this, cad);

        if (contrasenaOriginal.compareTo(contraAc)==0){
                if(contraNu.compareTo(confirma)==0){
                    int respuesta=JOptionPane.showConfirmDialog(this, "Esta seguro de cambiar la contrasena?", "Informacion", JOptionPane.OK_CANCEL_OPTION);
                    if (respuesta==0){
                         contrasenaNueva=contraNu;
                         this.setVisible(false);
                    }
                }
                else {
                    JOptionPane.showMessageDialog(this,"Confirmacion incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
                }
        }
        else {
            JOptionPane.showMessageDialog(this,"Contrasena actual incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
            this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    /**
    * @param args the command line arguments
    */
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPConfirmarContrasena;
    private javax.swing.JPanel jPContrasenaAct;
    private javax.swing.JPanel jPContrasenaNueva;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

}
