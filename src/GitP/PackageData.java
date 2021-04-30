package GitP;

import java.util.ArrayList;

public class PackageData {
    private String operationType;
    private static ArrayList<Students> students;
    private static Students student;

    public PackageData() {
    }

    public PackageData(String operationType, Students student) {
        this.operationType = operationType;
        this.student = student;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public ArrayList<Students> getStudents() {
        return students;
    }

    public void setStudents(Students student) {
        this.students.add(student);
    }

    public Students getStudent() {
        return student;
    }

    public void setStudent(Students student) {
        this.student = student;
    }
}
