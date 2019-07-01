package Exercise.A;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

//@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;
    @ManyToOne
    @JoinColumn(name = "deptId")
    private Department department;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Employee(String name, String email) {
        this.name = name;
        this.email = email;
    }

    @Override
    public String toString() {
        String s= "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';


        return s;
    }



}
