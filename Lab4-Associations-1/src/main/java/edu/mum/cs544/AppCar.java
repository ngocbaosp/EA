package edu.mum.cs544;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


public class AppCar {

    private static EntityManagerFactory emf;

    public void save(Object obj) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.persist(obj);
        em.getTransaction().commit();
        em.close();
    }

    public void CarTest() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        // Create new instance of Car and set values in it
        Car car1 = new Car("BMW", "SDA231", 30221.00);
        // save the car
        em.persist(car1);
        // Create new instance of Car and set values in it
        Car car2 = new Car("Mercedes", "HOO100", 4088.00);
        // save the car
        em.persist(car2);

        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();

        // retieve all cars
        TypedQuery<Car> query = em.createQuery("from Car", Car.class);
        List<Car> carList = query.getResultList();
        for (Car car : carList) {
            System.out.println("brand= " + car.getBrand() + ", year= "
                    + car.getYear() + ", price= " + car.getPrice());
        }
        em.getTransaction().commit();
        em.close();

    }

    public void OwerTest() {

        Owner obj = new Owner("Bao", "MUM");

        save(obj);
    }

    public void casCadeTestFail() {
        Car car1 = new Car("Toyota RAV4", "2019", 30221.00);
        Car car2 = new Car("Honda CRV", "2019", 4088.00);
        Owner owner = new Owner("Wick", "MUMVN");
        car1.setOwner(owner);
        car2.setOwner(owner);

        save(car1);
        //fail because owner object detached after save car1 so we can not pass it to car2
        save(car2);

    }


    public void casCadeTest() {
        Car car1 = new Car("Toyota RAV4", "2019", 30221.00);
        Car car2 = new Car("Honda CRV", "2019", 4088.00);
        Owner owner = new Owner("Wick", "MUMVN");
        car1.setOwner(owner);
        car2.setOwner(owner);

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.persist(car1);
        em.persist(car2);

        em.getTransaction().commit();
        em.close();


    }

    public void selectTest() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<Car> query = em.createQuery("from Car", Car.class);
        List<Car> carList = query.getResultList();
        for (Car car : carList) {
            System.out.println("brand= " + car.getBrand() + ", year= "
                    + car.getYear() + ", price= " + car.getPrice());
            System.out.println(car.getOwner());
        }

        em.getTransaction().commit();
        em.close();


    }

    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("cs544");

        AppCar app = new AppCar();

        //app.CarTest();

        app.OwerTest();


        //app.casCadeTestFail();


        app.casCadeTest();

        app.selectTest();


    }
}

