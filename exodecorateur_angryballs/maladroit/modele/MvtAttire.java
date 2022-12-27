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
    public void collisionContour(double abscisseCoinHautGauche, double ordonnéeCoinHautGauche, double largeur, double hauteur) {
        billeDecore.collisionContour(abscisseCoinHautGauche,ordonnéeCoinHautGauche,largeur,hauteur);

    }



    @Override
    public void gestionAccélération(Vector<Bille> billes)
    {
        super.gestionAccélération(billes);          // remise à zéro du vecteur accélération
        this.getAccélération().ajoute(OutilsBille.gestionAccélérationNewton(this, billes));     // contribution de l'accélération due à l'attraction des autres billes

        this.billeDecore.gestionAccélération(billes);
        this.getAccélération().ajoute(this.billeDecore.getAccélération());
        this.sound();

    }


    public void sound()
    {
        this.billeDecore.voices(10);


    }

    @Override
    public void itemStateChanged(ItemEvent e)
    {                                                                               //System.err.println("dans BilleHurlanteMvtNewtonArret.itemStateChanged au début");
        this.billeDecore.itemStateChanged(e);
    }



}
