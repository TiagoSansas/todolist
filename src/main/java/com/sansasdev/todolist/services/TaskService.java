package com.sansasdev.todolist.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sansasdev.todolist.entities.Task;
import com.sansasdev.todolist.repositories.TaskRepository;

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
  public Task findByName(String name) {
    Task task = findByName(name);
    return task;
  }
}
