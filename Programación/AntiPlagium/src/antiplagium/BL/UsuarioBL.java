/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package antiplagium.BL;

import antiplagium.BE.CategoriaBE;
import antiplagium.BE.RolBE;
import antiplagium.BE.TipoCeseBE;
import antiplagium.BE.UsuarioBE;
import antiplagium.DAO.UsuarioDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author piere
 */
public class UsuarioBL {

    private UsuarioDAO usuarioDAO;
    private UsuarioBE usuarioBE;
    private int usuarioValido;
    boolean r=false;

    public UsuarioBL(){
        this.usuarioDAO=new UsuarioDAO();
    }

    private UsuarioBL(UsuarioBE usuarioBE){
        this.usuarioDAO=new UsuarioDAO();
        this.usuarioBE=usuarioBE;
    }

    public int AutenticarUsuario(String nombreUsuario, String contrasena){
        try {
            usuarioValido = usuarioDAO.ValidarUsuario(nombreUsuario, contrasena);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuarioValido;
    }

    public UsuarioBE FormarUsuarioBE( int idUsuario, String nombres,String apellidoPaterno,
                                      String apellidoMaterno,String nombreUsuario, String password,
                                      Date fechaRegistro, Date fechaVencimiento,Date fechaCese,
                                      String estado, RolBE idRol, ArrayList<CategoriaBE> categorias,
                                      TipoCeseBE idTipoCese){


        usuarioBE=new UsuarioBE(idUsuario, nombres, apellidoPaterno, apellidoMaterno, nombreUsuario,
                                password, fechaRegistro, fechaVencimiento, fechaCese, estado, idRol,
                                categorias, idTipoCese);
        return usuarioBE;
    }

    public boolean guardarUsuario(UsuarioBE nuevoUsuario){
        
        try {
            r= usuarioDAO.InsertarUsuario(nuevoUsuario);
            return r;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBL.class.getName()).log(Level.SEVERE, null, ex);
            return r;
        }
        
    }

}
