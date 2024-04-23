package zaliczenie.wzorceProjekt.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
    @Before("@annotation(zaliczenie.wzorceProjekt.aspects.Loggable)")
    public void log(){

        System.out.println("Executing log");
    }


    @Pointcut("within(zaliczenie.wzorceProjekt.services..*)")
    public void logBeforeService()
    {
        System.out.println("SERVICE CALLED");
    }


}
