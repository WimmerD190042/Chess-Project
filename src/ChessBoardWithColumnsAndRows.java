import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ChessBoardWithColumnsAndRows extends JFrame {

    // The overall box count in chess board
    public static final int squareCount = 64;

    public ChessBoardWithColumnsAndRows(String title) {

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

                chessButton = new JButton();
                chessButton.setBackground(whiteColor);
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

    }

    public static void main(String[] args) {

        String title = "Schachbrett";

        ChessBoardWithColumnsAndRows chessBoard = new ChessBoardWithColumnsAndRows(title); // Creating the instance of chess board
    }
}