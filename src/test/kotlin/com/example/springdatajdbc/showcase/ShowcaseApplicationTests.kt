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

}
