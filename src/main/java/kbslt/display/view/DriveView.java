package kbslt.display.view;

import eu.hansolo.medusa.Gauge;
import eu.hansolo.medusa.GaugeBuilder;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.text.Text;
import javafx.util.StringConverter;
import kbslt.drive.Drive;

import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * @author Jean-Pierre Alonso.
 */
public class DriveView {
    private final GridPane gridPane = new GridPane();
    private final Text setText = new Text();
    private final Text viewText = new Text();
    private final Slider setSlider = new Slider(0,3000,0);
//    private final Slider viewSlider = new Slider(0,3000,0);
    private Gauge gauge;

    public DriveView (Drive dr) {
        setText.textProperty().bindBidirectional(setSlider.valueProperty(), new numberStringConverter() );
        setSlider.setVisible(true);
        setSlider.setSnapToTicks(true);
        setSlider.setShowTickLabels(true);
        setSlider.setMajorTickUnit(1000);
        setSlider.setMinorTickCount(100);
        setSlider.setOrientation(Orientation.HORIZONTAL);
        setSlider.setPrefSize(300, 100);
        dr.requestedConnectionsProperty().bind(setSlider.valueProperty());
        /* -----------------------------------*/
//        viewSlider.setVisible(true);
//        viewSlider.setSnapToTicks(false);
//        viewSlider.setShowTickLabels(true);
//        viewSlider.setMajorTickUnit(1000);
//        viewSlider.setMinorTickCount(100);
//        viewSlider.setOrientation(Orientation.HORIZONTAL);
//        viewSlider.setPrefSize(300, 100);
//        viewSlider.valueProperty().bind(dr.startedConnectionsProperty());
//        viewText.textProperty().bind(dr.startedConnectionsProperty().asString());
        /* -----------------------------------*/
        NumberFormat numberFormat = NumberFormat.getInstance(new Locale("fr", "FR"));
        numberFormat.setRoundingMode(RoundingMode.HALF_DOWN);
        numberFormat.setMinimumIntegerDigits(3);
        numberFormat.setMaximumIntegerDigits(3);
        numberFormat.setMinimumFractionDigits(0);
        numberFormat.setMaximumFractionDigits(0);

        gauge = GaugeBuilder.create()
                .prefSize(400, 400)
                .animated(true)
                .checkThreshold(true)
                .onThresholdExceeded(e -> System.out.println("threshold exceeded"))
                .threshold(2500)
                .lcdVisible(true)
                .locale(Locale.FRANCE)
                .numberFormat(numberFormat)
                .skinType(Gauge.SkinType.HORIZONTAL)
                //.interactive(true)
                //.onButtonPressed(o -> System.out.println("Button pressed"))
                .build();
        gauge.valueProperty().bind(dr.startedConnectionsProperty());
        gauge.setVisible(true);
        //gauge.valueVisibleProperty().bind(toggle);

        /* -----------------------------------*/
        gridPane.setPadding(new Insets(30,20,10,10));
        gridPane.add(setText,0,0);
        gridPane.add(setSlider,0,1);
        gridPane.add(viewText,0,2);
        gridPane.add(gauge,0,3);
    }

    public GridPane getGridPane() {
        return gridPane;
    }

    private class numberStringConverter extends StringConverter<Number> {
        @Override
        public String toString(Number object) {
            return Integer.toString(object.intValue());
        }

        @Override
        public Number fromString(String string) {
            return Integer.parseInt(string);
        }
    }
}
