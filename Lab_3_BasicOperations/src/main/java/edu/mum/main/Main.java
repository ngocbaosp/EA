package edu.mum.main;


import java.util.Date;
import java.util.List;

import edu.mum.dao.UserDao;
import edu.mum.dao.impl.UserDaoImpl;
import edu.mum.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.mum.domain.User;
import edu.mum.service.UserService;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public void addAndPrintUser(UserService userService) {

        String email = "tran@mum.edu";

        User user = new User("Bao", "Tran", email, 1, true, 1, new Date());

        userService.save(user);

        User u = userService.findByEmail(email);

        System.out.println("****************User****************");
        System.out.println("User name: " + u.getFirstName() + " " + u.getLastName());


    }

    public void updateUser(UserService userService) {
        System.out.println("****************Update User****************");

        String email = "tran@mum.edu";
        User u = userService.findByEmail(email);
        u.setFirstName("Updated successfully");

        User U1 = userService.update(u);
        System.out.println("****************User****************");
        System.out.println("User name: " + U1.getFirstName() + " " + U1.getLastName());


        try {

            System.out.println("****************Update Unmanaged User****************");
            //The user u was detached
            u.setFirstName("1234");
            User U2 = userService.update(u);

            System.out.println("****************User****************");
            System.out.println("User name: " + U2.getFirstName() + " " + U2.getLastName());
        } catch (Exception e) {
            System.out.println("****************Update fail****************");
            System.out.println(e.getMessage());
        }


    }

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath*:context/applicationContext.xml");
        UserService userService = (UserService) applicationContext.getBean("userServiceImpl");

        Main app = new Main();

        app.addAndPrintUser(userService);
        ////////////////////////////////
        app.updateUser(userService);

        ////////////////////////////////
        userService.flushTest();

        ////////////////////////////////
        userService.refeshTest();



    }

}