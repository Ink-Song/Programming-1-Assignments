import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    Student testStudent = new Student("Dave");

    @org.junit.jupiter.api.Test
    void getName() {
        assertEquals("Dave", testStudent.getName());
    }

    @org.junit.jupiter.api.Test
    void getCompletedAssignments() {
        assertEquals(0, testStudent.getCompletedAssignments());
    }

    @org.junit.jupiter.api.Test
    void increaseCompletedAssignments() {
        testStudent.increaseCompletedAssignments(12);
        assertEquals(12, testStudent.getCompletedAssignments());
        testStudent.increaseCompletedAssignments(-12);
    }

    @org.junit.jupiter.api.Test
    void testToString() {
        assertEquals("[Name: Dave, Completed Assignments: 0]", testStudent.toString());
    }
}