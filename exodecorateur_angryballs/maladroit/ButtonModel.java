package exodecorateur_angryballs.maladroit;

import java.util.Observable;

class ButtonModel extends Observable {
    private boolean clicked = false;

    public void setClicked(boolean clicked) {
        this.clicked = clicked;
        setChanged();
        notifyObservers();
    }

    public boolean isClicked() {
        return clicked;
    }
}