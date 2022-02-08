import javax.swing.*;

public class Rook extends Piece{

    public Rook(int xp, int yp, boolean isWhite) {
        super(xp, yp, isWhite);
    }
    @Override
    public void move(int futureY, int futureX) {
        if (isWhite) {
            Board.square[futureY][futureX].setIcon(new ImageIcon(getClass().getResource("Pieces pictures/rookwhite.png")));
        }else{
            Board.square[futureY][futureX].setIcon(new ImageIcon(getClass().getResource("Pieces pictures/rook black.png")));
        }
    }

    @Override
    public boolean correctMove(int fX, int fY){



        if (fX- Board.location[1]!=0||fY- Board.location[0]!=0){
            if (fX == Board.location[1]||fY == Board.location[0]){
                if(Board.pieceList[fY][fX]!=null && (Board.pieceList[fY][fX].isWhite==this.isWhite)){
                    return false;
                }
                return true;
            }
        }else{
            return false;
        }
        return false;




    }

}
