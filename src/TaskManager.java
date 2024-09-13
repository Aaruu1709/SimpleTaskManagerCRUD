import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Task {
    private int id;
    private String name;
    private String description;

    public Task(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Task ID: " + id + ", Name: " + name + ", Description: " + description;
    }
}

public class TaskManager {
    private List<Task> tasks = new ArrayList<>();
    private int taskIdCounter = 1;

    public void createTask() {
        System.out.println("**********************************************************************************");
        System.out.println("^^^^^^^^^^^^^^^^^^^^TASK MANAGING APPLICATION^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter task name: ");
        String name = scanner.nextLine();
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();

        Task task = new Task(taskIdCounter++, name, description);
        tasks.add(task);
        System.out.println("************************* Task created successfully************************.");
    }

    public void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to display.");
        } else {
            for (Task task : tasks) {
                System.out.println(task);
            }
        }
    }

    public void updateTask() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the task ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume the newline

        for (Task task : tasks) {
            if (task.getId() == id) {
                System.out.print("Enter new task name: ");
                task.setName(scanner.nextLine());
                System.out.print("Enter new task description: ");
                task.setDescription(scanner.nextLine());
                System.out.println("Task updated successfully.");
                return;
            }
        }
        System.out.println("Task with the given ID not found.");
    }

    public void deleteTask() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the task ID to delete: ");
        int id = scanner.nextInt();

        Task taskToDelete = null;
        for (Task task : tasks) {
            if (task.getId() == id) {
                taskToDelete = task;
                break;
            }
        }

        if (taskToDelete != null) {
            tasks.remove(taskToDelete);
            System.out.println("Task deleted successfully.");
        } else {
            System.out.println("Task with the given ID not found.");
        }
    }

    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("1. Create Task");
            System.out.println("2. Display Tasks");
            System.out.println("3. Update Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    taskManager.createTask();
                    break;
                case 2:
                    taskManager.displayTasks();
                    break;
                case 3:
                    taskManager.updateTask();
                    break;
                case 4:
                    taskManager.deleteTask();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
