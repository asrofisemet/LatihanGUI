import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// EVENT ADAPTER CLASS (extends WindowAdapter, override method)
public class FrameCloseListener extends WindowAdapter {

    private MainFrame frame;

    public FrameCloseListener(MainFrame frame) {
        this.frame = frame;
    }

    @Override
    public void windowClosing(WindowEvent e) {
        frame.konfirmasiKeluar();
    }
}
