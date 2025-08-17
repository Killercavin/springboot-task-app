package com.example.springboottaskapp.dto.response

import com.example.springboottaskapp.entity.Priority
import com.example.springboottaskapp.entity.Task
import java.time.LocalDateTime

data class TaskResponse(
    val id: Long,
    val title: String,
    val description: String,
    val priority: Priority?,
    val createdAt: LocalDateTime?,
    val updatedAt: LocalDateTime?
)

// mapper of the Task to TaskResponse
fun Task.toDTO(): TaskResponse {
    return TaskResponse(
        id = this.id,
        title = this.title,
        description = this.description,
        priority = this.priority,
        createdAt = this.createdAt,
        updatedAt = this.updatedAt
    )
}