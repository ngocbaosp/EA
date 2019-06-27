package edu.mum.dao.impl;


import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import edu.mum.dao.UserDao;
import edu.mum.domain.User;

import java.util.Date;


@SuppressWarnings("unchecked")
@Repository
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {


    @Override
    public void flushTest() {

        System.out.println("---------------Begin flush test---------------");

        String email = "tran1@mum.edu";

        User user = new User("Bao1", "Tran", email, 1, true, 1, new Date());

        System.out.println("1");
        save(user);
        System.out.println("2");
        user = findByEmail(email);
        System.out.println("3");
        delete(user);
        System.out.println("4");
        System.out.println("5");
        entityManager.flush();

        user.setId(null);
        user.setFirstName("BaoBao1");

        save(user);
        System.out.println("6");

        System.out.println("---------------End flush test---------------");
    }

    @Override
    public void refreshTest() {
        System.out.println("---------------Begin refresh test---------------");

        String email = "tran3@mum.edu";

        User user = new User("Bao3", "Tran", email, 1, true, 1, new Date());

        System.out.println("1");
        save(user);
        System.out.println("2");
        user = findByEmail(email);
        System.out.println("3");
        user.setFirstName("BaoBaoBao");

        System.out.println("4");
        save(user);
        System.out.println("5");
        entityManager.refresh(user);
        System.out.println("6");

        System.out.println("---------------End refresh test---------------");

    }

    public User findByEmail(String email) {

        Query query = entityManager.createQuery("select u from User u  where u.email =:email");
        return (User) query.setParameter("email", email).getSingleResult();


    }


}