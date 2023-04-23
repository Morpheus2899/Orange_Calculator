import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    public GUI() {
        super();
        setSize(900, 600);
        setTitle("ORANGE CALCULATOR v0.1");
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(panel1);
        panel1.setBackground(new Color(255,165,0));
    }
    public JPanel panel1;
    public JLabel result;
    private JComboBox comboBox1;
}
