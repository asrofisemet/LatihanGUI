import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

// EVENT ADAPTER CLASS (extends KeyAdapter, override method)
public class NomorKeyListener extends KeyAdapter {

    private FooterPanel footer;

    public NomorKeyListener(FooterPanel footer) {
        this.footer = footer;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        char c = e.getKeyChar();
        if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE) {
            e.consume();
            footer.setStatus("nomor punggung hanya boleh angka");
        }
    }
}
