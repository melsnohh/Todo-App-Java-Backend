package com.msnoh.todolist.services;

import com.msnoh.todolist.Entity.Task;
import com.msnoh.todolist.Repositories.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public Task createTask(Task task){
        return taskRepository.save(task);
    }

    public List<Task> findAllTask(){
        return taskRepository.findAll();
    }

    public Optional<Task> findById(Long id){
        return taskRepository.findById(id);
    }

    public Task updateTask(Task taskToUpdate){
        return taskRepository.save(taskToUpdate);
    }

    public void delete(Long id){
        taskRepository.deleteById(id);
    }
}
