package antiplagium.DAL;

import java.sql.*;

import org.postgresql.*;


public class ConexionJDBC {

public static void conexion() {
        
    try {            
            Class.forName("org.postgresql.Driver");            

            String url = "jdbc:postgresql:quilla.lab.inf.pucp.edu.pe:1053/postgres";

            Connection con = DriverManager.getConnection(url, "postgres", "cuadrado");

            Statement stmt = con.createStatement();

            //Se ejecuta una consulta y se devuelve el resultado en ResultSet

            ResultSet rs = stmt.executeQuery("select * from Usuario");

            /* Se realizan iteraciones a través del ResultSet y se imprimen en pantalla los valores de
            algunos atributos del renglón. El ResultSet mantiene un apuntador al renglón de datos
            actual, inicialmente el apuntador es posicionado antes del primer renglón. El método next
            mueve el apuntador al siguiente renglón. */

            while (rs.next()) {
                System.out.println(rs.getString("nombres"));
            }
        }
       
    catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
