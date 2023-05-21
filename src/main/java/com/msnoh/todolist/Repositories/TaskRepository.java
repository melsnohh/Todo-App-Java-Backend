package com.msnoh.todolist.Repositories;

import com.msnoh.todolist.Entity.Task;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query(nativeQuery = true, value="SELECT * FROM Task.task WHERE name=:name")
    Optional<Task[]> findByName(@Param("name") String name);

    @Query(nativeQuery = true, value="SELECT * FROM Task.task WHERE name=:name AND id=:id ")
    Optional<Task> findByNameAndId(@Param("name") String name, @Param("id") Long id);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value="DELETE FROM Task.task WHERE name=:name AND id=:id ")
    void deleteByNameAndId(@Param("name") String name, @Param("id") Long id);
}
