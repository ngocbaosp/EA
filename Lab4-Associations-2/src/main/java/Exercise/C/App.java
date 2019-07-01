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

        Course course = new Course("EA");

        Student student1 = new Student(1, "Phu Nguyen");
        Student student2 = new Student(2, "Long Nguyen");
        Student student3 = new Student(3, "Minh Nguyen");

        course.addStudent(student1);
        course.addStudent(student2);
        course.addStudent(student3);

        em.persist(student1);
        em.persist(student2);
        em.persist(student3);
        em.persist(course);


        Course course2 = new Course("Alg");

        Student student4 = new Student(4, "4. Phu Nguyen");
        Student student5 = new Student(5, "5. Long Nguyen");
        Student student6 = new Student(6, "6. Minh Nguyen");

        course2.addStudent(student4);
        course2.addStudent(student5);
        course2.addStudent(student6);

        em.persist(student4);
        em.persist(student5);
        em.persist(student6);
        em.persist(course2);


        TypedQuery<Course> qry = em.createQuery("from Course", Course.class);

        List<Course> result = qry.getResultList();

        System.out.println(result);

        TypedQuery<Student> qry2 = em.createQuery("from Student", Student.class);

        List<Student> result2 = qry2.getResultList();

        System.out.println(result2);


        em.getTransaction().commit();
        em.close();


    }
}
