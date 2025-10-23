# HabitForge - Daily Habit Tracker

## Short Description
HabitForge is a simple and user-friendly Java application designed to help you manage and track your daily habits. Whether you want to build new habits or break old ones, HabitForge makes it easy to keep a consistent record of your progress.

## Features
- **Add New Habits:** Easily add new habits to your list.
- **Log Habit Completion:** Mark the days when you complete a habit.
- **View All Habits:** See a list of all your habits and their completion history.
- **View Habit History:** Get detailed information about a specific habit, including its creation date and completion dates.
- **Persistent Data Storage:** Your habit data is saved to a file, so you won't lose your progress even if you close the application.

## Usage Instructions
1. **Clone the Repository:**
   ```sh
   git clone https://github.com/DDurgeshmahajan/HabitForge.git
   ```

2. **Compile the Java Files:**
   ```sh
   cd HabitForge
   javac *.java
   ```

3. **Run the Application:**
   ```sh
   java Main
   ```

4. **Using the Application:**
   - **Add a New Habit:**
     - Choose option `1` from the menu.
     - Enter the name of the new habit.
   - **Log Habit Completion:**
     - Choose option `2` from the menu.
     - Enter the name of the habit you completed.
     - Enter the date in the format `YYYY-MM-DD`.
   - **View All Habits:**
     - Choose option `3` from the menu.
   - **View Habit History:**
     - Choose option `4` from the menu.
     - Enter the name of the habit you want to view.
   - **Exit the Application:**
     - Choose option `5` from the menu.

## Dependencies
- **Java:** Ensure you have Java installed on your system. You can download it from the official [Oracle website](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html).

## Example/Preview
- **Main Menu:**
  ```
  --- HabitForge - Daily Tracker ---
  1. Add New Habit
  2. Log Habit Completion
  3. View All Habits
  4. View Habit History
  5. Exit
  ----------------------------------
  Enter your choice: 
  ```
- **Adding a New Habit:**
  ```
  Enter habit name: Jogging
  Habit 'Jogging' added successfully.
  ```
- **Logging Habit Completion:**
  ```
  Enter habit name: Jogging
  Enter date (YYYY-MM-DD): 2023-10-28
  Completion logged successfully.
  ```
- **Viewing All Habits:**
  ```
  Name: Jogging, Created: 2023-10-28, Completed: []
  ```
- **Viewing Habit History:**
  ```
  Enter habit name: Jogging
  Name: Jogging, Created: 2023-10-28, Completed: [2023-10-28]
  ```

## Contact / Author
- **Name:** Durgesh Mahajan
- **Email:** ashamahajan955@gmail.com

If you have any questions, suggestions, or feedback, feel free to reach out to me!