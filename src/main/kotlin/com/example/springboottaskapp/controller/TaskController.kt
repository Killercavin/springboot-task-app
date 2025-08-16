package com.example.springboottaskapp.controller

import com.example.springboottaskapp.service.TaskService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class TaskController(private val taskService: TaskService) {

    // GET all tasks
    @GetMapping("/tasks/all")
    fun getTasks(): ResponseEntity<Map<String, Any>> {
        val tasks = taskService.fetchAllTasks()

        return ResponseEntity.ok(mapOf("data" to tasks))
    }
}