package com.example.springdatajdbc.showcase

import org.springframework.data.repository.CrudRepository
import java.util.*

interface TicketRepository : CrudRepository<Ticket, UUID>