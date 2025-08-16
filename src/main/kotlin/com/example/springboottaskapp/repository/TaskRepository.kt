package com.example.springboottaskapp.repository

import com.example.springboottaskapp.entity.Task
import org.springframework.data.jpa.repository.JpaRepository

interface TaskRepository: JpaRepository<Task, Long>