package antiplagium.DAO;

import antiplagium.BE.RegistroOperacionBE;
import java.sql.SQLException;
import antiplagium.DAL.ConexionJDBC;
import java.sql.ResultSet;
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

    public ResultSet ConsultarLogOperaciones(int idOperacion, String nombreUsuario,String nombreCategoria,String cadenaFechaI,String cadenaFechaF,String tipoOperacion) throws SQLException{

        String queryListaOperaciones = " select D.\"idOperacion\", D.\"tipoOperacion\", A.\"idUsuario\", A.\"nombreUsuario\", D.\"fecha\", D.\"descripcion\" ";
        queryListaOperaciones+=" from \"Usuario\" A LEFT OUTER JOIN \"UsuarioXCategoria\" B ON A.\"idUsuario\"=B.\"idUsuario\" LEFT OUTER JOIN \"Categoria\" C ON B.\"idCategoria\"=C.\"idCategoria\" INNER JOIN \"Operacion\" D ON D.\"idUsuario\"=A.\"idUsuario\" ";
        queryListaOperaciones+=" where A.\"nombreUsuario\" like '%"+nombreUsuario+"%' and (D.\"fecha\" Between '"+cadenaFechaI+"' and '"+cadenaFechaF+"') and  D.\"tipoOperacion\" like '%"+tipoOperacion+"%' and (CAST (C.\"nombre\" AS character varying) like '%"+nombreCategoria+"%')  ";
        if(idOperacion!=0){
            queryListaOperaciones+=" and D.\"idOperacion\"="+idOperacion+" ";
        }
        queryListaOperaciones+=" ORDER BY D.\"idOperacion\"";

        ResultSet rs = ConexionJDBC.ejecutarQueryString(queryListaOperaciones);

        return rs;

    }
}
