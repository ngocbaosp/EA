package Exercise.E;


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

        Booking booking = new Booking("Book1", 1234);

        Booking booking2 = new Booking("Book2", 3456);

        Reservation reservation1 = new Reservation(new Date());
        Reservation reservation2 = new Reservation(new Date());

        reservation1.setBooking(booking);
        reservation2.setBooking(booking);


        Reservation reservation3 = new Reservation(new Date());
        Reservation reservation4 = new Reservation(new Date());

        reservation3.setBooking(booking2);
        reservation4.setBooking(booking2);


        em.persist(reservation1);
        em.persist(reservation2);
        em.persist(reservation3);
        em.persist(reservation4);

        em.persist(booking);
        em.persist(booking2);


        TypedQuery<Booking> qry = em.createQuery("from Booking", Booking.class);

        List<Booking> result = qry.getResultList();

        System.out.println(result);


        TypedQuery<Reservation> qry2 = em.createQuery("from Reservation", Reservation.class);

        List<Reservation> result2 = qry2.getResultList();

        System.out.println(result2);


        em.getTransaction().commit();
        em.close();


    }
}
