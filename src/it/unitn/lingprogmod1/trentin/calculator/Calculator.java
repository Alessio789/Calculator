package it.unitn.lingprogmod1.trentin.calculator;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Calculator extends Application {

    private static final String[][] CALC= {
            { "7", "8", "9", "/"},
            {"4", "5", "6", "*"},
            {"1", "2", "3", "-"},
            {"C", "0", ".", "+"},
            {"="}
    };

    private Button createButton(String s) {

        Button button = new Button(s);
        button.setStyle("-fx-base: white;");
        button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        return button;
    }

    private void createButtons(TilePane buttons, TextField textField) {

        NumButtonsListener numButtonsListener = new NumButtonsListener(textField);
        OpButtonListener opButtonListener = new OpButtonListener(textField);
        //EqButtonListener eqButtonListener = new EqButtonListener(textField);
        CancButtonListener cancButtonListener = new CancButtonListener(textField);

        for (String[] row : CALC) {

            for (String s : row) {
                Button b = createButton(s);

                if (b.getText().matches("[0-9]") || b.getText().matches("\\.")) {
                    b.addEventHandler(ActionEvent.ACTION, numButtonsListener);
                }

                else if (b.getText().matches("[+\\-*/=]")) {
                    b.addEventHandler(ActionEvent.ACTION, opButtonListener);

                }

                else if (b.getText().equals("C")) {
                    b.addEventHandler(ActionEvent.ACTION, cancButtonListener);
                }
                buttons.getChildren().add(b);
            }
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        VBox root = new VBox(24);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: grey; -fx-padding: 20; -fx-font-size: 20;");

        TilePane buttons = new TilePane();
        buttons.setVgap(7);
        buttons.setHgap(7);
        buttons.setPrefColumns(CALC[1].length);

        TextField textField = new TextField();
        textField.setStyle("-fx-background-color: white;");
        textField.setAlignment(Pos.CENTER_RIGHT);
        textField.setEditable(false);

        createButtons(buttons, textField);

        root.getChildren().setAll(textField, buttons);
        textField.prefWidthProperty().bind(buttons.widthProperty());

        primaryStage.setTitle("Calculator");
        primaryStage.initStyle(StageStyle.UTILITY);
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
