package exodecorateur_angryballs.maladroit;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

class StartButtonController {
    private ButtonModel startButtonModel;
    private Button stopButton;

    AnimationBilles animationBilles;



    public StartButtonController(ButtonModel startButtonModel, Button stopButton,AnimationBilles animationBilles,EcouteurBoutonLancer écouteurBoutonLancer) {
        this.startButtonModel = startButtonModel;
        this.stopButton = stopButton;
        this.animationBilles=animationBilles;
        this.stopButton.addActionListener(écouteurBoutonLancer);
        this.startButtonModel.addObserver(new Observer() {
            @Override
            public void update(Observable o, Object arg) {
                if (startButtonModel.isClicked()) {
                    animationBilles.lancerAnimation();
                }
            }
        });
    }
}