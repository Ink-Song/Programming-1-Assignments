import java.text.DecimalFormat;
import java.util.Scanner;

public class TextAnalyserClient {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text to analyse: ");
        String text = sc.nextLine();
        TextAnalyser ta = new TextAnalyser(text);
        DecimalFormat df = new DecimalFormat("0.00");
        do {
            int selection;
            do {
                System.out.println("How do you want to analyse the text?: ");
                System.out.println("1. Determine how many different letters can be found in the text.");
                System.out.println("2. Find the total number of letters in the text.");
                System.out.println("3. Find what percentage of the characters in the text aren't letters.");
                System.out.println("4. Find how often a specific character appears.");
                System.out.println("5. Find out which character appears most often.");
                System.out.println("0. Exit");
            }while(!sc.hasNextInt());
            selection = sc.nextInt();
            switch (selection) {
                case 1:
                    System.out.println("There are " + ta.getAntallForskjelligeBokstaver() + " different letters in the string." );
                    break;
                case 2:
                    System.out.println("There are " + ta.getAntallBokstaver() + " total characters in your message.");
                    break;
                case 3:
                    //System.out.println(df.format(ta.calculatePercentNonChar()) + "% of your characters are not letters.");
                    System.out.println(ta.calculatePercentNonChar() + "% of your characters are not letters.");
                    break;
                case 4:
                    sc.nextLine();
                    do {
                        System.out.println("What character would you like to check the occurrence of? Only type one character");
                    }while(!sc.hasNextLine());
                    String n = sc.nextLine();
                    System.out.println(n + " appears " + ta.getTallyCharacter(n) + " times.");
                    break;
                case 5:
                    System.out.println("The most frequently appearing character in the text is " + ta.getMostFrequentCharacter() + "." + " With " + ta.getTallyCharacter(String.valueOf(ta.getMostFrequentCharacter())) + " appearances");
                    break;
                case 0:
                    System.out.println("Exiting the program.");
                    sc.close();
                    return;
                default:
                    break;
            }

        } while(true);


    }

}
