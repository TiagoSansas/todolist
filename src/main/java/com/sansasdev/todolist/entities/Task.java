package com.sansasdev.todolist.entities;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_task")
public class Task {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
  @Size(min = 10, max = 80, message = "Deve ter entre 3 a 80 caracteres")
  @NotBlank
  private String name;
  @Size(min = 3, max = 120, message = "Deve ter entre 3 a 120 caracteres")
  @NotBlank
  private String description;
  private boolean complete;

  public Task() {
  }

  public Task(UUID id, String name, String description, boolean complete) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.complete = complete;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public boolean isComplete() {
    return complete;
  }

  public void setComplete(boolean complete) {
    this.complete = complete;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}