import javax.swing.*;

public class Pawn extends Piece {
    public boolean hasMoved;

    public Pawn(int xp, int yp, boolean isWhite) {
        super(xp, yp, isWhite);
    }

    @Override
    public void move(int futureY, int futureX) {
        if (isWhite) {
            Board.square[futureY][futureX].setIcon(new ImageIcon(getClass().getResource("Pieces pictures/pawn white.png")));
        } else {
            Board.square[futureY][futureX].setIcon(new ImageIcon(getClass().getResource("Pieces pictures/pawn black.png")));
        }
    }

    @Override
    public boolean correctMove(int fX, int fY) {
        if (Board.pieceList[fY][fX] != null && (Board.pieceList[fY][fX].isWhite == this.isWhite)) {
            return false;           //falls an der zukünftigen Stelle bereits ein Piece derselben Farbe ist
        }

        if(fX== Board.location[1]){
            if (Math.abs(fY - Board.location[0]) > 1) {
                if (!hasMoved && Math.abs(fY - Board.location[0]) == 2) {
                    hasMoved = true;
                    return true;
                } else{
                    return false;
                }
            }
        }else{
            return false;
        }
        hasMoved = true;
        return true;
    }
}