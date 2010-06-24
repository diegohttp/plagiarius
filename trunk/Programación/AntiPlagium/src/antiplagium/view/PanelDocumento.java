/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package antiplagium.view;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
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
public class PanelDocumento extends JPanel {

    int posXLupa = 0, posYLupa = 50;
    int anchoPanel, altoPanel;
    BufferedImage imgTotal, imgPapel, imgLupa;
    HiloAnimacion hilo = new HiloAnimacion();
    public static int delay = 50;
    float alpha = (float)0.5, angulo=0;
    public static boolean fin = false;

    public PanelDocumento() {
        this.setBackground(Color.white);


        try {
            imgPapel = ImageIO.read(new File("src/Iconos/cilindro.png"));
            imgLupa = ImageIO.read(new File("src/Iconos/papelGira.png"));

        } catch (IOException ex) {
            System.out.println(ex);
        }
        anchoPanel = imgPapel.getWidth();
        altoPanel = imgPapel.getHeight();

        this.setBounds(60, 20, anchoPanel, altoPanel);
        //this.setSize(anchoPanel, altoPanel);
        // this.setVisible(true);
        fin = false;
        hilo.start();
    }

    public static AlphaComposite creaComposite(float alfa) {
        int tipo = AlphaComposite.SRC_OVER;
        return (AlphaComposite.getInstance(tipo, alfa));
    }

    public void paint(Graphics g) {
        super.paint(g);

        try {

            imgTotal = new BufferedImage(anchoPanel, altoPanel, BufferedImage.TRANSLUCENT);
            Graphics gr = imgTotal.getGraphics();
            gr.drawImage(imgPapel, 0, 0, this);
            Graphics2D g2 = (Graphics2D) gr;

            g2.setComposite(creaComposite(alpha));
            BufferedImage aux=rotar(imgLupa,angulo);
            gr.drawImage(aux, posXLupa, posYLupa, this);

            g.drawImage(imgTotal, 0, 0, this);
        } catch (Exception e) {
        }
    }

    public BufferedImage rotar(BufferedImage img, float angulo){
        int w = img.getWidth();
        int h = img.getHeight();
        BufferedImage imgRotada= new BufferedImage(3*w, 2*h, BufferedImage.TRANSLUCENT);
        Graphics2D g2 = (Graphics2D) imgRotada.getGraphics();
        double x = (h - w) / 2.0;
        double y = (w - h) / 2.0;
        AffineTransform at = AffineTransform.getTranslateInstance(x, y);
        at.rotate(Math.toRadians(angulo), w/2.0 , h/2.0 );
        //at.rotate(Math.toRadians(anguloPez), w , h );
        g2.drawImage(img, at, this);
        g2.dispose();
        return imgRotada;
        //gr.drawImage(pezRotado, this.posXLupa, this.posYLupa, null);
    }

    class HiloAnimacion extends Thread {

        public void run() {

            int x = 4;
           // int y = 1;
            float a = (float) 0.03;
            float aRot=(float)2.0;
            while (!fin) {
                posXLupa += x;
               // posYLupa -= (100-x*x)/40;
                alpha += a;
                angulo+=aRot;

                if (posXLupa > anchoPanel-100 || posXLupa < 0) {
                    x = -1 * x;
                }
             //   if (posYLupa > 40 || posYLupa < -30) {
              //      y = -1 * y;
               // }
                if (alpha > 0.8 || alpha < 0.2) {
                    a = -1 * a;
                }

                PanelDocumento.this.repaint();
                try {
                    Thread.sleep(delay);
                } catch (InterruptedException ex) {
                    Logger.getLogger(PanelAnimado.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
