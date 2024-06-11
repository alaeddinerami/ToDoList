package com.Todolist.Todolist.controller;

import com.Todolist.Todolist.Model.Task;
import com.Todolist.Todolist.Service.TaskService;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
//    @Autowired
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
    this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getALlTasks(){
        return taskService.getAllTasks();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable int id){
        Task task = taskService.getTaskById(id);
        if(task == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(task);
    }
    @PostMapping
    public Task createTask(@RequestBody Task task){
        return taskService.saveTask(task);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable int id, @RequestBody Task taskDetails){
        Task task = taskService.getTaskById(id);
        if(task == null){
            return ResponseEntity.notFound().build();
        }
        task.setName(taskDetails.getName());
        task.setDescription(taskDetails.getDescription());
        task.setStatus(taskDetails.getStatus());
        Task updateTask = taskService.saveTask(task);
        return ResponseEntity.ok(updateTask);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable int id ) {
        Task task = taskService.getTaskById(id);
        if (task == null) {
            return ResponseEntity.notFound().build();
        }
        taskService.deleteTaskById(id);
        return ResponseEntity.noContent().build();
    }
    }

