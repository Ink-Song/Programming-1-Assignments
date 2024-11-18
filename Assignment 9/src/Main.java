import java.util.Scanner;

public class Main {
    private final static String MAIN_MENU_TEXT = """
            1. Register a New Student
            2. Increase Completed Assignments for a Student
            0. Exit Program
            """;
    public static void main(String[] args) {
        AssignmentOversight assignmentOversight = new AssignmentOversight(10);
        Scanner scanner = new Scanner(System.in);
        int selection;

        do {
            assignmentOversight.printList();
            System.out.println("\n" + "****** WHAT WOULD YOU LIKE TO DO? ******");
            selection = choose(MAIN_MENU_TEXT, scanner, 0, 2);
            switch (selection) {
                case 1:
                    assignmentOversight.addStudent(makeNewStudent(scanner));
                    break;
                case 2:
                    increaseAssignments(scanner, assignmentOversight);
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    scanner.close();
                    System.exit(0);
            }
        }while(true);
    }

    /**
     * @param displayText String that offers users a numbered list of items to choose from.
     * @param scanner Scanner used for User Input.
     * @param min The lowest selection that the user can make. Ensures that they don't select an option that's out of bounds.
     * @param max Highest selection the user can make.
     * @return Returns an integer to be used as user selection.
     */
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

    /**
     * @param scanner Scanner is used to allow user to input their own name.
     * @return Returns a new Student Object.
     */
    public static Student makeNewStudent(Scanner scanner) {
        scanner.nextLine();
        System.out.println("What name should the student have?");
        String name = scanner.nextLine();
        return new Student(name);
    }

    public static void increaseAssignments(Scanner scanner, AssignmentOversight assignmentOversight) {
        System.out.println("Select a student: ");
        int selection = choose(assignmentOversight.toString(), scanner, 1, assignmentOversight.getNumberOfStudents()+1) - 1;
        int newAssignments = choose("Input how many new assignments have been completed (Max 100): ",scanner,-100,100);
        assignmentOversight.increaseNumberOfCompletedAssignmentsForStudent(selection, newAssignments);
    }

}