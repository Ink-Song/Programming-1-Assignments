import java.util.Scanner;

public class MultiDimensionalArrayTest {

    // String Declarations for use later.
    static String PROGRAM_TYPE = """
            (1) Pre-Made
            (2) Custom
            """;
    static String ACTION_CHOICE = """
                (1): Add matrices
                (2): Multiply Matrices
                (3): Transpose Your Matrix
                """;
    static String ADDITIONTEXT = "Matrix 1 + Matrix 2 = ";
    static String MULTIPLICATIONTEXT = "Matrix 1 x Matrix 2 = ";
    static String TRANSPOSITIONTEXT = "Matrix 1 transposed = ";
    static String CONTINUETEXT = """
            Would you like to continue?
            (1) Yes
            (0) No
            """;
    // Int Declarations for use in defining Matrix Dimensions.
    static int MIN = 0;
    static int MAX = 12;


    public static void main(String[] args) {
        // Initialize Variables
        Scanner in = new Scanner(System.in);
        Matrix matrix1;
        Matrix matrix2;
        Matrix matrix3;

        // Declare Pre-defined matrices
        int[][] matrix4_base = {
                {2,0,1,4},
                {7,1,0,3}
        };
        int[][] matrix5_base = {
                {8,2,0,1},
                {9,7,3,3}
        };
        int[][] matrix6_base = {
                {1,2,3},
                {0,5,4},
                {7,8,1},
                {4,0,2}
        };
        // Build pre-defined matrices
        Matrix matrix4 = new Matrix(matrix4_base);
        Matrix matrix5 = new Matrix(matrix5_base);
        Matrix matrix6 = new Matrix(matrix6_base);

        int userSelection;

        // Start Program Loop
        do {

            System.out.println("Pre-set Matrices or custom?");
            // Decide function
            userSelection = getUserInput(PROGRAM_TYPE, in, 2,1);

            switch(userSelection){
                case 1:
                    System.out.println("What would you like to do?");
                    userSelection = getUserInput(ACTION_CHOICE, in, 3,0);
                    switch(userSelection){
                        case 1:
                            matrix3 = matrix4.addMatrices(matrix5);
                            outputResult(matrix3, ADDITIONTEXT);
                            break;
                        case 2:
                            matrix3 = matrix4.multiplyMatrices(matrix6);
                            outputResult(matrix3, MULTIPLICATIONTEXT);
                            break;
                        case 3:
                            System.out.println("Matrix 4 before transposition");
                            System.out.println(matrix4.PrintMatrix());
                            System.out.println("Matrix 4 after transposition");
                            matrix3 = matrix4.transpose();
                            outputResult(matrix3, TRANSPOSITIONTEXT);
                        case 0:
                            in.close();
                            return;
                        default:
                            in.close();
                            return;
                    }

                    break;
                case 2:
                    // Program begins
                    System.out.println("First Create a Matrix");

                    //Create First Matrix
                    matrix1 = CreateMatrix(in, 1);

                    //Display First Matrix in Terminal
                    System.out.println("Matrix 1:");
                    System.out.println(matrix1.PrintMatrix());

                    // Choose an action to perform on the matrix.
                    System.out.println("Now, what would you like to do?");
                    userSelection = getUserInput(ACTION_CHOICE,in,3,0);
                    switch(userSelection){
                        case 1: // Create Second Matrix and add the two together. Result is stored in third Matrix.
                            matrix2 = CreateMatrix(in, 2);
                            System.out.println("Matrix 2:");
                            System.out.println(matrix2.PrintMatrix());
                            matrix3 = matrix1.addMatrices(matrix2);
                            outputResult(matrix3, ADDITIONTEXT);
                            break;
                        case 2: // Create second matrix and multiply it against the First. Result is stored in Third Matrix.
                            matrix2 = CreateMatrix(in, 2);
                            System.out.println("Matrix 2:");
                            System.out.println(matrix2.PrintMatrix());
                            matrix3 = matrix1.multiplyMatrices(matrix2);
                            outputResult(matrix3, MULTIPLICATIONTEXT);
                            break;
                        case 3: // Transpose First matrix, store result in Third Matrix.
                            matrix3 = matrix1.transpose();
                            outputResult(matrix3, TRANSPOSITIONTEXT);
                            break;
                        case 0: // Close input scanner and exit program.
                            in.close();
                            return;
                        default: // In the event that anything goes wrong, will default to a safe shutdown.
                            in.close();
                            return;
                    }
                    // After results are displayed, ask user if they want to continue.
                    // If yes, loop repeats. If no, program closes.
                    userSelection = getUserInput(CONTINUETEXT,in,1,0);
                    if(userSelection == 0){
                        in.close();
                        return;
                }
                default:
                    in.close();
                    return;
            }
        }while(true);
    }

