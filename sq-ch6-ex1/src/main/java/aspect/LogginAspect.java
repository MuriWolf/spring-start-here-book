package aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.logging.Level;
import java.util.logging.Logger;

@Aspect
public class LogginAspect {

    Logger logger = Logger.getLogger(LogginAspect.class.getName());

    @Around("execution(* service.*.*(..))")
    public void log(ProceedingJoinPoint joinPoint) throws Throwable {
        double random = Math.random();

        if (random >= 0.5) {
            logger.info("before proceeding with the method");
            joinPoint.proceed();
            logger.info("after the method runs");
        } else {
            logger.log(Level.WARNING, "You cannot access the method. Go other way.");
        }
    }
}
