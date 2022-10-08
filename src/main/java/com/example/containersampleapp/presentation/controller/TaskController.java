package com.example.containersampleapp.presentation.controller;

import java.util.List;

import com.example.containersampleapp.business.TaskService;
import com.example.containersampleapp.business.model.Task;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import io.swagger.annotations.ApiOperation;

@RequestMapping("api/v1/tasks")
@RequiredArgsConstructor
@RestController
@Slf4j
public class TaskController {
    
    private final TaskService service;

    @ApiOperation(value = "タスクを全件取得します")
    @GetMapping("/")
    List<Task> findAll() {
        log.info("findAll");
        return service.findAll();
    }

    @ApiOperation(value = "タスクを登録します")
    @PostMapping("/")
    Task register(@RequestBody Task task) {
        log.info("save insert");
        return service.register(task);
    }

    @ApiOperation(value = "タスクを1件取得します")
    @GetMapping("/{id}")
    Task findById(@PathVariable Long id) {
        log.info("findById");
        return service.findById(id).orElse(null);
    }

    @ApiOperation(value = "タスクを更新します")
    @PutMapping("/")
    Task update(@RequestBody Task task) {
        log.info("findById update");
        return service.update(task);
    }

    @ApiOperation(value = "タスクを削除します")
    @DeleteMapping("/{id}")
    void deleteById(@PathVariable Long id) {
        log.info("delete");
        service.deleteById(id);
    }

}
