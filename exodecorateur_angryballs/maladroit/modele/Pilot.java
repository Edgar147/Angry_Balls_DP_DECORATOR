package exodecorateur_angryballs.maladroit.modele;

import exodecorateur_angryballs.maladroit.vues.CadreAngryBalls;
import mesmaths.cinematique.Collisions;
import mesmaths.geometrie.base.Vecteur;
import mesmaths.mecanique.MecaniquePoint;

import java.awt.event.*;
import java.util.Vector;

public class Pilot extends DecorateurBille  implements MouseListener, MouseMotionListener {

    private boolean inside=false;
    private long time,time1,time2;
    private double x1,y1,x2,y2;


    public Pilot(Bille billeDecore) {
        super(billeDecore);
    }

    @Override
    public void collisionContour(double abscisseCoinHautGauche, double ordonnéeCoinHautGauche, double largeur, double hauteur) {

        this.billeDecore.collisionContour(abscisseCoinHautGauche,ordonnéeCoinHautGauche,largeur,hauteur);

    }

    public void sound()
    {
        this.billeDecore.voices(10);


    }

    @Override
    public void gestionAccélération(Vector<Bille> billes)
    {
        super.gestionAccélération(billes);          // remise à zéro du vecteur accélération
        this.billeDecore.gestionAccélération(billes);
        this.getAccélération().ajoute(this.billeDecore.getAccélération());
        this.sound();

    }

    @Override
    public void itemStateChanged(ItemEvent e)
    {                                                                               //System.err.println("dans BilleHurlanteMvtNewtonArret.itemStateChanged au début");
        this.billeDecore.itemStateChanged(e);
    }




    public boolean estDedans(double clickX,double clickY){
        double x=this.getPosition().x;
        double y=this.getPosition().y;
        double r =this.getRayon();

        double distance=Math.sqrt(    Math.pow((clickX-x),2)   +  Math.pow(   (clickY-y),2)   );

        if(distance<=r){
            System.out.println("INNNNNNNNNNNSIIIIIIIDEEEEEEEEEEE");
            return true;
        }
        return  false;

    }


    @Override
    public void mouseClicked(MouseEvent e) {


    }

    @Override
    public void mousePressed(MouseEvent e) {
//        System.out.println("ggggggggggggggggggggggg");

        //System.out.println("FirstX="+ e.getX());
        //System.out.println("FirstY="+ e.getY());
        this.estDedans(e.getX(),e.getY());
        this.time1= System.currentTimeMillis();
        this.x1=e.getX();
        this.y1=e.getY();
        this.inside= this.estDedans(e.getX(),e.getY());
        System.out.println("");

    }

    @Override
    public void mouseReleased(MouseEvent e) {

        if(this.inside) {
            //System.out.println("LastX="+ e.getX());
            //System.out.println("LastY="+ e.getY());
//            System.out.println("vvvvv");

            this.time2 = System.currentTimeMillis();
            time = time2 - time1;
            this.x2 = e.getX();
            this.y2 = e.getY();
            double distance = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));

            //System.out.println("DeltaTime="+time);
            //.out.println("Distance="+distance);
            Vecteur vInitial = this.vitesse;
            //System.out.println("111111111=" + vInitial);

            double rayon=this.rayon;
            double rayonX=this.rayon;
            double rayonY=this.rayon;

            double vitesse=distance/time;
            double vitesseX=vitesse;
            double vitesseY=vitesse;

            if ((x2 <= x1)) {
                x2 = -x2;
                vitesseX=-vitesseX;
            }
            if ((y2 <= y1)) {
                y2 = -y2;
                vitesseY=-vitesseY;
            }


      /*      if ((x2 > x1)) {
                rayonX=-rayonX;
            }
            if ((y2 > y1)) {
                rayonY=-rayonY;
            }*/


            if ((this.vitesse.x > 0)) {
                rayonX=-rayonX;
            }
            if ((this.vitesse.y > 0)) {
                rayonY=-rayonY;
            }


            //System.out.println("Rayon=" + this.bille.rayon);


            //Vecteur v = new Vecteur(x2 * 0.0001+rayonX*0.0003, y2 * 0.0001+rayonY*0.0003);
            Vecteur v = new Vecteur(x2 * 0.0001-rayonX*0.0001+vitesseX*0.0001, y2 * 0.0001-rayonY*0.0001+vitesseY*0.0001);
//            this.setVitesse(vInitial.somme(v));
            this.getAccélération().ajoute(v);          // contribution du champ de pesanteur (par exemple)

            Vecteur vFinal = this.vitesse;
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
