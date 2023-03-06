import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.Scanner;

public class ex1 {

    public static double calculateSD(int numArray[])
    {
        double sum = 0.0, standardDeviation = 0.0;
        int length = numArray.length;

        for(int num : numArray) {
            sum += num;
        }

        double mean = sum/length;

        for(int num: numArray) {
            standardDeviation += Math.pow(num - mean, 2);
        }

        return Math.sqrt(standardDeviation/length);
    }

    public static void main(String[] args){

        Scanner sc= new Scanner(System.in);
        int[] tab = new int[10];

        for (int i = 0; i<10; i++){
            System.out.println("Veulliez saisir le nombre "+(i+1)+" du tableau");
            tab[i] = sc.nextInt();
        }

        System.out.println("Vous avez saisi le tableau suivant :");
        System.out.print("|");

        for (int i = 0; i<10; i++){
            System.out.print(tab[i] + "|");
        }

        OptionalDouble avg = Arrays.stream(tab).average();
        OptionalInt min = Arrays.stream(tab).min();
        OptionalInt max = Arrays.stream(tab).max();
        double sd = calculateSD(tab);
        System.out.println("Le minimum du tableau est : "+min);
        System.out.println("La maximum du tableau est : "+max);
        System.out.println("La moyenne du tableau est : "+avg);
        System.out.println("L'ecart type du tableau est : "+sd);
    }
}
