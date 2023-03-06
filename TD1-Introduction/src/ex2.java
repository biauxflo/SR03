import java.util.Random;

public class ex2 {
    public static void main(String[] args) {

        point2D[] tab = new point2D[5];
        tab[0] = new point2D(1,1);
        tab[1] = new point2D(2,2);
        tab[2] = new point2D(3,3);
        tab[3] = new point2D(4,4);
        tab[4] = new point2D(5,5);

        for(point2D p:tab){

            Random rand = new Random();
            p.setX(rand.nextInt());
            p.setY(rand.nextInt());

            System.out.println("["+p.getX()+","+p.getY()+"]");
        }

        System.out.println("Distance entre les points 2 et 4 " + tab[2].calculerDistance(tab[4]));
    }
}
