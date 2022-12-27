package exodecorateur_angryballs.maladroit.modele;

import exodecorateur_angryballs.maladroit.vues.BoutonChoixHurlement;
import mesmaths.mecanique.MecaniquePoint;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

public class MvtAttire extends DecorateurBille   implements ItemListener {


    public MvtAttire(Bille billeDecore) {
        super(billeDecore);
    }




    @Override
    public void collisionContour(double abscisseCoinHautGauche, double ordonn�eCoinHautGauche, double largeur, double hauteur) {
        billeDecore.collisionContour(abscisseCoinHautGauche,ordonn�eCoinHautGauche,largeur,hauteur);

    }



    @Override
    public void gestionAcc�l�ration(Vector<Bille> billes)
    {
        super.gestionAcc�l�ration(billes);          // remise � z�ro du vecteur acc�l�ration
        this.getAcc�l�ration().ajoute(OutilsBille.gestionAcc�l�rationNewton(this, billes));     // contribution de l'acc�l�ration due � l'attraction des autres billes

        this.billeDecore.gestionAcc�l�ration(billes);
        this.getAcc�l�ration().ajoute(this.billeDecore.getAcc�l�ration());
        this.sound();

    }


    public void sound()
    {
        this.billeDecore.voices(10);


    }

    @Override
    public void itemStateChanged(ItemEvent e)
    {                                                                               //System.err.println("dans BilleHurlanteMvtNewtonArret.itemStateChanged au d�but");
        this.billeDecore.itemStateChanged(e);
    }



}
