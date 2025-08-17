package com.example.springboottaskapp.controller

import com.example.springboottaskapp.dto.request.CreateTaskRequest
import com.example.springboottaskapp.dto.response.TaskResponse
import com.example.springboottaskapp.service.TaskService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/tasks")
class TaskController(private val taskService: TaskService) {

    // GET all tasks
    @GetMapping("/all") @ResponseStatus(HttpStatus.OK)
    fun getTasks(): List<TaskResponse>{
        return taskService.fetchAllTasks()
    }

    // ADD new task
    @PostMapping @ResponseStatus(HttpStatus.CREATED)
    fun addTask(@RequestBody @Valid createTaskRequest: CreateTaskRequest): TaskResponse {
        return taskService.createTask(createTaskRequest)
    }

    @GetMapping("/id") @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun missingId(): String {
        return "Missing ID"
    }

    @GetMapping("/id/{id}") @ResponseStatus(HttpStatus.OK)
    fun taskById(@Valid @PathVariable id: Long): TaskResponse? {
        return taskService.byId(id)
    }
}