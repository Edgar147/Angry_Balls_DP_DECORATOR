package exodecorateur_angryballs.maladroit.modele;

import mesmaths.geometrie.base.Vecteur;

import java.awt.*;

public abstract class DecorateurBille extends Bille {

    protected Bille billeDecore;



    public DecorateurBille(Bille billeDecore) {
        super(billeDecore.getPosition(),billeDecore.getRayon(),billeDecore.getVitesse(),billeDecore.getCouleur());
        this.billeDecore=billeDecore;

    }







}
