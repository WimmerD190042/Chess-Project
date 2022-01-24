import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.util.LinkedList;
import java.util.concurrent.Executors;

import javax.imageio.ImageIO;
import javax.swing.*;

public class ChessBoardWithColumnsAndRows extends JFrame {


    public static final String uniCodeWhitePawn="\u2654";

    // The overall box count in chess board
    public static final int squareCount = 64;

    public ChessBoardWithColumnsAndRows(String title) {

        LinkedList<Piece> pieceList = new LinkedList<>();

        //die Pieces adden:

        pieceList.add(new Piece(2,2,false,"pawn",pieceList));







        // Color of chess board this you can change accordingly like red or white
        Color blackColor = Color.BLACK;
        Color whiteColor = Color.WHITE;

        JButton chessButton = null;


        for (int i = 1; i <= squareCount; i++) {

            if (i % 2 == 0) { // schwarz oder weiß

                chessButton = new JButton();
                chessButton.setBackground(blackColor);
                add(chessButton);
            } else {

                chessButton = new JButton("\u2659");
                chessButton.setBackground(whiteColor);
                //


                //
                add(chessButton);
            }

            if (i % 8 == 0) { // nach einer vollständigen Reihe wird die Farbe auch geweschselt.

                Color temp = blackColor;
                blackColor = whiteColor;
                whiteColor = temp;
            }

        }

        this.setTitle(title); // Setting the title of board
        this.setLayout(new GridLayout(8, 18)); // GridLayout will arrange elements in Grid Manager 8 X 8
        this.setSize(650, 650); // Size of the chess board
        this.setVisible(true);


        for(int zeile=0;zeile<8;zeile++) {

           if(zeile==1){
               for(int spalte=0;spalte<8;spalte++) {
                   JButton button = new JButton("\u2659");
               }
           }
        }




    }

    public static void main(String[] args) {

        String title = "Schachbrett";

        ChessBoardWithColumnsAndRows chessBoard = new ChessBoardWithColumnsAndRows(title); // Creating the instance of chess board

        String unicodeMessage =
                "\u2654 " + // white king
                        "\u2655 " + // white queen
                        "\u2656 " + // white rook
                        "\u2657 " + // white bishop
                        "\u2658 " + // white knight
                        "\u2659 " + // white pawn
                        "\n" +
                        "\u265A " + // black king
                        "\u265B " + // black queen
                        "\u265C " + // black rook
                        "\u265D " + // black bishop
                        "\u265E " + // black knight
                        "\u265F " + // black pawn
                        "\n" ;
        try (PrintStream out = new PrintStream(System.out, true, "UTF8")) {
            out.println(unicodeMessage);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


    }





}