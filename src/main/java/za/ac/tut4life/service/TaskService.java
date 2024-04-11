package za.ac.tut4life.service;

import org.springframework.stereotype.Service;
import za.ac.tut4life.model.Task;

import java.util.List;


public interface TaskService {

    Task createTask(Task task);

    Task getTaskById(Long taskId);

    List<Task> getAllTasks();

    Task updateTask(Task task);

    void deleteTask(Long taskId);
}
