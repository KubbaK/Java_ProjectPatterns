package zaliczenie.wzorceProjekt.commands;

import zaliczenie.wzorceProjekt.models.Rent;

public class DeleteRentCommand extends RentCommand{

    public DeleteRentCommand(Rent rent) {
        super(rent);
    }

    @Override
    public void undo() {
        rentsRepository.save(rent);
    }

    @Override
    public Boolean execute() {
        rentsRepository.delete(rent);
        return true;
    }
}
