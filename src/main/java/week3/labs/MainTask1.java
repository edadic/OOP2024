package week3.labs;

public class MainTask1 {

    public static void main(String[] args) {
        DataStructures dataStructures = new DataStructures();

        System.out.println("All tasks:");
        dataStructures.getTasks().forEach(System.out::println);

        System.out.println("\nTasks with status IN_PROGRESS:");
        dataStructures.getByStatus(Status.IN_PROGRESS).forEach(System.out::println);

        System.out.println("\nTasks with id >= 2:");
        dataStructures.getTaskIdGreaterThanEqual(2).forEach(System.out::println);

        System.out.println("\nTask descriptions:");
        dataStructures.printTaskDescription();
    }
}
