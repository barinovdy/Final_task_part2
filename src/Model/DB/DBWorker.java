package Model.DB;

import Model.Animals.*;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static Model.DB.DBConnection.getConnection;

public class DBWorker {
    public void saveAnimal(Animal animal) {
        String sql = "INSERT INTO Animals (name, type, birthDate, commands) VALUES (?, ?, ?, ?)";
        try (Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, animal.getName());
            pstmt.setString(2, animal.getType());
            pstmt.setDate(3, Date.valueOf(animal.getBirthDate()));
            pstmt.setString(4, String.join(", ", animal.getCommands()));
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Animal> loadAllAnimals() {
        List<Animal> animals = new ArrayList<>();
        String sql = "SELECT * FROM Animals";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                String type = rs.getString("Type");
                String name = rs.getString("Name");
                LocalDate birthDate = rs.getDate("BirthDate").toLocalDate();
                List<String> commands = Arrays.asList(rs.getString("Commands").split(",\\s*"));
                switch (type) {
                    case "Dog":
                        animals.add(new Dog(name, birthDate, commands));
                        break;
                    case "Cat":
                        animals.add(new Cat(name, birthDate, commands));
                        break;
                    case "Hamster":
                        animals.add(new Hamster(name, birthDate, commands));
                        break;
                    case "Horse":
                        animals.add(new Horse(name, birthDate, commands));
                        break;
                    case "Camel":
                        animals.add(new Camel(name, birthDate, commands));
                        break;
                    case "Donkey":
                        animals.add(new Donkey(name, birthDate, commands));
                        break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return animals;
    }
}
