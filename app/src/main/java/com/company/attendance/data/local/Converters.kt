package com.company.attendance.data.local

import androidx.room.TypeConverter
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime

class Converters {
    
    @TypeConverter
    fun fromTimestamp(value: Long?): LocalDateTime? {
        return value?.let { 
            Instant.fromEpochMilliseconds(it).toString().let { 
                LocalDateTime.parse(it.substringBefore('Z'))
            }
        }
    }
    
    @TypeConverter
    fun dateToTimestamp(date: LocalDateTime?): Long? {
        return date?.let { 
            Instant.parse("${it}Z").toEpochMilliseconds()
        }
    }
    
    @TypeConverter
    fun fromDateTimestamp(value: Long?): LocalDate? {
        return value?.let {
            Instant.fromEpochMilliseconds(it).toString().let {
                LocalDate.parse(it.substringBefore('T'))
            }
        }
    }
    
    @TypeConverter
    fun localDateToTimestamp(date: LocalDate?): Long? {
        return date?.let {
            Instant.parse("${it}T00:00:00Z").toEpochMilliseconds()
        }
    }
}