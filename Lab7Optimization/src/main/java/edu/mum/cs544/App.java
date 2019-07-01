package edu.mum.cs544;

import java.util.List;

import javax.persistence.*;

public class App {

    private static EntityManagerFactory emf;

    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("cs544");

        long start = System.nanoTime();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        /*-------------d1----------------
        TypedQuery<Owner> query = em.createQuery("from Owner o join fetch o.pets", Owner.class);
        List<Owner> ownerlist = query.getResultList();
        for (Owner o : ownerlist) {
            o.getPets().size();
        }
        ---------------------*/

        /*-------------d2---------------
        TypedQuery<Owner> query = em.createNamedQuery("Owner.Pet", Owner.class);
        List<Owner> ownerlist = query.getResultList();
        for (Owner o : ownerlist) {
            o.getPets().size();
        }

         --------------------------------*/

        EntityGraph<Owner> graph = em.createEntityGraph(Owner.class);
        graph.addAttributeNodes("pets");

        TypedQuery<Owner> query = em.createQuery("from Owner", Owner.class);

        query.setHint("javax.persistence.fetchgraph", graph);

        List<Owner> ownerlist = query.getResultList();
        for (Owner o : ownerlist) {
            o.getPets().size();
        }


        em.getTransaction().commit();
        em.close();
        long stop = System.nanoTime();

        // stop time
        System.out.println("To fetch this data from the database took " + (stop - start) / 1000000 + " milliseconds.");
        System.exit(0);

        /*
        Without optimal: To fetch this data from the database took 33861 milliseconds.
         */

        /*--------Exercise a-----------------

        Add the @LazyCollection with option EXTRA to the association and run App again.
        To fetch this data from the database took 22397 milliseconds.

         --------------------------------------*/

        /*--------Exercise b-----------------

        @BatchSize(size = 10)
        To fetch this data from the database took 21781 milliseconds.

        @BatchSize(size = 5)
        To fetch this data from the database took 21956 milliseconds.

        @BatchSize(size = 50)
        To fetch this data from the database took 19531 milliseconds.

         --------------------------------------*/

        /*--------Exercise c-----------------

	    @Fetch(FetchMode.SUBSELECT)
        To fetch this data from the database took 19950 milliseconds.

         --------------------------------------*/

        /*--------Exercise d-----------------

        TypedQuery<Owner> query = em.createQuery("from Owner o join fetch o.pets", Owner.class);
        To fetch this data from the database took 19009 milliseconds.


        TypedQuery<Owner> query = em.createNamedQuery("Owner.Pet", Owner.class);
        To fetch this data from the database took 20841 milliseconds.

        --------------------------------------*/


        /*--------Exercise e-----------------

         EntityGraph<Owner> graph = em.createEntityGraph(Owner.class);
        graph.addAttributeNodes("pets");

        TypedQuery<Owner> query = em.createQuery("from Owner", Owner.class);

        query.setHint("javax.persistence.fetchgraph", graph);
        To fetch this data from the database took 17541 milliseconds.
        --------------------------------------*/


    }

}


