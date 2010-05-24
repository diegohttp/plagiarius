package antiplagium.DAL;

import java.sql.*;
import org.postgresql.*;


public class ConexionJDBC {

    private static Connection con;

    public static Connection getCon() {
        return con;
    }

    public static void setCon(Connection con) {
        ConexionJDBC.con = con;
    }

public static void conexion() {

    try {
            ///Libraries/postgresql-8.4-701.jdbc4.jar
            Class.forName("org.postgresql.Driver");

            String url = "jdbc:postgresql://quilla.lab.inf.pucp.edu.pe:1053/postgres";

            con = DriverManager.getConnection(url, "postgres", "cuadrado");


            Statement stmt = con.createStatement();

            //Se ejecuta una consulta y se devuelve el resultado en ResultSet

            //ResultSet rs = stmt.executeQuery("SELECT * FROM "+"public."+'"'+"Usuario"+'"');
            ResultSet rs = stmt.executeQuery("SELECT * FROM" +'"'+"Usuario"+'"');


            /* Se realizan iteraciones a través del ResultSet y se imprimen en pantalla los valores de
            algunos atributos del renglón. El ResultSet mantiene un apuntador al renglón de datos
            actual, inicialmente el apuntador es posicionado antes del primer renglón. El método next
            mueve el apuntador al siguiente renglón. */

//            while (rs.next()) {
//                System.out.println(rs.getString("nombres"));
//            }

//            stmt.close();
//            con.close();
        }

    catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
