import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

// EVENT LISTENER (implements interface)
public class DaftarListener implements ActionListener {

    private MainFrame frame;
    private FormPanel form;
    private HasilPanel hasil;
    private FooterPanel footer;

    private Set<Integer> nomorTerpakai = new HashSet<>();
    private int jumlahPemain = 0;

    public DaftarListener(MainFrame frame, FormPanel form, HasilPanel hasil, FooterPanel footer) {
        this.frame = frame;
        this.form = form;
        this.hasil = hasil;
        this.footer = footer;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (form.getNama().isEmpty()) {
            JOptionPane.showMessageDialog(frame,
                    "Nama pemain wajib diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int nomor = form.getNomor();
        if (nomor < 1 || nomor > 99) {
            JOptionPane.showMessageDialog(frame,
                    "Nomor punggung harus 1 - 99!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (nomorTerpakai.contains(nomor)) {
            JOptionPane.showMessageDialog(frame,
                    "Nomor punggung " + nomor + " sudah dipakai pemain lain!",
                    "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        nomorTerpakai.add(nomor);
        jumlahPemain++;

        hasil.tambahHasil(
                "Pemain ke-" + jumlahPemain + "\n" +
                "Nama      : " + form.getNama() + "\n" +
                "Nomor     : " + nomor + "\n" +
                "Posisi    : " + form.getPosisi() + "\n" +
                "Kaki      : " + form.getKaki() + "\n" +
                "Keahlian  : " + form.getKeahlian() + "\n" +
                "Catatan   : " + (form.getCatatan().isEmpty() ? "-" : form.getCatatan()) + "\n" +
                "------------------------------\n");

        footer.setStatus(jumlahPemain + " pemain terdaftar");
        form.reset();
    }
}
