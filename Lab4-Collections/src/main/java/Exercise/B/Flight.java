package Exercise.B;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String flightNo;
    private String departureAirport;
    private String arrivalAirport;
    @Temporal(TemporalType.TIMESTAMP)
    private Date departureTime;
    private Date arrivalTime;

    public Flight(String flightNo, String departureAirport, String arrivalAirport, Date departureTime, Date arrivalTime) {
        this.flightNo = flightNo;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", flightNo='" + flightNo + '\'' +
                ", departureAirport='" + departureAirport + '\'' +
                ", arrivalAirport='" + arrivalAirport + '\'' +
                ", departureTime=" + departureTime +
                ", arrivalTime=" + arrivalTime +
                '}';
    }
}
