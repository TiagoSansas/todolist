package com.sansasdev.todolist.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sansasdev.todolist.entities.Task;
import com.sansasdev.todolist.services.TaskService;

@RestController
@RequestMapping("tasks")
public class TaskController {

  @Autowired
  TaskService taskService;

  @GetMapping("/{name}")
  public ResponseEntity<Task> findByName(@PathVariable String name) {
    Task task = taskService.findByName(name);
    return ResponseEntity.ok(task);
  }

  @GetMapping
  public ResponseEntity<Page<Task>> findAll(Pageable pageable) {
    Page<Task> list = taskService.findAll(pageable);
    return ResponseEntity.ok(list);
  }
}