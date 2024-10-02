package View;

import View.Commands.MainMenu;
import Presenter.Presenter;

import javax.swing.text.BadLocationException;
import javax.swing.text.Position;
import javax.swing.text.View;
import java.awt.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ConsoleUI implements ConsoleView{
    private Scanner scanner;
    private Presenter presenter;
    private MainMenu mainMenu;
    private Output output;
    private boolean work;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        mainMenu = new MainMenu(this);
        output = new Output();
        work = true;
    }

    @Override
    public void start() throws IOException, ClassNotFoundException {
        output.printGreetingMessage();
        while(work){
            printMenu();
            workWithAnimalDB();
        }
    }

    public void addAnimal(){
        output.printMessage("Введите тип животного (Dog, Cat, Hamster, Horse, Camel, Donkey): ");
        String type = scanner.nextLine();
        output.printMessage("Введите имя животного: ");
        String name = scanner.nextLine();
        output.printMessage("Введите дату рождения (YYYY-MM-DD): ");
        String birthDateStr = scanner.nextLine();
        LocalDate birthDate = LocalDate.parse(birthDateStr);
        output.printMessage("Введите команды (через запятую): ");
        String commandsStr = scanner.nextLine();
        List<String> commands = Arrays.asList(commandsStr.split(",\\s*"));
        presenter.addAnimal(type, name, birthDate, commands);
    }

    public void countAnimal(){
        presenter.countAnimal();
    }

    public void showAnimalCommands(){
        output.printMessage("Введите имя животного: ");
        String name = scanner.nextLine();
        presenter.showAnimalCommands(name);
    }

    public void sortByBirthdate(){
        presenter.sortByBirthdate();
    }

    public void teachNewCommand(){
        output.printMessage("Введите имя животного: ");
        String name = scanner.nextLine();
        output.printMessage("Введите новую команду: ");
        String command = scanner.nextLine();
        presenter.teachNewCommand(name, command);
    }

    private void printMenu() {
        output.printMessage(mainMenu.menu());
    }

    private void workWithAnimalDB() throws IOException, ClassNotFoundException {
        String line = scanner.nextLine();
        if (checkTextForInt(line)){
            int numCommand = Integer.parseInt(line);
            if (checkCommand(numCommand)){
                mainMenu.execute(numCommand);
            }
        }
    }

    public void finishWork() {
        output.printExitMessage();
        work = false;
    }

    private boolean checkTextForInt(String text){
        if (text.matches("[0-9]+")){
            return true;
        } else {
            output.printErrorMessage();
            return false;
        }
    }

    private boolean checkCommand(int numCommand){
        if (numCommand <= mainMenu.getSize()){
            return true;
        } else {
            output.printErrorMessage();
            return false;
        }
    }

    @Override
    public void printAnswer(String answer) {
        output.printMessage(answer);
    }
}
