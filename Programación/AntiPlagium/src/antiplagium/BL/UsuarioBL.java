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
import antiplagium.BE.Utilitario;
import antiplagium.DAL.ConexionJDBC;
import antiplagium.DAO.UsuarioDAO;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author piere
 */
public class UsuarioBL {

    private UsuarioDAO usuarioDAO;
    private UsuarioBE usuarioBE;
    private int usuarioValido;
    boolean r=false;
    private String cadenaError="";

    public UsuarioBL(){
        this.usuarioDAO=new UsuarioDAO();
    }

    private UsuarioBL(UsuarioBE usuarioBE){
        this.usuarioDAO=new UsuarioDAO();
        this.usuarioBE=usuarioBE;
    }

    public int AutenticarUsuario(String nombreUsuario, String contrasena, String correoE){
        
            usuarioValido = usuarioDAO.ValidarUsuario(nombreUsuario, contrasena,correoE);
        
        return usuarioValido;
    }

    public UsuarioBE FormarUsuarioBE( int idUsuario, String nombres,String apellidoPaterno,
                                      String apellidoMaterno,String nombreUsuario, String password,
                                      Date fechaRegistro, Date fechaVencimiento,Date fechaCese,
                                      EstadoBE estadoBE, RolBE rolBE, ArrayList<CategoriaBE> categorias,
                                      TipoCeseBE tipoCeseBE,String email){



        Boolean rpta=validarCadenaAlfabetica(nombres,"Nombres");
        if(rpta==false){
            cadenaError+="El campo \"Nombres\" debe ser una cadena alfabetica.\n ";
        }

        rpta=validarCadenaVacia(nombres);
        if(rpta==false){
            cadenaError+="El campo \"Nombres\" no debe estar vacio. Campo obligatorio.\n ";
        }

        rpta=validarCadenaAlfabetica(apellidoPaterno,"Apellido Paterno");
        if(rpta==false){
            cadenaError+="El campo \"Apellido Paterno\" debe ser una cadena alfabetica.\n ";
        }

        rpta=validarCadenaVacia(apellidoPaterno);
        if(rpta==false){
            cadenaError+="El campo \"Apellido Paterno\" no debe estar vacio. Campo obligatorio.\n ";
        }

        rpta=validarCadenaAlfabetica(apellidoMaterno,"Apellido Materno");
        if(rpta==false){
            cadenaError+="El campo \"Apellido Materno\" debe ser una cadena alfabetica.\n ";
        }
        
        rpta=validarCadenaVacia(apellidoMaterno);
        if(rpta==false){
            cadenaError+="El campo \"Apellido Materno\" no debe estar vacio. Campo obligatorio.\n ";
        }


        rpta=validarCadenaSinEspacios(nombreUsuario);
        if(rpta==false){
            cadenaError+="El campo \"Nombre Usuario\" debe ser una cadena sin espacios.\n ";
        }

        rpta=validarCadenaVacia(nombreUsuario);
        if(rpta==false){
            cadenaError+="El campo \"Nombre Usuario\" no debe estar vacio. Campo obligatorio.\n ";
        }

        rpta=validarCadenaVacia(password);
        if(rpta==false){
            cadenaError+="El campo \"Contrasena\" no debe estar vacio. Campo obligatorio.\n ";
        }

        SimpleDateFormat formato=new SimpleDateFormat("yyyy-MM-dd");
        String cadenaFechaI=formato.format(fechaRegistro);
        String cadenaFechaF=formato.format(fechaVencimiento);

        rpta=validarFechas(cadenaFechaI, cadenaFechaF);
        if(rpta==false){
            cadenaError+="La fecha de inicio debe ser menor a la fecha fin.\n ";
        }

        rpta=validarMail(email);
        if(rpta==false){
            cadenaError+="El campo \"Correo Electronico\" no tiene el formato correcto \"nombreUsuario@dominio.ext\".\n ";
        }


        if(cadenaError.compareTo("")!=0){
            return null;
        }

        usuarioBE=new UsuarioBE(idUsuario, nombres, apellidoPaterno, apellidoMaterno, nombreUsuario,
                                password, fechaRegistro, fechaVencimiento, fechaCese, estadoBE, rolBE,
                                categorias, tipoCeseBE,email);
        return usuarioBE;
    }

    public String getCadenaError(){

        return cadenaError;
    }

    public int getIdUsuarioSiguiente() throws SQLException, ClassNotFoundException{
        int idUsuarioSig=0;
        idUsuarioSig=usuarioDAO.getIdUsuarioSig();
        return idUsuarioSig;
    }

