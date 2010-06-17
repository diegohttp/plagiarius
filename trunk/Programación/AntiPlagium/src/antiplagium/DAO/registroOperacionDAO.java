package antiplagium.DAO;

import antiplagium.BE.RegistroOperacionBE;
import java.sql.SQLException;
import antiplagium.DAL.ConexionJDBC;
import java.text.SimpleDateFormat;

public class registroOperacionDAO
{

//"INSERT INTO \"Operacion\"(\"idOperacion\", \"idUsuario\", \"nombreVentana\", \"fecha\", \"tipoOperacion\", \"descripcion\") "  +
//"VALUES (1, 1, 'administrarRoles', '05/16/2010', 'guardar registro', 'guardar registro') " ;

    private String SQL_INSERT_OPERACION  = "INSERT INTO \"Operacion\"(\"idUsuario\", \"nombreVentana\", \"fecha\", \"tipoOperacion\", \"descripcion\") "  +
                                           "VALUES ( " ;
    
    public void  insertOperacion(RegistroOperacionBE registroOperacion) throws SQLException
    {
        String SQL_Insert = null;
        String cadenaFecha = null;

        SimpleDateFormat formato=new SimpleDateFormat("dd/MMM/yyyy HH:mm:ss");
        if (registroOperacion.getFechaOperacion()!= null)
            cadenaFecha = formato.format(registroOperacion.getFechaOperacion());

        SQL_Insert = SQL_INSERT_OPERACION + 
                              registroOperacion.getIdUsuario().toString() +
                     ", '"  + registroOperacion.getNombreVentana()        +
                     "', '" + cadenaFecha                                 +
                     "', '" + registroOperacion.getTipoOperacion()        +
                     "', '" + registroOperacion.getDescripcion()    + "' )" ;

        ConexionJDBC.ejecutarUpdateString(SQL_Insert);
    }
}
