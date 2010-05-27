/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package antiplagium.DAO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import antiplagium.BE.CategoriaBE;
import antiplagium.DAL.ConexionJDBC;
/**
 *
 * @author PATTY
 */
public class CategoriaDAO {

     public static boolean registrar(CategoriaBE objCategoria) throws Exception
    {
        boolean boolExito = false;

        ConexionJDBC objConexion = new ConexionJDBC();
        String strSentencia = "INSERT INTO public.Categoria (idCategoria,descripcion,nombre) VALUES ('" + objCategoria.getIdCategoria() +"','"+ objCategoria.getDescripcion() +"','"+ objCategoria.getNombre() +"');";

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

    public static ArrayList<CategoriaBE> buscar(String descripcion,String nombre) throws FileNotFoundException, IOException{

        ConexionJDBC objConexion = new ConexionJDBC();

        String strSentencia = " SELECT idCategoria, descripcion, nombre FROM Categoria  ";
            strSentencia +=
                " WHERE descripcion like '"+ descripcion+"'||'%' and " +
                " nombre like '"+ nombre+"'||'%' " +
                " ORDER BY nombre ;";

        ArrayList<CategoriaBE> arrCategoria = new ArrayList<CategoriaBE>();
        try {
            ResultSet rs = (ResultSet) objConexion.ejecutarQuery(strSentencia);

            String stridCategoria = "";
            String strdescripcion = "";
            String strnombre = "";

            while (rs.next()) {
                stridCategoria = rs.getString(1);
                strdescripcion = rs.getString(2);
                strnombre = rs.getString(3);

                arrCategoria.add(new CategoriaBE(Integer.parseInt (stridCategoria), strdescripcion, strnombre));
            }

        }
        catch (Exception a){
            System.out.println(a.getMessage());
        }
        return arrCategoria;
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
        String strSentencia = "UPDATE Categoria SET ";
            strSentencia += "descripcion='"+objCategoria.getDescripcion()+"'," +
                    " nombre='"+objCategoria.getNombre()+ "'"+
                    " WHERE idCategoria='"+objCategoria.getIdCategoria() +"'";
        try{
            objConexion.ejecutarQuery(strSentencia);
            return true;
        }
        catch (Exception a){
            System.out.println(a.getMessage());
            return false;
        }
        

    }



}
