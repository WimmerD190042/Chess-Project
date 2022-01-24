import javax.swing.*;
import java.awt.*;

public class board {

    JFrame frame;
    JPanel squares[][] = new JPanel[8][8];

    public board() {
        frame = new JFrame("ChessBoard");
        frame.setSize(500, 500);
        frame.setLayout(new GridLayout(8, 8));

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                squares[i][j] = new JPanel();

                if ((i + j) % 2 == 0) {
                    squares[i][j].setBackground(Color.gray);
                } else {
                    squares[i][j].setBackground(Color.green);
                }
                frame.add(squares[i][j]);
            }
        }

       // squares[0][0].add(new JButton().setText("\u2654"));
        squares[0][1].add(new JButton(new ImageIcon("C:\\Users\\danwi\\Desktop\\Schule\\3A\\POS\\Chess-Project\\src\\Pieces pictures\\knight white.png")));
        squares[0][2].add(new JButton(new ImageIcon("C:\\Users\\danwi\\Desktop\\Schule\\3A\\POS\\Chess-Project\\src\\Pieces pictures\\bishop white.png")));
        squares[0][3].add(new JButton(new ImageIcon("C:\\Users\\danwi\\Desktop\\Schule\\3A\\POS\\Chess-Project\\src\\Pieces pictures\\queen white.png")));
        squares[0][4].add(new JButton(new ImageIcon("C:\\Users\\danwi\\Desktop\\Schule\\3A\\POS\\Chess-Project\\src\\Pieces pictures\\king white.png")));
        squares[0][5].add(new JButton(new ImageIcon("C:\\Users\\danwi\\Desktop\\Schule\\3A\\POS\\Chess-Project\\src\\Pieces pictures\\bishop white.png")));
        squares[0][6].add(new JButton(new ImageIcon("C:\\Users\\danwi\\Desktop\\Schule\\3A\\POS\\Chess-Project\\src\\Pieces pictures\\knight white.png")));
        squares[0][7].add(new JButton(new ImageIcon("C:\\Users\\danwi\\Desktop\\Schule\\3A\\POS\\Chess-Project\\src\\Pieces pictures\\rookwhite.png")));

        squares[7][0].add(new JButton(new ImageIcon("rookred.png")));
        squares[7][2].add(new JButton(new ImageIcon("bishopred.png")));
        squares[7][4].add(new JButton(new ImageIcon("kingred.png")));
        squares[7][5].add(new JButton(new ImageIcon("bishopred.png")));
        squares[7][7].add(new JButton(new ImageIcon("rookred.png")));

        for (int i = 0; i < 8; i++) {
            squares[1][i].add(new JLabel(new ImageIcon("C:\\Users\\danwi\\Desktop\\Schule\\3A\\POS\\Chess-Project\\src\\Pieces pictures\\pawn white.png")));
            squares[6][i].add(new JLabel(new ImageIcon("C:\\Users\\danwi\\Desktop\\Schule\\3A\\POS\\Chess-Project\\src\\Pieces pictures\\pawn black.png")));
        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new board();
    }
}