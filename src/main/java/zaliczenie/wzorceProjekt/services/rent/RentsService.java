package zaliczenie.wzorceProjekt.services.rent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import zaliczenie.wzorceProjekt.builders.RentBuilder;
import zaliczenie.wzorceProjekt.commands.AddRentCommand;
import zaliczenie.wzorceProjekt.commands.DeleteRentCommand;
import zaliczenie.wzorceProjekt.commands.RentCommand;
import zaliczenie.wzorceProjekt.commands.RentCommandHistory;
import zaliczenie.wzorceProjekt.dtos.RentCreateDto;
import zaliczenie.wzorceProjekt.exceptions.CarNotFoundException;
import zaliczenie.wzorceProjekt.exceptions.RentNotFoundException;
import zaliczenie.wzorceProjekt.models.Car;
import zaliczenie.wzorceProjekt.models.Rent.Rent;
import zaliczenie.wzorceProjekt.repositories.CarsRepository;
import zaliczenie.wzorceProjekt.repositories.RentsRepository;

public class RentsService extends RentServiceBase{
    @Autowired
    private RentCommandHistory rentCommandHistory;
    @Autowired
    private RentsRepository rentsRepository;
    @Autowired
    private CarsRepository carsRepository;

    @Override
    public ResponseEntity<String> createRent(RentCreateDto rentDto) {
        Car car = carsRepository.findById(rentDto.carId).orElseThrow(() -> new CarNotFoundException(rentDto.carId));
        var startDate = rentDto.startDate;
        var customerName = rentDto.customerName;

        var rentBuilder = new RentBuilder(car, customerName, startDate);
        RentCommand command = new AddRentCommand(rentBuilder.build());
        executeCommand(command);

        return ResponseEntity.ok("Rent created successfully.");
    }

    @Override
    public ResponseEntity<String> removeRent(int id) {
        Rent rent = rentsRepository.findById(id).orElseThrow(() -> new RentNotFoundException(id));

        RentCommand command = new DeleteRentCommand(rent);
        executeCommand(command);
        return ResponseEntity.ok("Rent deleted successfully.");
    }

    //Tydzień 5, Wzorzec Command i Memento, Command pozwala zamknąć całe żądanie wykonania konkretnej czynności w osobnym obiekcie.
    //Dzięki Memento łatwo można śledzić a nawet wycofywać zmiany
    private void executeCommand(RentCommand command) {
        if (command.execute()) {
            rentCommandHistory.push(command);
        }
    }

    @Override
    public void undo() {
        if (rentCommandHistory.isEmpty()) return;

        var command = rentCommandHistory.pop();
        if (command != null) {
            command.undo();
        }
    }
    //Koniec tydzien 5, Command i Memento
}
