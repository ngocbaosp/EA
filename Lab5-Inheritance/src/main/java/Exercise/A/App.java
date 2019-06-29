package Exercise.A;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

public class App {

    private static EntityManagerFactory emf;

    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("cs544");


        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Product product1 = new Product("EA Book", "EA Book");
        Product product2 = new Product("Alg Book", "Alg Book");

        Product product3 = new Product("CD 01", "CD 01");
        Product product4 = new Product("CD 02", "CD 02");


        OrderLine orderLine1 = new OrderLine(1);
        orderLine1.setProduct(product1);
        OrderLine orderLine2 = new OrderLine(2);
        orderLine2.setProduct(product2);

        OrderLine orderLine3 = new OrderLine(3);
        orderLine3.setProduct(product3);
        OrderLine orderLine4 = new OrderLine(4);
        orderLine4.setProduct(product4);

        Order order1 = new Order(new Date());
        Order order2 = new Order(new Date());

        order1.addOrderLine(orderLine1);
        order1.addOrderLine(orderLine2);

        order2.addOrderLine(orderLine3);
        order2.addOrderLine(orderLine4);


        System.out.println(orderLine1);
        System.out.println(orderLine2);
        System.out.println(orderLine3);
        System.out.println(orderLine4);



        Customer customer = new Customer("Bao", "Tran");
        customer.addOrder(order1);
        customer.addOrder(order2);


        //persist
        em.persist(product1);
        em.persist(product2);
        em.persist(product3);
        em.persist(product4);

        em.flush();



        em.persist(orderLine1);
        em.persist(orderLine2);
        em.persist(orderLine3);
        em.persist(orderLine4);
        em.flush();

        em.persist(order1);
        em.persist(order2);

        em.persist(customer);

        em.getTransaction().commit();
        em.close();


    }
}
