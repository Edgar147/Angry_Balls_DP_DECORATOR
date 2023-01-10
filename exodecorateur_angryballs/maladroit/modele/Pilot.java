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
    public void collisionContour(double abscisseCoinHautGauche, double ordonn�eCoinHautGauche, double largeur, double hauteur) {

        this.billeDecore.collisionContour(abscisseCoinHautGauche,ordonn�eCoinHautGauche,largeur,hauteur);

    }

    public void sound()
    {
        this.billeDecore.voices(10);


    }

    @Override
    public void gestionAcc�l�ration(Vector<Bille> billes)
    {
        super.gestionAcc�l�ration(billes);          // remise � z�ro du vecteur acc�l�ration
        this.billeDecore.gestionAcc�l�ration(billes);
        this.getAcc�l�ration().ajoute(this.billeDecore.getAcc�l�ration());
        this.sound();

    }

    @Override
    public void itemStateChanged(ItemEvent e)
    {                                                                               //System.err.println("dans BilleHurlanteMvtNewtonArret.itemStateChanged au d�but");
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
