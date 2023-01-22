package exodecorateur_angryballs.maladroit;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

class StopButtonController {
    private ButtonModel stopButtonModel;
    private Button stopButton;

    AnimationBilles animationBilles;



    public StopButtonController(ButtonModel stopButtonModel, Button stopButton,AnimationBilles animationBilles,EcouteurBoutonArreter écouteurBoutonArrêter) {
        this.stopButtonModel = stopButtonModel;
        this.stopButton = stopButton;
        this.animationBilles=animationBilles;
        this.stopButton.addActionListener(écouteurBoutonArrêter);
        this.stopButtonModel.addObserver(new Observer() {
            @Override
            public void update(Observable o, Object arg) {
                if (stopButtonModel.isClicked()) {
                    animationBilles.arrêterAnimation();
                }
            }
        });
    }
}