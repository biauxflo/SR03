import java.util.Random;

public class exo3 {
    public static void main(String[] args) {

        point3D[] tab = new point3D[5];
        tab[0] = new point3D(1,1,1);
        tab[1] = new point3D(2,2,2);
        tab[2] = new point3D(3,3,3);
        tab[3] = new point3D(4,4,4);
        tab[4] = new point3D(5,5,5);

        for(point3D p:tab){

            Random rand = new Random();
            p.setX(rand.nextInt());
            p.setY(rand.nextInt());
            p.setZ(rand.nextInt());
            System.out.println(p.toString());
        }

        System.out.println("Distance entre les points 2 et 4 " + tab[2].calculerDistance(tab[4]));
    }
}
