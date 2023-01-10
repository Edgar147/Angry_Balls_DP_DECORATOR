package exodecorateur_angryballs.maladroit.controleur;

import java.awt.event.MouseEvent;

public abstract class ControleurEtat {
	
	public ControleurGeneral controleurGeneral;
	public ControleurEtat precedant,suivant;

	public ControleurEtat(ControleurGeneral controleurGeneral, ControleurEtat suivant,ControleurEtat precedant) {
		super();
		this.controleurGeneral = controleurGeneral;
		this.precedant = precedant;
		this.suivant = suivant;
	}
	
	// Les methodes suivantes ne sont pas des evenements, elle seront completer dans les classes dériver au besoin

	public  void mousePressed(MouseEvent e){};
	public  void mouseReleased(MouseEvent e){};
	
}
