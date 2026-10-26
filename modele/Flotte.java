package modele;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.awt.Graphics;

public class Flotte {

    private Bateau[] bateaux;
    private int nbBateaux;
    private List<Position> listeTirs;

    public Flotte() {
        this.bateaux = new Bateau[5];        
        this.nbBateaux = 0;                       
        this.listeTirs = new ArrayList<Position>();
        this.initialiser(); 
    }

    public void ajouterBateau(Bateau b) {
        if (this.nbBateaux < 5) {
            this.bateaux[this.nbBateaux] = b;
            this.nbBateaux++;
        }
    }

    public Bateau getBateau(int i) {
        return this.bateaux[i];
    }


    public int GetnbBateaux() {
        return this.nbBateaux;
    }

    public void initialiser() {
        this.ajouterBateau(new LanceTorpille(2, 2, true));
        this.ajouterBateau(new ContreTorpilleur(5, 2, true));
        this.ajouterBateau(new SousMarin(2, 4, true));
        this.ajouterBateau(new Cuirasse(6, 4, true));
        this.ajouterBateau(new PorteAvions(2, 6, true));
    }


    public int salve(int x, int y) {
        this.listeTirs.add(new Position(x, y));
        int resultat = 0;
        for (int i = 0; i < this.nbBateaux; i++) {
            Bateau b = this.bateaux[i];
            for (int j = 0; j < b.getTaille(); j++) {
                Position p = b.getPosition(j);
                if (p.getX() == x && p.getY() == y) {
                    p.touche(); 
                    resultat = 1; 
                    if (b.estCoule()) {
                        resultat = 2;
                    }
                }
            }
        }
        return resultat;
    }

    public void dessinerFlotte(Graphics g) {
        for (int i = 0; i < this.nbBateaux; i++) {
            if (!this.bateaux[i].estCoule()) {
                this.bateaux[i].dessiner(g);
            }
        }
    }

    public boolean dejaTire(int x, int y) {
        for (Position p : this.listeTirs) {
            if (p.getX() == x && p.getY() == y) {
                return true;
            }
        }
        return false;
    }


    public void dessinerTirs(Graphics g) {
        for (Position tir : this.listeTirs) {
            g.setColor(Color.BLACK);
            for (int i = 0; i < this.nbBateaux; i++) {
                Bateau b = this.bateaux[i];
                for (int j = 0; j < b.getTaille(); j++) {
                    Position p = b.getPosition(j);
                    if (p.getX() == tir.getX() && p.getY() == tir.getY()) {
                        g.setColor(Color.RED);
                    }
                }
            }
            g.drawLine(tir.getX() * 20, tir.getY() * 20, (tir.getX() + 1) * 20, (tir.getY() + 1) * 20);
            g.drawLine((tir.getX() + 1) * 20, tir.getY() * 20, tir.getX() * 20, (tir.getY() + 1) * 20);
        }
    }
}