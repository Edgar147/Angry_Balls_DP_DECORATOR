package exodecorateur_angryballs.maladroit.modele;

import mesmaths.cinematique.Collisions;
import mesmaths.geometrie.base.Vecteur;

import java.awt.*;

public class ContactTravers extends DecorateurBille{
    public ContactTravers(Bille billeDecore) {
        super(billeDecore);
    }





    @Override
    public void collisionContour(double abscisseCoinHautGauche, double ordonn�eCoinHautGauche, double largeur, double hauteur) {
        Collisions.collisionBilleContourPasseMuraille( this.getPosition(), abscisseCoinHautGauche, ordonn�eCoinHautGauche, largeur, hauteur);
        this.billeDecore.collisionContour(abscisseCoinHautGauche,ordonn�eCoinHautGauche,largeur,hauteur);


    }



}
