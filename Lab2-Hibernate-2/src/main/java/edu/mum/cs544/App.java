package edu.mum.cs544;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class App {


    private static EntityManagerFactory emf;


    public void addStudent(EntityManagerFactory emf) {
        
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();


        int id = (int) Math.floor(Math.random() * 1000);

        Students st = new Students(id, "Wick", "wick@mum.edu", "123456");

        em.persist(st);


        em.getTransaction().commit();
        em.close();
    }

    public List<Students> retrieveAllStudent(EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<Students> query = em.createQuery("from edu.mum.cs544.Students", Students.class);
        List<Students> list = query.getResultList();

        em.getTransaction().commit();
        em.close();

        return list;

    }


    public void retrieveAll(EntityManagerFactory emf) {

        List<Students> list = retrieveAllStudent(emf);
        for (Students st : list) {
            System.out.println("studentname= " + st.getName());
        }
    }


    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("cs544");

        App app = new App();

        app.retrieveAll(emf);

        app.addStudent(emf);
        app.retrieveAll(emf);


    }
}

