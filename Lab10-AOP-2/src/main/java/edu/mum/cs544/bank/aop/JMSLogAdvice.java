package edu.mum.cs544.bank.aop;


import edu.mum.cs544.bank.logging.ILogger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class JMSLogAdvice {
    @Autowired
    private ILogger logger;

    public void setLogger(ILogger logger) {
        this.logger = logger;
    }


    @After("execution(* edu.mum.cs544.bank.jms.*.*(..))")
    public void logJMSMessage(JoinPoint joinpoint) {

        logger.log("method =  " + joinpoint.getSignature().getName());

        //b
        Object objects[] = joinpoint.getArgs();
        logger.log("message =  " + objects[0]);


    }
}
