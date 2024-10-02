package Presenter;

import Model.Service.Service;
import View.ConsoleView;

import java.time.LocalDate;
import java.util.List;

public class Presenter {
    ConsoleView consoleView;
    Service service;

    public Presenter(ConsoleView consoleView) {
        this.consoleView = consoleView;
        service = new Service();
    }

    public void addAnimal(String type, String name, LocalDate birthDate, List<String> commands) {
        String output = service.addAnimal(type, name, birthDate, commands);
        consoleView.printAnswer(output);
    }

    public void showAnimalCommands(String name) {
        String output = service.showAnimalCommands(name);
        consoleView.printAnswer(output);
    }

    public void teachNewCommand(String name, String command) {
        String output = service.teachNewCommand(name, command);
        consoleView.printAnswer(output);
    }

    public void countAnimal() {
        String output = service.countAnimal();
        consoleView.printAnswer(output);
    }

    public void sortByBirthdate() {
        String output = service.sortByBirthdate();
        consoleView.printAnswer(output);
    }
}
