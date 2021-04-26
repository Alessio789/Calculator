package it.unitn.lingprogmod1.trentin.calculator;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class OpButtonListener implements EventHandler {

    private TextField textField;
    ArrayList<String> operands;
    ArrayList<String> operators;

    @Override
    public void handle(Event event) {

        operands = new ArrayList<>();
        operators = new ArrayList<>();

        Button button = (Button) event.getTarget();
        String buttonName = button.getText();
        String text = textField.getText();

        boolean negative = false;
        if (text.equals("") && buttonName.equals("-")) {
            negative = true;
        }
        String[] operandsString = text.split("[+\\-*/=]");
        String[] operatorsString = text.split("[.0-9]");

        deleteNulls(operandsString, operatorsString);

        if (negative && operands.size() != 0 && operators.get(0) == "-") {
            operands.set(0, "-" + operands.get(0));
            operators.remove(0);
        }

        if (buttonName.equals("=")) {
            buttonName = "";
        }

        if (operands.size() < 2) {
            text += buttonName;
            textField.setText(text);
        }

        else {
            double ris;

            switch (operators.get(0)) {

                case "+":
                    ris = Double.parseDouble(operands.get(0)) + Double.parseDouble(operands.get(1));
                    textField.setText(ris + buttonName);
                    break;

                case "*":
                    ris = Double.parseDouble(operands.get(0)) * Double.parseDouble(operands.get(1));
                    textField.setText(ris + buttonName);
                    break;

                case "/":
                    ris = Double.parseDouble(operands.get(0)) / Double.parseDouble(operands.get(1));
                    textField.setText(ris + buttonName);
                    break;

                case "-":
                    ris = Double.parseDouble(operands.get(0)) - Double.parseDouble(operands.get(1));
                    textField.setText(ris + buttonName);
                    break;
            }
        }

    }

    private void deleteNulls(String[] operandsString, String[] operatorsString) {

        for (int i = 0; i < operandsString.length; i++) {
            if (!operandsString[i].equals("")) {
                operands.add(operandsString[i]);
            }
        }

        for (int i = 0; i < operatorsString.length; i++) {
            if (!operatorsString[i].equals("")) {
                operators.add(operatorsString[i]);
            }
        }
    }

    public OpButtonListener(TextField textField) {
        this.textField = textField;
    }
}
