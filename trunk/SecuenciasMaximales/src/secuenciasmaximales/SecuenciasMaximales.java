/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package secuenciasmaximales;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
/**
 *
 * @author alulab
 */
public class SecuenciasMaximales {
    private ArrayList<Documento> alstDocumento;
    private HashMap<String,Integer> diccionario;
    private ArrayList<String> alstPalabra;
    private ArrayList< ArrayList<NodoOcurrencia> > alstOcurrenciaxPalabra;
    private int contDocumentos;
    private int contPalabras;
    /**
     * @param args the command line arguments
     */
    SecuenciasMaximales(){
        this.alstDocumento = new ArrayList<Documento>();
        this.diccionario = new HashMap<String,Integer>();
        this.alstPalabra = new ArrayList<String>();
        this.alstOcurrenciaxPalabra = new ArrayList< ArrayList<NodoOcurrencia> >();
        this.contDocumentos = 0;
        this.contPalabras = 0;
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

    public void leerDocumento(String arch){
        BufferedReader entrada = null;
        this.agregarDocumento();
        int docActual = this.getIdDocActual();
        try {
            File f = new File(arch);
            entrada = new BufferedReader(new FileReader(f));
            
            while(entrada.ready()){
                String linea=entrada.readLine();
                String [] palabras = linea.split(" ");
                
                for (int i=0; i<palabras.length; i++){
                    this.insertarPalabra(docActual, palabras[i]);
                }


            }

            this.alstDocumento.get(docActual).cerrarEnlaces();
        } catch (Exception ex) {

        }
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

    public static void main(String[] args) {
        // TODO code application logic here
        SecuenciasMaximales sm = new SecuenciasMaximales();
        sm.leerDocumento("p1.txt");
        //sm.recorrerDocActual();
        sm.leerDocumento("p2.txt");
        //sm.recorrerDocActual();
        sm.creacionEnlacesVerticales();
        //sm.recorreVerticales();
        ArrayList<ArrayList<Integer>> SM = sm.comparaDocumentos(2);
        //sm.imprimeResultados(SM);
    }

    public ArrayList< ArrayList<Integer> > comparaDocumentos(int gap){
        ArrayList< ArrayList<Integer> > alstSM = new ArrayList< ArrayList<Integer> >();
        int nodoActual = 0;
        int referenciaNodo = 0;
        int idW;
        int cantSec = 1;
        alstSM.add(new ArrayList<Integer>());
        while (nodoActual >= 0){
            idW = this.alstDocumento.get(0).getNodos().get(nodoActual).getIdPalabra();
            //System.out.println("Se busca con la palabra " + this.alstPalabra.get(idW));
            if (this.alstOcurrenciaxPalabra.get(idW).size() > 1){
                //System.out.println("Esta palabra si esta en el otro documento");
                alstSM.get(cantSec - 1).add(idW);
                int actId = this.alstDocumento.get(1).contienePalabra(idW);
                int tmpNodo = this.alstDocumento.get(0).getNodos().get(nodoActual).getNextNodo(referenciaNodo);
                int tmpRef = this.alstDocumento.get(0).getNodos().get(nodoActual).getNextReferencia(referenciaNodo);
                if (tmpNodo >= 0){  /* Si no se busca el ultimo nodo */
                    int nextIdPal = this.alstDocumento.get(0).getNodos().get(tmpNodo).getIdPalabra();
                    int nextId = this.alstDocumento.get(1).contienePalabra(nextIdPal);
                    if (nextId < 0 || !cumpleAdicion(actId,nextId,gap)){
                        if (alstSM.get(cantSec - 1).size() < 2){
                            //System.out.println("Si cumple con la adicion");
                            alstSM.get(cantSec - 1).clear();
                        }
                        else {
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
        }
        return alstSM;
    }

    public boolean cumpleAdicion(int idAct,int idNext,int gap){
        ArrayList<Integer> A = this.alstDocumento.get(1).getNodos().get(idAct).getPosiciones();
        ArrayList<Integer> B = this.alstDocumento.get(1).getNodos().get(idNext).getPosiciones();
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
}
