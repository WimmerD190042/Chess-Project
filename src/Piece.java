import java.util.LinkedList;

public class Piece {
    int xp;
    int yp;
    boolean isWhite;
    LinkedList<Piece> pieceList;
    String name;

    public Piece(int xp, int yp, boolean isWhite,String name, LinkedList<Piece> pieceList) {
        this.xp = xp;
        this.yp = yp;
        this.isWhite = isWhite;
        this.pieceList=pieceList;
        this.name=name;
    }

    public void move(int xp, int yp){
        for(Piece p: pieceList){       //wenn ein Piece auf die selbe Stelle als ein anderes kommt     (dann soll dieses gekillt und das andere bewegt werden.)
            if(p.xp == xp && p.yp == yp){   //wenn die Koordinaten des  Pieces aus der List gleich sind als die mitgegebenen Koordinaten, wird das vorherige Piece gekillt
                p.kill();
            }
        }
        this.xp=xp;         //hier werden die Koordinaten nun aktualisiert
        this.yp= yp;
    }

    private void kill() {
        pieceList.remove(this);
    }
}
