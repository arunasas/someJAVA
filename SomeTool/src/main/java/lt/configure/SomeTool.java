package lt.configure;

import com.sun.javafx.scene.control.IntegerField;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SomeTool extends Application {
    // Define the Text Fields
    private final TextField firstIpField = new TextField();
    private final TextField lastIpField = new TextField();
    private final IntegerField timeOutField = new IntegerField();
    private final TextField userSSH = new TextField();
    private final PasswordField passwordSSH = new PasswordField();
    private final TextField sshCommandField = new TextField();

    // Create the TableView
    TableView<Item> table = new TableView<>();
    TextArea textArea = new TextArea();

    public static void main(String[] args) {
        launch(args);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void start(Stage stage) {
        // Turn on multi-row selection for the TableView
        //TableView.TableViewSelectionModel<Item> tableSelectionModel = table.getSelectionModel();
        //tableSelectionModel.setSelectionMode(SelectionMode.MULTIPLE);

        // Add columns to the TableView
        table.getColumns().addAll(TableViewHelp.getIdColumn(), TableViewHelp.getIpColumn(),
                TableViewHelp.getStateColumn(), TableViewHelp.getCheckBoxColumn());

        //table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        table.setEditable(true);
        table.setPlaceholder(new Label("No data exist."));
        table.setPrefHeight(300);
        // Create the GridPane
        GridPane inputPane = this.getStartPane();

        textArea.setPrefHeight(150);
        textArea.setPrefWidth(170);
        textArea.setStyle("-fx-font-family: 'monospaced';");

        // Create the VBox
        VBox root = new VBox();
        // Add the GridPane and the table to the VBox
        root.getChildren().addAll(inputPane, textArea, table);

        // Set the Padding and Border for the VBox
        root.setSpacing(5);
        // Set the Spacing and Border for the VBox
        root.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: red;");

        // Create the Scene
        Scene scene = new Scene(root);
        // Add the Scene to the Stage
        stage.setScene(scene);
        // Set the Title of the Stage
        stage.setTitle("Some Tool");
        // Display the Stage
        stage.show();
    }

    public GridPane getStartPane() {
        // Create the GridPane
        GridPane pane = new GridPane();

        // Set the hgap and vgap properties
        pane.setHgap(10);
        pane.setVgap(5);

        // Add the TextFields to the Pane
        int rI = 0;
        pane.addRow(rI++, new Label("Local Hostname / IP: "),
                new Label(new LocalHostAndIp().getName() + " / " + new LocalHostAndIp().getLocalIP()));

        pane.addRow(rI++, new Label("First IP address:"), firstIpField);
        pane.addRow(rI++, new Label("Last IP address:"), lastIpField);
        pane.addRow(rI++, new Label("Timeout, ms:"), timeOutField);
        timeOutField.setValue(100);
        pane.addRow(rI++, new Label("User SSH:"), userSSH);
        pane.addRow(rI++, new Label("Password SSH:"), passwordSSH);
        pane.addRow(rI++, new Label("Command SSH:"), sshCommandField);

        // Create the Add Button and add Event-Handler
        Button startButton = new Button("Start");
        startButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                runScan();
            }
        });

        pane.add(startButton, 2, 0);

        Button executeButton = new Button("Run");
        executeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                textArea.clear();

                TableView.TableViewSelectionModel<Item> tsm = table.getSelectionModel();
                if (tsm.isEmpty()) {
                    System.out.println("Please select a row");
                    return;
                }
                // Get all selected row indices in an array
                ObservableList<Integer> list = tsm.getSelectedIndices();

                Integer[] selectedIndices = new Integer[list.size()];
                selectedIndices = list.toArray(selectedIndices);

                Arrays.sort(selectedIndices);
                int k = 0;
                for (int i = selectedIndices.length - 1; i >= 0; i--) {
                    k = selectedIndices[i];
                    System.out.println(selectedIndices[i]);
                }
                StringBuilder string = JschExec.getSshOutput(table.getItems().get(k).getIp(), userSSH.getText(), //
                        passwordSSH.getText(), sshCommandField.getText());
                textArea.setText(string.toString());
            }
        });

        // Add the Add Button to the GridPane
        pane.add(executeButton, 2, 6);

        return pane;
    }

    public void runScan() {

        table.getItems().clear();

        int currentId = 1;

        for (String ip : HostsAliveCheck.IPstoArray(firstIpField.getText(), lastIpField.getText())
        ) {
            table.getItems().add(new Item(currentId, ip, HostsAliveCheck.IsAlive(ip, timeOutField.getValue()), false));
            System.out.println(currentId + " " + ip + " " + HostsAliveCheck.IsAlive(ip, timeOutField.getValue()));
            currentId++;
        }
    }

    public void test() {

        TableView.TableViewSelectionModel<Item> tsm = table.getSelectionModel();

        if (tsm.isEmpty()) {
            System.out.println("Please select a row");
            return;
        }

        // Get all selected row indices in an array
        ObservableList<Integer> list = tsm.getSelectedIndices();

        Integer[] selectedIndices = new Integer[list.size()];
        selectedIndices = list.toArray(selectedIndices);

        Arrays.sort(selectedIndices);
        int k = 0;
        for (int i = selectedIndices.length - 1; i >= 0; i--) {
            k = selectedIndices[i];
            System.out.println(selectedIndices[i]);
        }

        Item item = table.getItems().get(k);
        System.out.println("Selected row:");
        System.out.println(item.getId() + " " + item.getIp() + " " + item.getState() + ", To SSH: " + item.isSelect());

    }
}

