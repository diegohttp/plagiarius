package antiplagium.DAL;

import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import java.util.logging.Logger;

public class ConexionJDBC {

   private static final String CONTROLADOR = "org.postgresql.Driver";
    private static final String URL_BASEDATOS = "jdbc:postgresql://quilla.lab.inf.pucp.edu.pe:1053/postgres";
    //private static final String URL_BASEDATOS = "jdbc:postgresql://LocalHost:5433/postgres";

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
        try
        {
            //carga clase controlador
            Class.forName(CONTROLADOR);

        }
        catch (ClassNotFoundException noEncontroClase)
        {
            noEncontroClase.printStackTrace();
        }
    }//fin de conexionJDBC


    public static Vector ejecutarQuery(String queryString) throws SQLException
    {
        Vector vector = new Vector();

        conexion = DriverManager.getConnection(URL_BASEDATOS, "postgres", "cuadrado");
        conexion.setAutoCommit(false);
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

    public static ResultSet ejecutarQueryResultSet(String queryString) throws SQLException
    {
        ResultSet tablaResultados = null;

        conexion = DriverManager.getConnection(URL_BASEDATOS, "postgres", "cuadrado");
        conexion.setAutoCommit(true);
        conexion.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        instruccion = conexion.createStatement();
        tablaResultados = instruccion.executeQuery(queryString);
        return tablaResultados;
    }

    public static Connection getCon()
    {
            return conexion;
    }


    public static void abrirConexion() throws SQLException, ClassNotFoundException
    {
        Class.forName(CONTROLADOR);
        conexion = DriverManager.getConnection(URL_BASEDATOS, "postgres", "cuadrado");
        conexion.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        instruccion = conexion.createStatement();
    }

    public static ResultSet ejecutarQueryString(String query) throws SQLException
    {
        tablaResultados = instruccion.executeQuery(query);
        return tablaResultados;
    }

    public static void ejecutarUpdateString(String query) throws SQLException
    {
        instruccion.executeUpdate(query);
    }

    public static void cerrarConexion() throws SQLException
    {
        conexion.close();
        instruccion.close();
        tablaResultados.close();
    }

    public void ejecutarSentencia(String strSentencia) {

        try {
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
