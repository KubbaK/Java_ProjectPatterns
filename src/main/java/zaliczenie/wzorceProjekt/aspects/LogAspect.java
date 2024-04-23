package zaliczenie.wzorceProjekt.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

    @Around("@annotation(zaliczenie.wzorceProjekt.aspects.Loggable)")
    public Object logWithMessage(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Loggable loggableAnnotation = signature.getMethod().getAnnotation(Loggable.class);
        String message = loggableAnnotation.message();

        System.out.println("Log message: " + message);

        return joinPoint.proceed();
    }

}
