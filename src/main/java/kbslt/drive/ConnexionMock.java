package kbslt.drive;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jean-Pierre Alonso.
 */
public class ConnexionMock implements Connexion {

    @Override
    public ConnexionEvent executeCommand (Command t) {
        ConnexionEvent event;
        switch (t) {
            case OPEN :
                event = new ConnexionEvent(ConnexionState.CONNECTING);
                break;
            case CLOSE :
                event = new ConnexionEvent(ConnexionState.NOT_CONNECTED);
                break;
            default:
                event = null;
        }
        return event;
    }

    @Override
    public void applyEvent (ConnexionEvent evt){

    }

    @Override
    public List<ConnexionEvent> getUncommitedEvents() {
        List<ConnexionEvent> cnxList = new ArrayList<>();

        return cnxList;
    }

}
