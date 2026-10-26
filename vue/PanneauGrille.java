package vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JPanel;
import modele.Flotte;
import controleur.GestionSouris;

public class PanneauGrille extends JPanel {

    private Fenetre maFenetre;
    private Flotte maFlotte;
    private Random generateur;
    private boolean grilleOrdinateur;

    public PanneauGrille(Fenetre maFenetre, boolean grilleOrdinateur) {
        this.maFenetre = maFenetre;
        this.grilleOrdinateur = grilleOrdinateur;
        this.setPreferredSize(new Dimension(200, 200));
        this.maFlotte = new Flotte();
        this.generateur = new Random();
        if (this.grilleOrdinateur) {
            GestionSouris controleur = new GestionSouris(this);
            this.addMouseListener(controleur);
        }
    }

    public Flotte getFlotte() {
        return this.maFlotte;
    }

    public Fenetre getFenetre() {   
        return this.maFenetre;
    }

    public void jouerAutomatiquement(int nbTirs) {
        for (int i = 0; i < nbTirs; i++) {
            int x, y;
            do {
                x = this.generateur.nextInt(10);
                y = this.generateur.nextInt(10);
            } while (this.maFlotte.dejaTire(x, y));

            this.maFlotte.salve(x, y);
            
            if (this.maFenetre.finPartie()) {
                System.exit(0);
            }
        }
        this.repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        for (int i = 0; i <= 10; i++) {
            g.drawLine(i * 20, 0, i * 20, 200);
            g.drawLine(0, i * 20, 200, i * 20);
        }
        if (!this.grilleOrdinateur) {
            this.maFlotte.dessinerFlotte(g);
        }
        this.maFlotte.dessinerTirs(g);
    }
}