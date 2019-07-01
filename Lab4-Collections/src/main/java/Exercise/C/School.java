package Exercise.C;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;




    @OneToMany
    @JoinColumn(name = "schoolId")
    @MapKeyColumn(name = "studentId")
    private Map<Long,Student> students = new HashMap<>();

    public School(String name) {
        this.name = name;
    }

    public void addStudent(Student student)
    {
        students.put(student.getStudentId(),student);
    }

    @Override
    public String toString() {
        return "School{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", students=" + students +
                '}';
    }
}
