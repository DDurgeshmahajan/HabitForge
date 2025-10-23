/*
 * Author: Durgesh Mahajan
 * Date: 2023-10-26
 * Project: HabitForge
 */

import java.time.LocalDate;
import java.util.List;
import java.util.Collections;

public class Habit {
    private String name;
    private LocalDate creationDate;
    private List<LocalDate> completionDates;

    public Habit(String name, LocalDate creationDate) {
        this.name = name;
        this.creationDate = creationDate;
        this.completionDates = new java.util.ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public List<LocalDate> getCompletionDates() {
        return Collections.unmodifiableList(completionDates);
    }

    public void markCompleted(LocalDate date) {
        if (!completionDates.contains(date)) {
            completionDates.add(date);
            Collections.sort(completionDates);
        }
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Created: " + creationDate + ", Completed: " + completionDates;
    }
}