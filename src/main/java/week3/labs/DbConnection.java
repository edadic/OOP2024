package week3.labs;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbConnection {
    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/lab3";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "12345678";


    private Connection connection = null;


    public DbConnection() {
        try {
            connection = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<TaskItem> getAllTasks() throws SQLException {
        List<TaskItem> tasks = new ArrayList<>();
        PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM tasks");
        try {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                TaskItem task = new TaskItem(resultSet.getInt("id"), resultSet.getString("task_description"), Status.valueOf(resultSet.getString("task_status")));
                tasks.add(task);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return tasks;
    }

    public List<TaskItem> getTasksById(int id) throws SQLException {
        List<TaskItem> tasks = new ArrayList<>();
        PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM tasks WHERE id = ?");
        try {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    TaskItem task = new TaskItem(resultSet.getInt("id"), resultSet.getString("task_description"), Status.valueOf(resultSet.getString("task_status")));
                    tasks.add(task);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return tasks;
    }

    public void createTask(TaskItem task) throws SQLException {
        PreparedStatement statement = this.connection.prepareStatement("INSERT INTO tasks (id, task_description, task_status) VALUES (?, ?, ?)");
        try {
            statement.setInt(1, task.getTaskId());
            statement.setString(2, task.getTaskDescription());
            statement.setString(3, task.getTaskStatus().toString());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateTaskDescription(int id, String newDescription) throws SQLException {
        PreparedStatement statement = this.connection.prepareStatement("UPDATE tasks SET task_description = ? WHERE id = ?");
        try {
            statement.setString(1, newDescription);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
