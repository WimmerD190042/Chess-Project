import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;

public class Board {

    private final JFrame frame = new JFrame("ChessBoard");
    public static final JButton[][] square = new JButton[8][8];
    public static Piece[][] pieceList= new Piece[8][8];
    boolean selected=false;
    public static int[] location= new int[2];
    BufferedWriter dataToServer;
    BufferedReader dataFromServer;
    Socket socket;
    Piece currentPiece;

    public void Client(){
        try {
            String ip = "";
            socket = new Socket(ip, 1234);
            dataToServer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            dataFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void UserInterface(){


        frame.setSize(900, 900);
        frame.setLayout(new GridLayout(8, 8));


        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                JButton button = new JButton();
                square[i][j] = button;
                if ((i + j) % 2 == 0) {
                    square[i][j].setBackground(Color.white.darker());
                } else {
                    square[i][j].setBackground(Color.GREEN.darker().darker());
                }
                frame.add(square[i][j]);
               button.setBounds(i*100,j*100,100,100);



                button.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (!selected) {
                            location[1]=button.getX()/100;
                            location[0]=button.getY()/100;
                            selected=true;


                            try {
                                System.out.println(location[0]);
                                System.out.println(location[1]);
                                String x = String.valueOf(location[1]);
                                dataToServer.write(x);
                                dataToServer.newLine();
                                dataToServer.flush();

                                String y = String.valueOf(location[0]);
                                dataToServer.write(y);
                                dataToServer.newLine();
                                dataToServer.flush();

                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }



                        }
                        else{

                            int finx=button.getX()/100;
                            int finy=button.getY()/100;

                            try {
                                System.out.println(finy);
                                System.out.println(finx);
                                String x = String.valueOf(finx);
                                dataToServer.write(x);
                                dataToServer.newLine();
                                dataToServer.flush();

                                String y = String.valueOf(finy);
                                dataToServer.write(y);
                                dataToServer.newLine();
                                dataToServer.flush();

                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }


                            currentPiece= pieceList[location[0]][location[1]];


                            if (currentPiece.correctMove(finy,finx)){
                                currentPiece.move(finy, finx);

                                pieceList[location[1]][location[0]]=null;

                                pieceList[finy][finx]=currentPiece;
                                selected=false;
                                //removePicture(location[1],location[0]);
                                //square[finy][finx].
                            }
                            else
                            {
                                System.out.println("Ungültiger Zug");

                            }

                            background bg = new background();
                            bg.start();

                        }
                    }
                });
            }
        }
        fillPieceList();
        setFigures();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

            public class background extends Thread {

                @Override
                public void run(){


                    while (true){
                        try {


                            int xCoor = Integer.parseInt(dataFromServer.readLine());
                            int yCoor = Integer.parseInt(dataFromServer.readLine());
                            System.out.println("First Standort: [" + yCoor + "|" + xCoor+"]");

                            int fxCoor = Integer.parseInt(dataFromServer.readLine());
                            int fyCoor = Integer.parseInt(dataFromServer.readLine());
                            System.out.println("Future Standort: [" + fyCoor + "|" + fxCoor+"]");
                            square[fyCoor][fxCoor].setIcon(square[yCoor][xCoor].getIcon());
                           square[yCoor][xCoor].setIcon(null);
                           pieceList[yCoor][xCoor].move(fyCoor, fxCoor);

                        }catch (IOException e){
                            e.printStackTrace();
                        }

                    }
                }
            }


    private void removePicture(int x, int y) {
        square[y][x].setIcon(null);
    }


    public void setFigures(){
        square[0][0].setIcon(new ImageIcon(getClass().getResource("Pieces pictures/rook black.png")));
        square[0][1].setIcon(new ImageIcon(getClass().getResource("Pieces pictures/knight black.png")));
        square[0][2].setIcon(new ImageIcon(getClass().getResource("Pieces pictures/bishop black.png")));
        square[0][3].setIcon(new ImageIcon(getClass().getResource("Pieces pictures/queen black.png")));
        square[0][4].setIcon(new ImageIcon(getClass().getResource("Pieces pictures/king black.png")));
        square[0][5].setIcon(new ImageIcon(getClass().getResource("Pieces pictures/bishop black.png")));
        square[0][6].setIcon(new ImageIcon(getClass().getResource("Pieces pictures/knight black.png")));
        square[0][7].setIcon(new ImageIcon(getClass().getResource("Pieces pictures/rook black.png")));
        square[1][0].setIcon(new ImageIcon(getClass().getResource("Pieces pictures/pawn black.png")));
        square[1][1].setIcon(new ImageIcon(getClass().getResource("Pieces pictures/pawn black.png")));
        square[1][2].setIcon(new ImageIcon(getClass().getResource("Pieces pictures/pawn black.png")));
        square[1][3].setIcon(new ImageIcon(getClass().getResource("Pieces pictures/pawn black.png")));
        square[1][4].setIcon(new ImageIcon(getClass().getResource("Pieces pictures/pawn black.png")));
        square[1][5].setIcon(new ImageIcon(getClass().getResource("Pieces pictures/pawn black.png")));
        square[1][6].setIcon(new ImageIcon(getClass().getResource("Pieces pictures/pawn black.png")));
        square[1][7].setIcon(new ImageIcon(getClass().getResource("Pieces pictures/pawn black.png")));
        square[7][0].setIcon(new ImageIcon(getClass().getResource("Pieces pictures/rookwhite.png")));
        square[7][1].setIcon(new ImageIcon(getClass().getResource("Pieces pictures/knight white.png")));
        square[7][2].setIcon(new ImageIcon(getClass().getResource("Pieces pictures/bishop white.png")));
        square[7][3].setIcon(new ImageIcon(getClass().getResource("Pieces pictures/queen white.png")));
        square[7][4].setIcon(new ImageIcon(getClass().getResource("Pieces pictures/king white.png")));
        square[7][5].setIcon(new ImageIcon(getClass().getResource("Pieces pictures/bishop white.png")));
        square[7][6].setIcon(new ImageIcon(getClass().getResource("Pieces pictures/knight white.png")));
        square[7][7].setIcon(new ImageIcon(getClass().getResource("Pieces pictures/rookwhite.png")));
        square[6][0].setIcon(new ImageIcon(getClass().getResource("Pieces pictures/pawn white.png")));
        square[6][1].setIcon(new ImageIcon(getClass().getResource("Pieces pictures/pawn white.png")));
        square[6][2].setIcon(new ImageIcon(getClass().getResource("Pieces pictures/pawn white.png")));
        square[6][3].setIcon(new ImageIcon(getClass().getResource("Pieces pictures/pawn white.png")));
        square[6][4].setIcon(new ImageIcon(getClass().getResource("Pieces pictures/pawn white.png")));
        square[6][5].setIcon(new ImageIcon(getClass().getResource("Pieces pictures/pawn white.png")));
        square[6][6].setIcon(new ImageIcon(getClass().getResource("Pieces pictures/pawn white.png")));
        square[6][7].setIcon(new ImageIcon(getClass().getResource("Pieces pictures/pawn white.png")));

    }




    public void fillPieceList() {
        //black pawns
        pieceList[1][0]= new Pawn(0,1,false);
        pieceList[1][1]= new Pawn(1,1,false);
        pieceList[1][2]= new Pawn(2,1,false);
        pieceList[1][3]= new Pawn(3,1,false);
        pieceList[1][4]= new Pawn(4,1,false);
        pieceList[1][5]= new Pawn(5,1,false);
        pieceList[1][6]= new Pawn(6,1,false);
        pieceList[1][7]= new Pawn(7,1,false);

        //white pawns
        pieceList[6][0]= new Pawn(0,6,true);
        pieceList[6][1]= new Pawn(1,6,true);
        pieceList[6][2]= new Pawn(2,6,true);
        pieceList[6][3]= new Pawn(3,6,true);
        pieceList[6][4]= new Pawn(4,6,true);
        pieceList[6][5]= new Pawn(5,6,true);
        pieceList[6][6]= new Pawn(6,6,true);
        pieceList[6][7]= new Pawn(7,6,true);

        //black pieces
        pieceList[0][0]= new Rook(1,1,false);
        pieceList[0][1]= new Knight(1,0,false);
        pieceList[0][2]= new Bishop(2,0,false);
        pieceList[0][3]= new Queen(3,0,false);
        pieceList[0][4]= new King(4,0,false);
        pieceList[0][5]= new Bishop(5,0,false);
        pieceList[0][6]= new Knight(6,0,false);
        pieceList[0][7]= new Rook(7,0,false);

        //white Pieces
        pieceList[7][0]= new Rook(0,7,true);
        pieceList[7][1]= new Knight(1,7,true);
        pieceList[7][2]= new Bishop(2,7,true);
        pieceList[7][3]= new Queen(3,7,true);
        pieceList[7][4]= new King(4,7,true);
        pieceList[7][5]= new Bishop(5,7,true);
        pieceList[7][6]= new Knight(6,7,true);
        pieceList[7][7]= new Rook(7,7,true);
    }



    public static void main(String[] args){
        Board chessboard1 = new Board();
        chessboard1.Client();
        chessboard1.UserInterface();

    }


}