    // Function for outputting the result of a performed action.
    public static void outputResult(Matrix m, String displayText){
        if(m != null){
            System.out.println(displayText);
            System.out.println(m.PrintMatrix());
            return;
        }
        else{
            System.out.println("Error: The two matrices could not be added.");
            return;
        }
    }

    // Function for Generating a random matrix based on User Dimensions.
    // Currently limited to 0-10.
    public static Matrix GenerateRandomMatrix(int[][] inputMatrix){
        for (int i = 0; i < inputMatrix.length; i++) {
            for (int j = 0; j < inputMatrix[i].length; j++) {
                inputMatrix[i][j] = (int) (Math.random() * 10);
            }
        }
        return new Matrix(inputMatrix);
    }

    // Takes a prompt and returns an integer within a given range.
    public static int getUserInput(String displayText, Scanner input, int max, int min) {
        int selection = -90;
        do {
            System.out.println(displayText);
            while(!input.hasNextInt()){
                System.out.println("Please enter an integer in range " + min + " to " + max);
            }
            selection = input.nextInt();
        } while (selection > max || selection < min);
        return selection;
    }

    // Define the dimensions of the Matrix.
    public static int[][] defineMatrix(Scanner input) {
        return new int[inputMatrixLength(input, "Rows")][inputMatrixLength(input,"Columns")];
    }

    // Matrix input. Functionally no different to get user input. Should refactor and combine.
    public static int inputMatrixLength(Scanner input, String displayText) {
        int selection = MAX + 1;
        do {
            System.out.println("Please enter number of " + displayText);
            selection = input.nextInt();
        } while(selection > MAX || selection < MIN+1);
        return selection;
    }

    // Outputs an array. Mostly unused, should either remove or replace.
    public static void PrintArray(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
        }
    }

    // Function for Maually getting the definitions of a matrix.
    public static Matrix ManualMatrix(int[][] inputMatrix, Scanner input){
        String display = "";
        for (int i = 0; i < inputMatrix.length; i++) {
            for (int j = 0; j < inputMatrix[i].length; j++) {
                PrintArray(inputMatrix);
                display = "Input number for location m" + i + " n" + j;
                inputMatrix[i][j] = getUserInput(display, input, 10,-10);
            }
        }
        return new Matrix(inputMatrix);
    }


    // Main function that handles what to do with a matrix. Calls other subsequent functions.
    public static Matrix CreateMatrix(Scanner input,int matrixnumber){
        Matrix matrix;
        boolean finished = false;

        System.out.println("Building Matrix " + matrixnumber + ".");
        int selector = getUserInput("(1) Generate Matrix or (2) Create Manually? - (0): Exit Program", input, 2,0);
        if(selector == 0){
            input.close();
            System.exit(0);
        }
        return switch (selector) {
            case 1 -> matrix = GenerateRandomMatrix(defineMatrix(input));
            case 2 -> matrix = ManualMatrix(defineMatrix(input), input);
            default -> throw new RuntimeException("Whoops, something went wrong");
        };
    }
}
