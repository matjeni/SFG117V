package za.ac.tut4life.contoller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.tut4life.model.Task;
import za.ac.tut4life.service.TaskService;
import za.ac.tut4life.util.DateUtil;
import za.ac.tut4life.util.LoggerUtil;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/task/v1")
public class TaskController {

    @Autowired
    public TaskService taskService;
    public LoggerUtil LOGGER = new LoggerUtil();
    public DateUtil DATEUTIL = new DateUtil();

    @GetMapping(value = "/health-check")
    public String getHeaders(@RequestHeader Map<String, String> headers) {
        LOGGER.LOG_INFO("/health-check: was hit at: "+ DATEUTIL.getTime() +" by :", TaskController.class);
        headers.forEach((key, value) -> {
            LOGGER.LOG_INFO((String.format("Header '%s' = %s", key, value)), TaskController.class);
        });
        return "We are pumping!";
    }

   @PostMapping("/create/task")
    public ResponseEntity<Task> addTask(@RequestBody Task task){
        LOGGER.LOG_INFO("Endpoint /create/task/ : was hit at: "+ DATEUTIL.getTime() +" by : ", TaskController.class);
        Task savedtTask = taskService.createTask(task);
        return new ResponseEntity<>(savedtTask, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable("id") Long taskId, @RequestHeader Map<String, String> headers){
        LOGGER.LOG_INFO("Endpoint getTaskById : was hit at: "+ DATEUTIL.getTime() +" by : ", TaskController.class);
        Task t = taskService.getTaskById(taskId);
        LOGGER.LOG_INFO("Task Found: "+t.getTaskName(), TaskController.class);
        return new ResponseEntity<>(t,HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<Task>> getTaskList(){
        List<Task> taskList = taskService.getAllTasks();
        LOGGER.LOG_INFO(" getTaskList count :::::>> "+taskList.size(), TaskController.class);
        return new ResponseEntity<>(taskList,HttpStatus.OK);
    }

    @PostMapping("/update/task")
    public ResponseEntity<Task> updateTask(@RequestBody Task task,@RequestHeader Map<String, String> headers){
        LOGGER.LOG_INFO("Endpoint updateTask : was hit at: "+ DATEUTIL.getTime() +" by : ", TaskController.class);
        headers.forEach((key, value) -> {
            LOGGER.LOG_INFO((String.format("Header '%s' = %s", key, value)), TaskController.class);
        });
        Task t = taskService.updateTask(task);
        return new ResponseEntity<>(t,HttpStatus.OK);
    }

    @GetMapping("remove/{id}")
    public ResponseEntity<String> deleteTaskById(@PathVariable("id") Long taskId, @RequestHeader Map<String, String> headers){
        LOGGER.LOG_INFO("Endpoint deleteTaskById : was hit at: "+ DATEUTIL.getTime() +" by : ", TaskController.class);
        headers.forEach((key, value) -> {
            LOGGER.LOG_INFO((String.format("Header '%s' = %s", key, value)), TaskController.class);
        });
        taskService.deleteTask(taskId);
        return new ResponseEntity<>("Deleted for good!",HttpStatus.OK);
    }


}
