package kbs.monitor;

import javafx.application.Application;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import kbs.monitor.model.SysBeanFX;
import kbs.monitor.view.SysButtonView;
import kbs.monitor.view.SysGridView;
import kbs.monitor.view.SysTableView;


/**
 * @author Jean-Pierre Alonso.
 */
public class MainMonitoring extends Application {
    private Stage primaryStage;
    private SysBeanFX sysBean = new SysBeanFX();
    private final ObjectProperty<SysBeanFX> sbfx = new SimpleObjectProperty<>(new SysBeanFX());
    private TestMonitor tm = new TestMonitor(sbfx);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("KBS monitor");
        initRootLayout();
        primaryStage.show();
        // Démarrage du thread "métier"
        tm.start(true);
    }

    private void initRootLayout() throws Exception {
        // Init root layout as BorderPane and adding fields.
        BorderPane rootLayout = new BorderPane();
        // Init the TableView containing the system records
        SysTableView stv = new SysTableView();
        // Init GridPane that contains the text fields displaying the selected items in the table
        SysGridView sgv = new SysGridView();
        sgv.bind(sysBean);
        // Init Buttons
        SysButtonView sbv = new SysButtonView();
        sbv.setButtonActions(tm);
        // Init Listeners
        sbfx.addListener((observable, oldValue, newValue) -> {
            stv.getTableView().getItems().add(newValue);
//            System.out.println("Table size: " + stv.getTableView().getItems().size());
        });
        stv.getTableView().getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue)-> {
            sysBean.set(newValue);
        });

        // Place all componants in the rootLayout
        rootLayout.setCenter(stv.getTableView());
        rootLayout.setRight(sgv.getGridPane());
        rootLayout.setBottom(sbv.getHbox());
        // Show the scene containing the root layout.
        Scene scene = new Scene(rootLayout,1000,600);
        primaryStage.setScene(scene);
    }

//        Supplier<String> getText = committedLabel::getText;  // On affecte une méthode
}
