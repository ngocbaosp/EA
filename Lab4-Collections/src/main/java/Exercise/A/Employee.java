package Exercise.A;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL,
    orphanRemoval = true)
    Set<Laptop> laptops = new HashSet<>();

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

        for(Laptop laptop:laptops)
            s = s + " " + laptop.toString();

        return s;
    }

    public void addLaptop(Laptop laptop) {
        laptop.setOwner(this);
        laptops.add(laptop);
    }

    public void removeLaptop(Laptop laptop) {
        laptops.remove(laptop);
        laptop.setOwner(null);

    }


}
