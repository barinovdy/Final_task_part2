package View.Commands;

import View.ConsoleUI;

public class Finish extends Command{
    public Finish(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Завершить работу с базой данных";
    }

    @Override
    public void execute() {
        consoleUI.finishWork();
    }
}
