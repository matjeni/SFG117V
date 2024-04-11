package za.ac.tut4life.contoller;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import za.ac.tut4life.model.Task;
import za.ac.tut4life.service.TaskService;
import za.ac.tut4life.service.implementation.TaskServiceImpl;
import za.ac.tut4life.util.DateUtil;
import za.ac.tut4life.util.LoggerUtil;

import java.net.URI;
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
    public ResponseEntity<Task> getTaskById(@PathVariable("id") Long taskId){
        Task t = taskService.getTaskById(taskId);
        return new ResponseEntity<>(t,HttpStatus.OK);
    }

    @GetMapping("/")
    public String getTaskList(){
        //List<Task> taskList = taskService.getAllTasks();
        //return new ResponseEntity<>(taskList,HttpStatus.OK);
        LOGGER.LOG_INFO("hi",TaskController.class);
        return "hi";
    }
/*
    @GetMapping
    public ResponseEntity<String> updateTask(@PathVariable("id") Long taskId, @RequestBody Task task){
         taskService.deleteTask(taskId);
        return new ResponseEntity<>("Deleted successfully",HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Task> deleteTaskById(@PathVariable("id") Long taskId){
        Task t = taskService.getTaskById(taskId);
        return new ResponseEntity<>(t,HttpStatus.OK);
    }*/


}
