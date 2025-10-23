/*
 * Author: Durgesh Mahajan
 * Date: 2023-10-26
 * Project: HabitForge
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HabitManager {
    private List<Habit> habits;
    private String dataFilePath;

    public HabitManager(String filePath) {
        this.dataFilePath = filePath;
        this.habits = new ArrayList<>();
        loadHabits();
    }

    public void addHabit(String habitName) {
        LocalDate today = LocalDate.now();
        if (habits.stream().noneMatch(h -> h.getName().equalsIgnoreCase(habitName))) {
            habits.add(new Habit(habitName, today));
            saveHabits();
            System.out.println("Habit '" + habitName + "' added successfully.");
        } else {
            System.out.println("Error: Habit '" + habitName + "' already exists.");
        }
    }

    public boolean logCompletion(String habitName, LocalDate date) {
        Habit habit = getHabit(habitName);
        if (habit != null) {
            habit.markCompleted(date);
            saveHabits();
            return true;
        }
        return false;
    }

    public List<Habit> getAllHabits() {
        return Collections.unmodifiableList(habits);
    }

    public Habit getHabit(String habitName) {
        return habits.stream().filter(h -> h.getName().equalsIgnoreCase(habitName)).findFirst().orElse(null);
    }

    public void saveHabits() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(dataFilePath))) {
            for (Habit habit : habits) {
                String completionDatesStr = String.join(",", habit.getCompletionDates().stream()
                        .map(LocalDate::toString)
                        .collect(Collectors.toList()));
                writer.write(habit.getName() + ";" + habit.getCreationDate() + ";" + completionDatesStr + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error saving habits: " + e.getMessage());
        }
    }

    public void loadHabits() {
        habits.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(dataFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 3) {
                    String name = parts[0];
                    LocalDate creationDate = LocalDate.parse(parts[1]);
                    List<LocalDate> completionDates = new ArrayList<>();
                    if (!parts[2].isEmpty()) {
                        for (String dateStr : parts[2].split(",")) {
                            completionDates.add(LocalDate.parse(dateStr));
                        }
                    }
                    habits.add(new Habit(name, creationDate));
                    habits.get(habits.size() - 1).getCompletionDates().addAll(completionDates);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading habits: " + e.getMessage());
        }
    }
}