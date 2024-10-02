package Model.Animals;

import java.time.LocalDate;
import java.util.List;

public class Horse extends PackAnimals {

    public Horse(String name, LocalDate birthDate, List<String> commands) {
        super(name, birthDate, commands);
    }

    @Override
    public String getType() {
        return "Horse";
    }
}
