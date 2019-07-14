package edu.mum.cs544.bank.aop;


import edu.mum.cs544.bank.logging.ILogger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DAOLogAdvice {

    //private static Logger logger = LogManager.getLogger(DAOLogAdvice.class.getName());



    @Autowired
    private ILogger logger;

    public void setLogger(ILogger logger) {
        this.logger = logger;
    }


    @After("execution(* edu.mum.cs544.bank.dao.*.*(..))")
    public void logDAOCal(JoinPoint joinpoint) {

        logger.log("method =  " + joinpoint.getSignature().getName());
    }

}
