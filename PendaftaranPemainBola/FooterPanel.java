import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

// INTERMEDIATE CONTAINER CLASS
public class FooterPanel extends JPanel {

    private JButton btnDaftar, btnReset, btnKeluar;
    private JLabel lblStatus;

    public FooterPanel() {
        setLayout(new BorderLayout()); // Layout: BorderLayout
        setBorder(new EmptyBorder(5, 10, 8, 10));

        JPanel panelTombol = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0)); // Layout: FlowLayout
        btnDaftar = new JButton("Daftarkan");
        btnReset = new JButton("Reset Form");
        btnKeluar = new JButton("Keluar");
        panelTombol.add(btnDaftar);
        panelTombol.add(btnReset);
        panelTombol.add(btnKeluar);

        lblStatus = new JLabel("Status: siap");

        add(panelTombol, BorderLayout.CENTER);
        add(lblStatus, BorderLayout.SOUTH);
    }

    public JButton getBtnDaftar() { return btnDaftar; }
    public JButton getBtnReset() { return btnReset; }
    public JButton getBtnKeluar() { return btnKeluar; }
    public void setStatus(String teks) { lblStatus.setText("Status: " + teks); }
}
