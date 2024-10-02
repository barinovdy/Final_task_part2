package Model.Animals;

import java.time.LocalDate;
import java.util.List;

public class Camel extends PackAnimals{

    public Camel(String name, LocalDate birthDate, List<String> commands) {
        super(name, birthDate, commands);
    }

    @Override
    public String getType() {
        return "Camel";
    }
}
