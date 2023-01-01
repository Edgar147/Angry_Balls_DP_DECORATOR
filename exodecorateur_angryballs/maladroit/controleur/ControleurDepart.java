package exodecorateur_angryballs.maladroit.controleur;

import java.awt.event.MouseEvent;

public class ControleurDepart extends ControleurEtat {

	public ControleurDepart(ControleurGeneral controleurgeneral, ControleurEtat precedant) {
		super(controleurgeneral, precedant);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// Le controleur ne fait rien lors de cet evenement
	}
	
}
