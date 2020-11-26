package com.example.springdatajdbc.showcase

import org.springframework.core.convert.converter.Converter
import org.springframework.data.annotation.Id
import org.springframework.data.convert.ReadingConverter
import org.springframework.data.convert.WritingConverter

data class Ticket(
        @Id var id: Long? = null,
        val title: String,
        val assigned: String? = null,
        val status: TicketStatus = TicketStatus.UNKNOWN
) {
    enum class TicketStatus(private val databaseValue: String?) {
        OPEN("oPeN"),
        SOLVED("solVed"),
        UNKNOWN("unknown");

        @ReadingConverter
        class EnumReadingConverter : Converter<String, TicketStatus> {
            override fun convert(dbValue: String): TicketStatus {
                return values().first { it.databaseValue == dbValue }
            }
        }

        @WritingConverter
        class EnumWritingConverter : Converter<TicketStatus, String> {
            override fun convert(entity: TicketStatus): String? {
                return entity.databaseValue
            }
        }
    }
}