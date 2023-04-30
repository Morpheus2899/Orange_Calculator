import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
    JFrame errorPane;

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
        textField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && (c != '+') &&
                        (c != '-') && (c != 'x') && (c != '/')) {
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
                        break;
                    case "Light theme":
                        panel1.setBackground(new Color(220,220,220));
                        labelResult.setForeground(Color.BLACK);
                        break;
                    case "Dark theme":
                        panel1.setBackground(Color.DARK_GRAY);
                        labelResult.setForeground(Color.WHITE);
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + s);
                }
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
                    int num1 = 0;
                    int num2 = 0;
                    char op = ' ';
                    String r;
                    for (int i = 0; i < expression.length(); i++) {
                        if (expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == 'x' ||
                                expression.charAt(i) == '/') {
                            op = expression.charAt(i);
                            num1 = Integer.parseInt(expression.substring(0,i));
                            num2 = Integer.parseInt(expression.substring(i+1));
                        }
                    }
                    switch (op) {
                        case '+':
                            r = Integer.toString(num1 + num2);
                            break;
                        case '-':
                            r = Integer.toString(num1 - num2);
                            break;
                        case 'x':
                            r = Integer.toString(num1 * num2);
                            break;
                        case '/':
                            r = Double.toString((double) num1 / num2);
                            break;
                        default:
                            r = "ERROR";
                    }
                    result.setText(r);
                } catch (Exception e) {
                    errorPane = new JFrame();
                    JOptionPane.showMessageDialog(errorPane, "You can only do binary operations", "ERROR", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

    }
}
