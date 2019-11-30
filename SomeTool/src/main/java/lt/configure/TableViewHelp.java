package lt.configure;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

public class TableViewHelp {

    public static ObservableList<Item> getItemList() {

        return FXCollections.<Item>observableArrayList();
    }

    public static TableColumn<Item, Integer> getIdColumn() {
        TableColumn<Item, Integer> idCol = new TableColumn<>("#");
        PropertyValueFactory<Item, Integer> idCellValueFactory = new PropertyValueFactory<>("id");
        idCol.setCellValueFactory(idCellValueFactory);
        idCol.setPrefWidth(40);
        return idCol;
    }

    public static TableColumn<Item, String> getIpColumn() {
        TableColumn<Item, String> ipCol = new TableColumn<>("IP");
        PropertyValueFactory<Item, String> ipCellValueFactory = new PropertyValueFactory<>("ip");
        ipCol.setCellValueFactory(ipCellValueFactory);
        ipCol.setPrefWidth(180);
        return ipCol;
    }

    public static TableColumn<Item, String> getStateColumn() {
        TableColumn<Item, String> stateCol = new TableColumn<>("State");
        PropertyValueFactory<Item, String> stateCellValueFactory = new PropertyValueFactory<>("state");
        stateCol.setCellValueFactory(stateCellValueFactory);
        stateCol.setPrefWidth(60);
        return stateCol;
    }

    public static TableColumn<Item, Boolean> getCheckBoxColumn() {
        TableColumn<Item, Boolean> selectCol = new TableColumn<>("To SSH");

        selectCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Item, Boolean>, ObservableValue<Boolean>>() {

            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Item, Boolean> param) {
                Item item = param.getValue();

                SimpleBooleanProperty booleanProp = new SimpleBooleanProperty(item.isSelect());

                // When "Select" column change.
                booleanProp.addListener(new ChangeListener<Boolean>() {

                    @Override
                    public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                        item.setSelect(newValue);
                    }
                });
                return booleanProp;
            }
        });

        selectCol.setCellFactory(new Callback<TableColumn<Item, Boolean>, TableCell<Item, Boolean>>() {

            @Override
            public TableCell<Item, Boolean> call(TableColumn<Item, Boolean> p) {
                CheckBoxTableCell<Item, Boolean> cell = new CheckBoxTableCell<Item, Boolean>();
                cell.setAlignment(Pos.CENTER);
                return cell;
            }
        });

        selectCol.setPrefWidth(60);
        return selectCol;
    }

}

