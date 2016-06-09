package kbslt.display.view;

import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import kbslt.monitor.model.SysBeanFX;

/**
 * @author Jean-Pierre Alonso.
 */
public class SysTableView {
    private final TableView<SysBeanFX> tableView;
    private Observable selectedItem;

    public SysTableView() {
        tableView = new TableView<>();
        tableView.setEditable(false);
        tableView.setVisible(true);
        ObservableList<TableColumn<SysBeanFX, ?>> columns = tableView.getColumns();
//        ObservableList<SysBeanFX> lines = tableView.getItems();

        columns.add(new TableColumn<>("committedMem"));
        columns.add(new TableColumn<>("totalMem"));
        columns.add(new TableColumn<>("usedMem"));
        columns.add(new TableColumn<>("freeMem"));
        columns.add(new TableColumn<>("maxMem"));
        columns.add(new TableColumn<>("freePhMem"));
        columns.add(new TableColumn<>("totalPhMem"));
        columns.add(new TableColumn<>("sysLoad"));
        columns.add(new TableColumn<>("cpuLoad"));
        columns.add(new TableColumn<>("cpuTime"));
        int i=0;
        for (TableColumn<SysBeanFX, ?> column : columns) {
            String fieldName = SysBeanFX.class.getDeclaredFields()[i++].getName();
            column.setCellValueFactory(
                    new PropertyValueFactory<>(fieldName));
            System.out.printf("Colonne : %s, champ : %s", column.getText(), fieldName).println();
        }
        selectedItem = tableView.getSelectionModel().selectedItemProperty();
    }

    public TableView<SysBeanFX> getTableView() {
        return tableView;
    }

    public Observable getSelectedItem() {
        return selectedItem;
    }
}
