import java.io.IOException;
import java.net.Socket;

public class Client  {
    Socket requestSocket;
    public String ipAdress="";

    public Client(String ipAdress) {
        this.ipAdress = ipAdress;
    }

    public void run(){
        try {
            requestSocket= new Socket(ipAdress,50);






        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
