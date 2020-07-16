package com.example.springdatajdbc.showcase.model

data class Ticket(
        override val id: Long? = null,
        val title: String,
        val comments: MutableSet<Comment>
) : BaseEntity(id)

