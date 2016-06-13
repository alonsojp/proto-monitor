package kbslt.drive;

import java.util.List;

/**
 * @author Jean-Pierre Alonso.
 */
public interface Connexion {
    ConnexionEvent executeCommand (Command cmd);
    void applyEvent (ConnexionEvent evt);
    List<ConnexionEvent> getUncommitedEvents();
}
