package PlayerDomain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread {
    private Socket socket = null ;
    public ClientThread ( Socket socket ) { this.socket = socket ; }
    public void run () {
        try {
            // in este fluxul de intrare de la client
            BufferedReader in = new BufferedReader (
                    new InputStreamReader(socket.getInputStream()));
            //PrintWriter out = new PrintWriter(socket.getOutputStream());

            //adaugam un while ca sa nu pierdem clientul dupa o comanda
            while(true){
                String comanda = in.readLine (); // Primim cerere de la client
                // out este flux de iesire catre client
                PrintWriter out = new PrintWriter (socket.getOutputStream());
                if(comanda.equals("stop")){
                    out.println("Server stopped");
                    System.out.println("Client deconectat");
                    out.flush();
                    break;
                } else {
                    out.println("Server received the request ...");
                    out.flush();
                }
            }
        } catch (IOException e) {
            System.err.println("Eroare IO \n" + e);
        } finally { // Inchidem socketul deschis pentru clientul curent
            try {
                socket.close();
            } catch ( IOException e) { System.err. println (e); }
        }
    }
}
