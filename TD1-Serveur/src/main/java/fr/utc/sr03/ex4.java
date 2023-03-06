package fr.utc.sr03;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class ex4 {
    public static void main(String[] args) {
        Restaurant[] datas = new Restaurant[5];
        try {
            ServerSocket conn = new ServerSocket(10080);

            datas[0] = new Restaurant("McDo", "01.02.03.04.05.06", new point2D(1,1));
            datas[1] = new Restaurant("Burger King", "01.02.03.04.05.06", new point2D(5,3));
            datas[2] = new Restaurant("Pizza Hut", "01.02.03.04.05.06", new point2D(7,12));
            datas[3] = new Restaurant("KFC", "01.02.03.04.05.06", new point2D(8,3));
            datas[4] = new Restaurant("Wendy's", "01.02.03.04.05.06", new point2D(2,9));

            while(true){
                Socket comm = conn.accept();
                ObjectOutputStream out = new ObjectOutputStream(comm.getOutputStream());
                ObjectInputStream in = new ObjectInputStream(comm.getInputStream());

                point2D loc = (point2D)in.readObject();

                double min_dist =1000000;
                Restaurant close1 = null;
                Restaurant close2 = null;
                Restaurant close3 = null;
                for (Restaurant r: datas) {
                    double dist = r.getGeo().calculerDistance(loc);
                    if (dist < min_dist){
                        min_dist=dist;
                        close1 = r;
                    }
                }
                min_dist =1000000;
                for (Restaurant r: datas) {
                    double dist = r.getGeo().calculerDistance(loc);
                    if (dist < min_dist && r.getName()!= close1.getName()){
                        min_dist=dist;
                        close2 = r;
                    }
                }
                min_dist =1000000;
                for (Restaurant r: datas) {
                    double dist = r.getGeo().calculerDistance(loc);
                    if (dist < min_dist && r.getName()!= close1.getName() && r.getName()!= close2.getName()){
                        min_dist=dist;
                        close3 = r;
                    }
                }

                out.writeObject(close1);
                out.writeObject(close2);
                out.writeObject(close3);
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
