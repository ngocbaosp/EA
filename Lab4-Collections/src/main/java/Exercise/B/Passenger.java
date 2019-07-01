package Exercise.B;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private String country;
    @OneToMany
    @JoinColumn(name = "passengerId")
    @OrderColumn(name = "flightOrder")
    private List<Flight> flights = new ArrayList<>();


    public Passenger(String firstName, String lastName, String country) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", country='" + country + '\'' +
                ", flights=" + flights +
                '}';
    }

    public void addFlight(Flight flight)
    {
        flights.add(flight);
    }



}
