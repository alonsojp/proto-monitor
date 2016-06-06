package kbslt.display.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import kbslt.monitor.IProtoMonitor;

/**
 * @author Jean-Pierre Alonso.
 */
public class SysButtonView {
    private final HBox hbox;
    private final Button stop_btn;
    private final Button start_btn;
    private final Button toggle_btn;
    private final Button exit_btn;
    private boolean isChart;

    public SysButtonView(boolean _isChart) {
        // Creating the buttons
        stop_btn = new Button();
        start_btn = new Button();
        toggle_btn = new Button();
        exit_btn = new Button();
        isChart = _isChart;

        // PLacing the buttons in a HBox to align them
        hbox = new HBox();
        hbox.setPadding(new Insets(10));
        hbox.setSpacing(10);
        hbox.setAlignment(Pos.CENTER);
        // Stop monitor button
        stop_btn.setText("Stop monitor");
        hbox.getChildren().add(stop_btn);
        // Start monitor button
        start_btn.setText("Start monitor");
        hbox.getChildren().add(start_btn);
        // Start monitor button
        if (isChart)
            toggle_btn.setText("Table");
        else
            toggle_btn.setText("Chart");
        hbox.getChildren().add(toggle_btn);
        // Exit button
        exit_btn.setText("Exit");
        hbox.getChildren().add(exit_btn);
    }

    public void setButtonActions (IProtoMonitor tm, SysTableView stv, SysChartView scv) {
        stop_btn.setOnAction((actionEvent)  ->  tm.stop());
        start_btn.setOnAction((actionEvent) ->  tm.start(true));
        toggle_btn.setOnAction((actionEvent) ->  {
            BorderPane bpane;
            if (isChart) {
                toggle_btn.setText("Chart");
                bpane = (BorderPane) scv.getLineChart().getParent();
                bpane.getChildren().remove(scv.getLineChart());
                bpane.setCenter(stv.getTableView());
                stv.getTableView().setVisible(true);
                scv.getLineChart().setVisible(false);
                isChart = false;
            } else {
                toggle_btn.setText("Table");
                bpane = (BorderPane) stv.getTableView().getParent();
                bpane.getChildren().remove(stv.getTableView());
                bpane.setCenter(scv.getLineChart());
                stv.getTableView().setVisible(false);
                scv.getLineChart().setVisible(true);
                isChart = true;
            }
        });
        exit_btn.setOnAction((actionEvent)  ->  System.exit(0));
    }

    public HBox getHbox() {
        return hbox;
    }
}
