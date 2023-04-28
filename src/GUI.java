import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {
    private JPanel panel1;
    private JPanel panel2;
    private JComboBox comboBox1;
    private JLabel result;
    private JTextField textField;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton button0;
    private JButton buttonC;

    public GUI() {
        super();
        setSize(900, 600);
        setTitle("ORANGE CALCULATOR v0.1");
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(panel1);
        panel1.setBackground(new Color(255,165,0));
        panel2.setBackground(Color.WHITE);
        panel2.setSize(202,200);

        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String s = (String) comboBox1.getSelectedItem();
                switch (s) {
                    case "Orange theme":
                        panel1.setBackground(new Color(255,165,0));
                        break;
                    case "Light theme":
                        panel1.setBackground(new Color(220,220,220));
                        break;
                    case "Dark theme":
                        panel1.setBackground(Color.DARK_GRAY);
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + s);
                }
            };
        });

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String text = textField.getText();
                text += "1";
                textField.setText(text);
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String text = textField.getText();
                text += "2";
                textField.setText(text);
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String text = textField.getText();
                text += "3";
                textField.setText(text);
            }
        });

        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String text = textField.getText();
                text += "4";
                textField.setText(text);
            }
        });

        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String text = textField.getText();
                text += "5";
                textField.setText(text);
            }
        });

        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String text = textField.getText();
                text += "6";
                textField.setText(text);
            }
        });

        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String text = textField.getText();
                text += "7";
                textField.setText(text);
            }
        });

        button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String text = textField.getText();
                text += "8";
                textField.setText(text);
            }
        });

        button9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String text = textField.getText();
                text += "9";
                textField.setText(text);
            }
        });

        button0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String text = textField.getText();
                text += "0";
                textField.setText(text);
            }
        });

        buttonC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                textField.setText("");
            }
        });

    }
}
