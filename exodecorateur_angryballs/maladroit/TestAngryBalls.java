package exodecorateur_angryballs.maladroit;

import java.awt.*;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.Vector;

import exodecorateur_angryballs.maladroit.controleur.ControleurGeneral;
import exodecorateur_angryballs.maladroit.modele.*;
import mesmaths.geometrie.base.Vecteur;
import musique.SonLong;
//import exodecorateur_angryballs.maladroit.modele.brouillons.BilleMvtNewtonArret;
import exodecorateur_angryballs.maladroit.vues.CadreAngryBalls;


/**
 * Gestion d'une liste de billes en mouvement ayant toutes un comportement différent
 * 
 * Idéal pour mettre en place le DP decorator
 * */
public class TestAngryBalls
{

/**
 * @param args
 */
public static void main(String[] args)
{
//---------------------- gestion des bruitages : paramétrage du chemin du dossier contenant les fichiers audio --------------------------

File file = new File(""); // là où la JVM est lancée : racine du projet

File répertoireSon = new File(file.getAbsoluteFile(),
    "exodecorateur_angryballs"+File.separatorChar+
    "maladroit"+File.separatorChar+"bruits");

//-------------------- chargement des sons pour les hurlements --------------------------------------

Vector<SonLong> sonsLongs = OutilsConfigurationBilleHurlante.chargeSons(répertoireSon, "config_audio_bille_hurlante.txt");
 
SonLong hurlements[] = SonLong.toTableau(sonsLongs);                // on obtient un tableau de SonLong

//------------------- création de la liste (pour l'instant vide) des billes -----------------------

Vector<Bille> billes = new Vector<Bille>();

//---------------- création de la vue responsable du dessin des billes -------------------------

int choixHurlementInitial = 0;
CadreAngryBalls cadre = new CadreAngryBalls("Angry balls",
                                        "Animation de billes ayant des comportements différents. Situation idéale pour mettre en place le DP Decorator",
                                        billes,hurlements, choixHurlementInitial);

cadre.montrer(); // on rend visible la vue

//------------- remplissage de la liste avec 5 billes -------------------------------



double xMax, yMax;
double vMax = 0.1;
xMax = cadre.largeurBillard();      // abscisse maximal
yMax = cadre.hauteurBillard();      // ordonnée maximale

double rayon = 0.05*Math.min(xMax, yMax); // rayon des billes : ici toutes les billes ont le même rayon, mais ce n'est pas obligatoire

Vecteur p0, p1, p2, p3, p4,  v0, v1, v2, v3, v4;    // les positions des centres des billes et les vecteurs vitesse au démarrage. 
                                                    // Elles vont être choisies aléatoirement

//------------------- création des vecteurs position des billes ---------------------------------

p0 = Vecteur.créationAléatoire(0, 0, xMax, yMax);
p1 = Vecteur.créationAléatoire(0, 0, xMax, yMax);
p2 = Vecteur.créationAléatoire(0, 0, xMax, yMax);
p3 = Vecteur.créationAléatoire(0, 0, xMax, yMax);
p4 = Vecteur.créationAléatoire(0, 0, xMax, yMax);

//------------------- création des vecteurs vitesse des billes ---------------------------------

v0 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);
v1 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, 0);
v2 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);
v3 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);
v4 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);

//--------------- ici commence la partie à changer ---------------------------------

/*billes.add(new         BilleMvtRURebond(p0, rayon, v0, Color.red));
billes.add(new      BilleMvtPesanteurFrottementRebond(p1, rayon, v1, new Vecteur(0,0.001), Color.yellow));
billes.add(new              BilleMvtNewtonFrottementRebond(p2, rayon, v2, Color.green));
billes.add(new              BilleMvtRUPasseMurailles(p3, rayon, v3, Color.cyan));

BilleHurlanteMvtNewtonArret billeNoire;         // cas particulier de la bille qui hurle

billes.add(billeNoire = new BilleHurlanteMvtNewtonArret(p4, rayon, v4,  Color.black,hurlements[choixHurlementInitial], cadre));

cadre.addChoixHurlementListener(billeNoire);  // à présent on peut changer le son de la bille qui hurle*/

    Bille bille []= new Bille[6];

    bille[0]=new BilleBasique(p0,rayon,v0,Color.red);
    bille[1]=new BilleBasique(p1, rayon, v1,  Color.yellow);
    bille[2]=new BilleBasique(p2, rayon, v2, Color.green);
    bille[3]=new BilleBasique(p3, rayon, v3, Color.cyan);
    bille[4]=new BilleBasique(p4, rayon, v4,  Color.black);
    //bille[4]=new BilleBasique(new Vecteur(100,300), 20, new Vecteur(0,0),  Color.black);
    bille[5]=new BilleBasique(new Vecteur(300,150), 30, new Vecteur(0,0),  Color.black);

