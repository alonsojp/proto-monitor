package kbslt.drive;

import javafx.beans.property.IntegerProperty;

/**
 * @author Jean-Pierre Alonso.
 */
public interface Drive {
    void start(boolean mode_console);
    int getRequestedConnections();
    IntegerProperty requestedConnectionsProperty();
    void setRequestedConnections(int requestedConnections);
    int getStartedConnections();
    IntegerProperty startedConnectionsProperty();
    int getConnectedConnections();
    IntegerProperty connectedConnectionsProperty();
}
