package View;

import java.io.IOException;

public interface ConsoleView {
    void start() throws IOException, ClassNotFoundException;
    void printAnswer(String answer);
}
