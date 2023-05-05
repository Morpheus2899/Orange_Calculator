import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.prefs.Preferences;

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
    private JButton buttonPlus;
    private JButton buttonMinus;
    private JButton buttonTimes;
    private JButton buttonDiv;
    private JButton buttonEnter;
    private JLabel labelResult;
    private JButton buttonPoint;
    private JFrame errorPane;
    Preferences pref = Preferences.userRoot();

    public GUI() {
        super();
        setSize(750, 650);
        setTitle("ORANGE CALCULATOR v0.1");
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(panel1);
        panel1.setBackground(new Color(255,165,0));
        panel2.setBackground(Color.WHITE);
        panel2.setSize(202,200);
        String comboBoxValue = pref.get("comboBoxValue", "Dark theme");
        switch (comboBoxValue) {
            case "Orange theme":
                panel1.setBackground(new Color(255,165,0));
                labelResult.setForeground(Color.BLACK);
                button1.setBackground(new Color(64, 64, 64));
                button2.setBackground(new Color(64, 64, 64));
                button3.setBackground(new Color(64, 64, 64));
                button4.setBackground(new Color(64, 64, 64));
                button5.setBackground(new Color(64, 64, 64));
                button6.setBackground(new Color(64, 64, 64));
                button7.setBackground(new Color(64, 64, 64));
                button8.setBackground(new Color(64, 64, 64));
                button9.setBackground(new Color(64, 64, 64));
                button0.setBackground(new Color(64, 64, 64));
                button1.setForeground(new Color(255, 255, 255));
                button2.setForeground(new Color(255, 255, 255));
                button3.setForeground(new Color(255, 255, 255));
                button4.setForeground(new Color(255, 255, 255));
                button5.setForeground(new Color(255, 255, 255));
                button6.setForeground(new Color(255, 255, 255));
                button7.setForeground(new Color(255, 255, 255));
                button8.setForeground(new Color(255, 255, 255));
                button9.setForeground(new Color(255, 255, 255));
                button0.setForeground(new Color(255, 255, 255));
                comboBox1.setSelectedIndex(0);
                break;
            case "Light theme":
                panel1.setBackground(new Color(220,220,220));
                labelResult.setForeground(Color.BLACK);
                button1.setBackground(new Color(255, 111, 0));
                button2.setBackground(new Color(255, 111, 0));
                button3.setBackground(new Color(255, 111, 0));
                button4.setBackground(new Color(255, 111, 0));
                button5.setBackground(new Color(255, 111, 0));
                button6.setBackground(new Color(255, 111, 0));
                button7.setBackground(new Color(255, 111, 0));
                button8.setBackground(new Color(255, 111, 0));
                button9.setBackground(new Color(255, 111, 0));
                button0.setBackground(new Color(255, 111, 0));
                button1.setForeground(Color.BLACK);
                button2.setForeground(Color.BLACK);
                button3.setForeground(Color.BLACK);
                button4.setForeground(Color.BLACK);
                button5.setForeground(Color.BLACK);
                button6.setForeground(Color.BLACK);
                button7.setForeground(Color.BLACK);
                button8.setForeground(Color.BLACK);
                button9.setForeground(Color.BLACK);
                button0.setForeground(Color.BLACK);
                comboBox1.setSelectedIndex(1);
                break;
            case "Dark theme":
                panel1.setBackground(Color.DARK_GRAY);
                labelResult.setForeground(Color.WHITE);
                button1.setBackground(new Color(255, 111, 0));
                button2.setBackground(new Color(255, 111, 0));
                button3.setBackground(new Color(255, 111, 0));
                button4.setBackground(new Color(255, 111, 0));
                button5.setBackground(new Color(255, 111, 0));
                button6.setBackground(new Color(255, 111, 0));
                button7.setBackground(new Color(255, 111, 0));
                button8.setBackground(new Color(255, 111, 0));
                button9.setBackground(new Color(255, 111, 0));
                button0.setBackground(new Color(255, 111, 0));
                button1.setForeground(new Color(255, 255, 255));
                button2.setForeground(new Color(255, 255, 255));
                button3.setForeground(new Color(255, 255, 255));
                button4.setForeground(new Color(255, 255, 255));
                button5.setForeground(new Color(255, 255, 255));
                button6.setForeground(new Color(255, 255, 255));
                button7.setForeground(new Color(255, 255, 255));
                button8.setForeground(new Color(255, 255, 255));
                button9.setForeground(new Color(255, 255, 255));
                button0.setForeground(new Color(255, 255, 255));
                comboBox1.setSelectedIndex(2);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + comboBoxValue);
        }

        textField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && (c != '+') &&
                        (c != '-') && (c != 'x') && (c != '/') && (c != '.')) {
                    e.consume();  // ignore event
                }
                if (c == '+' || c == '-' || c == 'x' || c == '/') {
                    buttonPlus.setEnabled(false);
                    buttonMinus.setEnabled(false);
                    buttonTimes.setEnabled(false);
                    buttonDiv.setEnabled(false);
                }
                if (c == '\n') buttonEnter.doClick();

            }
        });

        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String s = (String) comboBox1.getSelectedItem();
                switch (s) {
                    case "Orange theme":
                        panel1.setBackground(new Color(255,165,0));
                        labelResult.setForeground(Color.BLACK);
                        button1.setBackground(new Color(64, 64, 64));
                        button2.setBackground(new Color(64, 64, 64));
                        button3.setBackground(new Color(64, 64, 64));
                        button4.setBackground(new Color(64, 64, 64));
                        button5.setBackground(new Color(64, 64, 64));
                        button6.setBackground(new Color(64, 64, 64));
                        button7.setBackground(new Color(64, 64, 64));
                        button8.setBackground(new Color(64, 64, 64));
                        button9.setBackground(new Color(64, 64, 64));
                        button0.setBackground(new Color(64, 64, 64));
                        button1.setForeground(new Color(255, 255, 255));
                        button2.setForeground(new Color(255, 255, 255));
                        button3.setForeground(new Color(255, 255, 255));
                        button4.setForeground(new Color(255, 255, 255));
                        button5.setForeground(new Color(255, 255, 255));
                        button6.setForeground(new Color(255, 255, 255));
                        button7.setForeground(new Color(255, 255, 255));
                        button8.setForeground(new Color(255, 255, 255));
                        button9.setForeground(new Color(255, 255, 255));
                        button0.setForeground(new Color(255, 255, 255));
                        break;
                    case "Light theme":
                        panel1.setBackground(new Color(220,220,220));
                        labelResult.setForeground(Color.BLACK);
                        button1.setBackground(new Color(255, 111, 0));
                        button2.setBackground(new Color(255, 111, 0));
                        button3.setBackground(new Color(255, 111, 0));
                        button4.setBackground(new Color(255, 111, 0));
                        button5.setBackground(new Color(255, 111, 0));
                        button6.setBackground(new Color(255, 111, 0));
                        button7.setBackground(new Color(255, 111, 0));
                        button8.setBackground(new Color(255, 111, 0));
                        button9.setBackground(new Color(255, 111, 0));
                        button0.setBackground(new Color(255, 111, 0));
                        button1.setForeground(Color.BLACK);
                        button2.setForeground(Color.BLACK);
                        button3.setForeground(Color.BLACK);
                        button4.setForeground(Color.BLACK);
                        button5.setForeground(Color.BLACK);
                        button6.setForeground(Color.BLACK);
                        button7.setForeground(Color.BLACK);
                        button8.setForeground(Color.BLACK);
                        button9.setForeground(Color.BLACK);
                        button0.setForeground(Color.BLACK);
                        break;
                    case "Dark theme":
                        panel1.setBackground(Color.DARK_GRAY);
                        labelResult.setForeground(Color.WHITE);
                        button1.setBackground(new Color(255, 111, 0));
                        button2.setBackground(new Color(255, 111, 0));
                        button3.setBackground(new Color(255, 111, 0));
                        button4.setBackground(new Color(255, 111, 0));
                        button5.setBackground(new Color(255, 111, 0));
                        button6.setBackground(new Color(255, 111, 0));
                        button7.setBackground(new Color(255, 111, 0));
                        button8.setBackground(new Color(255, 111, 0));
                        button9.setBackground(new Color(255, 111, 0));
                        button0.setBackground(new Color(255, 111, 0));
                        button1.setForeground(new Color(255, 255, 255));
                        button2.setForeground(new Color(255, 255, 255));
                        button3.setForeground(new Color(255, 255, 255));
                        button4.setForeground(new Color(255, 255, 255));
                        button5.setForeground(new Color(255, 255, 255));
                        button6.setForeground(new Color(255, 255, 255));
                        button7.setForeground(new Color(255, 255, 255));
                        button8.setForeground(new Color(255, 255, 255));
                        button9.setForeground(new Color(255, 255, 255));
                        button0.setForeground(new Color(255, 255, 255));
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + s);
                }
                pref.put("comboBoxValue", s);
            }
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

        buttonPoint.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String text = textField.getText();
                text += ".";
                textField.setText(text);
            }
        });

        buttonPlus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String text = textField.getText();
                text += "+";
                textField.setText(text);
                buttonPlus.setEnabled(false);
                buttonMinus.setEnabled(false);
                buttonTimes.setEnabled(false);
                buttonDiv.setEnabled(false);
            }
        });

        buttonMinus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String text = textField.getText();
                text += "-";
                textField.setText(text);
                buttonPlus.setEnabled(false);
                buttonMinus.setEnabled(false);
                buttonTimes.setEnabled(false);
                buttonDiv.setEnabled(false);
            }
        });

        buttonTimes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String text = textField.getText();
                text += "x";
                textField.setText(text);
                buttonPlus.setEnabled(false);
                buttonMinus.setEnabled(false);
                buttonTimes.setEnabled(false);
                buttonDiv.setEnabled(false);
            }
        });

        buttonDiv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String text = textField.getText();
                text += "/";
                textField.setText(text);
                buttonPlus.setEnabled(false);
                buttonMinus.setEnabled(false);
                buttonTimes.setEnabled(false);
                buttonDiv.setEnabled(false);
            }
        });

        buttonC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                textField.setText("");
                buttonPlus.setEnabled(true);
                buttonMinus.setEnabled(true);
                buttonTimes.setEnabled(true);
                buttonDiv.setEnabled(true);
            }
        });

        buttonEnter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    String expression = textField.getText();
                    double num1 = 0;
                    double num2 = 0;
                    char op = ' ';
                    String r;
                    for (int i = 0; i < expression.length(); i++) {
                        if (expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == 'x' ||
                                expression.charAt(i) == '/') {
                            op = expression.charAt(i);
                            num1 = Double.parseDouble(expression.substring(0,i));
                            num2 = Double.parseDouble(expression.substring(i+1));
                        }
                    }
                    switch (op) {
                        case '+':
                            r = Double.toString(num1 + num2);
                            break;
                        case '-':
                            r = Double.toString(num1 - num2);
                            break;
                        case 'x':
                            r = Double.toString(num1 * num2);
                            break;
                        case '/':
                            if (num2 == 0) r = "MATH ERROR";
                            else r = Double.toString((double) num1 / num2);
                            break;
                        default:
                            r = "ERROR";
                    }
                    result.setText(r);
                } catch (Exception e) {
                    errorPane = new JFrame();
                    JOptionPane.showMessageDialog(errorPane, "You can only do binary operations (for now)",
                            "ERROR", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

    }
}
