package modele;
import java.awt.Color;
import java.awt.Graphics;

public class Bateau implements Dessinable {

    private Position[] positions; 
    protected Color maCouleur; 

    public Bateau(int taille, int x, int y, boolean horizontal) {
        this.positions = new Position[taille]; 
        this.maCouleur = Color.BLACK;
        int dx = x;
        int dy = y;
        for (int i = 0; i < taille; i++) {
            this.positions[i] = new Position(dx, dy); 
            if (horizontal) {
                dx++;
            } else {
                dy++;
            }
        }
    }

    public int getTaille() {
        return this.positions.length;
    }

    public Position getPosition(int i) {
        return this.positions[i];
    }

    public void avancer(int dx, int dy) {
        for (int i = 0; i < this.positions.length; i++) {
            int ancienX = this.positions[i].getX();
            int ancienY = this.positions[i].getY();
            this.positions[i].setX(ancienX + dx);
            this.positions[i].setY(ancienY + dy);
        }
    }

    public int nbCasesTouchees() {
        int compteur = 0;
        for (int i = 0; i < this.positions.length; i++) {
            if (this.positions[i].estTouche()) {
                compteur++;
            }
        }
        return compteur;
    }

    public boolean estCoule() {
        return nbCasesTouchees() == this.positions.length;
    }

    public void dessiner(Graphics g) {
        g.setColor(this.maCouleur);
        for (int i = 0; i < this.positions.length; i++) {
            Position p = this.positions[i];
            g.fillRect(p.getX() * 20, p.getY() * 20, 20, 20);
            if (p.estTouche()) {
                g.setColor(Color.BLACK);
                g.drawLine(p.getX() * 20, p.getY() * 20, (p.getX() + 1) * 20, (p.getY() + 1) * 20);
                g.drawLine((p.getX() + 1) * 20, p.getY() * 20, p.getX() * 20, (p.getY() + 1) * 20);
                g.setColor(this.maCouleur);
            }
        }
    }
}