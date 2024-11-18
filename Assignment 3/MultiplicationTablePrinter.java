/* Assignment: Build a program that can perform basic times tables.
 * Goals: Allow the user to perform basic inputs and decide what they want to perform times tables on.
 * Challenges: Check user input and prevent them from providing data that would throw an exception.
 */
import java.util.Scanner;

public class MultiplicationTablePrinter{

    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        int userNumber;
        int userIterations;

        //int userStepSize;
        
        /*
        int userNumber = kb.nextInt();
        kb.close();
        for(int i = 1; i <= 10; i++){
            int a = userNumber*i;
            System.out.println(userNumber + " x " + i + " = " + a);
        }

        By not checking input, the user can write "twelve" or input other symbols. This throws us an exception. 
        We need to find a way to check our inputs so that the user can only input integers
        It's probably a good idea to check for, say integer size as well. 
        Integers have a range of -2147483648 to 2147483647, so if the user were to input a larger number
        Then we would get an overflow error.

        Let's limit the size of the integer to 1000, which is more than large enough. 
        We could also add a timestable range (Eg, (10,20)) and a stepsize for the iterator.
        */

        System.out.println("Let's get started with your timestable. First, what number do you want to multiply?");
        userNumber = TakeInput(-25, 25, kb);
        System.out.println("Thank you, got " + userNumber + ". Now, how many iterations do you want?");
        userIterations = TakeInput(5, 20, kb);
        System.out.println("Thank you, got " + userIterations + ". Performing operations...");
        kb.close();
        TimesTable(userNumber, userIterations);
    }
    public static void TimesTable(int base, int rounds){
        for (int i = 1; i <= rounds; i++) {
            int newResult = base*i;
            System.out.println(base + " x " + i + " = " + newResult);
        }
    }

    public static int TakeInput(int lowerRange, int upperRange, Scanner kb){
        int a;
        do { 
            System.out.println("Please input a number between " + lowerRange + " and " + upperRange);
            while(!kb.hasNextInt()){
                System.out.println("Sorry, that's not a number!");
                kb.next();
            }
            a = kb.nextInt();
        } while (a < lowerRange || a > upperRange);
        return a;
    }
}