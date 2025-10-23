/*
 * Author: Durgesh Mahajan
 * Date: 2023-10-26
 * Project: HabitForge
 */

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HabitManager manager = new HabitManager("habits.txt");
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("--- HabitForge - Daily Tracker ---");
            System.out.println("1. Add New Habit");
            System.out.println("2. Log Habit Completion");
            System.out.println("3. View All Habits");
            System.out.println("4. View Habit History");
            System.out.println("5. Exit");
            System.out.println("----------------------------------");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter habit name: ");
                    String habitName = scanner.nextLine();
                    manager.addHabit(habitName);
                    break;
                case 2:
                    System.out.print("Enter habit name: ");
                    String habitNameForCompletion = scanner.nextLine();
                    System.out.print("Enter date (YYYY-MM-DD): ");
                    String dateStr = scanner.nextLine();
                    try {
                        LocalDate date = LocalDate.parse(dateStr, DateTimeFormatter.ISO_LOCAL_DATE);
                        if (manager.logCompletion(habitNameForCompletion, date)) {
                            System.out.println("Completion logged successfully.");
                        } else {
                            System.out.println("Error: Habit not found.");
                        }
                    } catch (DateTimeParseException e) {
                        System.out.println("Invalid date format. Please use YYYY-MM-DD.");
                    }
                    break;
                case 3:
                    List<Habit> allHabits = manager.getAllHabits();
                    if (allHabits.isEmpty()) {
                        System.out.println("No habits found.");
                    } else {
                        for (Habit habit : allHabits) {
                            System.out.println(habit);
                        }
                    }
                    break;
                case 4:
                    System.out.print("Enter habit name: ");
                    String habitNameForHistory = scanner.nextLine();
                    Habit habit = manager.getHabit(habitNameForHistory);
                    if (habit != null) {
                        System.out.println(habit);
                    } else {
                        System.out.println("Error: Habit not found.");
                    }
                    break;
                case 5:
                    running = false;
                    manager.saveHabits();
                    System.out.println("Exiting HabitForge. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        }
        scanner.close();
    }
}