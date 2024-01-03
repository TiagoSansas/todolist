package com.sansasdev.todolist.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sansasdev.todolist.entities.Task;
import com.sansasdev.todolist.repositories.TaskRepository;
import com.sansasdev.todolist.services.exceptions.ResourceNotFoundException;

import jakarta.transaction.Transactional;

@Service
public class TaskService {

  @Autowired
  TaskRepository taskRepository;

  @Transactional
  public Page<Task> findAll(Pageable pageabele) {
    Page<Task> list = taskRepository.findAll(pageabele);
    return list;
  }

  @Transactional
  public Task findById(UUID id) {
    return taskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Tarefa não localizada"));
  }

  @Transactional
  public Task findByName(String name) {
    Task task = taskRepository.findByName(name)
        .orElseThrow(() -> new ResourceNotFoundException("Tarefa não localizada"));
    return task;

  }

  @Transactional
  public Task register(Task task) {
    return taskRepository.save(task);

  }

  @Transactional
  public Task update(UUID id, Task task) {
    Task taskUpdate = findById(id);
    taskUpdate.setName(task.getName());
    taskUpdate.setDescription(task.getDescription());
    taskUpdate.setComplete(task.isComplete());
    return taskRepository.save(taskUpdate);
  }

  @Transactional
  public void delete(UUID id) {
    this.findById(id);
    taskRepository.deleteById(id);
  }
}
