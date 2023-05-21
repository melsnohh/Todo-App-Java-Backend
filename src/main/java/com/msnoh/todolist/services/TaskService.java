package com.msnoh.todolist.services;

import com.msnoh.todolist.Entity.ResponseTask;
import com.msnoh.todolist.Entity.Task;
import com.msnoh.todolist.Entity.TaskReceived;
import com.msnoh.todolist.Repositories.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public Task createTask(ResponseTask responseTask){
        Task task = new Task();
        task.setDescription(responseTask.getDescription());
        task.setName(responseTask.getName());
        task.setStatus(Task.TaskStatusEnum.valueOf("PENDING"));
        task.setDueDate(responseTask.getDueDate());
        return taskRepository.save(task);
    }

    public List<Task> createTask(ResponseTask[] responseTasks){

        List<Task> allSavedTasks = new ArrayList<>();

        for(ResponseTask responseTask: responseTasks){
            Task task = new Task();
            task.setDescription(responseTask.getDescription());
            task.setName(responseTask.getName());
            task.setStatus(Task.TaskStatusEnum.valueOf(responseTask.getStatus()));
            task.setDueDate(responseTask.getDueDate());
           Task savedTask = taskRepository.save(task);

           allSavedTasks.add(savedTask);

        }

        return allSavedTasks;
    }

    public List<Task> findAllTask(){
        return taskRepository.findAll();
    }

    public Optional<Task> findById(Long id){
        return taskRepository.findById(id);
    }

    public Optional<Task []> findByName(String name){
        return taskRepository.findByName(name);
    }

    public Optional<Task> findByNameAndId (String name, Long id){
        return taskRepository.findByNameAndId(name,id);
    }


    public Task updateTask(Task taskToUpdate){
        return taskRepository.save(taskToUpdate);
    }

    public void delete(Long id){
        taskRepository.deleteById(id);
    }

    public void deleteByNameAndId(String name, Long id){
        taskRepository.deleteByNameAndId(name, id);
    }
}
