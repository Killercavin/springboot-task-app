package com.example.springboottaskapp.service

import com.example.springboottaskapp.entity.Task
import com.example.springboottaskapp.repository.TaskRepository
import org.springframework.stereotype.*

@Service
class TaskService(private val taskRepository: TaskRepository) {

    // fetch all tasks
    fun fetchAllTasks(): List<Task> {
        return taskRepository.findAll()
    }
}