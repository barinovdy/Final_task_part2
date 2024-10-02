package View.Commands;

import View.ConsoleUI;

public class TeachNewCommand extends Command{
    public TeachNewCommand(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Выучить новую команду";
    }

    @Override
    public void execute() {
        consoleUI.teachNewCommand();
    }
}
