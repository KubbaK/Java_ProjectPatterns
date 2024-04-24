package zaliczenie.wzorceProjekt.commands;

import java.util.Stack;

// Tydzień 7, Zasada pojedynczej odpowiedzialności
// Klasa jest odpowiedzialna za zarządzanie historią poleceń (RentCommand).
public class RentCommandHistory implements  IRentCommandHistory{
    private Stack<RentCommand> history = new Stack<>();

    public void push(RentCommand command) {
        history.push(command);
    }

    public RentCommand pop() {
        if (!history.isEmpty()) {
            return history.pop();
        } else {
            return null;
        }
    }

    public boolean isEmpty() {
        return history.isEmpty();
    }
}
//Koniec Tydzień 7, Zasada pojedynczej odpowiedzialności