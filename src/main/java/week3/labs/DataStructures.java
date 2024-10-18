package week3.labs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataStructures {
    private List<TaskItem> tasks = new ArrayList<>();

    public DataStructures() {
        tasks = Arrays.asList(
                new TaskItem(1,"Push lab code to the github", Status.TO_DO),
                new TaskItem(2,"Prepare for the quiz", Status.IN_PROGRESS),
                new TaskItem(3,"Go over tasks from lab2", Status.COMPLETED));
    }

    // TODO create a method to get all objects

    public List<TaskItem> getTasks() {
        return tasks;
    }

    // TODO create a method getByStatus that will accept a Status parameter and filter the tasks with the provided status

    public List<TaskItem> getByStatus(Status status) {
        List<TaskItem> filteredTasks = new ArrayList<>();
        for (TaskItem task : tasks) {
            if (task.getTaskStatus().equals(status)) {
                filteredTasks.add(task);
            }
        }
        return filteredTasks;
    }

    // TODO create a method to find tasks whose id parameter greater than or equal to 2

    public List<TaskItem> getTaskIdGreaterThanEqual(int id) {
        List<TaskItem> filteredTasks = new ArrayList<>();
        for (TaskItem task : tasks) {
            if (task.getTaskId() >= id) {
                filteredTasks.add(task);
            }
        }
        return filteredTasks;
    }

    // TODO create a method that will, by using the forEach stream method, print to the console the description of each task

    public void printTaskDescription() {
        tasks.forEach(task -> System.out.println(task.getTaskDescription()));
    }
}


