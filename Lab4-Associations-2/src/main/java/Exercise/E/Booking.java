package Exercise.E;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String des;
    private double price;

    public Booking(String des, double price) {
        this.des = des;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", des='" + des + '\'' +
                ", price=" + price +
                '}';
    }
}
