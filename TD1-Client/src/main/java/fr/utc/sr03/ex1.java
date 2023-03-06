package fr.utc.sr03;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ex1
{
    public static void main( String[] args ) throws IOException {
        Socket comm = new Socket("localhost", 10080);
        System.out.println("Connexion réussie");

        OutputStream out = comm.getOutputStream();
        out.write("Ping".getBytes());

        InputStream in = comm.getInputStream();
        byte[] b = new byte[1024];
        in.read(b);
        System.out.println("Message du serveur :" + new String(b));
    }
}
