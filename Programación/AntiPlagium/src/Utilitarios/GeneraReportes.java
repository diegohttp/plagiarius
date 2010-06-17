///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//
//package Utilitarios;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.HashMap;
//import java.util.Map;
//import net.sf.jasperreports.engine.JasperCompileManager;
//import net.sf.jasperreports.engine.JasperExportManager;
//import net.sf.jasperreports.engine.JasperFillManager;
//import net.sf.jasperreports.engine.JasperPrint;
//import net.sf.jasperreports.engine.JasperReport;
//import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
//
//
///**
// *
// * @author PATTY
// */
//public class GeneraReportes {
//
//    public static JasperPrint gestorReporte(String strNombreReporte,Map parametros, Collection list) {
//
//        //Por ahora todos los archivos leidos/creados estan en la
//        //raiz (al mismo nivel que la carpeta src):
//        //JRXML, JASPER, PDF
//        JRBeanCollectionDataSource dataSource;
//        JasperReport jasperReport;
//        JasperPrint jasperPrint;
//
//        try{
//            //1- Se llena el datasource con la informacion de la "busqueda"
//            dataSource = new JRBeanCollectionDataSource(list);
//            //2-Se compila el archivo XML y se carga en la memoria
//            jasperReport = JasperCompileManager.compileReport(strNombreReporte+".jrxml");
//            //3-Se llena el reporte con la información de la coleccion y parámetros necesarios para la consulta
//            jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, dataSource);
//            //4-Se exporta el reporte a pdf y se guarda en disco
//            JasperExportManager.exportReportToPdfFile(jasperPrint, strNombreReporte+".pdf");
//
//            System.out.println("Reporte");
//            return jasperPrint;
//        }catch (Exception e){
//          System.out.println("No hay reporte" + e);
//        }
//        return null;
//
//    }
//
//
//
//
//
//}