//--------------

    //billes.add(bille[0]= new ContactRebond(bille[0]) ); //      BilleMvtRURebond(p0, rayon, v0, Color.red);
   /* billes.add(bille[1]= new MvtGravity( new MvtFrotAir(     new ContactRebond(bille[1])      ),new Vecteur(0,0.001))); //BilleMvtPesanteurFrottementRebond(p1, rayon, v1, new Vecteur(0,0.001), Color.yellow)
    billes.add(bille[2]= new MvtAttire( new MvtFrotAir(     new ContactRebond(bille[2])      )));    // BilleMvtNewtonFrottementRebond(p2, rayon, v2, Color.green));
    billes.add(bille[3]= new ContactTravers(bille[3]) ); // BilleMvtRUPasseMurailles(p3, rayon, v3, Color.cyan));
    billes.add(  bille[4]= new  MvtAttire(    new Hurlante( new ContactRebond(bille[4])       ,hurlements[choixHurlementInitial], cadre )));  //BilleHurlanteMvtNewtonArret(p4, rayon, v4,  Color.black,hurlements[choixHurlementInitial], cadre))
    cadre.addChoixHurlementListener(bille[4]);*/
   // billes.add(bille[5]=  new Pilot(new ContactRebond(bille[5])));

    //billes.add(bille[5]=  new Pilot(new MvtGravity(new MvtFrotAir( new Hurlante(new ContactRebond(bille[5]) ,hurlements[choixHurlementInitial], cadre)),new Vecteur(0,0.001))));
//ABC

    billes.add(bille[5]=  new Pilot((new MvtFrotAir( new Hurlante(new ContactRebond(bille[5]) ,hurlements[choixHurlementInitial], cadre)))));


    cadre.addChoixHurlementListener(bille[5]);
            //Pilot p= new Pilot(bille[5]);
    //Pilot c= new Pilot(bille[5],cadre);
   // cadre.addMouseListener();
    //billes.add(bille[5]);
    //billes.add( c);

   // billes.add(  bille[4]= new MvtRect(    new Hurlante( new ContactRebond(bille[4])       ,hurlements[choixHurlementInitial], cadre )));

    ControleurGeneral controleurGeneral = new ControleurGeneral(cadre, (Pilot) bille[5]);



//---------------------- ici finit la partie à changer -------------------------------------------------------------

//System.out.println("billes = " + billes.get(0));


//-------------------- création de l'objet responsable de l'animation (c'est un thread séparé) -----------------------

AnimationBilles animationBilles = new AnimationBilles(billes, cadre);

//----------------------- mise en place des écouteurs de boutons qui permettent de contrôler (un peu...) l'application -----------------

EcouteurBoutonLancer écouteurBoutonLancer = new EcouteurBoutonLancer(animationBilles);
EcouteurBoutonArreter écouteurBoutonArrêter = new EcouteurBoutonArreter(animationBilles);
    //EcouteurSouris es= new EcouteurSouris(p);
    //EcouteurSouris es2= new EcouteurSouris(c);

//------------------------- activation des écouteurs des boutons et ça tourne tout seul ------------------------------

cadre.billard.addMouseListener(controleurGeneral);//ICI IL FAUT AJOUTER CONTROLLEURGENERAL CM PARAM!!!
//cadre.billard.addMouseListener(es2);

    ButtonModel stopButtonModel = new ButtonModel();
    ButtonModel startButtonModel = new ButtonModel();
    Button stopButton = cadre.arrêterBilles;
    Button startButton = cadre.lancerBilles;
    new StopButtonController(stopButtonModel, stopButton,animationBilles,écouteurBoutonArrêter);
    new StartButtonController(startButtonModel, startButton,animationBilles,écouteurBoutonLancer);


 //   cadre.lancerBilles.addActionListener(écouteurBoutonLancer);             // pourrait être remplacé par Observable - Observer
//cadre.arrêterBilles.addActionListener(écouteurBoutonArrêter);           // pourrait être remplacé par Observable - Observer



}

}
