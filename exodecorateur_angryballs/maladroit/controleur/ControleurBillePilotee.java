package exodecorateur_angryballs.maladroit.controleur;

import java.awt.event.MouseEvent;

public class ControleurBillePilotee extends ControleurEtat {

	public ControleurBillePilotee(ControleurGeneral controleurgeneral, ControleurEtat precedant) {
		super(controleurgeneral, precedant);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// Le controleur ne fait rien lors de cet evenement
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
