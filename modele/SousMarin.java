package modele;
import java.awt.Color;

public class SousMarin extends Bateau {
    public SousMarin(int x, int y, boolean horizontal) {
        super(3, x, y, horizontal);
        this.maCouleur = Color.YELLOW;
    }
}