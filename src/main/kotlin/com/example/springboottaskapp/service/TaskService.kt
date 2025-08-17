package com.example.springboottaskapp.service

import com.example.springboottaskapp.dto.request.CreateTaskRequest
import com.example.springboottaskapp.dto.response.TaskResponse
import com.example.springboottaskapp.dto.response.toDTO
import com.example.springboottaskapp.entity.Task
import com.example.springboottaskapp.repository.TaskRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.*

@Service
class TaskService(private val taskRepository: TaskRepository) {

    // fetch all tasks
    fun fetchAllTasks(): List<TaskResponse> {
        return taskRepository.findAll().map { it.toDTO() }
    }

    // create a task
    fun createTask(request: CreateTaskRequest): TaskResponse {
        val newTask = Task(
            title = request.title,
            description = request.description,
            priority = request.priority
        )

        return taskRepository.save(newTask).toDTO()
    }

    // fetch task by ID
    fun byId(id: Long): TaskResponse? {
        return taskRepository.findByIdOrNull(id)?.toDTO()
    }
}