package calculatorview;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Calculator  extends Application {

    private final int HEIGHT = 310;
    private final int WIDTH = 280;

    String strNumberButtons[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    String strOperationButtons[] = {"+", "-", "*", "/"};
    String strFunctionalButtons[] = {"sqrt(x)", "x^2", "C", "="};

    Button numberButtons[] = new Button[10];
    Button operationButtons[] = new Button[4];
    Button functionalButtons[] = new Button[4];
    Button point;
    Button inverseNumber;
    TextField writingField;

    @Override
    public void init(){

        point = new Button(".");
        point.setPrefSize(50, 50);
        inverseNumber = new Button("-+");
        inverseNumber.setPrefSize(50, 50);

        int funcCounter = operationButtons.length;
        for(int i = 0; i < numberButtons.length; i++){
            if(i < funcCounter){
                operationButtons[i] = new Button(strOperationButtons[i]);
                operationButtons[i].setPrefSize(50, 50);

                functionalButtons[i] = new Button(strFunctionalButtons[i]);
                functionalButtons[i].setPrefSize(50, 50);
            }
            numberButtons[i] = new Button(strNumberButtons[i]);
            numberButtons[i].setPrefSize(50, 50);
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Calculator");

        writingField = new TextField();
        //create numbers buttons with point and negative value
        GridPane numbersPane = new GridPane();
        createNumbersTable(numbersPane);


        FlowPane operationPane = new FlowPane(Orientation.VERTICAL);
        FlowPane functionalPane = new FlowPane(Orientation.VERTICAL);
        operationPane.getChildren().addAll(operationButtons);
        functionalPane.getChildren().addAll(functionalButtons);

        FlowPane mainPane = new FlowPane(Orientation.HORIZONTAL, 10, 10);
        mainPane.getChildren().addAll(numbersPane, operationPane, functionalPane);

        VBox rootPane = new VBox(15);
        rootPane.setPadding(new Insets(20, 20, 20, 20));
        Scene scene = new Scene(rootPane, HEIGHT,WIDTH);
        primaryStage.setScene(scene);

        rootPane.getChildren().addAll(writingField, mainPane);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    private void createNumbersTable(GridPane pane){
        pane.add(point, 0, 0);
        pane.add(numberButtons[0], 1, 0);
        pane.add(inverseNumber, 2, 0);
        int val = 1;
        for(int i = 1; i < 4; i++){
            for(int j = 0; j < 3; j++){
                pane.add(numberButtons[val], j, i);
                val++;
            }
        }

    }
}
