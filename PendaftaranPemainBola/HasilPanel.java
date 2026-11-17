import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

// INTERMEDIATE CONTAINER CLASS
public class HasilPanel extends JPanel {

    private JTextArea txtHasil;

    public HasilPanel() {
        setLayout(new BorderLayout()); // Layout: BorderLayout
        setBorder(new EmptyBorder(10, 10, 10, 10));

        txtHasil = new JTextArea();
        txtHasil.setEditable(false);
        txtHasil.setFont(new Font("Monospaced", Font.PLAIN, 13));
        add(new JScrollPane(txtHasil), BorderLayout.CENTER);
    }

    public void tambahHasil(String teks) { txtHasil.append(teks); }
}
