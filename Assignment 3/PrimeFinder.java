import java.util.Scanner;

public class PrimeFinder{

    public static void main(String[] args){
        Scanner kb = new Scanner(System.in); // Reads User Keystrokes
        int lowerRange = 1; // Lower range of inputs.
        int upperRange =  999; // Upper range of Inputs. Arbitrarily selected.
        int userInput; // Input Integer that we are checking to see if it's prime.
        int loopBreaker = 0; // Custom defined input for stopping the loop, which will otherwise continue.

        /* Test Data set:
         * Confirmed Prime Numbers:
         * - 2
         * - 199
         * - 401
         * Confirmed Composite Numbers
         * - 382
         * - 404
         * - 688
         */

        do { 
            System.out.println("Please input a number between " + lowerRange + " and " + upperRange + " or type " + loopBreaker + " to break.");
            while(!kb.hasNextInt()){
                System.out.println("The input you gave was not an integer. Please try again.");
                kb.next();
            }
            userInput = kb.nextInt();
            if(userInput == loopBreaker){
                break;
                }
            PrimeTester(userInput, lowerRange, upperRange); //Send to function that handles the Trial Division algorithm.
        } while (true); // This is never false, so we rely on the user to break, otherwise the loop continues.

        kb.close(); // Close user input once the loop is broken.
    }

    // I shamelessly used the algorithm described on the wikipedia page for Trial Division.
    // It's a brute force method wherein we create a loop and check if there's a remainder after a modulo operation.
    // If there isn't, the number is prime.
    // If there is, we iterate by one and retry. 
    // We repeat this until we've reached the square root of our input, after which the check would be checking duplicates.
    
    public static void PrimeTester(int n, int lowerRange, int upperRange){
        // Test for Primes using Trial Division
        if(n < lowerRange || n > upperRange){
            System.err.println("Sorry, " + n + " is out of range.");
            return;
        }
        int a = 2;
        while(a*a <= n){
            if(n % a == 0){
                System.out.println("False, " + n + " is a composite number as it is divisible by at least " + a);
                return;
            }
            a++;
        }
        System.out.println("True, " + n + " is a prime number.");
    }
}