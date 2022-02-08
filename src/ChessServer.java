import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ChessServer implements Runnable{

    ServerSocket serverSocket;
    BufferedWriter dataToWhitePlayer;
    BufferedReader dataFromBlackPlayer;
    BufferedWriter dataToBlackPlayer;
    BufferedReader dataFromWhitePlayer;
    Socket playerWhite;
    Socket playerBlack;

    public ChessServer(){
       // IPInput input= new IPInput();

        System.out.println("Server started, waiting for clients:");
        try {
            serverSocket = new ServerSocket(1234);


            playerWhite = serverSocket.accept();
            System.out.println("Player 1 connected");
            playerBlack = serverSocket.accept();
            System.out.println("Player 2 connected");

            dataFromBlackPlayer = new BufferedReader(new InputStreamReader(playerBlack.getInputStream()));
            dataFromWhitePlayer = new BufferedReader(new InputStreamReader(playerWhite.getInputStream()));
            dataToBlackPlayer = new BufferedWriter(new OutputStreamWriter(playerBlack.getOutputStream()));
            dataToWhitePlayer = new BufferedWriter(new OutputStreamWriter(playerWhite.getOutputStream()));


        } catch (IOException e) {
            e.printStackTrace();
        }

        Thread thread = new Thread(this);
        thread.start();

    }

    @Override
    public void run() {
        while (playerWhite.isConnected()&&playerBlack.isConnected()){

                try {
                    int yCoor = Integer.parseInt(dataFromBlackPlayer.readLine());
                    int xCoor = Integer.parseInt(dataFromBlackPlayer.readLine());

                    System.out.println("First Standort: [" + yCoor + "|" + xCoor+"]");

                    int fxCoor = Integer.parseInt(dataFromBlackPlayer.readLine());
                    int fyCoor = Integer.parseInt(dataFromBlackPlayer.readLine());
                    System.out.println("Future Standort: [" + fyCoor + "|" + fxCoor+"]");

                    dataToWhitePlayer.write(String.valueOf(yCoor));
                    dataToWhitePlayer.newLine();
                    dataToWhitePlayer.flush();
                    dataToWhitePlayer.write(String.valueOf(xCoor));
                    dataToWhitePlayer.newLine();
                    dataToWhitePlayer.flush();

                    dataToWhitePlayer.write(String.valueOf(fyCoor));
                    dataToWhitePlayer.newLine();
                    dataToWhitePlayer.flush();
                    dataToWhitePlayer.write(String.valueOf(fxCoor));
                    dataToWhitePlayer.newLine();
                    dataToWhitePlayer.flush();

                    dataToBlackPlayer.write(String.valueOf(yCoor));
                    dataToBlackPlayer.newLine();
                    dataToBlackPlayer.flush();
                    dataToBlackPlayer.write(String.valueOf(xCoor));
                    dataToBlackPlayer.newLine();
                    dataToBlackPlayer.flush();

                    dataToBlackPlayer.write(String.valueOf(fyCoor));
                    dataToBlackPlayer.newLine();
                    dataToBlackPlayer.flush();
                    dataToBlackPlayer.write(String.valueOf(fxCoor));
                    dataToBlackPlayer.newLine();
                    dataToBlackPlayer.flush();


                } catch (IOException e) {
                    e.printStackTrace();
                }

            try {
                int yCoor = Integer.parseInt(dataFromWhitePlayer.readLine());
                int xCoor = Integer.parseInt(dataFromWhitePlayer.readLine());

                System.out.println("First Standort: [" + yCoor + "|" + xCoor+"]");

                int fyCoor = Integer.parseInt(dataFromWhitePlayer.readLine());
                int fxCoor = Integer.parseInt(dataFromWhitePlayer.readLine());

                System.out.println("Future Standort: [" + fyCoor + "|" + fxCoor+"]");

                dataToWhitePlayer.write(String.valueOf(yCoor));
                dataToWhitePlayer.newLine();
                dataToWhitePlayer.flush();
                dataToWhitePlayer.write(String.valueOf(xCoor));
                dataToWhitePlayer.newLine();
                dataToWhitePlayer.flush();

                dataToWhitePlayer.write(String.valueOf(fyCoor));
                dataToWhitePlayer.newLine();
                dataToWhitePlayer.flush();
                dataToWhitePlayer.write(String.valueOf(fxCoor));
                dataToWhitePlayer.newLine();
                dataToWhitePlayer.flush();

                dataToBlackPlayer.write(String.valueOf(yCoor));
                dataToBlackPlayer.newLine();
                dataToBlackPlayer.flush();
                dataToBlackPlayer.write(String.valueOf(xCoor));
                dataToBlackPlayer.newLine();
                dataToBlackPlayer.flush();

                dataToBlackPlayer.write(String.valueOf(fyCoor));
                dataToBlackPlayer.newLine();
                dataToBlackPlayer.flush();
                dataToBlackPlayer.write(String.valueOf(fxCoor));
                dataToBlackPlayer.newLine();
                dataToBlackPlayer.flush();


            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }

    public static void main(String[] args) {
        ChessServer chessServer = new ChessServer();
    }

}
