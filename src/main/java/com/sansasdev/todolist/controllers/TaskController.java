package com.sansasdev.todolist.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sansasdev.todolist.entities.Task;
import com.sansasdev.todolist.services.TaskService;

import jakarta.validation.Valid;

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

  @GetMapping("/{id}")
  public ResponseEntity<Task> findById(@PathVariable UUID id) {
    Task task = taskService.findById(id);
    return ResponseEntity.ok(task);
  }

  @GetMapping
  public ResponseEntity<Page<Task>> findAll(Pageable pageable) {
    Page<Task> list = taskService.findAll(pageable);
    return ResponseEntity.ok(list);
  }

  @PostMapping
  public ResponseEntity<Task> register(@Valid @RequestBody Task task) {
    taskService.register(task);
    return ResponseEntity.status(201).body(task);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Task> update(@Valid @RequestBody Task task, @PathVariable UUID id) {
    taskService.update(id, task);
    return ResponseEntity.noContent().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable UUID id) {
    taskService.delete(id);
    return ResponseEntity.noContent().build();
  }
}