import java.util.Arrays;
public final class Matrix {
    // Object Variables
    private final int[][] matrix;

    // Constructor Function
    public Matrix(int[][] matrix) {
        this.matrix = matrix;
    }

    // Check if Matrices are Compatible (for addition)
    public boolean MatricesAreAlike(Matrix other){
//        if(matrix.length != other.matrix.length || matrix[0].length != other.matrix[0].length){
//            return false;
//        }
//        else{
//            return true;
//        }
        return matrix.length == other.matrix.length && matrix[0].length == other.matrix[0].length;

    }

    // Math Functions
    public Matrix addMatrices(Matrix other) {
        if(!MatricesAreAlike(other)){
            return null;
        }
        Matrix result = new Matrix(matrix);
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                result.matrix[i][j] = this.matrix[i][j] + other.matrix[i][j];
            }
        }
        return result;
    }
    //Multiplication
    public Matrix multiplyMatrices(Matrix other) {
        if(this.matrix[0].length != other.matrix.length){ // Check whether matrices fulfill requirement for matrix multiplication.
            return null;
        }
        Matrix result = new Matrix(new int[this.matrix.length][other.matrix[0].length]);
        for(int i = 0; i < result.matrix.length; i++){ // Iterate through Result matrix rows
            for(int j = 0; j < result.matrix[0].length; j++){ // Iterate through Result matrix columns
                for(int k = 0; k < this.matrix[0].length; k++){ // Iterate through Matrix A positions
                    result.matrix[i][j] += this.matrix[i][k] * other.matrix[k][j]; // Write sum result of operations to Current Result Matrix position.
                }
            }
        }
        return result;

    }
    // Swap points outside central diagonal.
    public Matrix transpose(){
        Matrix result = new Matrix(new int[this.matrix[0].length][this.matrix.length]);
        for(int i = 0; i < result.matrix.length; i++){
            for(int j = 0; j < result.matrix[0].length; j++){
                result.matrix[i][j] = this.matrix[j][i];
            }
        }
        return result;
    }
    // Retrieve Matrix.
    public int[][] getMatrix(){
        return this.matrix;
    }

    // Print out matrix formatted such that it displays cleanly in the Terminal.
    public String PrintMatrix(){
        //System.out.println(Arrays.deepToString(this.matrix).replace("], ", "]\n"));
        return Arrays.deepToString(this.matrix).replace("], ", "]\n");
    }

}
