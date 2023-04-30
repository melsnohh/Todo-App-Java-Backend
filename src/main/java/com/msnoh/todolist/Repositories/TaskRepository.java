package com.msnoh.todolist.Repositories;

import com.msnoh.todolist.Entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
