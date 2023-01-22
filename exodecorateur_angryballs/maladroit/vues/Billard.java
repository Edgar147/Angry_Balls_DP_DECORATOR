package exodecorateur_angryballs.maladroit.vues;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Vector;

import exodecorateur_angryballs.maladroit.modele.Bille;


/**
 * responsable du dessin des billes
 * 
 *  ICI : IL N'Y A RIEN A CHANGER 
 *  
 * 
 * */
public class Billard extends Canvas
{
    private boolean running = true;

    Vector<Bille> billes;
    public Billard(Vector<Bille> billes)
    {
this.billes = billes;
        startRendering();

    }


    private void startRendering() {
        new Thread(() -> {
            while (running) {
                repaint();   // à la place de getDrawGraphics et .show()
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }





    /* (non-Javadoc)
     * @see java.awt.Canvas#paint(java.awt.Graphics)
     */
    @Override
    public void paint(Graphics graphics)
    {
    	for(int i = 0; i < this.billes.size(); ++i) {
    		dessineBille(graphics, this.billes.get(i));
    	}

    //System.out.println("billes dans le billard = " + billes);
    }
    
    
    private void dessineBille(Graphics g, Bille bille) {
        int width, height;
        int xMin, yMin;
        
        xMin = (int)Math.round(bille.position.x-bille.rayon);
        yMin = (int)Math.round(bille.position.y-bille.rayon);

        width = height = 2*(int)Math.round(bille.rayon); 

        g.setColor(bille.getCouleur());
        g.fillOval( xMin, yMin, width, height);
        g.setColor(Color.CYAN);
        g.drawOval(xMin, yMin, width, height);
    }



//    private void startRendering(Bille bille,Graphics graphics) {
//        new Thread(() -> {
//            while (true) {
//                BufferStrategy bufferStrategy = this.getBufferStrategy();
//                Graphics g = bufferStrategy.getDrawGraphics();
//                bille.dessine(graphics);
//                bufferStrategy.show();
//                try {
//                    Thread.sleep(1000 / 60);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
//    }





    
 
}
