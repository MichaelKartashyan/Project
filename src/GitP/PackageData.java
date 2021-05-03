package GitP;

import java.io.Serializable;
import java.util.ArrayList;

public class PackageData implements Serializable {
    private String operationType;
    private  ArrayList<Students> students = new ArrayList<>();
    private  Students student;

    public PackageData() {
    }

    public PackageData(String operationType) {
        this.operationType = operationType;
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

    public  void setStudents(Students student) {
        this.students.add(student);
    }

    public  void setAllStudents(ArrayList<Students> student) {
        this.students = student;
    }

    public  Students getStudent() {
        return student;
    }

    public  void setStudent(Students student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "operationType=' " + operationType;
    }
}
