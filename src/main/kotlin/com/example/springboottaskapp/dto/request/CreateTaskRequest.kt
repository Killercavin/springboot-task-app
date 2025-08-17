package com.example.springboottaskapp.dto.request

import com.example.springboottaskapp.entity.Priority
import jakarta.validation.constraints.*

data class CreateTaskRequest(
    @field:NotBlank(message = "Title cannot be blank")
    val title: String,

    @field:NotBlank(message = "Description cannot be blank")
    val description: String,

    val priority: Priority? = Priority.MEDIUM
)
