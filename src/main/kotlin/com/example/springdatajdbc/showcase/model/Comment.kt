package com.example.springdatajdbc.showcase.model

import org.springframework.data.annotation.Id

data class Comment(
        @Id val id: Long? = null,
        val content: String
)