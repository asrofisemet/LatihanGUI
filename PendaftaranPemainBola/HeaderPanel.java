import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

// INTERMEDIATE CONTAINER CLASS
public class HeaderPanel extends JPanel {

    public HeaderPanel() {
        setLayout(new FlowLayout(FlowLayout.CENTER)); // Layout: FlowLayout
        setBackground(new Color(20, 120, 50));
        setBorder(new EmptyBorder(8, 8, 8, 8));

        JLabel judul = new JLabel("PENDAFTARAN PEMAIN SEPAK BOLA"); // Atomic Component
        judul.setForeground(Color.WHITE);
        judul.setFont(new Font("SansSerif", Font.BOLD, 18));
        add(judul);
    }
}
