package zaliczenie.wzorceProjekt.commands;

import org.springframework.beans.factory.annotation.Autowired;
import zaliczenie.wzorceProjekt.models.Rent.Rent;
import zaliczenie.wzorceProjekt.repositories.RentsRepository;

//Tydzień 8, Odwrócenie zależności
public abstract class RentCommand {

    protected RentsRepository rentsRepository;
    public Rent rent;

    public RentCommand(Rent rent) {
        this.rent = rent;
    }

    public abstract void undo();
    public abstract Boolean execute();
}
//Koniec tydzień 8, Odwrócenie zależności