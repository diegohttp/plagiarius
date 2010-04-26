/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package secuenciasmaximales;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
/**
 *
 * @author alulab
 */
public class SecuenciasMaximales {
    private ArrayList<Documento> alstDocumento;
    private HashMap<String,Integer> diccionario;
    private ArrayList<String> alstPalabra;
    private ArrayList< ArrayList<NodoOcurrencia> > alstOcurrenciaxPalabra;
    private ArrayList< BufferedReader > alstArchivos;
    private int contDocumentos;
    private int contPalabras;
    private int palabrasEncontradas;
    private int palabrasTotales;
    /**
     * @param args the command line arguments
     */
    SecuenciasMaximales(){
        this.alstDocumento = new ArrayList<Documento>();
        this.diccionario = new HashMap<String,Integer>();
        this.alstPalabra = new ArrayList<String>();
        this.alstOcurrenciaxPalabra = new ArrayList< ArrayList<NodoOcurrencia> >();
        this.alstArchivos = new ArrayList< BufferedReader >();
        this.contDocumentos = 0;
        this.contPalabras = 0;
        this.palabrasEncontradas = 0;
        this.palabrasTotales = 0;
    }

    public void insertarPalabra(int idDoc, String word){
        //System.out.println("Se trata de insertar " + word);
        if (diccionario.containsKey(word)){
            //Se debe agregar una referencia al documento predecesor
            int idxWord = diccionario.get(word);
            //System.out.println(word + " ya existia en el diccionario con id = " + idxWord);
            alstDocumento.get(idDoc).insertarNodoPalabra(idxWord);
        }
        else {
            //Agregamos al HashMap
            diccionario.put(word, contPalabras);
            int idxWord = contPalabras;
            //System.out.println(word + " no existe en el diccionario, se inserta con id = " + idxWord);
            alstPalabra.add(word);
            alstDocumento.get(idDoc).insertarNodoPalabra(idxWord);
            contPalabras++;
        }
    }

    public void agregarDocumento(){
        /* Insertamos un nuevo documento y aumentamos el contador */
        alstDocumento.add(new Documento(contDocumentos++));
    }

    public int getIdDocActual(){
        return contDocumentos - 1;
    }

    public void leerDocumento(int idDoc,ArrayList<String> pal){
        this.alstDocumento.set(idDoc, new Documento(idDoc) );
        for (int i=0; i<pal.size(); i++){
            this.insertarPalabra(idDoc, pal.get(i));
        }
        this.alstDocumento.get(idDoc).cerrarEnlaces();
    } 

    public void recorrerDocActual(){
        int docActual = this.getIdDocActual();
        /*for (int i=0; i < alstPalabra.size(); ++i){
            System.out.println("Palabra = " + alstPalabra.get(i) + "\tidPalabra = " + i);
        }*/
        this.alstDocumento.get(docActual).recorrerDocumento();
    }

    public void creacionEnlacesVerticales(){
        int idW;
        int idxNodo;
        /* Creamos la estructura con N vectores (N es la cantidad de palabras
            totales)
        */
        for (int i=0; i < this.alstPalabra.size(); ++i)
            this.alstOcurrenciaxPalabra.add(new ArrayList<NodoOcurrencia>());

        for (int i=0; i < this.alstPalabra.size(); ++i){
            idW = this.diccionario.get(this.alstPalabra.get(i));
            for (int j=0; j < this.alstDocumento.size(); ++j){
                idxNodo = this.alstDocumento.get(j).contienePalabra(idW);
                if (idxNodo >= 0){
                    this.alstOcurrenciaxPalabra.get(i).add( new NodoOcurrencia(this.alstDocumento.get(j).getId(),idxNodo));
                }
            }
        }
    }

