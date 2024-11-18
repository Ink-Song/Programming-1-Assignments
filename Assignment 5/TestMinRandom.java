public class TestMinRandom {

    public static void main(String[] args) {
        MinRandom rando = new MinRandom();
        int rounds = 0;
        for (int i = 0; i < 30; i++) {
            System.out.println("Running Round: (" + i + ")");
            System.out.println(rando.nesteHeltall(0, 10));
            System.out.println(rando.nesteDesimaltall(0, 1));
        }
        //for (int i = 0; i < 1000000; i++) {
        //    double n = rando.nesteDesimaltall(0, 1);
        //    if(n == 1 || n == 0){
        //        System.out.println("ERROR: Randomly generated " + n + " when trying to generate a double");
        //        break;
        //    }
        //    rounds++;
        //}
        //System.out.println("Doubles Check Complete after " + rounds + " rounds.");
        //rounds = 0;
        //for (int i = 0; i < 1000000; i++) {
        //    int n = rando.nesteHeltall(0, 10);
        //    if(n > 10 || n < 0){
        //        System.out.println("ERROR: 11 detected when range should be 10. N =" + n );
        //        break;
        //    }
        //    rounds++;
        //}
        //System.out.println("Heltall Check Complete after " + rounds + " rounds.");
    }
}
