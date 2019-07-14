package edu.mum.cs544;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class LogAspect {
    private static Logger logger = LogManager.getLogger(LogAspect.class.getName());


    @After("execution(* EmailSender.*(..))")
    public void logAfter(JoinPoint joinpoint) {

        //a
        logger.warn("method =  " + joinpoint.getSignature().getName());

        //b
        Object objects[] = joinpoint.getArgs();
        logger.warn("address =  " + objects[0]);
        logger.warn("message =  " + objects[1]);
        //c
        EmailSender emailSender = (EmailSender) joinpoint.getTarget();
        logger.warn("outgoing mail server =  " + emailSender.getOutgoingMailServer());

    }

    //d
    @Around("execution(* CustomerDAO.save(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {

        StopWatch sw = new StopWatch();
        sw.start(pjp.getSignature().getName());
        Object retVal = pjp.proceed();
        sw.stop();
        long totaltime = sw.getLastTaskTimeMillis();
        // print the time to the console
        logger.warn("Time to execute save =  " + totaltime);
        return retVal;

    }


}
