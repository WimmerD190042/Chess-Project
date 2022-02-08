import javax.swing.*;

public class Knight extends Piece {

    public Knight(int xp, int yp, boolean isWhite) {
        super(xp, yp, isWhite);
    }

    @Override
    public void move(int futureY, int futureX) {
        if (isWhite) {
            Board.square[futureY][futureX].setIcon(new ImageIcon(getClass().getResource("Pieces pictures/knight white.png")));
        }else{
            Board.square[futureY][futureX].setIcon(new ImageIcon(getClass().getResource("Pieces pictures/knight black.png")));
        }
    }

    @Override
    public boolean correctMove(int fX, int fY) {
        if(Board.pieceList[fY][fX]!=null && (Board.pieceList[fY][fX].isWhite==this.isWhite)){
            return false;
        }

        if(Math.abs(fX - Board.location[1]) == 2 && Math.abs(fY - Board.location[0]) == 1){
            return true;
        }



        if(Math.abs(fX - Board.location[1]) == 1 && Math.abs(fY - Board.location[0]) == 2){
            return true;
        }
        return false;
    }
}
