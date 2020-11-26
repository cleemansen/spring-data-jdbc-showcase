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
	fun saveTicketWithStatus_ValueShouldBeWrittenToDatabase() {
		// execute
		val actual = ticketRepository.save(Ticket(title = "NPE", status = Ticket.TicketStatus.OPEN))

		// verify
		assertThat(actual.id).isNotNull()
	}

	@Test
	fun saveTicketWithDefaultStatus_NullValueShouldBeWrittenToDatabase() {
		// execute
		val actual = ticketRepository.save(Ticket(title = "NPE", status = Ticket.TicketStatus.UNKNOWN))

		// verify
		assertThat(actual.id).isNotNull()
	}

}
