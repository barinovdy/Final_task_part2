package View.Commands;

import View.ConsoleUI;

public class CountAnimals extends Command{
    public CountAnimals(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Вычислить количество животных в базе данных";
    }

    @Override
    public void execute() {
        consoleUI.countAnimal();
    }
}
