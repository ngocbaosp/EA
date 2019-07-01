package Exercise.A;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @OneToMany(mappedBy = "department")
    private List<Employee> employees = new ArrayList<>();

    public Department(String name) {
        this.name = name;
    }

    public void addEmployee(Employee employee)
    {
        employee.setDepartment(this);
        employees.add(employee);
    }

    public void removeEmployee(Employee employee)
    {
        employees.remove(employee);
        employee.setDepartment(null);
    }


    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", employees=" + employees +
                '}';
    }
}
