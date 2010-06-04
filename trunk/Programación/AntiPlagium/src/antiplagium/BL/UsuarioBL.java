/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package antiplagium.BL;

import antiplagium.BE.CategoriaBE;
import antiplagium.BE.EstadoBE;
import antiplagium.BE.RolBE;
import antiplagium.BE.TipoCeseBE;
import antiplagium.BE.UsuarioBE;
import antiplagium.DAL.ConexionJDBC;
import antiplagium.DAO.UsuarioDAO;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
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
        
            usuarioValido = usuarioDAO.ValidarUsuario(nombreUsuario, contrasena);
        
        return usuarioValido;
    }

    public UsuarioBE FormarUsuarioBE( int idUsuario, String nombres,String apellidoPaterno,
                                      String apellidoMaterno,String nombreUsuario, String password,
                                      Date fechaRegistro, Date fechaVencimiento,Date fechaCese,
                                      EstadoBE estadoBE, RolBE rolBE, ArrayList<CategoriaBE> categorias,
                                      TipoCeseBE tipoCeseBE){


        usuarioBE=new UsuarioBE(idUsuario, nombres, apellidoPaterno, apellidoMaterno, nombreUsuario,
                                password, fechaRegistro, fechaVencimiento, fechaCese, estadoBE, rolBE,
                                categorias, tipoCeseBE);
        return usuarioBE;
    }

    public int getIdUsuarioSiguiente() throws SQLException, ClassNotFoundException{
        int idUsuarioSig=0;
        idUsuarioSig=usuarioDAO.getIdUsuarioSig();
        return idUsuarioSig;
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

    public ResultSet getListaUsuarios(String usuario,String nombreCompleto,String cadenaFechaI,String cadenaFechaF, int idRol, int idArea){
        ResultSet rs=null;
        rs=usuarioDAO.getConsultaUsuarios(usuario,nombreCompleto, cadenaFechaI, cadenaFechaF, idRol,  idArea);
        return rs;
    }


    public UsuarioBE getUsuarioBE(int idUsuario){
        try {
            ConexionJDBC.abrirConexion();
            ResultSet rsUsuarioBE;
            rsUsuarioBE = usuarioDAO.getUsuario(idUsuario);

            int codigo = 0;
            String nombres = null;
            String apellidoPaterno = null;
            String apellidoMaterno = null;
            String nombreUsuario = null;
            String password = null;
            Date fechaRegistro = null;
            Date fechaVencimiento = null;
            Date fechaCese = null;
            int idRol;
            int idTipoCese;
            int idEstado;
            EstadoBE estadoBE = null;
            RolBE rolBE = null;
            TipoCeseBE tipoCeseBE = null;
            if (rsUsuarioBE != null) {
                try {
                    while (rsUsuarioBE.next()) {
                        codigo = (Integer) rsUsuarioBE.getObject(1);
                        nombres = (String) rsUsuarioBE.getObject(2);
                        apellidoPaterno = (String) rsUsuarioBE.getObject(3);
                        apellidoMaterno = (String) rsUsuarioBE.getObject(4);
                        nombreUsuario = (String) rsUsuarioBE.getObject(5);
                        password = (String) rsUsuarioBE.getObject(6);
                        fechaRegistro = (Date) rsUsuarioBE.getObject(7);
                        fechaVencimiento = (Date) rsUsuarioBE.getObject(8);
                        fechaCese = (Date) rsUsuarioBE.getObject(9);

                        if(rsUsuarioBE.getObject(10)!=null){
                            idRol = (Integer) rsUsuarioBE.getObject(10);
                        }
                        else {idRol=0;}
                        if (rsUsuarioBE.getObject(11)!=null){
                            idTipoCese = (Integer) rsUsuarioBE.getObject(11);
                        }
                        else { idTipoCese=0; }

                        if(rsUsuarioBE.getObject(12)!=null){
                            idEstado = (Integer) rsUsuarioBE.getObject(12);
                        }
                        else{idEstado=0;}

                        estadoBE = new EstadoBE();
                        estadoBE.setIdEstado(idEstado);
                        rolBE = new RolBE();
                        rolBE.setIdRol(idRol);
                        tipoCeseBE = new TipoCeseBE();
                        tipoCeseBE.setIdTipoCEse(idTipoCese);
                    }
                 ConexionJDBC.cerrarConexion();
                 ConexionJDBC.abrirConexion();
                 ResultSet rsCategorias;
                 rsCategorias = usuarioDAO.getCategorias(idUsuario);

                    ArrayList<CategoriaBE> categorias = null;
                    if (rsCategorias != null) {
                        categorias = new ArrayList<CategoriaBE>();
                        while (rsCategorias.next()) {
                            CategoriaBE catBE = null;
                            int idCategoria = rsCategorias.getInt("idCategoria");
                            String descripcion = rsCategorias.getString("descripcion");
                            String nombre = rsCategorias.getString("nombre");
                            catBE = new CategoriaBE(idCategoria, descripcion, nombre);
                            categorias.add(catBE);
                        }
                    }
                    usuarioBE = new UsuarioBE(codigo, nombres, apellidoPaterno, apellidoMaterno, nombreUsuario, password, fechaRegistro, fechaVencimiento, fechaCese, estadoBE, rolBE, categorias, tipoCeseBE);
                    ConexionJDBC.cerrarConexion();
                    return usuarioBE;
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioBL.class.getName()).log(Level.SEVERE, null, ex);
                    return null;
                }
            } else {
                    return null;
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBL.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioBL.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public void AbrirConexion() throws SQLException, ClassNotFoundException
    {
        ConexionJDBC.abrirConexion();
    }

    public void CerrarConexion() throws SQLException
    {
        ConexionJDBC.cerrarConexion();
    }

}
