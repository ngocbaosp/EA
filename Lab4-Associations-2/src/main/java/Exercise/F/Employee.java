package Exercise.F;




import javax.persistence.*;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;
    @ManyToOne
    @JoinColumn(name = "officeId")
    private Office office;

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
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
