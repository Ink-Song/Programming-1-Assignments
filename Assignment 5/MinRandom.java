import java.util.Random;

public class MinRandom {
    java.util.Random rand = new java.util.Random();

    public int nesteHeltall(int nedre, int ovre){
        int result = rand.nextInt(nedre, ovre+1);
        return result;
    }
    public double nesteDesimaltall(double nedre, double ovre){
        double result = rand.nextDouble(nedre, ovre);
        return result;
    }
}
