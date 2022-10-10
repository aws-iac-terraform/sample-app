package com.example.containersampleapp.business;

import java.util.List;
import java.util.Optional;

import com.example.containersampleapp.business.model.Task;

public interface TaskService {
    List<Task> findAll();

    Optional<Task> findById(Long id);

    Task register(Task task);

    Task update(Task task);

    void deleteById(Long id);

    List<Task> search(String name);
}
