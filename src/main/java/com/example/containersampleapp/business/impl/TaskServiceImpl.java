package com.example.containersampleapp.business.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.containersampleapp.business.TaskService;
import com.example.containersampleapp.business.model.Task;

import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {

    private static final List<Task> taskList = new ArrayList<>();

    static {
        taskList.add(new Task(1L, "run", false));
        taskList.add(new Task(2L, "eat", false));
        taskList.add(new Task(3L, "work", false));
        taskList.add(new Task(4L, "sleep", false));
    }

    @Override
    public List<Task> findAll() {
        return taskList;
    }

    @Override
    public Optional<Task> findById(Long id) {
        return taskList.stream().filter(x -> x.getId().equals(id)).findFirst();
    }

    @Override
    public Task register(Task task) {
        Optional<Task> searchedTask = findById(task.getId());
        if (searchedTask.isPresent()) {
            throw new IllegalArgumentException("既に存在します。");
        }

        Task newTask = new Task();
        newTask.setId(getMaxId());
        newTask.setName(task.getName());
        newTask.setCompleted(task.getCompleted());

        taskList.add(newTask);
        return newTask;
    }

    @Override
    public Task update(Task task) {
        Task searchedTask = findById(task.getId()).orElseThrow(() -> new IllegalArgumentException("データが存在しません"));

        taskList.remove(searchedTask);

        taskList.add(task);

        return task;
    }

    @Override
    public void deleteById(Long id) {
        Task searchedTask = findById(id).orElseThrow(() -> new IllegalArgumentException("データが存在しません"));
        taskList.remove(searchedTask);
    }

    Long getMaxId() {
        return taskList.stream().mapToLong(Task::getId).max().orElse(0) + 1L;
    }

    @Override
    public List<Task> search(String name) {
        return taskList.stream().filter(x -> x.getName().matches(".*" + name + ".*")).collect(Collectors.toList());
    }
}
