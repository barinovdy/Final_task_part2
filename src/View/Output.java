package View;

public class Output implements OutputView{
    @Override
    public void printMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void printErrorMessage() {
        printMessage("Вы ввели неверное значение.");
    }

    @Override
    public void printGreetingMessage() {
        printMessage("Добро пожаловать!\n" +
                "Начинаем работу с реестром животных.");
    }

    @Override
    public void printExitMessage() {
        printMessage("Работа с реестром животных завершена.\n" +
                "До новых встреч!");
    }

    @Override
    public void printDateFormatError() {
        printMessage("Ошибка. Неверный формат даты.");
    }
}
