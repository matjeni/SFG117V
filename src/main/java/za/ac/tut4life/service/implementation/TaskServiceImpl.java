package za.ac.tut4life.service.implementation;


import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.tut4life.model.Task;
import za.ac.tut4life.repository.TaskRepository;
import za.ac.tut4life.service.TaskService;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task getTaskById(Long taskId) {
        Optional<Task> optionalTask = taskRepository.findById(taskId);
        return optionalTask.get();
    }

    @Override
    public List<Task> getAllTasks() {
        return (List<Task>) taskRepository.findAll();
    }

    @Override
    public Task updateTask(Task task) {
        Task currentTask = taskRepository.findById(task.getTaskID()).get();
        currentTask.setTaskDescription(task.getTaskDescription());
        currentTask.setTaskName(task.getTaskName());
        currentTask.setTaskStartDate(task.getTaskStartDate());
        currentTask.setTaskEndDate(task.getTaskEndDate());
        currentTask.setTaskStatus(task.getTaskStatus());
        Task updatedTask = taskRepository.save(currentTask);
        return updatedTask;
    }

    @Override
    public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);

    }
}
