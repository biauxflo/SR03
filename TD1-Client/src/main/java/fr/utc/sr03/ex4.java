package fr.utc.sr03;

import java.awt.*;
import java.awt.geom.Point2D;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class ex4 {
    public static void main(String[] args) {
        try {
            Socket client = new Socket("localhost", 10080);
            ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(client.getInputStream());
            out.writeObject(new point2D(1,7));
            System.out.println("Restaurant les + proche : ");
            Restaurant closest = (Restaurant) in.readObject();
            System.out.println("1- " + closest);
            closest = (Restaurant) in.readObject();
            System.out.println("2- " + closest);
            closest = (Restaurant) in.readObject();
            System.out.println("3- " + closest);
            out.close();
            in.close();
            client.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
