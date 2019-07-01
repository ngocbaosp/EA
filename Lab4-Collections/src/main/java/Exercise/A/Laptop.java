package Exercise.A;

import javax.persistence.*;

@Entity
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String brand;

    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                //", owner=" + owner +
                '}';
    }

    public Laptop()
    {

    }

    public Laptop(String name, String brand) {
        this.name = name;
        this.brand = brand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Laptop laptop = (Laptop) o;

        if (id != laptop.id) return false;
        if (!name.equals(laptop.name)) return false;
        if (!brand.equals(laptop.brand)) return false;
        return owner != null ? owner.equals(laptop.owner) : laptop.owner == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + name.hashCode();
        result = 31 * result + brand.hashCode();
        return result;
    }

    @ManyToOne
    private Employee owner;

    public void setOwner(Employee owner) {
        this.owner = owner;
    }
}
