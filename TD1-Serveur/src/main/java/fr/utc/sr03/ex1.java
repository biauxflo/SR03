package fr.utc.sr03;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ex1
{
    public static void main( String[] args ) throws IOException {
        ServerSocket conn = new ServerSocket(10080);
        System.out.println("Serveur démarré");
        while(true){
            Socket comm = conn.accept();
            System.out.println("Connexion établie avec le client");

            InputStream in = comm.getInputStream();
            byte[] b = new byte[1024];
            in.read(b);
            System.out.println("Message du client :" + new String(b));

            OutputStream out = comm.getOutputStream();
            out.write("Pong".getBytes());
        }
    }
}
