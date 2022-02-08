import javax.swing.*;

public class Bishop extends Piece{
    public Bishop(int xp, int yp, boolean isWhite) {
        super(xp, yp, isWhite);
    }

    @Override
    public void move(int futureY, int futureX) {
        if (isWhite) {
            Board.square[futureY][futureX].setIcon(new ImageIcon(getClass().getResource("Pieces pictures/bishop white.png")));
        }else{
            Board.square[futureY][futureX].setIcon(new ImageIcon(getClass().getResource("Pieces pictures/bishop black.png")));
        }
    }

    @Override
    public boolean correctMove(int fx, int fy) {

        if(Board.location[1] == fx || Board.location[0] == fy){
            return false;
        }

        if(Math.abs(fx - Board.location[1]) != Math.abs(fy - Board.location[0])){
            return false;
        }
        if(Board.pieceList[fy][fx]!=null && (Board.pieceList[fy][fx].isWhite==this.isWhite)){
            return false;
        }
        /*
        int rowOffset, colOffset;

        if(board.location[1] < fx){
            rowOffset = 1;
        }else{
            rowOffset = -1;
        }

        if(board.location[0] < fy){
            colOffset = 1;
        }else{
            colOffset = -1;
        }*/

       /* int y = board.location[0] + colOffset;
        for(int x = board.location[1] + rowOffset; x != fx; x += rowOffset){
            /*if(board[x][y] != null){
                return false;
            }

            y += colOffset;
        }
        */return true;
    }
}
