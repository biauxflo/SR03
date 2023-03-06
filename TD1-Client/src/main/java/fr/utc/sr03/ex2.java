package fr.utc.sr03;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ex2 {
    public static void main(String[] args) {
        int compteur=0,nbMax;
        byte b[]=new byte[20];
        try {
            Socket client = new Socket ("localhost", 10080);
            OutputStream out = client.getOutputStream();
            InputStream in=client.getInputStream();
            out.write("bonjour4".getBytes());
            System.out.println("Donnez le nombre max de messages à envoyer au serveur :");
            Scanner sc = new Scanner(System.in);
            nbMax = sc.nextInt();
            while(compteur!=nbMax){
                in.read(b);
                System.out.println("le serveur a dit: "+new String(b));
                System.out.println("Le client envoie le message:message"+compteur);
                out.write(("message"+compteur).getBytes());
                compteur++;
                b=new byte[20];
            }
            out.write(("END").getBytes());
            try {
                Thread.sleep(20);
            } catch (InterruptedException ex) {
                Logger.getLogger(ex2.class.getName()).log(Level.SEVERE, null, ex);
            }
            in.close();
            out.close();
            client.close();
        } catch (IOException ex) {
            Logger.getLogger(ex2.class.getName()).log(Level.SEVERE, null, ex);
        }
    } }