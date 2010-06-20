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
public class PanelAnimadoLogo extends JPanel {

    int posXLupa = 0, posYLupa = 0;
    int anchoPanel, altoPanel;
    BufferedImage imgTotal, imgPapel, imgLupa;
    HiloAnimacion hilo= new HiloAnimacion();
    public static int delay=150;

    public PanelAnimadoLogo() {
        this.setBackground(Color.white);


        try {
            imgPapel = ImageIO.read(new File("src/Iconos/fondoLogo.png"));
            imgLupa = ImageIO.read(new File("src/Iconos/detectiveLogo.png"));

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
            int x=1;
           // int y=1;
            while(!fin){
                posXLupa+=x;
              //  posYLupa+=y;
                if (posXLupa>50 || posXLupa<0) x=-1*x;
              //  if (posYLupa>90 || posYLupa<-30) y=-1*y;
                //if (posXLupa>30) fin=true;
                PanelAnimadoLogo.this.repaint();
                try {
                    Thread.sleep(delay);
                } catch (InterruptedException ex) {
                    Logger.getLogger(PanelAnimadoLogo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
