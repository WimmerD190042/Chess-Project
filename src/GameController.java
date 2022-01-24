import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class GameController {
    public static String ipAdress ="";

    public static void main(String[] args) throws IOException {
           IPInput ip= new IPInput();
           ip.start();

           InetAddress ipAdress= InetAddress.getByName(ip.getIpAdress());
        ServerSocket socket= new ServerSocket(1234,1, ipAdress);
    }
}
