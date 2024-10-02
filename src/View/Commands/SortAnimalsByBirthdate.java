package View.Commands;

import View.ConsoleUI;

public class SortAnimalsByBirthdate extends Command{
    public SortAnimalsByBirthdate(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Отсортировать животных в базе данных по дате рождения";
    }

    @Override
    public void execute() {
        consoleUI.sortByBirthdate();
    }
}
