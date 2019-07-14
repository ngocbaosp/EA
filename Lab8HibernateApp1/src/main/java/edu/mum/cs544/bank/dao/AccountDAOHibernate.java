package edu.mum.cs544.bank.dao;

import edu.mum.cs544.bank.domain.Account;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Collection;
import java.util.List;

public class AccountDAOHibernate implements IAccountDAO {

    @Override
    public void saveAccount(Account account) {
        EntityManager em = EntityManagerHelper.getCurrent();

        //em.getTransaction().begin();
        em.persist(account);
        //em.getTransaction().commit();

    }

    @Override
    public void updateAccount(Account account) {
        EntityManager em = EntityManagerHelper.getCurrent();

        //em.getTransaction().begin();
        em.merge(account);

        //em.getTransaction().commit();


    }

    @Override
    public Account loadAccount(long accountnumber) {
        EntityManager em = EntityManagerHelper.getCurrent();

        EntityGraph<Account> graph = em.createEntityGraph(Account.class);
        graph.addAttributeNodes("customer");
        graph.addAttributeNodes("entryList");

        TypedQuery<Account> query = em.createQuery("from Account where id = :id", Account.class);
        query.setParameter("id", accountnumber);
        query.setHint("javax.persistence.fetchgraph", graph);

        return query.getSingleResult();

        //return em.find(Account.class, accountnumber);

    }

    @Override
    public Collection<Account> getAccounts() {

        EntityManager em = EntityManagerHelper.getCurrent();


        TypedQuery<Account> query =
                em.createQuery("select distinct a from Account a join fetch a.entryList e join fetch a.customer c ", Account.class);
        return query.getResultList();

    }
}
