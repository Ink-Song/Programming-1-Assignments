import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.util.GregorianCalendar;
import java.util.stream.IntStream;


public class Main {
    public static void main(String[] args) {
        GregorianCalendar GC = new GregorianCalendar();
        int CURRENT_YEAR = GC.get(java.util.GregorianCalendar.YEAR);
        Scanner scanner = new Scanner(System.in);
        ArrayList<Employee> employees = new ArrayList<>();
        ArrayList<Person> people = new ArrayList<>();
        Employee selectedEmployee = null;

        Person basePerson = new Person("Smitty", "Werbenjagermanjenson",2001);
        Employee smitty = new Employee(basePerson,0001,2005,45000,25);
        employees.add(smitty);
        setupEmployees(employees);

        do {
            System.out.println("Welcome! Please Choose what you would like to do: ");
            int selection = choose("""
                    1. Create new Employee
                    2. Display Employees
                    0. Exit Program
                    """, scanner,0,2);
            switch (selection){
                case 1:
                    createNewEmployee(employees,scanner);
                    selection = -1;
                    continue;
                case 2:
                    if (employees.isEmpty()){
                        System.out.println("There are no employees. Returning to main menu.");
                        continue;
                    }
                    IntStream.range(0,employees.size()).forEach(i ->{
                        System.out.println((i+1) +". " + employees.get(i).getPerson().getLastName() + ", " + employees.get(i).getPerson().getFirstName());
                    });
                    selection = choose("Select employee to interact with: ", scanner, 1, employees.size());
                    selectedEmployee = employees.get(selection-1);
                    break;
                default:
                    scanner.close();
                    System.exit(0);
            }
            do {
                boolean modifyEmployee = false;
                selection = -1;
                selection = choose("""
                    Please choose the action you'd like to perform:
                    1. Display Employee Info (Name, Employee ID, etc)
                    2. Modify Employee Info
                    3. Remove Employee
                    0. Return to Main Menu
                    """,scanner,0,3);
                switch (selection){
                    case 1:
                        System.out.println("Employee number: " + selectedEmployee.getEmployeeNumber() + ". Name:" + selectedEmployee.getFullName());
                        System.out.println("Employed: " + selectedEmployee.getEmploymentYear());
                        System.out.println("Years employed: " + selectedEmployee.findYearsEmployed(CURRENT_YEAR));
                        System.out.println("Monthly Salary: " + selectedEmployee.getMonthlySalary() + ". Gross Salary: " + selectedEmployee.calculateGrossSalary());
                        System.out.println("Income lost to Taxes (Yearly): " + selectedEmployee.calculateYearlyTax());
                        System.out.println("Tax Percent: " + selectedEmployee.getTaxPercent() + ". Tax Deductible (Monthly): " + selectedEmployee.calculateTaxDeductible());
                        continue;
                    case 2:
                        selection = choose("""
                                1. Monthly Salary
                                2. Tax Percent
                                """, scanner,1,2);
                        switch(selection){
                            case 1:
                                System.out.println("Current Monthly Salary: " + selectedEmployee.getMonthlySalary());
                                selectedEmployee.setMonthlySalary(choose("Set New Monthly Salary: ", scanner, 0, 150000));
                                System.out.println("New Monthly Salary: " + selectedEmployee.getMonthlySalary());
                                break;
                            case 2:
                                System.out.println("Current Tax Percent: " + selectedEmployee.getTaxPercent());
                                selectedEmployee.setTaxPercent(choose("Set New Tax Percent: ", scanner, 0, 100));
                                System.out.println("New Tax Percent: " + selectedEmployee.getTaxPercent());
                                break;
                        }
                        continue;
                    case 3:
                        employees.remove(selectedEmployee);
                        System.out.println("Employee Removed");
                        break;
                }
                break;
            }while(true);
        }while(true);




//        Person john = new Person("John", "Jacob Jingleheimer Schmitt", 1900);
//
//        Person father = new Person("Your", "Father", 1969);
//        Person dan = new Person("Dirty", "Dan", 2002);
//        Employee employee1 = new Employee(john, 0001, 2000, 45400, 30);
//        Person hugh = new Person(userStringInput("Choose first name",scanner), userStringInput("Choose last name", scanner), choose("Enter Birth Year", scanner, 0,2024));
//
//        ArrayList<Person> persons = new ArrayList<>();
//        persons.add(john);
//        persons.add(joe);
//        persons.add(blue);
//        persons.add(father);
//        persons.add(dan);
//        persons.add(hugh);
//        persons.forEach((Person person) ->
//                System.out.println(person.getLastName() + ", " + person.getFirstName()));
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
    public static String userStringInput(String displayText, Scanner scanner) {
        System.out.println(displayText);
        return scanner.nextLine();
    }

    public static void createNewEmployee(ArrayList<Employee> employees, Scanner scanner) {
        scanner.nextLine();
        System.out.println("Input First Name:");
        String name = scanner.nextLine();
        System.out.println("Input Last Name:");
        String lastname = scanner.nextLine();
        System.out.println("Input Birth Year:");
        int birthYear = scanner.nextInt();
        Person newPerson = new Person(name, lastname, birthYear);
        Random random = new Random();
        int employeeNumber;
        do {
            employeeNumber = random.nextInt(1000,9999);
            for (Employee employee : employees) {
                if (employee.getEmployeeNumber() == employeeNumber) {
                    continue;
                }
            }
            break;
        }while(true);
        int employmentYear = choose("Input employment year",scanner,1920,2024);
        float monthlySalary = choose("Enter monthly salary in Kroner",scanner,0,150000);
        float taxPercent = choose("Enter employee tax percent",scanner,0,100);
        System.out.println("Employee created Successfully!");
        employees.add(new Employee(newPerson, employeeNumber, employmentYear, monthlySalary, taxPercent));
    }

    private static void setupEmployees(ArrayList<Employee> employees) {
        Person p1 = new Person("John", "Jacob Jingleheimer Schmitt", 1881);
        Person joe = new Person("Joe", "Cotton-Eye", 1050);
        Person blue = new Person("Blue", "Dabadeedabadie", 1990);
        Person mario = new Person("Mario", "Mario", 1981);
        Person luigi = new Person("Luigi", "Mario", 1982);

        ArrayList<Person> people = new ArrayList<>();
        people.add(p1);
        people.add(joe);
        people.add(blue);
        people.add(mario);
        people.add(luigi);
        Random random = new Random();

        people.forEach(p -> {
            employees.add(new Employee(p, random.nextInt(1000,9999),random.nextInt(1940,2024),random.nextInt(10000,100000),random.nextInt(0,100)));
        });

    }



}