package exodecorateur_angryballs.maladroit.modele;

import mesmaths.mecanique.MecaniquePoint;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;
import java.util.logging.Logger;

public class MvtFrotAir extends DecorateurBille  implements ItemListener {

    public MvtFrotAir(Bille billeDecore) {
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
        this.getAccélération().ajoute(MecaniquePoint.freinageFrottement(this.masse(), this.getVitesse())); // contribution de l'accélération due au frottement dans l'air
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
