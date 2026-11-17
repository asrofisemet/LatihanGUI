import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// EVENT LISTENER (implements interface)
public class ResetListener implements ActionListener {

    private FormPanel form;
    private FooterPanel footer;

    public ResetListener(FormPanel form, FooterPanel footer) {
        this.form = form;
        this.footer = footer;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        form.reset();
        footer.setStatus("form direset");
    }
}
