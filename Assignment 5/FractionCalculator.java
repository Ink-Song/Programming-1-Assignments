import java.util.Scanner;

public class FractionCalculator{
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        int selection;
        boolean useDenominator = true;
        int[] fractionValues = {0,0};

        Fraction fraction1;
        Fraction fraction2;
        String[] message = {"Fraction 1: Select Telleren", "Fraction 1: Select Nevneren"};
        for (int i = 0; i < 2; i++) {
            int temp_selection;
            do { 
            System.out.println(message[i]);
            } while (!userInput.hasNextInt());
            fractionValues[i] = userInput.nextInt();
            if(i <1){
                do { 
                    System.out.println("1. Set denominator 2. Skip");
                } while (!userInput.hasNextInt());
                temp_selection = userInput.nextInt();
                if(temp_selection == 2){
                    useDenominator = false;
                    break;
                }
                else if(temp_selection < 1 || temp_selection >2){
                    userInput.close();
                    throw new IllegalArgumentException("Illegal Selection.");
                }
            }
        }
        if(useDenominator == false){
            fraction1 = new Fraction(fractionValues[0]);
        }
        else{
            fraction1 = new Fraction(fractionValues[0],fractionValues[1]);
        }
        
        String[] message_2 = {"Fraction 2: Select Telleren", "Fraction 2: Select Nevneren"};
        for (int i = 0; i < 2; i++) {
            int temp_selection;
            do { 
            System.out.println(message[i]);
            } while (!userInput.hasNextInt());
            fractionValues[i] = userInput.nextInt();
            if(i <1){
                do { 
                    System.out.println("1. Set denominator 2. Skip");
                } while (!userInput.hasNextInt());
                temp_selection = userInput.nextInt();
                if(temp_selection == 2){
                    useDenominator = false;
                    break;
                }
                else if(temp_selection < 1 || temp_selection >2){
                    userInput.close();
                    throw new IllegalArgumentException("Illegal Selection.");
                }
                else {
                    useDenominator = true;
                }
            }
        }
        if(useDenominator == false){
            fraction2 = new Fraction(fractionValues[0]);
        }
        else{
            fraction2 = new Fraction(fractionValues[0],fractionValues[1]);
        }

        do { 
            System.out.println("What action would you like to perform? Please input a number to select your action.");
            System.out.println("1. Addition");
            System.out.println("2. Substraction");
            System.out.println("3. Multiplcation");
            System.out.println("4. Division");
            while (!userInput.hasNextInt()) { 
                System.out.println("Please select 1."); // Temporary. Rework at later date.
            }
            selection = userInput.nextInt();
        } while (selection < 1 || selection > 4);

        /* 
        Just a quick test as a proof of concept that the other constructor works.
        Fraction fraction3 = new Fraction(3);
        int n[] = {fraction3.getTeller(),fraction3.getNevner()};
        System.out.println(n[0]);
        System.out.println(n[1]);
        */  

        switch (selection) {
            case 1:
                fraction1.Add(fraction2);
                break;
            case 2:
                fraction1.Subtract(fraction2);
                break;
            case 3:
                fraction1.Multiply(fraction2);
                break;
            case 4:
                fraction1.Divide(fraction2);
                break;
            default:
                userInput.close();
                throw new AssertionError();
        }
        int result[] = fraction1.getResult();
        System.out.println("Operation finished. Result = " + result[0] + "/" + result[1]);

        userInput.close();
    }
}