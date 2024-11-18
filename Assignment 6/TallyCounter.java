import java.util.Random;

public class TallyCounter{
    public static void main(String[] args) {
        java.util.Random rand = new java.util.Random();
        int tall;
        int[] antall = new int[10];

        for (int i = 0; i < 10000; i++) {
            tall = rand.nextInt(10);
            antall[tall]++;
        }
        //for (int j : antall) {
        //     System.out.println(j);
        // }
        for (int i = 0; i < antall.length; i++) {
            System.out.println("Number of " + i + "'s: " + antall[i]);
        }
    }
}