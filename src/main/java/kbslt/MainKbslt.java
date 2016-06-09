package kbslt;

import javafx.application.Application;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import kbslt.display.Display;
import kbslt.display.view.SysChartView;
import kbslt.monitor.IProtoMonitor;
import kbslt.monitor.ProtoMonitor;
import kbslt.monitor.model.SysBeanFX;
import kbslt.display.view.SysButtonView;
import kbslt.display.view.SysGridView;
import kbslt.display.view.SysTableView;


/**
 * @author Jean-Pierre Alonso.
 */
public class MainKbslt extends Application {
    private Stage primaryStage;
    private IProtoMonitor tm = ProtoMonitor.getInstance();
    private Display display = new Display(tm);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("KBS Load Tester");
        primaryStage.show();
        // Show the scene containing the root layout.
        Scene scene = new Scene(display.getRootLayout(),1000,600);
        primaryStage.setScene(scene);
        // Démarrage du thread "métier"
        tm.start(true);
    }

    private void initRootLayout() throws Exception {
    }

//        Supplier<String> getText = committedLabel::getText;  // On affecte une méthode
}