    public boolean guardarUsuario(UsuarioBE nuevoUsuario){
        try {
            
            r = usuarioDAO.InsertarUsuario(nuevoUsuario);
            return r;
           
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBL.class.getName()).log(Level.SEVERE, null, ex);
            return r;
        }

    }

    public boolean actualizarUsuario(UsuarioBE nuevoUsuario,UsuarioBE originalUsuario){
        
            //ConexionJDBC.abrirConexion();
            r = usuarioDAO.ActualizarUsuario(nuevoUsuario, originalUsuario);
            //ConexionJDBC.cerrarConexion();
            return r;
            

    }

    public boolean actualizarContrasena(UsuarioBE usuarioOriginal){

        Boolean r=usuarioDAO.ActualizarContrasenaUsuario(usuarioOriginal);
        return r;
    }

    public boolean validarCadenaVacia(String campo){
        if((campo==null)||(campo.length()==0)){
            return false;
        }
        return true;

    }

    public Boolean validarCadenaAlfabetica(String cadena,String nombreCampo){
        char[] caracteres = cadena.toCharArray();
            for (int i = 0; i < caracteres.length; i++) {
                if (Utilitario.esLetra(caracteres[i]) == false) {
                    //JOptionPane.showMessageDialog(null, "Debe ingresar caracteres alfabeticos en el campo "+nombreCampo, "Invalido", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }
        return true;
        
    }

    public Boolean validarCadenaSinEspacios(String cadena){
        char[] caracteres = cadena.toCharArray();
            for (int i = 0; i < caracteres.length; i++) {
                    if (caracteres[i] == ' ' || caracteres[i] == 8 ){
                      //JOptionPane.showMessageDialog(null, "El campo nombre de usuario no debe tener espacios", "Invalido", JOptionPane.ERROR_MESSAGE);
                        return false;
                    }
            }
        return true;
    }
    
    public Boolean validarFechas(String cadenaFI,String cadenaFF){
        if( (cadenaFI.compareTo(cadenaFF)>0) || (cadenaFI.compareTo(cadenaFF)==0) ){
                   //JOptionPane.showMessageDialog(null, "La fecha de inicio debe ser menor a la fecha fin ", "Invalido", JOptionPane.ERROR_MESSAGE);
                   return false;
            }
        return true;
    }
    
    public Boolean validarMail(String email){
        Boolean rpta=Utilitario.esEmailValido(email);    
        //if(rpta==false) JOptionPane.showMessageDialog(null, "El campo \"Correo Electronico\" no es valido", "Invalido", JOptionPane.ERROR_MESSAGE);
        return rpta;
    }

    public ResultSet getListaUsuarios(String usuario,String nombreCompleto,String cadenaFechaI,String cadenaFechaF, int idRol, int idArea, int idEstado){

            Boolean rpta=validarCadenaAlfabetica(nombreCompleto,"Nombre Completo");
            if(rpta==false) return null;
  
            rpta=validarFechas(cadenaFechaI, cadenaFechaF);
            if(rpta==false) return null;
         
            ResultSet rs = null;
            rs = usuarioDAO.getConsultaUsuarios(usuario, nombreCompleto, cadenaFechaI, cadenaFechaF, idRol, idArea,idEstado);
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
            String email=null;

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
                        
                        email=(String)rsUsuarioBE.getObject(13);

                        EstadoBL estadoBL=new EstadoBL();
                        if(estadoBL.ObtenerEstados(idEstado, "","").size()!=0){
                            estadoBE = estadoBL.ObtenerEstados(idEstado, "","").get(0);
                        }
                        else {estadoBE=null;}
                        
                        ConexionJDBC.abrirConexion();
                        RolBL rolBL=new RolBL();
                        ResultSet rs=rolBL.getListRoles();
                        while (rs.next()){
                            if(rs.getInt("idRol")==idRol){
                                rolBE=new RolBE(idRol,rs.getString("nombre"),rs.getString("descripcion"));
                            }
                        }
                        ConexionJDBC.cerrarConexion();

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

                    usuarioBE = new UsuarioBE(codigo, nombres, apellidoPaterno, apellidoMaterno, nombreUsuario, password, fechaRegistro, fechaVencimiento, fechaCese, estadoBE, rolBE, categorias, tipoCeseBE,email);

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

    public Boolean ElminarUsuario(UsuarioBE usuarioBE){
        try {
            Boolean r=false;
            ConexionJDBC.abrirConexion();
            r = usuarioDAO.EliminarUsuario(usuarioBE);
            ConexionJDBC.cerrarConexion();
            return r;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBL.class.getName()).log(Level.SEVERE, null, ex);
            return r;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioBL.class.getName()).log(Level.SEVERE, null, ex);
            return r;
        }
    }

    public void AbrirConexion() throws SQLException, ClassNotFoundException{
        ConexionJDBC.abrirConexion();
    }

    public void CerrarConexion() throws SQLException{
        ConexionJDBC.cerrarConexion();
    }

}
