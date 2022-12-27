package exodecorateur_angryballs.maladroit.modele;

import mesmaths.geometrie.base.Vecteur;
import mesmaths.mecanique.MecaniquePoint;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

public class MvtGravity extends DecorateurBille  implements ItemListener {

    Vecteur pesanteur;

    public MvtGravity(Bille billeDecore,Vecteur pesanteur) {
        super(billeDecore);
        this.pesanteur=pesanteur;
    }



    @Override
    public void collisionContour(double abscisseCoinHautGauche, double ordonnéeCoinHautGauche, double largeur, double hauteur) {
billeDecore.collisionContour(abscisseCoinHautGauche,ordonnéeCoinHautGauche,largeur,hauteur);
    }




    @Override
    public void gestionAccélération(Vector<Bille> billes)
    {
        super.gestionAccélération(billes);          // remise à zéro du vecteur accélération
        this.getAccélération().ajoute(this.pesanteur);          // contribution du champ de pesanteur (par exemple)
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
