package modele;
import java.awt.Color;

public class Cuirasse extends Bateau {
    public Cuirasse(int x, int y, boolean horizontal) {
        super(4, x, y, horizontal);
        this.maCouleur = Color.PINK;
    }
}