package Exercise.A;

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


        Employee employee1 = new Employee("Bao Tran1","bt1@mum.edu");
        Employee employee2 = new Employee("Bao Tran2","bt2@mum.edu");


        Laptop laptop1 = new Laptop("Lenovo 01","Lenovo");
        Laptop laptop2 = new Laptop("HP 01","HP");

        Laptop laptop3 = new Laptop("Lenovo 03","Lenovo");
        Laptop laptop4 = new Laptop("HP 04","HP");

        employee1.addLaptop(laptop1);
        employee1.addLaptop(laptop2);
        employee2.addLaptop(laptop3);
        employee2.addLaptop(laptop4);


        System.out.println(employee1);

        em.persist(employee1);

        System.out.println(employee2);

        em.persist(employee2);


        TypedQuery<Employee> qry = em.createQuery("from Employee",Employee.class);

        List<Employee> result = qry.getResultList();

        System.out.println(result);


        em.getTransaction().commit();
        em.close();


    }
}