    public void recorreVerticales(){
        for (int i=0; i < this.alstPalabra.size(); ++i){
            System.out.println("Palabra = " + this.alstPalabra.get(i) + "\nOcurrencias:\n");
            for (int j=0; j < this.alstOcurrenciaxPalabra.get(i).size(); ++j){
                System.out.println("IdDoc = "+ this.alstOcurrenciaxPalabra.get(i).get(j).getIdDoc() + "\tIdNodo = " +
                this.alstOcurrenciaxPalabra.get(i).get(j).getIdNodo());
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        SecuenciasMaximales sm = new SecuenciasMaximales();
        sm.leerNombreArchivos("entrada.txt");
        int cnt = 0;
        sm.agregarDocumento();
        int doc = 1;
        for (int i=1; i < sm.alstArchivos.size(); ++i){
            while (sm.alstArchivos.get(i).ready()){
                sm.agregarDocumento();
                sm.leerParrafo(i, doc);
                doc++;
            }
        }
        while (sm.alstArchivos.get(0).ready()){
            sm.leerParrafo(0,0);
            sm.alstOcurrenciaxPalabra.clear();
            sm.creacionEnlacesVerticales();
            sm.palabrasTotales += sm.alstDocumento.get(0).getCantPalabras();
            int percent = 0;
            int cmpVal;
            for (int i=1; i < sm.alstDocumento.size(); ++i){
                cmpVal = sm.comparaDocumentos(0, i, 2);
                percent = Math.max(percent,cmpVal);
                if (percent == 100) break;
            }

            sm.palabrasEncontradas += percent;
            System.out.println("Porcentaje de plagio parrafo " + (cnt + 1) + " " + (percent*100)/sm.alstDocumento.get(0).getCantPalabras());
            cnt++;
        }
        System.out.println("Porcentaje de plagio total del texto = " + (sm.palabrasEncontradas*100) / sm.palabrasTotales);
    }

    public int comparaDocumentos(int idDoc1,int idDoc2,int gap){
        ArrayList< ArrayList<Integer> > alstSM = new ArrayList< ArrayList<Integer> >();
        int nodoActual = 0;
        int referenciaNodo = 0;
        int idW;
        int cantSec = 1;
        int res = 0;
        int numCoincidencias = 0;
        alstSM.add(new ArrayList<Integer>());
        while (nodoActual >= 0){
            idW = this.alstDocumento.get(idDoc1).getNodos().get(nodoActual).getIdPalabra();
            //System.out.println("Se busca con la palabra " + this.alstPalabra.get(idW));
            if (this.alstDocumento.get(idDoc2).contienePalabra(idW) >= 0){
                //System.out.println("Esta palabra si esta en el otro documento");
                alstSM.get(cantSec - 1).add(idW);
                int actId = this.alstDocumento.get(idDoc2).contienePalabra(idW);
                int tmpNodo = this.alstDocumento.get(idDoc1).getNodos().get(nodoActual).getNextNodo(referenciaNodo);
                int tmpRef = this.alstDocumento.get(idDoc1).getNodos().get(nodoActual).getNextReferencia(referenciaNodo);
                if (tmpNodo >= 0){  /* Si no se busca el ultimo nodo */
                    int nextIdPal = this.alstDocumento.get(idDoc1).getNodos().get(tmpNodo).getIdPalabra();
                    int nextId = this.alstDocumento.get(idDoc2).contienePalabra(nextIdPal);
                    if (nextId < 0 || !cumpleAdicion(idDoc2,actId,nextId,gap)){
                        if (alstSM.get(cantSec - 1).size() < 2){
                            //System.out.println("Si cumple con la adicion");
                            alstSM.get(cantSec - 1).clear();
                        }
                        else {
                            System.out.println(alstSM.get(cantSec - 1).size());
                            numCoincidencias += alstSM.get(cantSec - 1).size();
                            cantSec++;
                            alstSM.add(new ArrayList<Integer>());
                        }
                    }
                }
                nodoActual = tmpNodo;
                referenciaNodo = tmpRef;
            }
            else {
                //System.out.println("No esta en el otro documento");
                if (alstSM.get(cantSec - 1).size() < 2){
                    alstSM.get(cantSec - 1).clear();
                }
                else {
                    System.out.println(alstSM.get(cantSec - 1).size());
                    numCoincidencias += alstSM.get(cantSec - 1).size();
                    cantSec++;
                    alstSM.add(new ArrayList<Integer>());
                }
                int tmpNodo = this.alstDocumento.get(0).getNodos().get(nodoActual).getNextNodo(referenciaNodo);
                int tmpRef = this.alstDocumento.get(0).getNodos().get(nodoActual).getNextReferencia(referenciaNodo);
                nodoActual = tmpNodo;
                referenciaNodo = tmpRef;
            }
        }
        if (alstSM.get(cantSec - 1).size() < 2){
            alstSM.remove(cantSec - 1);
            cantSec--;
        }
        else if (cantSec > 0){
            numCoincidencias += alstSM.get(cantSec - 1).size();
        }
        this.imprimeResultados(alstSM);
        //System.out.println("nc = " + numCoincidencias);
        //res = (numCoincidencias*100) / this.alstDocumento.get(0).getCantPalabras();
        //System.out.println("res = " + res);
        return numCoincidencias;
    }

    public boolean cumpleAdicion(int idDoc,int idAct,int idNext,int gap){
        ArrayList<Integer> A = this.alstDocumento.get(idDoc).getNodos().get(idAct).getPosiciones();
        ArrayList<Integer> B = this.alstDocumento.get(idDoc).getNodos().get(idNext).getPosiciones();
        int minDiff = Integer.MAX_VALUE;
        int posA;
        int posB;
        for (int i=0; i < A.size(); ++i){
            posA = A.get(i);
            for (int j=0; j < B.size(); ++j){
                posB = B.get(j);
                if (posA < posB){
                   minDiff = Math.min(minDiff, posB - posA);
                }
            }
        }
        //System.out.println("La minima diferencia entre los nodos es " + minDiff);
        if (minDiff <= (gap + 1))
            return true;
        else
            return false;
    }

    public void imprimeResultados(ArrayList<ArrayList<Integer>> SM){
       for (int i=0; i < SM.size(); ++i){
            System.out.println("Secuencia maximal " + (i + 1) + ":");
            for (int j=0; j < SM.get(i).size(); ++j){
                System.out.println(" " + this.alstPalabra.get(SM.get(i).get(j)));
            }
            System.out.println();
       }
    }

    public void leerNombreArchivos(String arch){
        BufferedReader entrada = null;
        try {
            File f = new File(arch);
            entrada = new BufferedReader(new FileReader(f));

            while(entrada.ready()){
                String linea=entrada.readLine();
                File e = new File(linea);
                this.alstArchivos.add(new BufferedReader(new FileReader(e)));
            }
        } catch (Exception ex) {
            System.out.println("Error en la lectura de archivos");
        }
    }

    public void leerParrafo(int idFile,int idDoc) throws IOException{
        ArrayList<String> tmp;
        ArrayList<String> pal;
        pal = new ArrayList<String>();
        while(this.alstArchivos.get(idFile).ready()){
            String line = this.alstArchivos.get(idFile).readLine();
            if (line.length() == 0) break;
            tmp = this.obtenerPalabras(line);
            pal.addAll(tmp);
        }
        this.leerDocumento(idDoc,pal);
    }

    ArrayList<String> obtenerPalabras(String linea){
        ArrayList<String> palabras = new ArrayList<String>();
        StringTokenizer parser = new StringTokenizer(linea," ,.-;()[]^+-*/%<>!¿?");
        while (parser.hasMoreTokens()){
            palabras.add(parser.nextToken().toLowerCase());
        }
        return palabras;
    }
}
