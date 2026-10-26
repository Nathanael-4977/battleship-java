package modele;
import java.awt.Color;

public class PorteAvions extends Bateau {
    public PorteAvions(int x, int y, boolean horizontal) {
        super(5, x, y, horizontal);
        this.maCouleur = Color.MAGENTA;
    }
}