import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Scanner input = new Scanner(System.in);

        MenuRegister menuRegister = new MenuRegister();
        menuRegister.addMenu(new Menu("Denny's"));
        menuRegister.createNewDish("Bananas Foster", "Main",240.0,"Just Do it");

        ArrangementRegister register = new ArrangementRegister();
        Arrangement myArrangement = new Arrangement(1314,"Rockheim","Trondheim","Me","Concert", 200201241900L);
        Arrangement myArrangement2 = new Arrangement(1314,"Trondheim Rocks","Trondheim","You","Concert", 200201241800L);
        Arrangement myArrangement3 = new Arrangement(0404,"KammerMusikkFest","Trondheim","Olavshallen","Concert", 202409241800L);

        register.addArrangement(myArrangement);
        register.addArrangement(myArrangement2);
        register.addArrangement(myArrangement3);

        register.findArrangementsByDate(19950234,20210403);

        menuRegister.addMenu(new Menu("Mac Donalds"));
        menuRegister.getMenu("Denny's").addDish(menuRegister.findDish("Bananas Foster"));
        menuRegister.getMenu("Denny's").displayMenu();
        menuRegister.getMenu("Mac Donalds").addDish(menuRegister.findDish("Bananas Foster"));

        Menu currentMenu = menuRegister.getMenu("Mac Donalds");
        menuRegister.createNewDish("Cheese Burger", "Main",39.0,"I'm lovin it");
        currentMenu.addDish(menuRegister.findDish("Cheese Burger"));
        menuRegister.createNewDish("Milkshake", "Dessert",78.0,"I'm lovin it");
        currentMenu.addDish(menuRegister.findDish("Milkshake"));
        currentMenu.displayMenu();

        menuRegister.displayMenus(menuRegister.findMenusWithinPriceRange(10,280));

        String menu = """
                Welcome! What would you like to do?
                1. Assignment 1 (Arrangement Register)
                2. Assignment 2 (Menu Register)
                0. Exit Program
                """;
        int selection;
        do {
            selection = choose(menu,input,0,2);
            switch (selection) {
                case 1:
                    startAssignment1(input,register);
                    break;
                case 2:
                    startAssignment2(input,menuRegister);
                    break;
                case 0:
                    input.close();
                    System.exit(0);
            }
        }while(true);


    }

    public static int choose(String displayText, Scanner scanner, int min, int max) {
        int selection = max + 1;
        do {
            System.out.println(displayText);
            while(!scanner.hasNextInt()){
                System.out.println("Please enter an integer in range " + min + " to " + max);
                scanner.next();
            }
            selection = scanner.nextInt();
        } while (selection > max || selection < min);
        return selection;
    }
    public static String getInput(String displayText, Scanner scanner) {
        String input;
        scanner.nextLine();
        do{
            System.out.println(displayText);
            input = scanner.nextLine();
        }while(input.length() > 40);
        return input;
    }
    public static void startAssignment1(Scanner input, ArrangementRegister register) {
        String menu = """
                Welcome to the Arrangements Program. Please choose from the following options:
                1. Create new Arrangement
                2. Find or List Arrangements
                0. Return to previous Menu
                """;
        int selection = choose(menu,input,0,2);
        switch(selection){
            case 1: register.addArrangement(makeNewArrangement(input));
            break;
            case 2: sortArrangements(register,input);
            break;
            case 0: return;
        }

    }
    public static void startAssignment2(Scanner input, MenuRegister register) {
        String menu = """
                1. Create new Dish
                2. Find Dish by Name
                3. Dishes by Type
                4. Create a new Menu
                5. Find Menus within a given price range
                6. Show all Menus
                0. Return to previous Menu
                """;
        do {
            int selection = choose(menu,input,0,6);
            switch(selection){
                case 0: return;
                case 1: createDish(input,register);
                    break;
                case 2: System.out.println(register.findDish(getInput("Enter the name of the dish", input)).toString());
                    break;
                case 3: register.findDishByType(getInput("Enter what type of dish you'd like to find: Breakfast, Main, Dessert", input));
                    break;
                case 4: createMenu(input,register);
                    break;
                case 5: register.displayMenus(register.findMenusWithinPriceRange(Double.parseDouble(getInput("Input lower range",input)),Double.parseDouble(getInput("Input upper range",input))));
                    break;
                case 6: showMenus(input,register);
                    break;
            }
            continue;
        }while(true);

    }

    public static void findDishByType(Scanner input, ArrangementRegister register) {

    }
    public static void createDish(Scanner input, MenuRegister register) {
        do {
            System.out.println("1. Create Dish");
            String name = getInput("Enter the name of the dish",input);
            String type = getInput("Enter the type of the dish",input);
            double price = Double.parseDouble(getInput("Enter the price of the dish in kr",input));
            String recipe = getInput("Enter the recipe of the dish",input);
            try{
                register.createNewDish(name, type, price, recipe);
            }
            catch(Exception e){
                System.out.println(e.getMessage());
                continue;
            }
            System.out.println(register.findDish(name).toString());
            break;
        }while(true);
        return;
    }

    public static void createMenu(Scanner input, MenuRegister register) {
        //choose dishes to add to menu
        ArrayList<Dish> dishes = new ArrayList<>();
        String menuName = getInput("Enter the name of the menu",input);
        int selection;
        do {
            register.printDishes();
            System.out.println("0. Finish creating Menu");
            selection = choose("Choose an item to add to menu",input,0,register.getNumberOfDishes());
            if(selection > 0){
                dishes.add(register.getDish(selection-1));
            }
        }while(selection != 0);

        register.createNewMenu(menuName, dishes);
        selection = choose("1. Create another Menu \n 2. Return to Main Menu",input,1,2);
        if(selection == 2){
            return;
        }
        else{
            createMenu(input,register);
        }
    }

    public static void showMenus(Scanner input, MenuRegister register) {
        int selection;
        String menuName;
        Menu selectedMenu;
        do {
            register.getMenus();
            System.out.println("0. Return to Main Menu");
            menuName = getInput("Enter the name of the menu you want to see",input);

            selectedMenu = register.getMenu(menuName);
            selectedMenu.displayMenu();
            selection = choose("1. Add Dish to Menu \n 2. Select new Menu \n 0. Return to Main Menu",input,0,2);
            if(selection == 1){
                addDishesToMenu(input,register,selectedMenu);
            }
            else if(selection == 0){
                return;
            }
            else{
                continue;
            }
        }while(true);
    }

    public static void addDishesToMenu(Scanner input, MenuRegister register, Menu menu) {
        ArrayList<Dish> dishes = new ArrayList<>();
        int selection;
        do {
            register.printDishes();
            System.out.println("0. Finish");
            selection = choose("\n Select Dishes:",input,0,register.getNumberOfDishes());
            if(selection > 0){
                dishes.add(register.getDish(selection-1));
            }
        }while(selection!=0);
        for(Dish dish: dishes){
            menu.addDish(dish);
        }
        return;
    }


    public static Arrangement makeNewArrangement(Scanner input){
        int eventNumber = choose("Enter 4 integer event number (format 9999)", input, 1000, 9999);
        String name = getInput("Enter Event name", input);
        String location = getInput("Enter Location", input);
        String host = getInput("Enter Host", input);
        String type =  getInput("Enter Type", input);
        long timestamp = Long.parseLong(getInput("Enter date/time in format yyyyMMddhhmm",input));
        return new Arrangement(eventNumber, name, location, host, type, timestamp);
    }


    public static void sortArrangements(ArrangementRegister register, Scanner input){
        //choose how to sort
        input.nextLine();
        String menu = """
                Choose an option:
                1. Find Arrangements by Location
                2. Find Arrangements by Date.
                3. Find arrangements within a given period
                4. Sort arrangements by Location
                5. Sort Arrangements by Type
                6. Sort Arrangements by Date
                0. Return to Previous Menu
                """;
        do {
            int selection = choose(menu,input,0,6);
            switch (selection){
                case 1: register.findArrangementsByLocation(getInput("1. Find Arrangement by location: Enter a Location",input));
                    break;
                case 2: register.findArrangementsByDate(getInput("2. Find Arrangements by Date. Use Format yyyyMMdd",input));
                    break;
                case 3: register.findArrangementsByDate(choose("3. Find Arrangement by date period, input in format yyyyMMdd. \n Date 1:",input,10000000,99999999), choose("Enter Second Date (yyyyMMdd)",input,10000000,99999999));
                    break;
                case 4: register.sortListByLocation();
                    break;
                case 5: register.sortListByEventType();
                    break;
                case 6: register.sortListByDate();
                    break;
                case 0: return;

            }
        }while(true);
    }
}