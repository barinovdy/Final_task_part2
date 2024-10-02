package View.Commands;

import View.ConsoleUI;

public class ShowAnimalCommands extends Command{
    public ShowAnimalCommands(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Вывести список команд животного";
    }

    @Override
    public void execute() {
        consoleUI.showAnimalCommands();
    }
}
