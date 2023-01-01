package exodecorateur_angryballs.maladroit.modele;

import exodecorateur_angryballs.maladroit.vues.CadreAngryBalls;
import mesmaths.cinematique.Collisions;
import mesmaths.geometrie.base.Vecteur;
import mesmaths.mecanique.MecaniquePoint;

import java.awt.event.*;
import java.util.Vector;

public class Pilot extends DecorateurBille  implements MouseListener, MouseMotionListener {
    public Pilot(Bille billeDecore, CadreAngryBalls cadre) {
        super(billeDecore);
    }

    @Override
    public void collisionContour(double abscisseCoinHautGauche, double ordonnéeCoinHautGauche, double largeur, double hauteur) {
        Collisions.collisionBilleContourAvecRebond( this.getPosition(), this.getRayon(), this.getVitesse(), abscisseCoinHautGauche, ordonnéeCoinHautGauche, largeur, hauteur);

    }



    @Override
    public void gestionAccélération(Vector<Bille> billes)
    {



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

        //cadre.addMouseListener(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

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
