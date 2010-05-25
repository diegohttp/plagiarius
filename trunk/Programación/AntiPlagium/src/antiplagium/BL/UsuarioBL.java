/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package antiplagium.BL;

import antiplagium.DAO.UsuarioDAO;

/**
 *
 * @author piere
 */
public class UsuarioBL {

    private UsuarioDAO usuarioDAO;
    private int usuarioValido;

    public UsuarioBL(){
        usuarioDAO=new UsuarioDAO();


    }

    public int AutenticarUsuario(String nombreUsuario, String contrasena){

        usuarioValido=usuarioDAO.ValidarUsuario(nombreUsuario,contrasena);


        return usuarioValido;
    }

}
