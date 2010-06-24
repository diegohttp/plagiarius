/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package antiplagium.view;

import antiplagium.BL.DetectorBL;
import java.awt.AlphaComposite;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author KIM
 */
public class PanelBarras extends JPanel {

    int anchoPanel = 300, altoPanel = 100;
    int sepX = 35, sepY = 5;
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

        this.dibujarBarra(100, 1, g);

        g.setColor(Color.DARK_GRAY);
        //raya vertical
        g.drawLine(sepX / 2, sepY / 2, sepX / 2, altoPanel - sepY / 2);
        //raya horizontal
        g.drawLine(sepX / 3, altoPanel - sepY + 1, anchoPanel, altoPanel - sepY + 1);

        int sepVert = altMax / 4;
        for (int i = 1; i < 5; i++) {
            g.drawLine(sepX / 3, sepY + sepVert * (i-1), sepX * 2 / 3, sepY + sepVert * (i-1)); //rayita horiz
            g.drawLine(sepX + pasoX * i, altoPanel - sepY, sepX + pasoX * i, altoPanel - sepY + 2);  //rayita vertical
            g.setColor(Color.blue);
            g.setFont(new Font(null, Font.BOLD, 12));
            g.drawString("Doc"+(docActual+i-1), sepX+pasoX/2-5+pasoX*(i-1), altoPanel - sepY-2); //numero de doc
            g.setColor(Color.black);
            g.setFont(new Font(null, Font.ITALIC, 9));
            g.drawString(""+(25*(5-i)), 2, sepY + sepVert * (i-1)+8);
        }

        
    }

    public void dibujarBarra(int porc, int pos, Graphics g){
        float a=(float)0.6;
        Graphics2D g2 = (Graphics2D) g;
        g2.setComposite(creaComposite(a));

        g.setColor(Color.green);
        int altura=porc*altMax/100;
        g2.fillRect(sepX + pasoX * pos-pasoX*3/4, sepY+(altMax-altura),pasoX*3/4, altura);


        g2.setColor(Color.cyan);
        g2.fillRect(sepX + pasoX-5 * pos-pasoX*3/4, sepY+(altMax-altura),pasoX*3/4, altura);

         g2.setComposite(creaComposite(1));


    }

    public void paint(Graphics g) {
        super.paint(g);
        this.dibujarRegla(g);

    }




     public static AlphaComposite creaComposite(float alfa) {
        int tipo = AlphaComposite.SRC_OVER;
        return (AlphaComposite.getInstance(tipo, alfa));
    }
}
