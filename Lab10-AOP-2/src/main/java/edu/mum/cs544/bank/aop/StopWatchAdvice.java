package edu.mum.cs544.bank.aop;


import edu.mum.cs544.bank.domain.Account;
import edu.mum.cs544.bank.domain.AccountEntry;
import edu.mum.cs544.bank.logging.ILogger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.Date;

@Aspect
@Component
public class StopWatchAdvice {

    @Autowired
    private ILogger logger;

    public void setLogger(ILogger logger) {
        this.logger = logger;
    }

    @Around("execution(* edu.mum.cs544.bank.service.*.*(..))")
    public Object methodTimer(ProceedingJoinPoint pjp) throws Throwable {

        StopWatch sw = new StopWatch();
        sw.start(pjp.getSignature().getName());
        Object retVal = pjp.proceed();
        sw.stop();
        long totaltime = sw.getLastTaskTimeMillis();
        // print the time to the console
        logger.log("Time to execute save =  " + totaltime);
        return retVal;

    }

    @Around("execution(* edu.mum.cs544.bank.service.AccountService.createAccount(..))")
    public Object proc(ProceedingJoinPoint pjp) throws Throwable {
        logger.log("method =  " + pjp.getSignature().getName());
        Object args[] = pjp.getArgs();
        args[1] = "BAOBAOBAO";
        Account retVal = (Account) pjp.proceed(args);
        logger.log("This is a new pro");
        retVal.deposit(2000000);
        return retVal;
    }

    @AfterReturning(value = "execution(* edu.mum.cs544.bank.service.AccountService.createAccount(..))", returning = "ret")
    public void afterReturn(JoinPoint joinPoint, Account ret) {
        System.out.println("AfterReturning");
        Object objects[] = joinPoint.getArgs();
        for (Object object : objects)
            System.out.println("object =  " + object);
        System.out.println(ret);

    }


}
