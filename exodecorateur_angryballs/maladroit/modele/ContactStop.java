package exodecorateur_angryballs.maladroit.modele;

import mesmaths.cinematique.Collisions;

public class ContactStop extends DecorateurBille {


    public ContactStop(Bille billeDecore) {
        super(billeDecore);
    }




    @Override
    public void collisionContour(double abscisseCoinHautGauche, double ordonnéeCoinHautGauche, double largeur, double hauteur) {
        Collisions.collisionBilleContourAvecArretHorizontal(this.getPosition(), this.getRayon(), this.getVitesse(), abscisseCoinHautGauche, largeur);
        Collisions.collisionBilleContourAvecArretVertical(this.getPosition(), this.getRayon(), this.getVitesse(), ordonnéeCoinHautGauche, hauteur);
        this.billeDecore.collisionContour(abscisseCoinHautGauche,ordonnéeCoinHautGauche,largeur,hauteur);

    }
}
