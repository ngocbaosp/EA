package Exercise.C;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {
    @Id
    private long studentId;
    private String name;
    @ManyToMany
    private List<Course> courses = new ArrayList<>();

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                '}';
    }

    public void addCourse(Course course)
    {
        courses.add(course);
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
