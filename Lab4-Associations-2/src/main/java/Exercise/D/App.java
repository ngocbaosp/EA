package Exercise.D;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class App {

    private static EntityManagerFactory emf;

    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("cs544");


        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();


        Reservation reservation1 = new Reservation(new Date());
        Reservation reservation2 = new Reservation(new Date());


        Reservation reservation3 = new Reservation(new Date());
        Reservation reservation4 = new Reservation(new Date());


        Customer customer1 = new Customer("Phu");

        Customer customer2 = new Customer("Minh");

        customer1.addReservation(reservation1);
        customer1.addReservation(reservation2);

        customer2.addReservation(reservation3);
        customer2.addReservation(reservation4);

        em.persist(reservation1);
        em.persist(reservation2);
        em.persist(reservation3);
        em.persist(reservation4);
        em.persist(customer1);
        em.persist(customer2);


        TypedQuery<Customer> qry = em.createQuery("from Customer", Customer.class);

        List<Customer> result = qry.getResultList();

        System.out.println(result);


        em.getTransaction().commit();
        em.close();


    }
}
