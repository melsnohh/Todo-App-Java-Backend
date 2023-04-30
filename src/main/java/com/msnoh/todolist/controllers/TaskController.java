package com.msnoh.todolist.controllers;

import com.msnoh.todolist.Entity.Task;
import com.msnoh.todolist.services.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class TaskController {

    public TaskService taskService;

    @PostMapping("/tasks")
    public ResponseEntity<Task> createdTask(@RequestBody Task task){

        return new ResponseEntity<>(taskService.createTask(task), HttpStatus.CREATED);
    }

    @GetMapping("/tasks")
    public ResponseEntity<List<Task>> getAllTasks(){
        return new ResponseEntity<>(taskService.findAllTask(), HttpStatus.CREATED);
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id){
        Optional<Task> optionalTask = taskService.findById(id);

        if(optionalTask.isPresent()){
            return new ResponseEntity<>(optionalTask.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PutMapping("/tasks/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id, @RequestBody Task newUpdateInfo){
        Optional<Task> optionalTask = taskService.findById(id);

        if(optionalTask.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Task taskToBeUpdated = optionalTask.get();

        taskToBeUpdated.setStatus(newUpdateInfo.getStatus());
        taskToBeUpdated.setDueDate(newUpdateInfo.getDueDate());

        Task taskUpdated = taskService.updateTask(taskToBeUpdated);

        return new ResponseEntity<>(taskUpdated, HttpStatus.OK);
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id){
        taskService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
