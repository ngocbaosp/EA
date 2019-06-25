package book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class AppBook {


    private static EntityManagerFactory emf;

    public void createBooks(EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Date date = new Date();

        // Create 3 books save them to the database
        Book book1 = new Book("Book1", "111", "Wick", 111, date);
        // save the car
        em.persist(book1);

        Book book2 = new Book("Book2", "222", "Wick", 222, date);
        // save the car
        em.persist(book2);

        Book book3 = new Book("Book3", "333", "Wick", 333, date);
        // save the car
        em.persist(book3);


        em.getTransaction().commit();
        em.close();
    }

    public List<Book> retrieveAllBook(EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<Book> query = em.createQuery("from Book", Book.class);
        List<Book> list = query.getResultList();

        em.getTransaction().commit();
        em.close();

        return list;

    }


    public void retrieveAll(EntityManagerFactory emf) {

        List<Book> list = retrieveAllBook(emf);
        for (Book book : list) {
            System.out.println("title= " + book.getTitle() + ", isbn= "
                    + book.getISBN() + ", price= " + book.getPrice());
        }
    }


    public void updateBook(EntityManagerFactory emf) {

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<Book> query = em.createQuery("FROM Book", Book.class);
        List<Book> list = query.getResultList();


        //change one book
        Book book = list.get(0);
        book.setTitle("New title");
        book.setPrice(123445);
        em.merge(book);

        //remove the last one
        book = list.get(list.size() - 1);
        em.remove(book);


        em.getTransaction().commit();
        em.close();

    }


    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("cs544");

        AppBook appBook = new AppBook();

        appBook.createBooks(emf);
        appBook.retrieveAll(emf);

        appBook.updateBook(emf);
        appBook.retrieveAll(emf);


    }
}

