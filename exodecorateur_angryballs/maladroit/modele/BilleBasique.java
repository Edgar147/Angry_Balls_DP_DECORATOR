package exodecorateur_angryballs.maladroit.modele;

import mesmaths.cinematique.Collisions;
import mesmaths.geometrie.base.Vecteur;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.logging.Logger;

public class BilleBasique  extends Bille  implements ItemListener{


    public BilleBasique(Vecteur centre, double rayon, Vecteur vitesse, Color couleur) {
        super(centre, rayon, vitesse, couleur);
    }


    @Override
    public void collisionContour(double abscisseCoinHautGauche, double ordonnéeCoinHautGauche, double largeur, double hauteur) {
      //  Collisions.collisionBilleContourAvecRebond( this.getPosition(), this.getRayon(), this.getVitesse(), abscisseCoinHautGauche, ordonnéeCoinHautGauche, largeur, hauteur);
    }


    @Override
    public void itemStateChanged(ItemEvent e) {

    }
}
