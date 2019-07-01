package Exercise.F;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Office {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @OneToMany(mappedBy = "office")
    private List<Employee> employees = new ArrayList<>();

    public Office(String name) {
        this.name = name;
    }

    public void addEmployee(Employee employee)
    {
        employee.setOffice(this);
        employees.add(employee);
    }

    public void removeEmployee(Employee employee)
    {
        employees.remove(employee);
        employee.setOffice(null);
    }


    @Override
    public String toString() {
        return "Office{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", employees=" + employees +
                '}';
    }
}
