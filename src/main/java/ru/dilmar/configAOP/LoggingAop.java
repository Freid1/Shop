package ru.dilmar.configAOP;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import ru.dilmar.Start;


@Aspect
@Component
@Order(-40) // Очередность выполнения от -int до +int -40 0 10
public class LoggingAop {
    private Logger logger = LoggerFactory.getLogger(getClass().getName());
    @Pointcut("within(ru.dilmar..*)")
    public void loggingPointcut() {
    }
    @Pointcut("execution(* ru.dilmar.Start.*(..))") //метод мэен вызывается раньше чем запустится АОП
    public void loggingPointcut2() {
    }
    @Before("loggingPointcut()||loggingPointcut2()")
    public void loggingMethodBefore(JoinPoint joinPoint) {
        String theMethod = joinPoint.getSignature().toShortString();
       logger.info("=====>> in @Before: calling method: " + theMethod);
      /*  Object[] args = joinPoint.getArgs();
        for (Object tempArg : args) {
            logger.info("=====>> argument: " + tempArg);
        }*/

    }
    @After("loggingPointcut()||loggingPointcut2()")
    public void loggingMethodAfter(JoinPoint joinPoint) {
        String theMethod = joinPoint.getSignature().toShortString();
        logger.info("=====>> in @After: calling method: " + theMethod);

    }
}
