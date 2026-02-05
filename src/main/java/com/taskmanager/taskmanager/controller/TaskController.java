package com.taskmanager.taskmanager.controller;

import com.taskmanager.taskmanager.model.Task;
import com.taskmanager.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/user/{userId}")
    public ResponseEntity<?> createTask(
            @PathVariable Long userId,
            @RequestBody Task task
    ) {
        try {
            Task createdTask = taskService.createTask(userId, task);
            return ResponseEntity.ok(createdTask);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
