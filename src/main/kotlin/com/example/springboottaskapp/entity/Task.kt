package com.example.springboottaskapp.entity

import jakarta.persistence.*
import jakarta.validation.constraints.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

enum class Priority { LOW, MEDIUM, HIGH, VITAL }

@Entity
data class Task(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @field:NotBlank(message = "Title cannot be blank")
    @Column(nullable = false, length = 255)
    var title: String,

    @field:NotBlank(message = "Description cannot be blank")
    @Column(nullable = false, length = 255)
    var description: String,

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    var priority: Priority? = Priority.MEDIUM,

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    var createdAt: LocalDateTime? = null,

    @UpdateTimestamp
    @Column(nullable = false)
    var updatedAt: LocalDateTime? = null
)
