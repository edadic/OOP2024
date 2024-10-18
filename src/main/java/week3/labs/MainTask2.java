package week3.labs;


import java.sql.SQLException;

public class MainTask2 {
    public static void main(String[] args) {

        DbConnection dbConnection = new DbConnection();

        TaskItem newTask = new TaskItem(8, "Task 8", Status.COMPLETED);
        try {
            dbConnection.createTask(newTask);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.println("All tasks:");
        try {
            dbConnection.getAllTasks().forEach(System.out::println);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.println("\nTasks with id = 2:");
        try {
            System.out.println(dbConnection.getTasksById(2));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            dbConnection.updateTaskDescription(5, "Task 5 updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
