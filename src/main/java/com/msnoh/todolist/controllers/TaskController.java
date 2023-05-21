package com.msnoh.todolist.controllers;

import com.msnoh.todolist.Entity.ResponseTask;
import com.msnoh.todolist.Entity.Task;
import com.msnoh.todolist.Entity.TaskReceived;
import com.msnoh.todolist.services.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@CrossOrigin()
public class TaskController {

    public TaskService taskService;

    @PostMapping("users/{username}/tasks")
    public ResponseEntity<List<Task>> createdTasks(@RequestBody ResponseTask[] responseTask){

        return new ResponseEntity<>(taskService.createTask(responseTask), HttpStatus.OK);

    }
    @PostMapping("users/{username}/tasks/task")
    public ResponseEntity<Task> createdTasks(@RequestBody ResponseTask responseTask){

        return new ResponseEntity<>(taskService.createTask(responseTask), HttpStatus.OK);

    }

    @GetMapping("users/tasks")
    public ResponseEntity<List<Task>> getAllTasks(){
        return new ResponseEntity<>(taskService.findAllTask(), HttpStatus.CREATED);
    }

    @GetMapping("users/{name}/tasks")
    public ResponseEntity<Task[]> getTaskByName(@PathVariable String name){
        Optional<Task[]> optionalTask = taskService.findByName(name);

        if(optionalTask.isPresent()){
            return new ResponseEntity<>(optionalTask.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("users/{name}/tasks/{id}")
    public ResponseEntity<Task> getTaskByNameAndId(@PathVariable String name, @PathVariable Long id){
        Optional<Task> optionalTask = taskService.findByNameAndId(name, id);

        if(optionalTask.isPresent()){
            return new ResponseEntity<>(optionalTask.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @GetMapping("users/tasks/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id){
        Optional<Task> optionalTask = taskService.findById(id);

        if(optionalTask.isPresent()){
            return new ResponseEntity<>(optionalTask.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PutMapping("/users/{username}/tasks/{id}")
    public ResponseEntity<Task> addTaskById(@PathVariable Long id, @RequestBody Task newUpdateInfo){
        Optional<Task> optionalTask = taskService.findById(id);

        if(optionalTask.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Task taskToBeUpdated = optionalTask.get();

        taskToBeUpdated.setDescription(newUpdateInfo.getDescription());
        taskToBeUpdated.setDueDate(newUpdateInfo.getDueDate());

        Task taskUpdated = taskService.updateTask(taskToBeUpdated);

        return new ResponseEntity<>(taskUpdated, HttpStatus.OK);
    }

    @DeleteMapping("users/{username}/tasks/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable String username, @PathVariable Long id){
        taskService.deleteByNameAndId(username, id);
        return ResponseEntity.noContent().build();
    }

}
