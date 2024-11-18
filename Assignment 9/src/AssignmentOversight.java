import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AssignmentOversight {
    // Object Variables
    private int numberOfStudents;
    private ArrayList<Student> students;
    private final StudentGenerator studentGenerator = new StudentGenerator();

    // Methods
    public AssignmentOversight(int numberOfPreGeneratedStudents) {
        numberOfStudents = numberOfPreGeneratedStudents;
        students = new ArrayList<>();
        for (int i = 0; i < numberOfPreGeneratedStudents; i++) {
            students.add(studentGenerator.makeStudent());
        }
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public int findNumberOfStudentsAssignment(Student student){
        return student.getCompletedAssignments();
    }

    public void addStudent(Student student) {
        students.add(student);
        numberOfStudents++;
    }

    /**
     *
     * @param studentNumber The index value of the Student object in the Array List. List starts at 0.
     * @param amount The amount by which you'd like to increase their number of completed assignments.
     */
    public void increaseNumberOfCompletedAssignmentsForStudent(int studentNumber,int amount) {
        students.get(studentNumber).increaseCompletedAssignments(amount);
    }

    @Override
    public String toString() {
        String numberOfStudentsInfo = "Number of Students: " + getNumberOfStudents();
        String studentInfo = IntStream.range(0,students.size())
                .mapToObj(i -> (i+1) + "." + students.get(i).toString())
                .collect(Collectors.joining("\n"));
        return numberOfStudentsInfo + "\n" + studentInfo;
    }

    public void printList(){
        System.out.println(this.toString());
    }
}
