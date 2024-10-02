
import View.ConsoleUI;
import View.ConsoleView;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ConsoleView consoleView = new ConsoleUI();
        consoleView.start();
    }
}