package edu.mum.cs544;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class StudentDAOHibernate {

    public Student load(long studentid) {

        EntityManager em = EntityManagerHelper.getCurrent();


        EntityGraph<Student> graph = em.createEntityGraph(Student.class);
        graph.addAttributeNodes("courselist");


        TypedQuery<Student> query = em.createQuery("from Student where id = :id", Student.class);
        query.setParameter("id", studentid);
        query.setHint("javax.persistence.fetchgraph", graph);

        return query.getSingleResult();

    }
}
