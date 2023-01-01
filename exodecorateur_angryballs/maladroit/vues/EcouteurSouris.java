package exodecorateur_angryballs.maladroit.vues;

import exodecorateur_angryballs.maladroit.modele.Bille;
import exodecorateur_angryballs.maladroit.modele.Pilot;
import mesmaths.geometrie.base.Vecteur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class EcouteurSouris implements MouseListener, MouseMotionListener {

    Pilot bille;
    private boolean inside=false;
    private long time,time1,time2;
    private double x1,y1,x2,y2;
    public EcouteurSouris(Pilot bille){
        this.bille=bille;
    }



    @Override
    public void mouseClicked(MouseEvent e) {


    }

    @Override
    public void mousePressed(MouseEvent e) {
        //System.out.println("FirstX="+ e.getX());
        //System.out.println("FirstY="+ e.getY());
        this.bille.estDedans(e.getX(),e.getY());
        this.time1= System.currentTimeMillis();
        this.x1=e.getX();
        this.y1=e.getY();
        this.inside= this.bille.estDedans(e.getX(),e.getY());
        System.out.println("");

    }

    @Override
    public void mouseReleased(MouseEvent e) {

        if(this.inside) {
            //System.out.println("LastX="+ e.getX());
            //System.out.println("LastY="+ e.getY());
            this.time2 = System.currentTimeMillis();
            time = time2 - time1;
            this.x2 = e.getX();
            this.y2 = e.getY();
            double distance = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));

            //System.out.println("DeltaTime="+time);
            //.out.println("Distance="+distance);
            Vecteur vInitial = this.bille.vitesse;
            //System.out.println("111111111=" + vInitial);

            double rayon=this.bille.rayon;
            double rayonX=this.bille.rayon;
            double rayonY=this.bille.rayon;

            if ((x2 <= x1)) {
                x2 = -x2;
            }
            if ((y2 <= y1)) {
                y2 = -y2;
            }


      /*      if ((x2 > x1)) {
                rayonX=-rayonX;
            }
            if ((y2 > y1)) {
                rayonY=-rayonY;
            }*/


 /*           if ((this.bille.vitesse.x > 0)) {
                rayonX=-rayonX;
            }
            if ((this.bille.vitesse.y > 0)) {
                rayonY=-rayonY;
            }
*/

            //System.out.println("Rayon=" + this.bille.rayon);


            //Vecteur v = new Vecteur(x2 * 0.0001+rayonX*0.0003, y2 * 0.0001+rayonY*0.0003);
            Vecteur v = new Vecteur(x2 * 0.00022, y2 * 0.0001);
            this.bille.setVitesse(vInitial.somme(v));
            Vecteur vFinal = this.bille.vitesse;
            //System.out.println("2222222222=" + vFinal);
/*

            System.out.println("x2vitesse=" + x2);
            System.out.println("rayonX=" + rayonX);
            System.out.println("vitesseX=" + (x2 +rayonX));
            System.out.println("vitesseReelDe_X=" + (x2  +(rayonX)*5));


            System.out.println("y2vitesse=" + y2);
            System.out.println("rayonY=" + rayonY);
            System.out.println("vitesseY=" + (y2 +rayonY));

            System.out.println("vitesseReelDe_X=" + (y2 * 0.0001-rayonY*0.001));
*/

            //this.bille.setVitesse(vFinal);
        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {


    }

    @Override
    public void mouseMoved(MouseEvent e) {


    }
}
