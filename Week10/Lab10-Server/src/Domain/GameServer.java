package Domain;

import PlayerDomain.ClientThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class GameServer {

    public static final int PORT = 8800;

    public GameServer() throws IOException {
        ServerSocket serverSocket = null ;
        try {
            serverSocket = new ServerSocket( PORT );
            System.out.println("Start server");

            while ( true ) {
                System.out.println ("Asteptam un client ...");
                Socket socket = serverSocket.accept();
                System.out.println("Client conectat");
                // Executam solicitarea clientului intr -un fir de executie
                new ClientThread(socket).start();
            }
        } catch ( IOException e) {
            System.err. println (" Eroare IO \n" + e);
        } finally {
            serverSocket.close();
        }
    }
    public static void main ( String [] args ) throws IOException {
        GameServer server = new GameServer ();
    }
}
