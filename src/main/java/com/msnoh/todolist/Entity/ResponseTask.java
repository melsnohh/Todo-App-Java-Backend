package com.msnoh.todolist.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter

public class ResponseTask {
    private Long id;
    private String name;
    private String description;
    private String status;
    private LocalDate dueDate;
}
