import javax.swing.*;
import java.awt.*;

// TOP-LEVEL CONTAINER CLASS
public class MainFrame extends JFrame {

    private HeaderPanel header;
    private FormPanel form;
    private HasilPanel hasil;
    private FooterPanel footer;

    public MainFrame() {
        setTitle("Latihan GUI - Pendaftaran Pemain Sepak Bola");
        setSize(650, 560);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLayout(new BorderLayout(10, 10)); // Layout: BorderLayout

        header = new HeaderPanel();
        form = new FormPanel();
        hasil = new HasilPanel();
        footer = new FooterPanel();

        JTabbedPane tabs = new JTabbedPane(); // Intermediate Container
        tabs.addTab("Form Pemain", form);
        tabs.addTab("Daftar Pemain", hasil);

        add(header, BorderLayout.NORTH);
        add(tabs, BorderLayout.CENTER);
        add(footer, BorderLayout.SOUTH);

        pasangEvent();
    }

    private void pasangEvent() {
        footer.getBtnDaftar().addActionListener(new DaftarListener(this, form, hasil, footer));
        footer.getBtnReset().addActionListener(new ResetListener(form, footer));
        footer.getBtnKeluar().addActionListener(new KeluarListener(this));
        form.getTxtNomor().addKeyListener(new NomorKeyListener(footer));
        addWindowListener(new FrameCloseListener(this));
    }

    public void konfirmasiKeluar() {
        int pilih = JOptionPane.showConfirmDialog(this,
                "Yakin ingin keluar?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (pilih == JOptionPane.YES_OPTION) {
            dispose();
            System.exit(0);
        }
    }
}
