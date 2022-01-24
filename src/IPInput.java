import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;

public class IPInput {
    public static String ipAdress ="";

    public void start(){

        /*JFrame frame = new JFrame();
        JTextField fn= new JTextField();
        fn.setText("enter ip");
        frame.add(fn);
        frame.setSize(200,200);
        frame.setVisible(true);
*/
        JFrame f=new JFrame("Button Example");
        //submit button
        JButton b=new JButton("Submit");
        b.setBounds(100,100,140, 40);
        //enter name label
        JLabel label = new JLabel();
        label.setText("Enter IP Address :");
        label.setBounds(10, 10, 100, 100);
        //empty label which will show event after button clicked
        JLabel label1 = new JLabel();
        label1.setBounds(10, 110, 200, 100);
        //textfield to enter name
        JFormattedTextField textfield= new JFormattedTextField(new IPAddressFormatter());
        textfield.setBounds(110, 50, 130, 30);
        //add to frame
        f.add(label1);
        f.add(textfield);
        f.add(label);
        f.add(b);
        f.setSize(300,300);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Socket socket = new Socket(ipAdress,5555);


        b.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                label1.setText("IP has been submitted.");
                setIpAdress(textfield.getText());
                ChessBoardWithColumnsAndRows board = new ChessBoardWithColumnsAndRows("schach");

            }
        });



    }

    public static void setIpAdress(String ipAdress) {
        GameController.ipAdress = ipAdress;
    }

    public static String getIpAdress() {
        return ipAdress;
    }
}
