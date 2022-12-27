package exodecorateur_angryballs.maladroit.modele;

import exodecorateur_angryballs.maladroit.vues.BoutonChoixHurlement;
import exodecorateur_angryballs.maladroit.vues.VueBillard;
import mesmaths.geometrie.base.Vecteur;
import musique.SonLong;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

public class Hurlante  extends DecorateurBille implements ItemListener {

    private static final int DELAI_MIN = 10;    /* d�lai minimum de rafraichissement du son. en millisecondes */
    public static final int DELAI_MAX = 150;    /* d�lai maximum de rafraichissement du son. en millisecondes */
    public SonLong sonLong;                            /* bande son � diffuser */
    int i;              /* n� de l'�l�ment de sonLong � jouer. on doit avoir i >= 0.
                    sonLong se charge de faire le modulo pour obtenir un indice correct
                    et pour boucler ainsi sur le tableau inscrit dans sonLong */
    long dernierInstant;        /* dernier instant o� le son a �t� diffus� */
    VueBillard vueBillard;
    private static final double COEFF_VOLUME = 6;      // plus la valeur est grande, plus le son augmente rapidement en fct de la vitesse de la boule




    public Hurlante(Bille billeDecore, SonLong sonLong,VueBillard vueBillard) {
        super(billeDecore);
        this.sonLong = sonLong;
        i = 0;
        dernierInstant = System.currentTimeMillis();
        this.vueBillard = vueBillard;



    }



    @Override
    public void itemStateChanged(ItemEvent e)
    {                                                                               //System.err.println("dans BilleHurlanteMvtNewtonArret.itemStateChanged au d�but");
        if (e.getSource() instanceof BoutonChoixHurlement)
        {
            BoutonChoixHurlement boutonChoixHurlement = (BoutonChoixHurlement)(e.getSource());
            this.sonLong = boutonChoixHurlement.sonLong;                                //System.err.println("dans BilleHurlanteMvtNewtonArret.itemStateChanged");
        }
    }

    @Override
    public void collisionContour(double abscisseCoinHautGauche, double ordonn�eCoinHautGauche, double largeur, double hauteur) {
        billeDecore.collisionContour(abscisseCoinHautGauche,ordonn�eCoinHautGauche,largeur,hauteur);

    }



    @Override
    public void gestionAcc�l�ration(Vector<Bille> billes)
    {

        super.gestionAcc�l�ration(billes);          // remise � z�ro du vecteur acc�l�ration
        this.billeDecore.gestionAcc�l�ration(billes);
        //this.getAcc�l�ration().ajoute(this.billeDecore.getAcc�l�ration());

    }


@Override
    public void voices(int deltaT)
    {
        Vecteur p = this.getPosition();
        Vecteur v = this.getVitesse();
        double xMax;

        xMax = vueBillard.largeurBillard();

        double n = v.norme();
//double n2 = v.normeCarr�e();
        double y = Math.exp(-COEFF_VOLUME*n);                // y = e^(-COEFF*n). on obtient donc 0 < y <= 1
        double volume = 1-y;                                 // on obtient 0 <= volume < 1 avec volume == 0 si n == 0  et volume proche de 1 si n est grand
        double x1 = p.x/xMax;                   /* on obtient 0 <= x1 <= 1 */ ////System.err.println("dans BilleHurlante.d�placer() : x1 =  "+ x1);
        double balance = 2*x1 - 1;              // on obtient -1 <= balance <= 1
        ////System.err.println("volume = " + volume);
//double v2 = volume*volume;
        int d�lai = (int)(DELAI_MIN*volume + DELAI_MAX*y);              /* le d�lai entre 2 diffusions diminue lorsque la vitesse augmente */
        long instant = System.currentTimeMillis();
        if (instant - this.dernierInstant >=d�lai)                      /* la fr�quence de diffusion augmente donc avec la vitesse de la bille */
        {
            double coeffPitch = 1;
            this.sonLong.joue(i++, volume, balance, coeffPitch);            /* le son est diffus� dans un thread s�par� */
            this.dernierInstant= instant;
        }

    }



}
