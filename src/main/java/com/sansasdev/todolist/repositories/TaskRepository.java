package com.sansasdev.todolist.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sansasdev.todolist.entities.Task;

public interface TaskRepository extends JpaRepository<Task, UUID> {

  Optional<Task> findByName(String name);

}
