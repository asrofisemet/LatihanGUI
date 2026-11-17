import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// EVENT LISTENER (implements interface)
public class KeluarListener implements ActionListener {

    private MainFrame frame;

    public KeluarListener(MainFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.konfirmasiKeluar();
    }
}
