package Exercise.B;


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


        Passenger passenger = new Passenger("Phu", "Nguyen", "VN");


        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(2019, 06, 30, 10, 20, 00);

        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(2019, 06, 30, 16, 20, 00);


        Calendar calendar3 = Calendar.getInstance();
        calendar3.set(2019, 07, 01, 10, 20, 00);

        Calendar calendar4 = Calendar.getInstance();
        calendar4.set(2019, 07, 01, 16, 20, 00);

        Flight flight1 = new Flight("AA123", "SGN", "NRT", calendar1.getTime(), calendar2.getTime());
        Flight flight2 = new Flight("AA3456", "NRT", "JFK", calendar3.getTime(), calendar4.getTime());


        passenger.addFlight(flight1);
        passenger.addFlight(flight2);


        em.persist(flight1);
        em.persist(flight2);

        em.persist(passenger);


        TypedQuery<Passenger> qry = em.createQuery("from Passenger", Passenger.class);

        List<Passenger> result = qry.getResultList();

        System.out.println(result);


        em.getTransaction().commit();
        em.close();


    }
}
