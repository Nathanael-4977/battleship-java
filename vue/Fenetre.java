package vue;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Fenetre extends JFrame {

    private PanneauGrille grilleJoueur;
    private PanneauGrille grilleOrdinateur;
    private PanneauInformation information;

    public Fenetre(String nom) {
        super(nom);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.information = new PanneauInformation(this);
        this.grilleJoueur = new PanneauGrille(this, false);
        this.grilleOrdinateur = new PanneauGrille(this, true);

        JPanel panneauCentral = new JPanel();
        panneauCentral.setLayout(new GridLayout(1, 2));

        JPanel conteneurJoueur = new JPanel(new BorderLayout());
        conteneurJoueur.add(this.grilleJoueur, BorderLayout.CENTER);
        conteneurJoueur.add(new JLabel("Ma Grille", SwingConstants.CENTER), BorderLayout.SOUTH);

        JPanel conteneurOrdi = new JPanel(new BorderLayout());
        conteneurOrdi.add(this.grilleOrdinateur, BorderLayout.CENTER);
        conteneurOrdi.add(new JLabel("Ordinateur", SwingConstants.CENTER), BorderLayout.SOUTH);
        panneauCentral.add(conteneurJoueur);
        panneauCentral.add(conteneurOrdi);

        this.setLayout(new BorderLayout());
        this.add(this.information, BorderLayout.NORTH);
        this.add(panneauCentral, BorderLayout.CENTER);
        this.pack();
        this.setVisible(true);
    }

    public PanneauGrille getGrilleJoueur() {
        return this.grilleJoueur;
    }

    public PanneauGrille getGrilleOrdinateur() {
        return this.grilleOrdinateur;
    }

    public PanneauInformation getInformation() {
        return this.information;
    }

    public void afficherMessage(String s) {
        this.information.afficherMessage(s);
    }

    public boolean finPartie() {
        return false;
    }
}