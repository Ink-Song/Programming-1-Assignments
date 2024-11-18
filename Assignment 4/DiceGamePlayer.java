import java.util.Random;

public class DiceGamePlayer{

    static Player player1 = new Player();
    static Player player2 = new Player();

    public static void main(String[] args) {
        int roundNumber = 0;
        int roll;
        int score1 = 0;
        int score2 = 0;
        while (!player1.erFerdig(score1) && !player2.erFerdig(score2)) {
            roundNumber++;
            System.out.println("Round Number: " + roundNumber);

            roll = player1.kastTerning();
            System.out.println("Player 1 Rolled " + roll);
            score1 = player1.getPoengSum(roll);
            System.out.println("Player 1 has: " + score1 + " points."); 
            

            roll = player2.kastTerning();
            System.out.println("Player 2 Rolled " + roll);
            score2 = player2.getPoengSum(roll);
            System.out.println("Player 2 has: " + score2 + " points."); 
        }
        if(player1.getPoengSum(0) > player2.getPoengSum(0)){
            System.out.println("Player 1 wins! Player 1 has " + player1.getPoengSum(0) + " points, while player 2 only has " + player2.getPoengSum(0) + " points!");
        }
        else if (player1.getPoengSum(0) == player2.getPoengSum(0)) {
            System.out.println("Players have tied! Player 1 has " + player1.getPoengSum(0) + " points, while Player 2 has " + player2.getPoengSum(0) + " points!");
        }
        else{
            System.out.println("Player 2 wins! Player 2 has " + player2.getPoengSum(0) + " points, while player 1 only has " + player1.getPoengSum(0) + " points!");
        }
        System.out.println("This game took " + roundNumber + " rounds!");
    }


}

class Player{
    private int poengSum = 0;
    java.util.Random terning = new java.util.Random();

    public int getPoengSum(int poeng) {
        if(poeng == 1){
            poengSum = 0;
        }
        else{
            poengSum += poeng;
        }
        
        return poengSum;
    }

    public int kastTerning(){
        int terningKast = terning.nextInt(6);
        return (terningKast + 1);
    }

    public boolean erFerdig(int poeng){
        if(poeng > 100){
            return true;
        }
        else{
            return false;
        }
    }
}