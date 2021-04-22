package it.unitn.lingprogmod1.trentin.calculator;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

public class EqButtonListener implements EventHandler {

    private TextField textField;

    @Override
    public void handle(Event event) {

        boolean negative = false;
        String operation = textField.getText();
        double op1 = 0;

        if (operation.startsWith("-")) {
            negative = true;
        }

        if (operation.contains("+")) {

            String[] op = operation.split("\\+");
            op1 = Double.parseDouble(op[0]);
            double op2 = Double.parseDouble(op[1]);
            double ris = op1 + op2;
            textField.setText(String.valueOf(ris));
        }

        else if (operation.contains("*")) {

            String[] op = operation.split("\\*");
            op1 = Double.parseDouble(op[0]);
            double op2 = Double.parseDouble(op[1]);
            double ris = op1 * op2;
            textField.setText(String.valueOf(ris));
        }

        else if (operation.contains("/")) {

            String[] op = operation.split("/");
            op1 = Double.parseDouble(op[0]);
            double op2 = Double.parseDouble(op[1]);
            double ris = op1 / op2;
            textField.setText(String.valueOf(ris));
        }

        else if (operation.contains("-")) {

            String[] op;
            if (!negative) {
                op = operation.split("-");
                op1 = Double.parseDouble(op[0]);
            }
            else {
                operation = operation.substring(1);
                op = operation.split("-");
                op1 = 0 - Double.parseDouble(op[0]);
            }

            double op2 = Double.parseDouble(op[1]);
            double ris = op1 - op2;
            textField.setText(String.valueOf(ris));
        }

        else {
            textField.setText("Error!");
        }
    }

    public EqButtonListener(TextField textField) {
        this.textField = textField;
    }
}
