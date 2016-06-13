package kbslt.drive;

/**
 * @author Jean-Pierre Alonso.
 */
public class ConnexionEvent {

    ConnexionState state;

    public ConnexionEvent(ConnexionState state) {
        this.state = state;
    }

    public ConnexionState getState() {
        return state;
    }
}
