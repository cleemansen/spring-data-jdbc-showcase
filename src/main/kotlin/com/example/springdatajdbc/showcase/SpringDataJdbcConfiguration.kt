package com.example.springdatajdbc.showcase

import org.springframework.context.annotation.Configuration
import org.springframework.data.jdbc.core.convert.JdbcCustomConversions
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories

@Configuration
@EnableJdbcRepositories
class SpringDataJdbcConfiguration : AbstractJdbcConfiguration() {

    override fun jdbcCustomConversions(): JdbcCustomConversions {
        return JdbcCustomConversions(
                listOf(
                        Ticket.TicketStatus.EnumReadingConverter(),
                        Ticket.TicketStatus.EnumWritingConverter()
                )
        )
    }
}