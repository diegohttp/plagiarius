package antiplagium.DAL;

import java.sql.*;
import org.postgresql.*;

public class ConexionJDBC {

public static void conexion() {
        
    try {            
            Class.forName("org.postgresql.Driver");            

            //String url = "jdbc:postgresql:quilla.lab.inf.pucp.edu.pe:1053/postgres";
            String url = "jdbc:postgresql://localhost:5433/postgres";

            //Connection con = DriverManager.getConnection(url, "postgres", "cuadrado");
            Connection con = DriverManager.getConnection(url, "postgres", "aaa");

            Statement stmt = con.createStatement();

            //Se ejecuta una consulta y se devuelve el resultado en ResultSet

            ResultSet rs = stmt.executeQuery(" select * from \"Usuario\" ");

            while (rs.next())
            {
                System.out.println(rs.getString("nombre"));
            }
        }       
    catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
