package antiplagium.DAL;

import java.sql.*;

public class ConexionJDBC {

    private static final String CONTROLADOR = "org.postgresql.Driver";
    private static final String URL_BASEDATOS = "jdbc:postgresql://quilla.lab.inf.pucp.edu.pe:1053/postgres";

    private static Connection conexion = null;
    private static Statement  instruccion = null;
    private static ResultSet  tablaResultados = null;
    
    public static void conexion()
    {
        try {
            //carga clase controlador
            Class.forName(CONTROLADOR);

            //establece conexion con base de datos
            conexion = DriverManager.getConnection(URL_BASEDATOS, "postgres", "cuadrado");

            //crea objeto statement para consultar la base de datos
            instruccion = conexion.createStatement();
            
//             Ejemplo consulta base de datos
//            tablaResultados = instruccion.executeQuery("SELECT * FROM" +'"'+"Usuario"+'"');
//
//            while (tablaResultados.next()) {
//                  System.out.println(tablaResultados.getString("nombres"));
//            }
        }
        catch ( SQLException excepcionSql)
        {
            excepcionSql.printStackTrace();
        }
        catch (ClassNotFoundException noEncontroClase)
        {
            noEncontroClase.printStackTrace();
        }
        finally //asegura que tabla de resultados, instruccion y conexión estén cerrados
        {
            try
            {
                tablaResultados.close();
                instruccion.close();
                conexion.close();
            }
            catch(Exception excepcion)
            {
                excepcion.printStackTrace();
            }
        }//fin de finally
    }//fin de conexionJDBC

    public static Connection getCon()
    {
            return conexion;
    }

}
