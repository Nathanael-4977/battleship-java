package modele;
import java.awt.Color;

public class ContreTorpilleur extends Bateau {
    public ContreTorpilleur(int x, int y, boolean horizontal) {
        super(3, x, y, horizontal);
        this.maCouleur = Color.BLUE;
    }
}