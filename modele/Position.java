package modele;

public class Position { 
    private int x, y;
    private boolean touche;

    public Position(int x, int y){
        this.x = x;
        this.y = y;
        this.touche = false;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public boolean estTouche(){
        return this.touche;
    }

    public void touche(){
        this.touche = true;
    }

    public String toString(){
        return "Votre bateau est à la position : (" + this.x + "," + this.y + ")"; 
    }
}