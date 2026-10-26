package controleur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import vue.PanneauGrille;

public class GestionSouris implements MouseListener, MouseMotionListener {

    private PanneauGrille monPanneau;
    private int tirsRestants;

    public GestionSouris(PanneauGrille panneau) {
        this.monPanneau = panneau;
        this.tirsRestants = 3;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (this.tirsRestants > 0) {
            int x = e.getX() / 20;
            int y = e.getY() / 20;
            if (x >= 0 && x < 10 && y >= 0 && y < 10 && !this.monPanneau.getFlotte().dejaTire(x, y)) {
                this.tirsRestants--;
                int resultat = this.monPanneau.getFlotte().salve(x, y);
                String message = "";
                if (resultat == 0) message = "A l'eau !";
                else if (resultat == 1) message = "Touché !";
                else if (resultat == 2) message = "Touché Coulé !";
                this.monPanneau.getFenetre().afficherMessage(message + " (Reste " + this.tirsRestants + ")");
                this.monPanneau.repaint();
                if (this.monPanneau.getFenetre().finPartie()) {
                    System.exit(0);
                }
            }
        }
        if (this.tirsRestants == 0) {
            this.monPanneau.getFenetre().getGrilleJoueur().jouerAutomatiquement(3);
            this.tirsRestants = 3;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
    @Override
    public void mouseDragged(MouseEvent e) {}
    @Override
    public void mouseMoved(MouseEvent e) {}
}