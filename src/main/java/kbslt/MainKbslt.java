package kbslt;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import kbslt.display.Display;
import kbslt.drive.DriveImpl;
import kbslt.drive.Drive;
import kbslt.monitor.IProtoMonitor;
import kbslt.monitor.ProtoMonitor;


/**
 * @author Jean-Pierre Alonso.
 */
public class MainKbslt extends Application {
    private IProtoMonitor tm = ProtoMonitor.getInstance();
    private Drive dr = DriveImpl.getInstance();
    private Display display = new Display(tm);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        boolean mode_monitor = true;

        primaryStage.setTitle("KBS Load Tester");
        primaryStage.show();
        // Show the scene containing the root layout.
        Scene scene = new Scene(display.getRootLayout(),1000,600);
        primaryStage.setScene(scene);
        // Démarrage du thread "métier"
        tm.start(!mode_monitor);
        dr.start(mode_monitor);
    }

//        Supplier<String> getText = committedLabel::getText;  // On affecte une méthode
}
