public class Student {
    private final String name;
    private int completedAssignments = 0;

    public Student(String name) {
        this.name = name;
    }
    public Student(String name, int completedAssignments) {
        this.name = name;
        this.completedAssignments = completedAssignments;
    }

    public String getName() {
        return name;
    }
    public int getCompletedAssignments() {
        return completedAssignments;
    }

    public void increaseCompletedAssignments(int assignments) {
        completedAssignments += assignments;
    }

    @Override
    public String toString() {
        return "[Name: " + getName() + ", Completed Assignments: " + getCompletedAssignments() + "]";
    }
}
