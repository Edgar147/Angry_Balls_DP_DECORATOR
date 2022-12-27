package exodecorateur_angryballs.maladroit.modele;

import mesmaths.cinematique.Collisions;
import mesmaths.geometrie.base.Vecteur;

import java.awt.*;

public class ContactRebond extends DecorateurBille{


    public ContactRebond(Bille billeDecore) {
        super(billeDecore);
    }


    @Override
    public void collisionContour(double abscisseCoinHautGauche, double ordonnéeCoinHautGauche, double largeur, double hauteur) {
        Collisions.collisionBilleContourAvecRebond( this.getPosition(), this.getRayon(), this.getVitesse(), abscisseCoinHautGauche, ordonnéeCoinHautGauche, largeur, hauteur);
        this.billeDecore.collisionContour(abscisseCoinHautGauche,ordonnéeCoinHautGauche,largeur,hauteur);
    }




}
