package exodecorateur_angryballs.maladroit.controleur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControleurGeneral implements MouseListener {

	/* On peut (en theorie) avoir un nombre de bille pillotee variable donc il vaut mieux proceder avec un tableau
	 * Tout de fois le controleur courant et debut seront laisser en dehors de ce tableau par choix et parce qu'il ne varient pas en nombre
	 */
	public ControleurEtat[] controleursetat;
	public ControleurEtat controleurcourant, controleurdebut;
	
	/*
	 * TODO constructeur, membres de la classe (les restants) et fonction(s)
	 * Par rapport aux membres il manque le cadre (pour la vue) et probablement les billes (je sais pas trop)
	 * */
	
	
	private void installeControleur() {
		// TODO
	}
	
	public void setControleur(ControleurEtat controleurEtat) {
		this.controleurcourant = controleurEtat;
	}

	// MouseEvent
	@Override
	public void mousePressed(MouseEvent e) {
		this.controleurcourant.mousePressed(e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		this.controleurcourant.mouseReleased(e);
	}
	
	
	// -------------------------------- Inutile pour nous --------------------------------
	@Override
	public void mouseClicked(MouseEvent e) {
		// inutile ici
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// inutile ici 
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// inutile ici 
	}

}
