package aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
public class LoggingAspect {

  private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

  @After("@annotation(ToLog)")
  public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
    String methodName = joinPoint.getSignature().getName();
    Object[] arguments = joinPoint.getArgs();

    logger.info("the method " + methodName + " will run with the following arguments: " + Arrays.asList(arguments));

    Object returnedByMethod = joinPoint.proceed();

    return returnedByMethod;
  }

  public void setLogger(Logger logger) {
    this.logger = logger;
  }
}
