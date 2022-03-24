package Stepanov.homework.Task21_SpringAOP.service.aspects;

import Stepanov.homework.Task21_SpringAOP.Task21SpringAopApplication;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CalculationAspect {

    private static final Logger log = LoggerFactory.getLogger(Task21SpringAopApplication.class);

    @Around("@annotation(Stepanov.homework.Task21_SpringAOP.service.LogMethod)")
    public Object around1(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("LogMethod! {}", joinPoint);
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            log.info("arg: {}", arg);
        }
        Object result = joinPoint.proceed();
        log.info("Return value: {}", result);
        return result;
    }

    @Around("@annotation(Stepanov.homework.Task21_SpringAOP.service.WorkTime)")
    public Object around2(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        log.info("WorkTime! {}", joinPoint.toString());
        Object result = joinPoint.proceed();
        log.info("Working time of the method: {}", System.currentTimeMillis() - start);
        return result;
    }
}
