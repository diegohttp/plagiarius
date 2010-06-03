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

  public int ValidarUsuario(String nombreUsuario, String contrasena) throws SQLException{
        try {
            con = DriverManager.getConnection("jdbc:postgresql://quilla.lab.inf.pucp.edu.pe:1053/postgres", "postgres", "cuadrado");
            stmt = con.createStatement();
            //Se ejecuta una consulta y se devuelve el resultado en ResultSet
            //ResultSet rs = stmt.executeQuery("SELECT * FROM "+"public."+'"'+"Usuario"+'"');
            char cd='"';
            String cs="'";
            char nt='A';
            squery="SELECT * FROM " +cd+ "Usuario" +cd+" AS "+nt;
            squery+=" WHERE "+nt+"."+cd+"nombreUsuario"+cd+"="+cs+nombreUsuario+cs+" and "+nt+"."+cd+"password"+cd+"="+cs+contrasena+ cs;
            squery+=";";
            System.out.println(squery);

            ResultSet rs = stmt.executeQuery(squery);
            /* Se realizan iteraciones a través del ResultSet y se imprimen en pantalla los valores de
            algunos atributos del renglón. El ResultSet mantiene un apuntador al renglón de datos
            actual, inicialmente el apuntador es posicionado antes del primer renglón. El método next
            mueve el apuntador al siguiente renglón. */

            int numeroRegistros=rs.getRow();
            System.out.println(numeroRegistros);
            while (rs.next()) {
                System.out.println(rs.getString("nombres"));
                numeroRegistros=rs.getRow();
                System.out.println(numeroRegistros);
            }


//            numeroRegistros=rs.getRow();
//            System.out.println(numeroRegistros);
            squery="";
            if (numeroRegistros==1) {
                stmt.close();
                con.close();
                return 0;
            }
            else{
                stmt.close();
                con.close();
                return 1;
            }



        } catch (SQLException ex) {
            squery="";
            stmt.close();
            con.close();
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
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

        //Switch to manual transaction mode by setting
        //autocommit to false. Note that this starts the first
        //manual transaction.
           SimpleDateFormat formato=new SimpleDateFormat("yyyy-MM-dd");

           if (u.getFechaRegistro()!= null)     cadenaFechaI="'"+formato.format(u.getFechaRegistro())+"'";
           if (u.getFechaVencimiento()!=null)   cadenaFechaF="'"+formato.format(u.getFechaVencimiento())+"'";
           if (u.getFechaCese()!=null)          cadenaFechaC="'"+formato.format(u.getFechaCese())+"'";
           if (u.getIdRol()!=null)              cadenaIdROl="'"+2+"'";
                                                /*cadenaIdROl="'"+u.getIdRol().getIdRol()+"'"; no se puede aun*/
           if (u.getIdTipoCese()!=null)         cadenaIdTipoCese="'"+u.getIdTipoCese()+"'";

            con = ConexionJDBC.getCon();
            con.setAutoCommit(false);
            stmt = con.createStatement();
            squery+="INSERT INTO \"Usuario\"(\"idUsuario\", nombres, \"apellidoPaterno\", \"apellidoMaterno\", \"nombreUsuario\", \"password\", \"fechaRegistro\", \"fechaVencimiento\", \"fechaCese\",estado, \"idRol\", \"idTipoCese\") VALUES (";
            squery+=u.getIdUsuario()+",'"+u.getNombres()+"','"+u.getApellidoPaterno()+"','"+
                    u.getApellidoMaterno()+"','"+u.getNombreUsuario()+ "','"+u.getPassword()+
                    "',"+cadenaFechaI+ ","+cadenaFechaF+ ","+
                    cadenaFechaC+ ",'"+ u.getEstado()+ "',"+cadenaIdROl+ ","+cadenaIdTipoCese+");";

            System.out.println(squery);
            stmt.executeUpdate(squery);
            con.commit(); //This commits the transaction and starts a new one.

            stmt.close(); //This turns off the transaction.
            con.close();
            System.out.println("Transaction succeeded. Both records were written to the database.");
            error=true;
            return error;
      }
        catch (SQLException ex) {
                                ex.printStackTrace();

                try {
                    con.rollback();
                    stmt.close(); //This turns off the transaction.
                    con.close();
                    System.out.println("Transaction failed. No records were written to the database.");
                    return error;
                }
                catch (SQLException se) {
                        se.printStackTrace();
                        return error;
                }
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
            String cadidRol="";
            String cadidArea="";

            if(idRol!=0) { cadidRol=String.valueOf(idRol);}
            if(idArea!=0){ cadidArea=String.valueOf(idArea); }

            String queryListaUsuarios = " select A.\"nombreUsuario\", A.nombres||' '||\"apellidoPaterno\"||' '||\"apellidoMaterno\" as NombreCompleto, B.nombre as NombreRol, \"fechaVencimiento\",D.nombre as NombreCategoria ";
            queryListaUsuarios += " from \"Usuario\" A INNER JOIN \"Rol\" B ON A.\"idRol\"=B.\"idRol\" INNER JOIN \"UsuarioXCategoria\" C ON A.\"idUsuario\"=C.\"idUsuario\" INNER JOIN \"Categoria\" D on C.\"idCategoria\"=D.\"idCategoria\" ";
            queryListaUsuarios += " where A.\"nombreUsuario\" like '%"+usuario+"%' and A.nombres||' '||\"apellidoPaterno\"||' '||\"apellidoMaterno\" like '%"+nombreCompleto+"%' and (A.\"fechaRegistro\" Between '"+cadenaFechaI+"' and '"+cadenaFechaF+"') and A.\"idRol\" like '%"+cadidRol+"%' and C.\"idCategoria\" like '%"+cadidArea+"%' ";

            System.out.println(queryListaUsuarios);
            
            ResultSet rs = ConexionJDBC.ejecutarQueryString(queryListaUsuarios);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
  }

}
