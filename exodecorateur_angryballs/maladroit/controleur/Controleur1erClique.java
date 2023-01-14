package exodecorateur_angryballs.maladroit.controleur;

import java.awt.event.MouseEvent;

public class Controleur1erClique extends ControleurEtat{
    public Controleur1erClique(ControleurGeneral controleurGeneral, ControleurEtat suivant, ControleurEtat precedant) {
        super(controleurGeneral, suivant, precedant);
    }

    @Override
    public void mousePressed(MouseEvent e) {

        this.controleurGeneral.billePilote.estDedans(e.getX(),e.getY());
        this.controleurGeneral.billePilote.time1= System.currentTimeMillis();
        this.controleurGeneral.billePilote.x1=e.getX();
        this.controleurGeneral.billePilote.y1=e.getY();
        this.controleurGeneral.billePilote.inside= this.controleurGeneral.billePilote.estDedans(e.getX(),e.getY());
        System.out.println("Souris appuyé ");
        if(this.controleurGeneral.billePilote.inside){
            this.controleurGeneral.setControleur(suivant);

        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }





}
