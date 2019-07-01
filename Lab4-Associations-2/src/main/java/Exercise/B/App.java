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

        Publisher publisher1 = new Publisher("IEEE");
        Publisher publisher2 = new Publisher("ACM");

        Book book1 = new Book("Book1",publisher1);
        Book book2 = new Book("Book2",publisher1);
        Book book3 = new Book("Book3",publisher2);
        Book book4 = new Book("Book4",publisher2);


        em.persist(publisher1);
        em.persist(publisher2);
        em.persist(book1);
        em.persist(book2);
        em.persist(book3);
        em.persist(book4);





        TypedQuery<Book> qry = em.createQuery("from Book", Book.class);

        List<Book> result = qry.getResultList();

        System.out.println(result);


        em.getTransaction().commit();
        em.close();


    }
}
