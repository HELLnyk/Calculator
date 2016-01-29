package calculatorview;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Calculator  extends Application {

    String strNumberButtons[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    //String operationButtons[] = {"+", "-", "*", "/"};

    Button numberButtons[] = new Button[10];
    //Button operationButtons[];

    @Override
    public void init(){
        for(int i = 0; i < 10; i++){
            numberButtons[i] = new Button(strNumberButtons[i]);
            numberButtons[i].setPrefSize(50, 50);
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Calculator");

        FlowPane rootPane = new FlowPane(Orientation.HORIZONTAL);
        rootPane.setAlignment(Pos.CENTER);
        Scene scene = new Scene(rootPane, 400, 300);
        primaryStage.setScene(scene);

        rootPane.getChildren().addAll(numberButtons);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
