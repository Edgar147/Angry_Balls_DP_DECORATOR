package exodecorateur_angryballs.maladroit.modele;

import exodecorateur_angryballs.maladroit.vues.CadreAngryBalls;
import mesmaths.cinematique.Collisions;
import mesmaths.geometrie.base.Vecteur;
import mesmaths.mecanique.MecaniquePoint;

import java.awt.event.*;
import java.util.Vector;

public class Pilot extends DecorateurBille {


    public  boolean inside=false;
    public long time,time1,time2;
    public double x1,y1,x2,y2;



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
            System.out.println("Inside");
            return true;
        }
        System.out.println("Outside");

        return  false;

    }





}
