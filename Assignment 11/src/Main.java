import java.util.Scanner;

public class Main {
    private PropertyRegister PROPERTY_REGISTER;
    private Scanner SCANNER;
    private String MAIN_MENU = """
            1. Register a new property.
            2. Remove a property from the Register.
            3. Print out all registered properties.
            4. Search for a Property
            5. Calculate Average total Surface Area of all properties in the register.
            0. Exit Program
            """;
    private String NEW_PROPERTY = """
            Does the new property have a name?
            1. Yes
            2. No
            """;

    public static void main(String[] args) {
        System.out.println("Hello world!");
        Main main = new Main();
        main.init();
        main.start();
    }

    private void init(){
        PROPERTY_REGISTER = new PropertyRegister();
        PROPERTY_REGISTER.addPropertyToRegister(new Property(1445,"Gloppen",77,631,1017.6,"Jens Olsen"));
        PROPERTY_REGISTER.addPropertyToRegister(new Property(1445,"Gloppen",77,131,661.3,"Nicolay Madsen", "Syningom"));
        PROPERTY_REGISTER.addPropertyToRegister(new Property(1445,"Gloppen",75,19,650.6,"Evilyn Jensen", "Fugletun"));
        PROPERTY_REGISTER.addPropertyToRegister(new Property(1445,"Gloppen",74,188,1457.2,"Karl Ove Bråten"));
        PROPERTY_REGISTER.addPropertyToRegister(new Property(1445,"Gloppen",69,47,1339.4,"Elsa Indegård", "Høiberg"));

        SCANNER = new Scanner(System.in);
    }
    private void start(){
        do {
            System.out.println("\nWelcome! What would you like to do?");
            int selection = choose(MAIN_MENU, 0, 5);
            switch(selection){
                case 1:
                    addNewProperty();
                    System.out.println("\nNew property Added. \n");
                    break;
                case 2:
                    removeProperty();
                    System.out.println("\nProperty Removed. \n");
                    break;
                case 3:
                    PROPERTY_REGISTER.printProperties();
                    break;
                case 4:
                    searchForProperty();
                    break;
                case 5:
                    double totalArea = PROPERTY_REGISTER.calculateTotalAverageArea();
                    System.out.println("Total Average Area of all Properties in the Register: " + totalArea + "m^2");
                    break;
                case 0:
                    close();
            }
        }while(true);


    }
    public void close(){
        SCANNER.close();
        System.exit(0);
    }

    private void addNewProperty(){
        int selection = choose(NEW_PROPERTY, 1, 2);
        String name = "";
        switch(selection){
            case 1:
                name = getUserInput("Please enter a new property name: ");
                break;
            case 2:
                break;
        }
        int municipalityNumber = choose("Enter the municipality number: ", 0,999);
        String municipalityName = getUserInput("Please enter the municipality name: ");
        int lotNumber = choose("Enter the lot number of this property: ", 0,999);
        int sectionNumber = choose("Enter the section number: ", 0,999);
        double area = Double.parseDouble(getUserInput("Enter the area of the new property in square meters."));
        String ownersName = getUserInput("Please enter the owner name: ");

        if(name.isBlank()){
            PROPERTY_REGISTER.addPropertyToRegister(new Property(municipalityNumber,municipalityName,lotNumber,sectionNumber,area,ownersName));
        }
        else{
            PROPERTY_REGISTER.addPropertyToRegister(new Property(municipalityNumber,municipalityName,lotNumber,sectionNumber,area,ownersName,name));
        }
    }
    private void removeProperty(){
        String propertyID = getUserInput("\nPlease enter the ID of the Property you'd like to remove: ");
        Property propertyToRemove = PROPERTY_REGISTER.findPropertyByID(propertyID);
        if(propertyToRemove != null){
            PROPERTY_REGISTER.removePropertyFromRegister(propertyToRemove);
        }
        else{
            System.out.println("Error: Property does not exist.");
        }
    }
    private void searchForProperty(){
        String choice = """
                Please choose how you'd like to find the property:
                1. By ID Number
                2. By Section Number
                """;
        int selection = choose(choice, 1, 2);
        switch(selection){
            case 1:
                Property property = PROPERTY_REGISTER.findPropertyByID(getUserInput("\nPlease enter a property ID (Municipality Number - Lot Number / Section Number)"));
                if(property != null){
                    System.out.println(property.toString());
                }
                else{
                    System.out.println("Property Not Found");
                }
                break;
            case 2:
                int lotNumber = choose("Enter the lot number you'd like to search: ", 0,999);
                PROPERTY_REGISTER.findPropertyByLotNumber(lotNumber);
        }
    }

    private int choose(String displayText, int min, int max){
        int selection;
        do {
            System.out.print(displayText);
            while(!SCANNER.hasNextInt()){
                System.out.print("Please enter a number between " + min + " and " + max + ": ");
            }
            selection = SCANNER.nextInt();
        }while(selection < min || selection > max);
        return selection;
    }
    private String getUserInput(String displayText){
        String userInput = "";
        SCANNER.nextLine();
        do {
            System.out.print(displayText);
            userInput = SCANNER.nextLine();
        }while(userInput.length() > 50);
        return userInput;
    }

}