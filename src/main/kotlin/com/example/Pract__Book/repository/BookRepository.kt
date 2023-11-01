package com.example.Pract__Book.repository

import com.example.Pract__Book.model.Book
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BookRepository : JpaRepository<Book, Long?> {
    fun findById (id: Long?): Book?
}