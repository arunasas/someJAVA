package lt.configure;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GuiTest extends Application {
        public static void main(String[] args) {
            launch(args);
        }

        @Override
        public void start(Stage stage) {


            Label nameLabelIpStart = new Label("IP start address:");
            Label nameLabelIpEnd = new Label("IP end address:");
            nameLabelIpStart.setPrefWidth(150);
            nameLabelIpEnd.setPrefWidth(150);


            Label labelError1 = new Label();
            Label labelError2 = new Label();


            TextField ipStartTextField = new TextField();
            TextField ipEndTextField = new TextField();

            ipStartTextField.setPrefWidth(150);
            ipEndTextField.setPrefWidth(150);


            Button btnStart = new Button("Start");

            ToolBar toolBar1 = new ToolBar();
            toolBar1.getItems().addAll(
                    new Separator(),
                    nameLabelIpStart,
                    new Separator(),
                    nameLabelIpEnd,
                    new Separator()
            );
            ToolBar toolBar2 = new ToolBar();
            //toolBar2.setOrientation(Orientation.VERTICAL);
            toolBar2.getItems().addAll(
                    new Separator(),
                    ipStartTextField,
                    new Separator(),
                    ipEndTextField,
                    new Separator(),
                    btnStart,
                    new Separator()
            );

            BorderPane pane = new BorderPane();
            pane.setTop(toolBar1);
            pane.setLeft(toolBar2);

            Scene scene = new Scene(pane, 600, 400);
            stage.setScene(scene);
            stage.setTitle("GUI Test");
            stage.show();

            GridPane grid = new GridPane();
            grid.setAlignment(Pos.TOP_CENTER);
            grid.setHgap(5);
            grid.setVgap(0);
            grid.setPadding(new Insets(3, 3, 3, 3));



        }
    }

