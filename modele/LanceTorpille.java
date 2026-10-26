package modele;
import java.awt.Color;

public class LanceTorpille extends Bateau {
    public LanceTorpille(int x, int y, boolean horizontal) {
        super(2, x, y, horizontal);
        this.maCouleur = Color.GREEN;
    }
}