package Model.DB;

import Model.Animals.Animal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AnimalRegistry {
    private List<Animal> animals;
    private DBWorker dbWorker;

    public AnimalRegistry() {
        dbWorker = new DBWorker();
        animals = dbWorker.loadAllAnimals();
        Counter.setCount(animals.size());
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
        dbWorker.saveAnimal(animal);
        Counter.increment();
    }

    public List<String> getCommands(String animalName) {
        for (Animal animal : animals) {
            if (animal.getName().equalsIgnoreCase(animalName)) {
                return animal.getCommands();
            }
        }
        return null;
    }

    public boolean addCommand(String animalName, String command) {
        for (Animal animal : animals) {
            if (animal.getName().equalsIgnoreCase(animalName)) {
                animal.addCommand(command);
                return true;
            }
        }
        return false;
    }

    public List<Animal> getAnimalsByBirthDate() {
        List<Animal> sorted = new ArrayList<>(animals);
        sorted.sort(Comparator.comparing(Animal::getBirthDate));
        return sorted;
    }

    public int getTotalCount() {
        return Counter.getCount();
    }
}
