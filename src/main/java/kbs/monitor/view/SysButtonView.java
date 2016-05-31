package kbs.monitor.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import kbs.monitor.TestMonitor;

/**
 * @author Jean-Pierre Alonso.
 */
public class SysButtonView {
    private final HBox hbox = new HBox();
    private final Button stop_btn = new Button();
    private final Button start_btn = new Button();
    private final Button exit_btn;

    public SysButtonView() {
        exit_btn = new Button();
        hbox.setPadding(new Insets(10));
        hbox.setSpacing(10);
        hbox.setAlignment(Pos.CENTER);
        // Stop monitor button
        stop_btn.setText("Stop monitor");
        hbox.getChildren().add(stop_btn);
        // Start monitor button
        start_btn.setText("Start monitor");
        hbox.getChildren().add(start_btn);
        // Exit button
        exit_btn.setText("Exit");
        hbox.getChildren().add(exit_btn);
    }

    public void setButtonActions (TestMonitor tm) {
        stop_btn.setOnAction((actionEvent)  ->  tm.stop());
        start_btn.setOnAction((actionEvent) ->  tm.start(true));
        exit_btn.setOnAction((actionEvent)  ->  System.exit(0));
    }

    public HBox getHbox() {
        return hbox;
    }
}
