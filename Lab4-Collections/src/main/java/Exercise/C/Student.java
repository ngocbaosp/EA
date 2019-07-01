package Exercise.C;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
    @Id
    private long studentId;
    private String name;

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                '}';
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student(long studentId, String name) {
        this.studentId = studentId;
        this.name = name;
    }
}
