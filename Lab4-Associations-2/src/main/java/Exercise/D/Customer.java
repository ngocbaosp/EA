package Exercise.D;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @OneToMany
    @JoinColumn
    private List<Reservation> reservations = new ArrayList<>();

    public void addReservation(Reservation reservation)
    {
        reservations.add(reservation);
    }


    public Customer(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", reservations=" + reservations +
                '}';
    }
}
