package zaliczenie.wzorceProjekt.commands;

import zaliczenie.wzorceProjekt.models.Rent.Rent;

public class AddRentCommand extends RentCommand{

    public AddRentCommand(Rent rent) {
        super(rent);
    }

    @Override
    public void undo() {
        rentsRepository.delete(rent);
    }

    @Override
    public Boolean execute() {
        rentsRepository.save(rent);
        return true;
    }
}