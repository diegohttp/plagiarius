/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication1;

import java.awt.Point;

/**
 *
 * @author Administrador
 */
public class Conexion {
    public Point documentosConectados= new Point();
    public Point oracionesConectadas= new Point();
    public int porcentaje=0;

    public Conexion(int numDoc1, int numDoc2, int numOr1, int numOr2, int porc){
        documentosConectados.x=numDoc1;
        documentosConectados.y=numDoc2;

        oracionesConectadas.x=numOr1;
        oracionesConectadas.y=numOr2;

        porcentaje=porc;

    }
}
