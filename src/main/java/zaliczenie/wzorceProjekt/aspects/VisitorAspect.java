package zaliczenie.wzorceProjekt.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import zaliczenie.wzorceProjekt.models.CombustionCar;
import zaliczenie.wzorceProjekt.models.ElectricCar;
//Tydzień 11 - Programowanie aspektowe, logowanie wizytatora
@Aspect
@Component
public class VisitorAspect {
    @Before("execution(* VisitElectricCar(..))")
    public void logBeforeVisitElectricCar() {
        System.out.println("Visiting electric car");
    }

    @Before("execution(* VisitCombustionCar(..))")
    public void logBeforeVisitCombustionCar() {
        System.out.println("Visiting combustion car");
    }
}
//Koniec tygodnia 11 - Programowanie aspektowe, logowanie wizytatora