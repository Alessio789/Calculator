package it.unitn.lingprogmod1.trentin.calculator;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

public class CancButtonListener implements EventHandler {

    private TextField textField;

    @Override
    public void handle(Event event) {

        textField.setText("");
    }

    public CancButtonListener(TextField textField) {
        this.textField = textField;
    }
}
