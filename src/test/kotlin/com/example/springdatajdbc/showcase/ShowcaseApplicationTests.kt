package com.example.springdatajdbc.showcase

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ShowcaseApplicationTests {

	@Autowired lateinit var ticketRepository: TicketRepository

	@Test
	fun contextLoads() {
	}

	@Test
	fun `it should insert the one-to-one model`() {
		// prepare
		val ticket = Ticket(
				title = "ticket side of one-to-one relationship",
				status = Ticket.TicketStatus.OPEN,
				project = Project(
						title = "project side of one-to-one relationship"
				)
		)

		// execute
		val actual = ticketRepository.save(ticket)

		// verify
		assertThat(actual.id).isNotNull()
		assertThat(actual.project!!.title).isEqualTo(ticket.project!!.title)
	}

}
