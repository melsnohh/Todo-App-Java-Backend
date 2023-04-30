package com.msnoh.todolist.controllers;

import com.msnoh.todolist.Entity.Task;
import com.msnoh.todolist.services.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class TaskController {

    public TaskService taskService;

    @PostMapping("/tasks")
    public ResponseEntity<Task> createdTask(@RequestBody Task task){

        return new ResponseEntity<>(taskService.createTask(task), HttpStatus.CREATED);
    }

}
