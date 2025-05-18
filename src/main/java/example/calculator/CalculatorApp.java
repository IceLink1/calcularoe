//package com.example.calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorApp {
    private JFrame frame;
    private JTextField display;
    private String currentInput = "";
    private double result = 0;
    private String lastOperation = "";

    public CalculatorApp() {

        frame = new JFrame("Калькулятор");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);
        frame.setLayout(new BorderLayout());

        try {
            UIManager.setLookAndFeel("com.formdev.flatlaf.FlatLightLaf");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        display = new JTextField();
        display.setFont(new Font("Arial", Font.PLAIN, 24));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        frame.add(display, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4, 5, 5));

        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+",
                "C", "⌫", "±", "√"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.PLAIN, 18));
            button.addActionListener(new ButtonClickListener());
            buttonPanel.add(button);
        }

        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            switch (command) {
                case "0": case "1": case "2": case "3": case "4":
                case "5": case "6": case "7": case "8": case "9":
                case ".":
                    currentInput += command;
                    display.setText(currentInput);
                    break;

                case "+": case "-": case "*": case "/":
                    if (!currentInput.isEmpty()) {
                        calculate();
                        lastOperation = command;
                        currentInput = "";
                    }
                    break;

                case "=":
                    calculate();
                    lastOperation = "";
                    break;

                case "C":
                    currentInput = "";
                    result = 0;
                    lastOperation = "";
                    display.setText("");
                    break;

                case "⌫":
                    if (!currentInput.isEmpty()) {
                        currentInput = currentInput.substring(0, currentInput.length() - 1);
                        display.setText(currentInput);
                    }
                    break;

                case "±":
                    if (!currentInput.isEmpty()) {
                        double value = Double.parseDouble(currentInput);
                        value = -value;
                        currentInput = Double.toString(value);
                        display.setText(currentInput);
                    }
                    break;

                case "√":
                    if (!currentInput.isEmpty()) {
                        double value = Double.parseDouble(currentInput);
                        if (value >= 0) {
                            value = Math.sqrt(value);
                            currentInput = Double.toString(value);
                            display.setText(currentInput);
                        } else {
                            display.setText("Ошибка");
                            currentInput = "";
                        }
                    }
                    break;
            }
        }

        private void calculate() {
            if (currentInput.isEmpty()) return;

            double inputNumber = Double.parseDouble(currentInput);

            switch (lastOperation) {
                case "+":
                    result += inputNumber;
                    break;
                case "-":
                    result -= inputNumber;
                    break;
                case "*":
                    result *= inputNumber;
                    break;
                case "/":
                    if (inputNumber != 0) {
                        result /= inputNumber;
                    } else {
                        display.setText("Ошибка");
                        currentInput = "";
                        result = 0;
                        lastOperation = "";
                        return;
                    }
                    break;
                default:
                    result = inputNumber;
                    break;
            }

            display.setText(Double.toString(result));
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CalculatorApp());
    }
}