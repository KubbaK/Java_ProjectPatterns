package zaliczenie.wzorceProjekt.commands;

import java.util.Stack;

public class RentCommandHistory {
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
