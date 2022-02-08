import java.util.LinkedList;

public class Piece {
    public int xp;     //xKoordinate
    public int yp;     //yKoordinate
    public boolean isWhite;
    public pieceType type;
    LinkedList<Piece> pieceList;
    String name;

    public Piece(int xp, int yp, boolean isWhite) {
        this.xp = xp;
        this.yp = yp;
        this.isWhite = isWhite;

    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getYp() {
        return yp;
    }

    public void setYp(int yp) {
        this.yp = yp;
    }

    public void move(int futureX, int futureY){

    }

    public boolean correctMove(int fX, int fY){
        return true;
    }
}
