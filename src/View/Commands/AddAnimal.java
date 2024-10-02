package View.Commands;

import View.ConsoleUI;

public class AddAnimal extends Command{
    public AddAnimal(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить животное в базу данных";
    }

    @Override
    public void execute() {
        consoleUI.addAnimal();
    }
}
