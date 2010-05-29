/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package antiplagium.DAO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import antiplagium.BE.CategoriaBE;
import antiplagium.DAL.ConexionJDBC;
import java.util.Vector;
/**
 *
 * @author PATTY
 */
public class CategoriaDAO {

     public static boolean registrar(CategoriaBE objCategoria) throws Exception
    {
        boolean boolExito = false;

        ConexionJDBC objConexion = new ConexionJDBC();
        String strSentencia = "INSERT INTO \"Categoria\" (\"idCategoria\",descripcion,nombre) VALUES ('" + objCategoria.getIdCategoria() +"','"+ objCategoria.getDescripcion() +"','"+ objCategoria.getNombre() +"');";

        try{
            objConexion.ejecutarSentencia(strSentencia);

            boolExito=true;
        }

        catch (Exception a){
            System.out.println(a.getMessage());
        }
        /*finally{objConexion.SalirUID();}*/

        return boolExito;
    }

    public static ArrayList<CategoriaBE> buscar(String descripcion,String nombre) throws FileNotFoundException, IOException, SQLException{

        ConexionJDBC objConexion = new ConexionJDBC();

        String strSentencia = " SELECT \"idCategoria\", descripcion, nombre FROM \"Categoria\"";
        if (descripcion.compareTo("") != 0 && nombre.compareTo("")==0){
            strSentencia += " WHERE descripcion like '%"+ descripcion + "%' and nombre like '%"+ nombre + "%'" ;
        }
        else if (descripcion.compareTo("")!=0){
            strSentencia += " WHERE descripcion like '%"+ descripcion + "%'";
        }
        else if (nombre.compareTo("")!=0){
            strSentencia += " WHERE nombre like '%"+ nombre + "%'";
        }
        strSentencia +=" ORDER BY \"idCategoria\"";
        System.out.println(strSentencia);
        /*strSentencia +=
                " WHERE descripcion like '"+ descripcion+"'||'%' and " +
                " nombre like '"+ nombre+"'||'%' " +
                " ORDER BY nombre ;";
            */
        Vector arrCategoria;
        arrCategoria = objConexion.ejecutarQuery(strSentencia);
        ArrayList<CategoriaBE> gestorCategoria = new ArrayList<CategoriaBE>();

        for (int i=0; i < arrCategoria.size(); ++i){
            Object[] registro = (Object[])arrCategoria.get(i);
            gestorCategoria.add(new CategoriaBE((Integer)registro[0],(String)registro[1],(String)registro[2]));
        }
        return gestorCategoria;
    }

    public static CategoriaBE buscar(int idCategoria) throws FileNotFoundException, IOException{

        ConexionJDBC objConexion = new ConexionJDBC();

        String strSentencia = " SELECT idCategoria,descripcion,nombre from Categoria";
            strSentencia += " WHERE idCategoria ='"+idCategoria+"' ";

        CategoriaBE objCategoria = new CategoriaBE();

        try {
            ResultSet rs = (ResultSet) objConexion.ejecutarQuery(strSentencia);

            while (rs.next()) {
                objCategoria.setIdCategoria(rs.getInt(1));
                objCategoria.setDescripcion(rs.getString(2));
                objCategoria.setNombre(rs.getString(3));
            }
        }
        catch (Exception a){
            System.out.println(a.getMessage());
        }
        return objCategoria;
    }


    public static boolean modificar(CategoriaBE objCategoria)throws FileNotFoundException, IOException {

        ConexionJDBC objConexion = new ConexionJDBC();
        String strSentencia = "UPDATE \"Categoria\" SET ";
            strSentencia += "descripcion='"+objCategoria.getDescripcion()+"'," +
                    " nombre='"+objCategoria.getNombre()+ "'"+
                    " WHERE \"idCategoria\"='"+objCategoria.getIdCategoria() +"'";
        try{
            objConexion.ejecutarSentencia(strSentencia);
            return true;
        }
        catch (Exception a){
            System.out.println(a.getMessage());
            return false;
        }
        

    }

   


}
