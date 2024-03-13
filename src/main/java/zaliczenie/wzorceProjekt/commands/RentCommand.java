package zaliczenie.wzorceProjekt.commands;

import org.springframework.beans.factory.annotation.Autowired;
import zaliczenie.wzorceProjekt.models.Rent;
import zaliczenie.wzorceProjekt.repositories.RentsRepository;

public abstract class RentCommand {
    @Autowired
    protected RentsRepository rentsRepository;
    public Rent rent;

    public RentCommand(Rent rent) {
        this.rent = rent;
    }

    public abstract void undo();
    public abstract Boolean execute();
}
