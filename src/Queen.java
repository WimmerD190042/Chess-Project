import javax.swing.*;

public class Queen extends Piece{
    public Queen(int xp, int yp, boolean isWhite) {
        super(xp, yp, isWhite);
    }

    @Override
    public void move(int futureY, int futureX) {
        if (isWhite) {
            Board.square[futureY][futureX].setIcon(new ImageIcon(getClass().getResource("Pieces pictures/queen white.png")));
        }else{
            Board.square[futureY][futureX].setIcon(new ImageIcon(getClass().getResource("Pieces pictures/queen black.png")));
        }
    }

    @Override
    public boolean correctMove(int fX, int fY) {
        return (new Rook(fX,fY,this.isWhite).correctMove(fX,fY)) || new Bishop(fX,fY,this.isWhite).correctMove(fX,fY);
    }
}
