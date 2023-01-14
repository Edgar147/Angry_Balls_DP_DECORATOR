package exodecorateur_angryballs.maladroit.controleur;

import mesmaths.geometrie.base.Vecteur;

import java.awt.event.MouseEvent;

public class Controleur2emeClique extends  ControleurEtat{
    public Controleur2emeClique(ControleurGeneral controleurGeneral, ControleurEtat suivant, ControleurEtat precedant) {
        super(controleurGeneral, suivant, precedant);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {



        if(this.controleurGeneral.billePilote.inside) {
            //System.out.println("LastX="+ e.getX());
            //System.out.println("LastY="+ e.getY());
//            System.out.println("vvvvv");
            System.out.println("RELEASED");

            this.controleurGeneral.billePilote.time2 = System.currentTimeMillis();
            controleurGeneral.billePilote.time = controleurGeneral.billePilote.time2 - controleurGeneral.billePilote.time1;
            this.controleurGeneral.billePilote.x2 = e.getX();
            this.controleurGeneral.billePilote.y2 = e.getY();
            double distance = Math.sqrt(Math.pow((controleurGeneral.billePilote.x2 - controleurGeneral.billePilote.x1), 2) + Math.pow((controleurGeneral.billePilote.y2 - controleurGeneral.billePilote.y1), 2));

            //System.out.println("DeltaTime="+time);
            //.out.println("Distance="+distance);
            Vecteur vInitial = this.controleurGeneral.billePilote.vitesse;
            //System.out.println("111111111=" + vInitial);

            double rayon=this.controleurGeneral.billePilote.rayon;
            double rayonX=this.controleurGeneral.billePilote.rayon;
            double rayonY=this.controleurGeneral.billePilote.rayon;

            double vitesse=distance/controleurGeneral.billePilote.time;
            double vitesseX=vitesse;
            double vitesseY=vitesse;

            if ((controleurGeneral.billePilote.x2 <= controleurGeneral.billePilote.x1)) {
                controleurGeneral.billePilote.x2 = -controleurGeneral.billePilote.x2;
                vitesseX=-vitesseX;
            }
            if ((controleurGeneral.billePilote.y2 <= controleurGeneral.billePilote.y1)) {
                controleurGeneral.billePilote.y2 = -controleurGeneral.billePilote.y2;
                vitesseY=-vitesseY;
            }


      /*      if ((x2 > x1)) {
                rayonX=-rayonX;
            }
            if ((y2 > y1)) {
                rayonY=-rayonY;
            }*/


            if ((this.controleurGeneral.billePilote.vitesse.x > 0)) {
                rayonX=-rayonX;
            }
            if ((this.controleurGeneral.billePilote.vitesse.y > 0)) {
                rayonY=-rayonY;
            }


            //System.out.println("Rayon=" + this.bille.rayon);


            //Vecteur v = new Vecteur(x2 * 0.0001+rayonX*0.0003, y2 * 0.0001+rayonY*0.0003);
            Vecteur v = new Vecteur(controleurGeneral.billePilote.x2 * 0.0001-rayonX*0.0001+vitesseX*0.0001, controleurGeneral.billePilote.y2 * 0.0001-rayonY*0.0001+vitesseY*0.0001);
//            this.setVitesse(vInitial.somme(v));
            this.controleurGeneral.billePilote.getAccélération().ajoute(v);          // contribution du champ de pesanteur (par exemple)

            //System.out.println("2222222222=" + vFinal);
/*

            System.out.println("x2vitesse=" + x2);
            System.out.println("rayonX=" + rayonX);
            System.out.println("vitesseX=" + (x2 +rayonX));
            System.out.println("vitesseReelDe_X=" + (x2  +(rayonX)*5));


            System.out.println("y2vitesse=" + y2);
            System.out.println("rayonY=" + rayonY);
            System.out.println("vitesseY=" + (y2 +rayonY));

            System.out.println("vitesseReelDe_X=" + (y2 * 0.0001-rayonY*0.001));
*/

            //this.bille.setVitesse(vFinal);
            this.controleurGeneral.setControleur(precedant);

        }





    }
}
