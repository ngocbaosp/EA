package Exercise.A;

import javax.persistence.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderId;

    @Temporal(TemporalType.DATE)
    private Date date;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    public Order(Date date) {
        this.date = date;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    public void addOrderLine(OrderLine orderLine)
    {
        orderLines.add(orderLine);
    }

    //Uni-directional Order-OrderLine
    //If not specified by default using Join Table
    @OneToMany
    @JoinColumn(name = "orderId")
    @OrderColumn(name = "sequence")
    private List<OrderLine> orderLines = new ArrayList<>();

}
