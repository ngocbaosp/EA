package Exercise.C;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.Calendar;
import java.util.List;

public class App {

    private static EntityManagerFactory emf;

    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("cs544");


        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        School school = new School("MUM");

        Student student1 = new Student(1, "Phu Nguyen");
        Student student2 = new Student(2, "Long Nguyen");
        Student student3 = new Student(3, "Minh Nguyen");

        school.addStudent(student1);
        school.addStudent(student2);
        school.addStudent(student3);

        em.persist(student1);
        em.persist(student2);
        em.persist(student3);
        em.persist(school);


        School school2 = new School("MUM-IA");

        Student student4 = new Student(4, "4. Phu Nguyen");
        Student student5 = new Student(5, "5. Long Nguyen");
        Student student6 = new Student(6, "6. Minh Nguyen");

        school2.addStudent(student4);
        school2.addStudent(student5);
        school2.addStudent(student6);

        em.persist(student4);
        em.persist(student5);
        em.persist(student6);
        em.persist(school2);


        TypedQuery<School> qry = em.createQuery("from School", School.class);

        List<School> result = qry.getResultList();

        System.out.println(result);

        em.getTransaction().commit();
        em.close();


    }
}
