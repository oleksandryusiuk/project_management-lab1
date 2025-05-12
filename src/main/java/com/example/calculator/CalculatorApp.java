package com.example.calculator;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class CalculatorApp extends JFrame implements ActionListener {

    private JTextField input1, input2, result;
    private JButton addBtn, subBtn, mulBtn, divBtn;

    public CalculatorApp() {
        setTitle("Калькулятор");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2));

        input1 = new JTextField();
        input2 = new JTextField();
        result = new JTextField();
        result.setEditable(false);

        addBtn = new JButton("+");
        subBtn = new JButton("-");
        mulBtn = new JButton("*");
        divBtn = new JButton("/");

        addBtn.addActionListener(this);
        subBtn.addActionListener(this);
        mulBtn.addActionListener(this);
        divBtn.addActionListener(this);

        add(new JLabel("Число 1:"));
        add(input1);
        add(new JLabel("Число 2:"));
        add(input2);
        add(addBtn);
        add(subBtn);
        add(mulBtn);
        add(divBtn);
        add(new JLabel("Результат:"));
        add(result);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double num1 = Double.parseDouble(input1.getText());
            double num2 = Double.parseDouble(input2.getText());
            double res = 0;

            if (e.getSource() == addBtn) {
                res = num1 + num2;
            } else if (e.getSource() == subBtn) {
                res = num1 - num2;
            } else if (e.getSource() == mulBtn) {
                res = num1 * num2;
            } else if (e.getSource() == divBtn) {
                if (num2 == 0) {
                    result.setText("Ділення на 0!");
                    return;
                }
                res = num1 / num2;
            }

            result.setText(String.valueOf(res));
        } catch (NumberFormatException ex) {
            result.setText("Помилка вводу");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CalculatorApp().setVisible(true);
        });
    }
}
