package exodecorateur_angryballs.maladroit.controleur;

import java.awt.event.MouseEvent;

public abstract class ControleurEtat {
	
	public ControleurGeneral controleurgeneral;
	public ControleurEtat precedant;
	public ControleurEtat suivants[];
	
	public ControleurEtat(ControleurGeneral controleurgeneral, ControleurEtat precedant) {
		this.controleurgeneral = controleurgeneral;
		this.precedant = precedant;
		this.suivants = null;
	}
	
	// Les methodes suivantes ne sont pas des evenements, elle seront completer dans les classes dériver au besoin
	public abstract void mousePressed(MouseEvent e);
	public abstract void mouseReleased(MouseEvent e);
	
}
