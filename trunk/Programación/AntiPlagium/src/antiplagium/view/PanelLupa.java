/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package antiplagium.view;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author KIM
 */
public class PanelLupa extends JPanel {

    int posXLupa = 0, posYLupa = 0;
    int anchoPanel, altoPanel;
    BufferedImage imgTotal, imgPapel, imgLupa;
    HiloAnimacion hilo = new HiloAnimacion();
    public static int delay = 50;
    float alpha = 0;

    public PanelLupa() {
        this.setBackground(Color.white);


        try {
            imgPapel = ImageIO.read(new File("src/Iconos/papel.png"));
            imgLupa = ImageIO.read(new File("src/Iconos/lupa.png"));

        } catch (IOException ex) {
            System.out.println(ex);
        }
        anchoPanel = imgPapel.getWidth();
        altoPanel = imgPapel.getHeight();


        this.setSize(anchoPanel, altoPanel);
        // this.setVisible(true);
        hilo.start();
    }

    public static AlphaComposite creaComposite(float alfa) {
        int tipo = AlphaComposite.SRC_OVER;
        return (AlphaComposite.getInstance(tipo, alfa));
    }

    public void paint(Graphics g) {
        super.paint(g);

        imgTotal = new BufferedImage(anchoPanel, altoPanel, BufferedImage.TRANSLUCENT);
        Graphics gr = imgTotal.getGraphics();
        gr.drawImage(imgPapel, 0, 0, this);
        Graphics2D g2 = (Graphics2D) gr;
        g2.setComposite(creaComposite(alpha));
        gr.drawImage(imgLupa, posXLupa, posYLupa, this);

        g.drawImage(imgTotal, 0, 0, this);
    }

    class HiloAnimacion extends Thread {

        public void run() {
            boolean fin = false;
            int x = 1;
            int y = 1;
            float a = (float) 0.03;
            while (!fin) {
                posXLupa += x;
                posYLupa += y;
                alpha += a;

                if (posXLupa > 50 || posXLupa < 0) {
                    x = -1 * x;
                }
                if (posYLupa > 40 || posYLupa < -30) {
                    y = -1 * y;
                }
                if (alpha > 1 || alpha < 0) {
                    a = -1 * a;
                }

                PanelLupa.this.repaint();
                try {
                    Thread.sleep(delay);
                } catch (InterruptedException ex) {
                    Logger.getLogger(PanelAnimado.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
