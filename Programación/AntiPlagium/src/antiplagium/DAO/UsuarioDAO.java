/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package antiplagium.DAO;

import antiplagium.BE.UsuarioBE;
import antiplagium.DAL.ConexionJDBC;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author piere
 */
public class UsuarioDAO {

    Connection con;
    Statement stmt;
    Boolean error;
    String squery;

  public UsuarioDAO(){
        //ConexionJDBC.conexion();
        error=false;
        squery="";
  }

  public int ValidarUsuario(String nombreUsuario, String contrasena) {
        try {
            ConexionJDBC.abrirConexion();
            char cd = '"';
            String cs = "'";
            char nt = 'A';
            squery = "SELECT * FROM " + cd + "Usuario" + cd + " AS " + nt;
            squery += " WHERE " + nt + "." + cd + "nombreUsuario" + cd + "=" + cs + nombreUsuario + cs + " and " + nt + "." + cd + "password" + cd + "=" + cs + contrasena + cs;
            squery += ";";
            System.out.println(squery);
            ResultSet rs = ConexionJDBC.ejecutarQueryString(squery);
            int numeroRegistros = rs.getRow();
            System.out.println(numeroRegistros);
            while (rs.next()) {
                System.out.println(rs.getString("nombres"));
                numeroRegistros = rs.getRow();
                System.out.println(numeroRegistros);
            }
            ConexionJDBC.cerrarConexion();
            if (numeroRegistros == 1) {
                return 0;
            } else {
                return 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 1;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 1;
        }

  }

  public boolean InsertarUsuario(UsuarioBE nuevoUsuario) throws SQLException{

      try {
          UsuarioBE u=nuevoUsuario;

          String cadenaFechaI=null;
          String cadenaFechaF=null;
          String cadenaFechaC=null;
          String cadenaIdROl=null;
          String cadenaIdTipoCese=null;
          String cadenaIdEstado=null;

           SimpleDateFormat formato=new SimpleDateFormat("yyyy-MM-dd");

           if (u.getFechaRegistro()!= null)     cadenaFechaI="'"+formato.format(u.getFechaRegistro())+"'";
           if (u.getFechaVencimiento()!=null)   cadenaFechaF="'"+formato.format(u.getFechaVencimiento())+"'";
           if (u.getFechaCese()!=null)          cadenaFechaC="'"+formato.format(u.getFechaCese())+"'";
           
           if (u.getRolBE()!=null && u.getRolBE().getIdRol()!=0)                    cadenaIdROl="'"+u.getIdUsuario()+"'";
           if (u.getTipoCeseBE()!=null && u.getTipoCeseBE().getIdTipoCEse()!=0)     cadenaIdTipoCese="'"+u.getTipoCeseBE().getIdTipoCEse()+"'";
           if (u.getEstadoBE()!=null && u.getEstadoBE().getIdEstado()!=0)           cadenaIdEstado="'"+u.getEstadoBE().getIdEstado()+"'";
            
            squery+="INSERT INTO \"Usuario\"(\"idUsuario\", nombres, \"apellidoPaterno\", \"apellidoMaterno\", \"nombreUsuario\", \"password\", \"fechaRegistro\", \"fechaVencimiento\", \"fechaCese\", \"idRol\", \"idTipoCese\",\"idEstado\") VALUES (";
            squery+=u.getIdUsuario()+",'"+u.getNombres()+"','"+u.getApellidoPaterno()+"','"+
                    u.getApellidoMaterno()+"','"+u.getNombreUsuario()+ "','"+u.getPassword()+
                    "',"+cadenaFechaI+ ","+cadenaFechaF+ ","+
                    cadenaFechaC+","+cadenaIdROl+ ","+cadenaIdTipoCese+","+cadenaIdEstado+");";

            System.out.println(squery);
            stmt.executeUpdate(squery);
           
            error=true;
            return error;
      }
        catch (SQLException ex) {
                                ex.printStackTrace();

                    System.out.println("Transaction failed. No records were written to the database.");
                    return error;
               
        }

  }

  public int getIdUsuarioSig() throws SQLException, ClassNotFoundException{

      ConexionJDBC.abrirConexion();

      int idUsuarioSig=0;
      String queryGetIdSig="select max(\"idUsuario\") from \"Usuario\"";
      ResultSet rs =ConexionJDBC.ejecutarQueryString(queryGetIdSig);

      if (rs.next()){
        idUsuarioSig=rs.getInt(1)+1;
      }

      ConexionJDBC.cerrarConexion();

      return idUsuarioSig;

  }

  public ResultSet getConsultaUsuarios(String usuario,String nombreCompleto,String cadenaFechaI,String cadenaFechaF, int idRol, int idArea){
        try {
            String queryListaUsuarios = " select A.\"idUsuario\", A.\"nombreUsuario\", A.nombres||' '||\"apellidoPaterno\"||' '||\"apellidoMaterno\" as NombreCompleto, B.nombre as NombreRol, \"fechaVencimiento\",D.nombre as NombreCategoria ";

            String cadidRol="";
            String cadidArea="";

            if(idRol>0) { cadidRol=String.valueOf(idRol);}
            if(idArea>0){ cadidArea=String.valueOf(idArea); }

            //(TODOS VS TODOS)
            if (idRol<0 && idArea<0){
                queryListaUsuarios+=" from \"Usuario\" A LEFT OUTER JOIN \"Rol\" B ON A.\"idRol\"=B.\"idRol\" LEFT OUTER JOIN \"UsuarioXCategoria\" C ON A.\"idUsuario\"=C.\"idUsuario\" LEFT OUTER JOIN \"Categoria\" D on C.\"idCategoria\"=D.\"idCategoria\" ";
                queryListaUsuarios+=" where A.\"nombreUsuario\" like '%"+usuario+"%' and A.nombres||' '||\"apellidoPaterno\"||' '||\"apellidoMaterno\" like '%"+nombreCompleto+"%' and (A.\"fechaRegistro\" Between '"+cadenaFechaI+"' and '"+cadenaFechaF+"') and (A.\"idRol\" like '%%' or A.\"idRol\" is null ) and (C.\"idCategoria\" like '%%' or C.\"idCategoria\" is null) ";
            }
            //(OPCION VS OPCION)
            if (idRol>0 && idArea>0){
                 queryListaUsuarios += " from \"Usuario\" A INNER JOIN \"Rol\" B ON A.\"idRol\"=B.\"idRol\" INNER JOIN \"UsuarioXCategoria\" C ON A.\"idUsuario\"=C.\"idUsuario\" INNER JOIN \"Categoria\" D on C.\"idCategoria\"=D.\"idCategoria\" ";
                 queryListaUsuarios += " where A.\"nombreUsuario\" like '%"+usuario+"%' and A.nombres||' '||\"apellidoPaterno\"||' '||\"apellidoMaterno\" like '%"+nombreCompleto+"%' and (A.\"fechaRegistro\" Between '"+cadenaFechaI+"' and '"+cadenaFechaF+"') and A.\"idRol\" like '%"+cadidRol+"%' and C.\"idCategoria\" like '%"+cadidArea+"%' ";
            }
            //(OPCION VS TODOS)
            if (idRol>0 && idArea<0){
                queryListaUsuarios+=" from \"Usuario\" A LEFT OUTER JOIN \"Rol\" B ON A.\"idRol\"=B.\"idRol\" LEFT OUTER JOIN \"UsuarioXCategoria\" C ON A.\"idUsuario\"=C.\"idUsuario\" LEFT OUTER JOIN \"Categoria\" D on C.\"idCategoria\"=D.\"idCategoria\" ";
                queryListaUsuarios+=" where A.\"nombreUsuario\" like '%"+usuario+"%' and A.nombres||' '||\"apellidoPaterno\"||' '||\"apellidoMaterno\" like '%"+nombreCompleto+"%' and (A.\"fechaRegistro\" Between '"+cadenaFechaI+"' and '"+cadenaFechaF+"') and (A.\"idRol\" like '%"+cadidRol+"%') and (C.\"idCategoria\" like '%%' or C.\"idCategoria\" is null) ";
            }
            //(TODOS VS OPCION)
            if (idRol<0 && idArea>0){
                queryListaUsuarios+=" from \"Usuario\" A LEFT OUTER JOIN \"Rol\" B ON A.\"idRol\"=B.\"idRol\" LEFT OUTER JOIN \"UsuarioXCategoria\" C ON A.\"idUsuario\"=C.\"idUsuario\" LEFT OUTER JOIN \"Categoria\" D on C.\"idCategoria\"=D.\"idCategoria\" ";
                queryListaUsuarios+=" where A.\"nombreUsuario\" like '%"+usuario+"%' and A.nombres||' '||\"apellidoPaterno\"||' '||\"apellidoMaterno\" like '%"+nombreCompleto+"%' and (A.\"fechaRegistro\" Between '"+cadenaFechaI+"' and '"+cadenaFechaF+"') and (A.\"idRol\" like '%%' or A.\"idRol\" is null ) and (C.\"idCategoria\" like '%"+cadidArea+"%') ";
            }

            //(NINGUNO VS NINGUNO)
            if (idRol==0 && idArea==0){
                queryListaUsuarios+=" from \"Usuario\" A LEFT OUTER JOIN \"Rol\" B ON A.\"idRol\"=B.\"idRol\" LEFT OUTER JOIN \"UsuarioXCategoria\" C ON A.\"idUsuario\"=C.\"idUsuario\" LEFT OUTER JOIN \"Categoria\" D on C.\"idCategoria\"=D.\"idCategoria\" ";
                queryListaUsuarios+=" where A.\"nombreUsuario\" like '%%' and A.nombres||' '||\"apellidoPaterno\"||' '||\"apellidoMaterno\" like '%%' and (A.\"fechaRegistro\" Between '"+cadenaFechaI+"' and '"+cadenaFechaF+"') and A.\"idRol\" is null and C.\"idUsuario\" is null ";
            }
            //(NINGUNO VS TODOS)
            if (idRol==0 && idArea<0){
                queryListaUsuarios+=" from \"Usuario\" A LEFT OUTER JOIN \"Rol\" B ON A.\"idRol\"=B.\"idRol\" LEFT OUTER JOIN \"UsuarioXCategoria\" C ON A.\"idUsuario\"=C.\"idUsuario\" LEFT OUTER JOIN \"Categoria\" D on C.\"idCategoria\"=D.\"idCategoria\" ";
                queryListaUsuarios+=" where A.\"nombreUsuario\" like '%%' and A.nombres||' '||\"apellidoPaterno\"||' '||\"apellidoMaterno\" like '%%' and (A.\"fechaRegistro\" Between '"+cadenaFechaI+"' and '"+cadenaFechaF+"') and A.\"idRol\" is null and (C.\"idCategoria\" like '%"+cadidArea+"%' or C.\"idCategoria\" is null) ";

            }
            //(TODOS VS NINGUNO)
            if (idRol<0 && idArea==0){
                queryListaUsuarios+=" from \"Usuario\" A LEFT OUTER JOIN \"Rol\" B ON A.\"idRol\"=B.\"idRol\" LEFT OUTER JOIN \"UsuarioXCategoria\" C ON A.\"idUsuario\"=C.\"idUsuario\" LEFT OUTER JOIN \"Categoria\" D on C.\"idCategoria\"=D.\"idCategoria\" ";
                queryListaUsuarios+=" where A.\"nombreUsuario\" like '%%' and A.nombres||' '||\"apellidoPaterno\"||' '||\"apellidoMaterno\" like '%%' and (A.\"fechaRegistro\" Between '"+cadenaFechaI+"' and '"+cadenaFechaF+"') and (A.\"idRol\" like '%"+cadidRol+"%' or A.\"idRol\" is null ) and C.\"idCategoria\" is null ";

            }
            //(NINGUNO VS OPCION)
            if (idRol==0 && idArea>0){
                queryListaUsuarios+=" from \"Usuario\" A LEFT OUTER JOIN \"Rol\" B ON A.\"idRol\"=B.\"idRol\" INNER JOIN \"UsuarioXCategoria\" C ON A.\"idUsuario\"=C.\"idUsuario\" INNER JOIN \"Categoria\" D on C.\"idCategoria\"=D.\"idCategoria\" ";
                queryListaUsuarios+=" where A.\"nombreUsuario\" like '%%' and A.nombres||' '||\"apellidoPaterno\"||' '||\"apellidoMaterno\" like '%%' and (A.\"fechaRegistro\" Between '"+cadenaFechaI+"' and '"+cadenaFechaF+"') and A.\"idRol\" is null and C.\"idCategoria\" like '%"+cadidArea+"%' ";

            }
            //(OPCION VS NINGUNO)
            if (idRol>0 && idArea==0){
                queryListaUsuarios+=" from \"Usuario\" A INNER JOIN \"Rol\" B ON A.\"idRol\"=B.\"idRol\" LEFT OUTER JOIN \"UsuarioXCategoria\" C ON A.\"idUsuario\"=C.\"idUsuario\" LEFT OUTER JOIN \"Categoria\" D on C.\"idCategoria\"=D.\"idCategoria\" ";
                queryListaUsuarios+=" where A.\"nombreUsuario\" like '%%' and A.nombres||' '||\"apellidoPaterno\"||' '||\"apellidoMaterno\" like '%%' and (A.\"fechaRegistro\" Between '"+cadenaFechaI+"' and '"+cadenaFechaF+"') and A.\"idRol\" like '%"+cadidRol+"%' and C.\"idCategoria\" is null ";

            }

            queryListaUsuarios+=" ORDER BY A.\"idUsuario\"";
            
            System.out.println(queryListaUsuarios);
            
            ResultSet rs = ConexionJDBC.ejecutarQueryString(queryListaUsuarios);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
  }

  public ResultSet getUsuario(int idUsuario){
        try {
            String queryBusqueda = "Select * from \"Usuario\" A where A.\"idUsuario\"=" + String.valueOf(idUsuario);
            ResultSet rs = ConexionJDBC.ejecutarQueryString(queryBusqueda);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
  }

  public ResultSet getCategorias(int idUsuario){
        try {
            String queryBusquedaCat = "Select C.* from \"UsuarioXCategoria\" A INNER JOIN \"Usuario\" B ON A.\"idUsuario\"=B.\"idUsuario\" INNER JOIN \"Categoria\" C ON A.\"idCategoria\"=C.\"idCategoria\" ";
            queryBusquedaCat+=" Where B.\"idUsuario\"="+String.valueOf(idUsuario);
            System.out.println(queryBusquedaCat);
            ResultSet rsCategorias = ConexionJDBC.ejecutarQueryString(queryBusquedaCat);
            return rsCategorias;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

  }

}
