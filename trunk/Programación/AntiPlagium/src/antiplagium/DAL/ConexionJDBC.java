package antiplagium.DAL;

import java.sql.*;
import java.util.Vector;
import javax.swing.JOptionPane;

public class ConexionJDBC {

    private static final String CONTROLADOR = "org.postgresql.Driver";
    private static final String URL_BASEDATOS = "jdbc:postgresql://quilla.lab.inf.pucp.edu.pe:1053/postgres";

    public static Connection conexion = null;
    public static Statement  instruccion = null;
    public static ResultSet  tablaResultados = null;


    private String driver;
    private String connectString;
    private String user;
    private String password;
    private Statement stmt;
    private Connection con;



    public static void conexion()
    {
        try {
            //carga clase controlador
            Class.forName(CONTROLADOR);

            //establece conexion con base de datos
            //conexion = DriverManager.getConnection(URL_BASEDATOS, "postgres", "cuadrado");

            //crea objeto statement para consultar la base de datos
            //instruccion = conexion.createStatement();
            
//             Ejemplo consulta base de datos
//            tablaResultados = instruccion.executeQuery("SELECT * FROM" +'"'+"Usuario"+'"');
//
//            while (tablaResultados.next()) {
//                  System.out.println(tablaResultados.getString("nombres"));
//            }
        }
//        catch ( SQLException excepcionSql)
//        {
//            excepcionSql.printStackTrace();
//        }
        catch (ClassNotFoundException noEncontroClase)
        {
            noEncontroClase.printStackTrace();
        }
//        finally //asegura que tabla de resultados, instruccion y conexión estén cerrados
//        {
//            try
//            {
//                tablaResultados.close();
//                instruccion.close();
//                conexion.close();
//            }
//            catch(Exception excepcion)
//            {
//                excepcion.printStackTrace();
//            }
//        }//fin de finally
    }//fin de conexionJDBC

    public static Vector ejecutarQuery(String queryString) throws SQLException
    {
        Vector vector = new Vector();
        
        conexion = DriverManager.getConnection(URL_BASEDATOS, "postgres", "cuadrado");
        conexion.setAutoCommit(true);
        conexion.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        instruccion = conexion.createStatement();
        tablaResultados = instruccion.executeQuery(queryString);
        
        if (tablaResultados.getMetaData().getColumnCount() > 0)
        {
            int nroColumnas = tablaResultados.getMetaData().getColumnCount();

            while(tablaResultados.next())
            {
                Object[] registro = new Object[nroColumnas];
                for (int i=0; i < nroColumnas; i++)
                {
                    registro[i] = tablaResultados.getObject(i+1);
                }
                vector.addElement(registro);
            }
        }

        tablaResultados.close();
        instruccion.close();
        conexion.close();
                              
        return vector;
    }

    public static Connection getCon()
    {
            return conexion;
    }

    public void ejecutarSentencia(String strSentencia) {

        try {
            Class.forName(CONTROLADOR);
            con = DriverManager.getConnection(URL_BASEDATOS, "postgres", "cuadrado");
            stmt = con.createStatement();
            stmt.executeUpdate(strSentencia);
        }
        catch ( Exception e ) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }

    }

    /*
     instruccion = conexion.createStatement();
        tablaResultados = instruccion.executeQuery(queryString);
     */


}
