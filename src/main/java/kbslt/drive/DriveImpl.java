package kbslt.drive;

import javafx.application.Platform;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.concurrent.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Jean-Pierre Alonso.
 */
public class DriveImpl implements Drive {
    private static final DriveImpl instance = new DriveImpl();   // singleton

    private final IntegerProperty requestedConnections = new SimpleIntegerProperty();
    private final IntegerProperty startedConnections = new SimpleIntegerProperty();
    private final IntegerProperty connectedConnections = new SimpleIntegerProperty();
    private List <Connexion> connexionList = new ArrayList<>();

    private Thread th;
    boolean cancelled;
    boolean mode_console;

    public static DriveImpl getInstance() {
        return instance;
    }

    @Override
    public void start(boolean mode_console) {
        this.mode_console = mode_console;
//        setRequestedConnections(1000);
//        setStartedConnections(0);
        Timer t = new Timer("Drive timer");
        t.schedule(TestRequested,0,10);
    }

    private TimerTask TestRequested = new TimerTask() {
        @Override
        public void run() {
            if (getStartedConnections() < getRequestedConnections()) {
                // We must start new connections
                Connexion cnx = new ConnexionMock();
                connexionList.add(cnx);
//                cnx.executeCommand(Command.OPEN);
                try {
                    startedConnections.add(1);
//                    setStartedConnections(getStartedConnections()+1);
                } catch (Exception e){
                        System.out.printf("Exception / started connections : %d / %d (time = %d)",
                                getStartedConnections(),
                                getRequestedConnections(),
                                System.nanoTime()/1000000
                        ).println();
                }
            } else {
                // We must close existing connections
                connexionList.remove(0);
            }
            if (mode_console)
                System.out.printf("started connections : %d / %d (time = %d)", getStartedConnections(), getRequestedConnections(),System.nanoTime()).println();
        }
    };

    @Override
    public int getRequestedConnections() {
        return requestedConnections.get();
    }

    @Override
    public IntegerProperty requestedConnectionsProperty() {
        return requestedConnections;
    }

    @Override
    public int getStartedConnections() {
        return startedConnections.get();
    }

    @Override
    public IntegerProperty startedConnectionsProperty() {
        return startedConnections;
    }

    private void setStartedConnections(int s) {
        startedConnections.set(s);
    }

    @Override
    public int getConnectedConnections() {
        return connectedConnections.get();
    }

    @Override
    public IntegerProperty connectedConnectionsProperty() {
        return connectedConnections;
    }
}
