import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {
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
        ActionListener cb = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
            }
        };
        comboBox1.addActionListener(cb);
    }
    public JPanel panel1;
    public JLabel result;
    public JComboBox comboBox1;
    public JPanel panel2;

}
