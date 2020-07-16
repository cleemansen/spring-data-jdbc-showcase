package com.example.springdatajdbc.showcase

import com.example.springdatajdbc.showcase.model.Comment
import com.example.springdatajdbc.showcase.model.Ticket
import com.example.springdatajdbc.showcase.repository.TicketRepository
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.repository.findByIdOrNull

@SpringBootTest
class ShowcaseApplicationTests {

	@Autowired lateinit var ticketRepository: TicketRepository

	@Test
	fun contextLoads() {
	}

	@Test
	fun saveTicketWithComment() {
		// prepare
		val inserted = ticketRepository
				.save(
						Ticket(
								title = "NPE",
								comments = mutableSetOf(
										Comment(content = "great!"),
										Comment(content = "solved!")
								)
						)
				)

		// execute
		val actual = ticketRepository.findByIdOrNull(id = inserted.id!!)

		// verify
		assertThat(actual?.id).isNotNull()
	}

}
