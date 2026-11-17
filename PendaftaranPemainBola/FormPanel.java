import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

// INTERMEDIATE CONTAINER CLASS (berisi Atomic Components)
public class FormPanel extends JPanel {

    private static final String[] POSISI = {
            "Kiper", "Bek", "Gelandang", "Penyerang"};
    private static final String[] KEAHLIAN = {
            "Dribbling", "Passing", "Shooting", "Heading"};

    private JTextField txtNama, txtNomor;
    private JComboBox<String> cmbPosisi;
    private JRadioButton rbKanan, rbKiri;
    private JCheckBox[] chkKeahlian;
    private JTextArea txtCatatan;

    public FormPanel() {
        setLayout(new GridBagLayout()); // Layout: GridBagLayout
        setBorder(new EmptyBorder(10, 15, 10, 15));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 6, 6, 6);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Nama pemain
        gbc.gridx = 0; gbc.gridy = 0; gbc.weightx = 0;
        add(new JLabel("Nama Pemain:"), gbc);
        txtNama = new JTextField(20);
        gbc.gridx = 1; gbc.weightx = 1;
        add(txtNama, gbc);

        // Nomor punggung
        gbc.gridx = 0; gbc.gridy = 1; gbc.weightx = 0;
        add(new JLabel("Nomor Punggung:"), gbc);
        txtNomor = new JTextField(20);
        gbc.gridx = 1; gbc.weightx = 1;
        add(txtNomor, gbc);

        // Posisi
        gbc.gridx = 0; gbc.gridy = 2; gbc.weightx = 0;
        add(new JLabel("Posisi:"), gbc);
        cmbPosisi = new JComboBox<>(POSISI);
        gbc.gridx = 1; gbc.weightx = 1;
        add(cmbPosisi, gbc);

        // Kaki dominan
        gbc.gridx = 0; gbc.gridy = 3; gbc.weightx = 0;
        add(new JLabel("Kaki Dominan:"), gbc);
        JPanel panelKaki = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0)); // Layout: FlowLayout
        rbKanan = new JRadioButton("Kanan", true);
        rbKiri = new JRadioButton("Kiri");
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbKanan);
        bg.add(rbKiri);
        panelKaki.add(rbKanan);
        panelKaki.add(rbKiri);
        gbc.gridx = 1; gbc.weightx = 1;
        add(panelKaki, gbc);

        // Keahlian
        gbc.gridx = 0; gbc.gridy = 4; gbc.weightx = 0;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        add(new JLabel("Keahlian:"), gbc);
        JPanel panelKeahlian = new JPanel(new GridLayout(2, 2)); // Layout: GridLayout
        chkKeahlian = new JCheckBox[KEAHLIAN.length];
        for (int i = 0; i < KEAHLIAN.length; i++) {
            chkKeahlian[i] = new JCheckBox(KEAHLIAN[i]);
            panelKeahlian.add(chkKeahlian[i]);
        }
        panelKeahlian.setBorder(new TitledBorder("Pilih keahlian"));
        gbc.gridx = 1; gbc.weightx = 1;
        add(panelKeahlian, gbc);

        // Catatan
        gbc.gridx = 0; gbc.gridy = 5; gbc.weightx = 0;
        add(new JLabel("Catatan:"), gbc);
        txtCatatan = new JTextArea(3, 20);
        txtCatatan.setLineWrap(true);
        txtCatatan.setWrapStyleWord(true);
        gbc.gridx = 1; gbc.weightx = 1;
        add(new JScrollPane(txtCatatan), gbc); // Intermediate: JScrollPane
    }

    // ===== Getter =====
    public JTextField getTxtNomor() { return txtNomor; }
    public String getNama() { return txtNama.getText().trim(); }
    public String getCatatan() { return txtCatatan.getText().trim(); }
    public String getPosisi() { return cmbPosisi.getSelectedItem().toString(); }
    public String getKaki() { return rbKanan.isSelected() ? "Kanan" : "Kiri"; }

    public int getNomor() {
        try {
            return Integer.parseInt(txtNomor.getText().trim());
        } catch (NumberFormatException ex) {
            return 0;
        }
    }

    public String getKeahlian() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chkKeahlian.length; i++) {
            if (chkKeahlian[i].isSelected()) sb.append(KEAHLIAN[i]).append(", ");
        }
        return sb.length() > 0 ? sb.substring(0, sb.length() - 2) : "-";
    }

    public void reset() {
        txtNama.setText("");
        txtNomor.setText("");
        txtCatatan.setText("");
        cmbPosisi.setSelectedIndex(0);
        rbKanan.setSelected(true);
        for (JCheckBox c : chkKeahlian) c.setSelected(false);
    }
}
