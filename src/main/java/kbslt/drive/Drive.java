package kbslt.drive;

import javafx.beans.property.LongProperty;

import java.util.List;

/**
 * @author Jean-Pierre Alonso.
 */
public class Drive implements IDrive {
    private LongProperty usersCountRequested;
    private LongProperty usersCount;
    private List <IConnexion> connexionList;

    public Drive() {
        usersCountRequested.addListener((observable, oldValue, newValue) -> {
            ;
        });
    }

    public void start() {
        
    }

    public long getUsersCountRequested() {
        return usersCountRequested.get();
    }

    public LongProperty usersCountRequestedProperty() {
        return usersCountRequested;
    }

    public void setUsersCountRequested(long usersCountRequested) {
        this.usersCountRequested.set(usersCountRequested);
    }

    public long getUsersCount() {
        return usersCount.get();
    }

    public LongProperty usersCountProperty() {
        return usersCount;
    }
}
