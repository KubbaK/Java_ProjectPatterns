package zaliczenie.wzorceProjekt.aspects;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
//Tydzień 11 - Programowanie aspektowe, adnotacja loggable
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Loggable {
    String message() default "";
}
//Koniec tygodnia 11 - Programowanie aspektowe, logowanie wizytatora