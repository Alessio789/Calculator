package it.unitn.lingprogmod1.trentin.calculator;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class TextButtonsListener implements EventHandler {

    private TextField textField;

    @Override
    public void handle(Event event) {

        Button button = (Button) event.getTarget();
        String number = button.getText();
        String text = textField.getText();
        text += number;
        textField.setText(text);
    }

    public TextButtonsListener(TextField textField) {
        this.textField = textField;
    }
}
