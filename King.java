import javax.swing.*;

public class King extends Piece{

    public King(int xp, int yp, boolean isWhite) {
        super(xp, yp, isWhite);
    }
    @Override
    public void move(int futureY, int futureX) {
        if (isWhite) {
            Board.square[futureY][futureX].setIcon(new ImageIcon(getClass().getResource("Pieces pictures/king white.png")));
        }else{
            Board.square[futureY][futureX].setIcon(new ImageIcon(getClass().getResource("Pieces pictures/king black.png")));
        }
    }

    @Override
    public boolean correctMove(int fX, int fY) {
        if(Math.abs(fY - Board.location[0])>1 || Math.abs(fX - Board.location[1])>1){
            return false;
        }

        if(Board.pieceList[fY][fX]!=null && (Board.pieceList[fY][fX].isWhite==this.isWhite)){
            return false;
        }
        return true;
    }

}
