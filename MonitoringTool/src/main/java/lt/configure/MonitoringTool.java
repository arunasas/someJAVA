package lt.configure;

import javafx.application.Application;
import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.net.InetAddress;


import static javafx.application.Application.launch;

public class MonitoringTool extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    private int prefWidth = 200;
    private int prefWidth2 = 60;

    @Override
    public void start(Stage stage) {
        stage.setTitle("Some Tool");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setHgap(5);
        grid.setVgap(0);
        grid.setPadding(new Insets(3, 3, 3, 3));

        Label labelLocalHostNameAndIp = new Label("Local HostName / IP:");
        Label labelLocalHostAndIp = new Label(new LocalHostAndIp().getName() + " / "
                + new LocalHostAndIp().getIp());
        Label labelEmpty = new Label();
        Label nameLabelIpStart = new Label("First IP address:");
        Label nameLabelIpEnd = new Label("Last IP address:");
        Label labelError1 = new Label();
        Label labelError2 = new Label();

        TextField ipStartTextField = new TextField();
        TextField ipEndTextField = new TextField();

        ipStartTextField.setPrefWidth(prefWidth);
        ipEndTextField.setPrefWidth(prefWidth);

        Button btnStart = new Button("Start");

        CheckBox CheckBoxIp0 = new CheckBox();
        CheckBoxIp0.setIndeterminate(false);

        Label labelIpStart = new Label();
        //Label labelIpEnd = new Label();

        TextArea textArea = new TextArea();
        textArea.setPrefHeight(200);
        textArea.setPrefWidth(prefWidth);
        StringBuilder b = new StringBuilder();
//
        ObservableList<Item> list = FXCollections.observableArrayList();
        //list.addAll(new Item("Jonas", "Jonaitis", 11), new Item("Petras", "Petraitis", 13));
        TableView table = new TableView();
        table.setPrefWidth(prefWidth);
        TableColumn col1 = new TableColumn("IP");
        col1.setPrefWidth(prefWidth-prefWidth2);
        col1.setCellValueFactory(new Callback<TableColumn.CellDataFeatures, ObservableValue>() {
            @Override
            public ObservableValue call(TableColumn.CellDataFeatures param) {
                Item item = (Item) param.getValue();
                return new ReadOnlyStringWrapper(item.getIp());
            }
        });
        TableColumn col2 = new TableColumn("State");
        col2.setPrefWidth(prefWidth2);
        col2.setCellValueFactory(new Callback<TableColumn.CellDataFeatures, ObservableValue>() {
            @Override
            public ObservableValue call(TableColumn.CellDataFeatures param) {
                Item item = (Item) param.getValue();
                return new ReadOnlyStringWrapper(item.getReachable());
            }
        });

        table.getColumns().addAll(col1, col2);
        table.setItems(list);
        grid.add(table, 0, 7);

//

        grid.add(labelLocalHostNameAndIp, 0, 0); grid.add(labelLocalHostAndIp, 1, 0);
        grid.add(new Label(), 0, 1);

        grid.add(nameLabelIpStart, 0, 3); grid.add(nameLabelIpEnd, 1, 3);
        grid.add(ipStartTextField, 0, 4); grid.add(ipEndTextField, 1, 4);

        grid.add(btnStart, 2, 4);

        grid.add(labelError1, 0, 5); grid.add(labelError2, 1, 5);
        grid.add(new Label(), 0, 6);
        //grid.add(textArea, 0, 7);


        btnStart.setOnMouseClicked(mouseEvent -> {
            String ipStart = ipStartTextField.getText();
            String ipEnd = ipEndTextField.getText();

            boolean boolIp1 = new HostsAliveCheck().validateIP(ipStart);
            boolean boolIp2 = new HostsAliveCheck().validateIP(ipEnd);
            if (!(boolIp1 && boolIp2)) {
                if (!boolIp1) {
                    labelError1.setText("Incorrect IP");
                    labelIpStart.setText(null);
                }
                if (!boolIp2) {
                    labelError2.setText("Incorrect IP");
                }
            } else {
                    labelError1.setText(null);
                    labelError2.setText(null);
                    list.clear();
                for (String ip : HostsAliveCheck.IPstoArray(ipStart, ipEnd)
                ) {
                    list.add(new Item(ip,HostsAliveCheck.IsAlive(ip)));
                    System.out.println(ip + " " + HostsAliveCheck.IsAlive(ip));
                }
            }
        });

        Scene scene = new Scene(grid, 500, 400);
        stage.setScene(scene);
        stage.show();
    }
}