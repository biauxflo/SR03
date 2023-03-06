package fr.utc.sr03;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import static java.lang.Math.floor;

public class ex3 {
    public static void main(String[] args) {
        try {
            ServerSocket conn = new ServerSocket(10080);
            Socket comm = conn.accept();
            DataOutputStream out = new DataOutputStream(comm.getOutputStream());
            DataInputStream in = new DataInputStream(comm.getInputStream());
            while(true){
                int nb_restant = in.readInt();
                int nb_max = in.readInt();
                int coup = jeu_ordi(nb_restant, nb_max);
                out.writeInt(coup);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static int jeu_ordi (int nb_allum, int prise_max)
    {
        int prise = 0;
        int s = 0;
        float t = 0;
        s = prise_max + 1;
        t = ((float) (nb_allum - s)) / (prise_max + 1);
        while (t != floor(t))
        {
            s--;
            t = ((float) (nb_allum-s)) / (prise_max + 1);
        }
        prise = s - 1;
        if (prise == 0)
            prise = 1;
        return (prise);
    }
}
