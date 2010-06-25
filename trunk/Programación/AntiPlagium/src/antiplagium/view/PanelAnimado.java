/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package antiplagium.view;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
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
public class PanelAnimado extends JPanel {

    int posXLupa = 0, posYLupa = 0;
    int anchoPanel, altoPanel;
    BufferedImage imgTotal, imgPapel, imgLupa;
    HiloAnimacion hilo= new HiloAnimacion();
    public static int delay=100;

    public PanelAnimado() {
        this.setBackground(Color.white);


        try {
            imgPapel = ImageIO.read(getClass().getResource("/Iconos/fondoLogo.png"));
            imgLupa = ImageIO.read(getClass().getResource("/Iconos/detectiveLogo.png"));

        } catch (IOException ex) {
            System.out.println(ex);
        }
        anchoPanel=imgPapel.getWidth();
        altoPanel=imgPapel.getHeight();

        int ancho = Toolkit.getDefaultToolkit().getScreenSize().width;
        int alto = Toolkit.getDefaultToolkit().getScreenSize().height;

        this.setBounds((ancho-anchoPanel)/2, (alto-altoPanel)/2-50, anchoPanel, altoPanel);
        this.setVisible(true);
        hilo.start();
    }

    public void paint(Graphics g) {
        super.paint(g);

        imgTotal = new BufferedImage(anchoPanel, altoPanel, BufferedImage.TRANSLUCENT);
        Graphics gr = imgTotal.getGraphics();
        gr.drawImage(imgPapel, 0, 0, this);
        gr.drawImage(imgLupa, posXLupa, posYLupa, this);

        g.drawImage(imgTotal, 0, 0, this);
    }

    class HiloAnimacion extends Thread {

        public void run() {
            boolean fin=false;
            int x=2;
            while(!fin){
                posXLupa+=x;
              
                if (posXLupa>50 || posXLupa<0) x=-1*x;
             
                PanelAnimado.this.repaint();
                try {
                    Thread.sleep(delay);
                } catch (InterruptedException ex) {
                    Logger.getLogger(PanelAnimado.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
