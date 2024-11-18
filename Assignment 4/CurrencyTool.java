import java.util.Scanner;


public class CurrencyTool {
    public static void main(String[] args) {
        Scanner inputTool = new Scanner(System.in);
        int selection;
        float amountToConvert = 0;
        float conversionResult;
        boolean shouldStop = false;
        Valuta canadianDollar = new Valuta("Canadian Dollar", 0.13f);
        Valuta danishKroner = new Valuta("Dansk Kroner", 0.64f);
        Valuta ugandanShillings = new Valuta("Ugandan Shillings", 350.51f);
        Valuta selectedCurrency = null;
        do {
            System.out.println("Please select a currency:");
            System.out.println("1. Canadian Dollars");
            System.out.println("2. Dansk Kroner");
            System.out.println("3. Ugandan Shillings");
            System.out.println("0. Quit");
            while(!inputTool.hasNextInt()){
                System.out.println("The Input you gave was not an integer. Please Try again.");
                inputTool.next();
            }
            selection = inputTool.nextInt();
        } while(selection < 0 || selection > 3);

        switch (selection) {
            case 1:
            selectedCurrency = canadianDollar;
                break;
            case 2:
            selectedCurrency = danishKroner;
                break;
            case 3:
            selectedCurrency = ugandanShillings;
                break;
            case 0:
                inputTool.close();
                shouldStop = true;
                break;

            default:
                inputTool.close();
                throw new AssertionError();
        }
        if(shouldStop){
            return;
        }
        selection = 0;
        if(selectedCurrency!=null){
            System.out.println("You selected " + selectedCurrency.getName());
        }
        

        do { System.out.println("Would you like to convert to or from Norwegian Crowns?");
            System.out.println("Type (1): My Currency -> Norwegian Crowns");
            System.out.println("Type (2) Norwegian Crowns -> My Currency");
            System.out.println("Type (0): Type 0 to quit.");
            while(!inputTool.hasNextInt()){
                System.out.println("The Input you gave was not an integer. Please Try again.");
                inputTool.next();
            }
            selection = inputTool.nextInt();
        } while (selection < 0 || selection > 2);

        switch (selection) {
            case 0:
                inputTool.close();
                break;
            case 1:
                do { System.out.println("Converting from your currency to Norwegian Kroner. How much would you like to convert?");
                    while(!inputTool.hasNextFloat()){
                        System.out.println("The Input you gave could not be converted. Please Try again.");
                        inputTool.next();
                    }
                    amountToConvert = inputTool.nextFloat();
                } while (amountToConvert < -100000000 || amountToConvert > 100000000);

                conversionResult = selectedCurrency.ConvertToKroner(amountToConvert);
                System.out.println(amountToConvert + " " + selectedCurrency.getName() + "(s) is worth " + conversionResult+ " Norwegian Kroner");
                break;
            case 2:
            do { System.out.println("Converting from Norwegian Crowns to you currency. How much would you like to convert?");
                while(!inputTool.hasNextFloat()){
                    System.out.println("The Input you gave could not be converted. Please Try again.");
                    inputTool.next();
                }
                amountToConvert = inputTool.nextFloat();
                } while (amountToConvert < (-100000000) || amountToConvert > (100000000));

                conversionResult = selectedCurrency.ConvertFromKroner(amountToConvert);
                System.out.println(amountToConvert + " Norwegian Kroner is worth " + conversionResult + " "+ selectedCurrency.getName() + "(s)");
                break;
            default:
                inputTool.close();
                throw new AssertionError();
        }
        inputTool.close();
    }
}

class Valuta {
    private String name = "";
    private float value;

    public Valuta(String input_name, float conversionValue){ // Constructor, used to build a new instance of the class.
        this.name = input_name;
        this.value = conversionValue;
    }

    public String getName(){
        return name;
    }
    public float getValue(){
        return value;
    }

    public float ConvertToKroner(float amount){ // Method, used to perform an operation on the data contained within the class.
        // Converts to a currency. Default is NoK. 
        float result = amount/this.value;
        return result;
    }
    public float ConvertFromKroner(float amount){
        // Converts from Nok to a selected currency.
        float result = amount*this.value;
        return result;
    }
}
