/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package antiplagium.view;

import antiplagium.BL.DetectorBL;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author KIM
 */
public class PanelBarras extends JPanel {

    int anchoPanel = 300, altoPanel = 100;
    int sepX = 30, sepY = 5;
    int pasoX = (anchoPanel - sepX) / 4;
    int altMax = altoPanel - sepY * 2;
    public int docActual = 0;
    ArrayList<DetectorBL> alstDetectores;

    public PanelBarras(ArrayList<DetectorBL> alstDetectores) {
        this.alstDetectores = alstDetectores;
        this.setBackground(Color.white);
        this.setSize(anchoPanel, altoPanel);
        this.setVisible(true);

    }

    public void dibujarRegla(Graphics g) {

        this.dibujarBarra(50, 1, g);

        g.setColor(Color.black);
        //raya vertical
        g.drawLine(sepX / 2, sepY / 2, sepX / 2, altoPanel - sepY / 2);
        //raya horizontal
        g.drawLine(sepX / 3, altoPanel - sepY + 1, anchoPanel, altoPanel - sepY + 1);

        int sepVert = altMax / 4;
        for (int i = 1; i < 5; i++) {
            g.drawLine(sepX / 3, sepY + sepVert * (i-1), sepX * 2 / 3, sepY + sepVert * (i-1)); //rayita horiz
            g.drawLine(sepX + pasoX * i, altoPanel - sepY, sepX + pasoX * i, altoPanel - sepY + 2);  //rayita vertical
            g.drawString(""+(docActual+i-1), sepX+pasoX/2-5+pasoX*(i-1), altoPanel - sepY-2); //numero de doc
            g.drawString(""+(25*(5-i)), 2, sepY + sepVert * (i-1)+8);
        }

        
    }

    public void dibujarBarra(int porc, int pos, Graphics g){
        g.setColor(Color.red);
        int altura=porc*altMax/100;
        g.fillRect(sepX + pasoX * pos-pasoX/2, sepY+(altMax-altura),pasoX/2, altura);


    }

    public void paint(Graphics g) {
        super.paint(g);
        this.dibujarRegla(g);

    }
}
