package kbs.monitor.view;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import kbs.monitor.model.SysBeanFX;

/**
 * @author Jean-Pierre Alonso.
 */
public class SysGridView {
    private GridPane gridPane = new GridPane();
    // Field showing the available memory
    private TextField committedMemText  = new TextField("-");
    private TextField totalMemText      = new TextField("-");
    private TextField usedMemText       = new TextField("-");
    private TextField freeMemText       = new TextField("-");
    private TextField sysMaxMemText     = new TextField("-");
    private TextField freePhMemText     = new TextField("-");
    private TextField totalPhMemText    = new TextField("-");
    private TextField sysLoadText       = new TextField("-");
    private TextField cpuLoadText       = new TextField("-");
    private TextField cpuTimeText       = new TextField("-");
    private TextField nbProcText        = new TextField("-");
    // Setting labels to identify text fields
    private Label committedLabel     = new Label("Committed mem");
    private Label totalMemLabel      = new Label("Total mem    ");
    private Label usedMemLabel       = new Label("Used  mem    ");
    private Label freeMemLabel       = new Label("Free  mem    ");
    private Label sysMaxMemLabel     = new Label("Max mem      ");
    private Label freePhMemLabel     = new Label("Sys free mem ");
    private Label totalPhMemLabel    = new Label("Sys total mem ");
    private Label sysLoadLabel       = new Label("Sys load     ");
    private Label cpuLoadLabel       = new Label("Cpu load     ");
    private Label cpuTimeLabel       = new Label("Cpu time used");
    private Label nbProcLabel        = new Label("# processors ");

    public SysGridView () {
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10));

        // Putting each field in the grid
        int i = 0;
        committedLabel.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        gridPane.add(committedLabel, 0, i);
        gridPane.add(committedMemText, 1, i);
        gridPane.add(new Label("Mb"), 2, i++);
        //----------------
        totalMemLabel.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        gridPane.add(totalMemLabel, 0, i);
        gridPane.add(totalMemText, 1, i);
        gridPane.add(new Label("Mb"), 2, i++);
        //----------------
        usedMemLabel.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        gridPane.add(usedMemLabel, 0, i);
        gridPane.add(usedMemText, 1, i);
        gridPane.add(new Label("Mb"), 2, i++);
        //----------------
        freeMemLabel.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        gridPane.add(freeMemLabel, 0, i);
        gridPane.add(freeMemText, 1, i);
        gridPane.add(new Label("Mb"), 2, i++);
        //----------------
        sysMaxMemLabel.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        gridPane.add(sysMaxMemLabel, 0, i);
        gridPane.add(sysMaxMemText, 1, i);
        gridPane.add(new Label("Mb"), 2, i++);
        //----------------
        freePhMemLabel.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        gridPane.add(freePhMemLabel, 0, i);
        gridPane.add(freePhMemText, 1, i);
        gridPane.add(new Label("Mb"), 2, i++);
        //----------------
        totalPhMemLabel.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        gridPane.add(totalPhMemLabel, 0, i);
        gridPane.add(totalPhMemText, 1, i);
        gridPane.add(new Label("Mb"), 2, i++);
        //----------------
        sysLoadLabel.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        gridPane.add(sysLoadLabel, 0, i);
        gridPane.add(sysLoadText, 1, i++);
        //----------------
        cpuLoadLabel.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        gridPane.add(cpuLoadLabel, 0, i);
        gridPane.add(cpuLoadText, 1, i);
        gridPane.add(new Label("%"), 2, i++);
        //----------------
        cpuTimeLabel.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        gridPane.add(cpuTimeLabel, 0, i);
        gridPane.add(cpuTimeText, 1, i);
        gridPane.add(new Label("ms"), 2, i++);
        //----------------
        nbProcLabel.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        gridPane.add(nbProcLabel, 0, i);
        gridPane.add(nbProcText, 1, i++);
    }

    public void bind (SysBeanFX sbfx) {
        committedMemText.textProperty().bind(sbfx.committedMemProperty());
        totalMemText.textProperty().bind(sbfx.totalMemProperty());
        usedMemText.textProperty().bind(sbfx.usedMemProperty());
        freeMemText.textProperty().bind(sbfx.freeMemProperty());
        sysMaxMemText.textProperty().bind(sbfx.maxMemProperty());
        freePhMemText.textProperty().bind(sbfx.freePhMemProperty());
        totalPhMemText.textProperty().bind(sbfx.totalPhMemProperty());
        sysLoadText.textProperty().bind(sbfx.sysLoadProperty());
        cpuLoadText.textProperty().bind(sbfx.cpuLoadProperty());
        cpuTimeText.textProperty().bind(sbfx.cpuTimeProperty());
        nbProcText.textProperty().bind(sbfx.processorsProperty());
    }

    public GridPane getGridPane() {
        return gridPane;
    }
}
