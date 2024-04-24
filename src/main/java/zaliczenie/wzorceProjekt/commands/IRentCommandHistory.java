package zaliczenie.wzorceProjekt.commands;

public interface IRentCommandHistory {
    void push(RentCommand command);
    RentCommand pop();
    boolean isEmpty();
}
