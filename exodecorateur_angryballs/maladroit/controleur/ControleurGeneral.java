package exodecorateur_angryballs.maladroit.controleur;

import exodecorateur_angryballs.maladroit.modele.Bille;
import exodecorateur_angryballs.maladroit.modele.Pilot;
import exodecorateur_angryballs.maladroit.vues.CadreAngryBalls;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class ControleurGeneral  implements MouseListener {
	CadreAngryBalls cadre; //reference vue
	protected Pilot billePilote;  //reference modele

	ControleurEtat controleurCourant;
	Controleur1erClique controleur1erClique;
	Controleur2emeClique controleur2emeClique;


	public ControleurGeneral(CadreAngryBalls cadre, Pilot billePilote) {
		this.cadre = cadre;
		this.billePilote=billePilote;
		this.installeControleur();
		this.cadre.addMouseListener(this);

	}

	private void installeControleur() {
		this.controleur2emeClique=new Controleur2emeClique(this,null,null);
		this.controleur1erClique=new Controleur1erClique(this,controleur2emeClique,null);

		//liens oubliées
		this.controleur2emeClique.precedant=this.controleur1erClique;
		this.controleur1erClique.suivant=this.controleur2emeClique;

		this.controleurCourant=this.controleur1erClique;



	}
	
	public void setControleur(ControleurEtat controleurEtat) {
		this.controleurCourant = controleurEtat;
	}

	// MouseEvent
	@Override
	public void mousePressed(MouseEvent e) {
		this.controleurCourant.mousePressed(e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		this.controleurCourant.mouseReleased(e);
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
