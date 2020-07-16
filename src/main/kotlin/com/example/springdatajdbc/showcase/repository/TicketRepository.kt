package com.example.springdatajdbc.showcase.repository

import com.example.springdatajdbc.showcase.model.Ticket
import org.springframework.data.repository.CrudRepository

interface TicketRepository : CrudRepository<Ticket, Long>