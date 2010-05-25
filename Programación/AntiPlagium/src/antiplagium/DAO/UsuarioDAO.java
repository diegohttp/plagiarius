/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package antiplagium.DAO;

import antiplagium.DAL.ConexionJDBC;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author piere
 */
public class UsuarioDAO {

  public UsuarioDAO(){
        ConexionJDBC.conexion();
  }

  public int ValidarUsuario(String nombreUsuario, String contrasena){
        try {
            Connection con = ConexionJDBC.getCon();
            Statement stmt = con.createStatement();
            //Se ejecuta una consulta y se devuelve el resultado en ResultSet
            //ResultSet rs = stmt.executeQuery("SELECT * FROM "+"public."+'"'+"Usuario"+'"');
            char cd='"';
            String cs="'";
            char nt='A';
            String squery="SELECT * FROM " +cd+ "Usuario" +cd+" AS "+nt;
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
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }


        return 0;
  }

}
