/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package antiplagium.view;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
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
    int anchoPanel = 500, altoPanel = 500;
    BufferedImage imgTotal, imgPapel, imgLupa;
    HiloAnimacion hilo= new HiloAnimacion();

    public PanelAnimado() {
        this.setBackground(Color.white);
        

        try {
            imgPapel = ImageIO.read(new File("src/papel2.png"));
            imgLupa = ImageIO.read(new File("src/lupa3.png"));
            imgTotal = new BufferedImage(anchoPanel, altoPanel, BufferedImage.TRANSLUCENT);
            imgTotal.getGraphics().drawImage(imgPapel, 0, 0, this);
        } catch (IOException ex) {
            System.out.println(ex);
        }
        anchoPanel=imgPapel.getWidth();
        altoPanel=imgPapel.getHeight();
        this.setBounds(100, 100, anchoPanel, altoPanel);
        this.setVisible(true);
        hilo.start();
    }

    public void paint(Graphics g) {
        super.paint(g);

        imgTotal = new BufferedImage(anchoPanel, altoPanel, BufferedImage.TRANSLUCENT);
        Graphics gr = imgTotal.getGraphics();
        gr.drawImage(imgPapel, 0, 0, this);
       gr.setColor(Color.BLUE);
       gr.setFont(new Font(null, Font.BOLD, 30));
        gr.drawString("Antiplagium",50, altoPanel-20);
        
        gr.drawImage(imgLupa, posXLupa, posYLupa, this);

        g.drawImage(imgTotal, 0, 0, this);
    }

    class HiloAnimacion extends Thread {

        public void run() {
            int x=1;
            int y=1;
            while(true){
                posXLupa+=x;
                posYLupa+=y;
                if (posXLupa>120 || posXLupa<-40) x=-1*x;
                if (posYLupa>90 || posYLupa<-30) y=-1*y;

                PanelAnimado.this.repaint();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException ex) {
                    Logger.getLogger(PanelAnimado.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
