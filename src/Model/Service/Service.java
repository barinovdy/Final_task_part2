package Model.Service;

import Model.Animals.*;
import Model.DB.AnimalRegistry;

import java.time.LocalDate;
import java.util.List;

public class Service {
    private AnimalRegistry animalRegistry;

    public Service() {
        animalRegistry = new AnimalRegistry();
    }

    public String addAnimal(String type, String name, LocalDate birthDate, List<String> commands) {
        Animal animal = null;
        switch (type.toLowerCase()) {
            case "dog":
                animal = new Dog(name, birthDate, commands);
                break;
            case "cat":
                animal = new Cat(name, birthDate, commands);
                break;
            case "hamster":
                animal = new Hamster(name, birthDate, commands);
                break;
            case "horse":
                animal = new Horse(name, birthDate, commands);
                break;
            case "camel":
                animal = new Camel(name, birthDate, commands);
                break;
            case "donkey":
                animal = new Donkey(name, birthDate, commands);
                break;
            default:
                return "Неизвестный тип животного.";
        }
        animalRegistry.addAnimal(animal);
        return "Животное добавлено успешно.";
    }

    public String sortByBirthdate() {
        List<Animal> sortedAnimals = animalRegistry.getAnimalsByBirthDate();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список животных по дате рождения:\n");
        for (Animal animal : sortedAnimals) {
            stringBuilder.append(animal.getName() + " - " + animal.getBirthDate() + " - " + animal.getType());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public String showAnimalCommands(String name) {
        List<String> commands = animalRegistry.getCommands(name);
        if (commands != null) {
            return "Команды для " + name + ": " + String.join(", ", commands);
        } else {
            return "Животное не найдено.";
        }
    }

    public String teachNewCommand(String name, String command) {
        boolean teached = animalRegistry.addCommand(name, command);
        if (teached) {
            return "Команда добавлена успешно.";
        } else {
            return "Животное не найдено.";
        }
    }

    public String countAnimal() {
        int count = animalRegistry.getTotalCount();
        return "Общее количество животных: " + count;
    }
}
