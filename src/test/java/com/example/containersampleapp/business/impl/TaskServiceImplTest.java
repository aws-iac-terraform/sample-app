package com.example.containersampleapp.business.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import com.example.containersampleapp.business.model.Task;

import org.junit.jupiter.api.Test;


class TaskServiceImplTest {

    TaskServiceImpl target = new TaskServiceImpl();

    @Test
    void findAll() {

        List<Task> actual = target.findAll();

        assertEquals(4, actual.size());
    }
}