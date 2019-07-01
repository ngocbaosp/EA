package Exercise.F;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class App {

    private static EntityManagerFactory emf;

    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("cs544");


        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Employee employee1 = new Employee("Quy1", "quy1@mum.edu");
        Employee employee2 = new Employee("Quy2", "quy2@mum.edu");
        Employee employee3 = new Employee("Quy3", "quy3@mum.edu");

        Office office1 = new Office("HR");
        Office office2 = new Office("IT");

        office1.addEmployee(employee1);
        office1.addEmployee(employee2);

        office2.addEmployee(employee3);


        em.persist(employee1);
        em.persist(employee2);
        em.persist(employee3);

        em.persist(office1);
        em.persist(office2);


        TypedQuery<Office> qry = em.createQuery("from Office", Office.class);

        List<Office> result = qry.getResultList();

        System.out.println(result);


        em.getTransaction().commit();
        em.close();


    }
}
