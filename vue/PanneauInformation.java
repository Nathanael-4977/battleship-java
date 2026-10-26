package vue;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PanneauInformation extends JPanel {

    private Fenetre maFenetre;
    private JLabel message;

    public PanneauInformation(Fenetre maFenetre) {
        this.maFenetre = maFenetre;
        this.setLayout(new GridLayout(2, 1));

        JLabel titre = new JLabel("Bataille Navale", SwingConstants.CENTER);
        this.add(titre);

        this.message = new JLabel("En attente...", SwingConstants.CENTER);
        this.add(this.message);
    }

    public void afficherMessage(String texte) {
        this.message.setText(texte);
    }

    public Fenetre getFenetre() {
        return this.maFenetre;
    }
}