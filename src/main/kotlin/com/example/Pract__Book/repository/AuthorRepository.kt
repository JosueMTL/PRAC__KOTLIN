package com.example.Pract__Book.repository

import com.example.Pract__Book.model.Author
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AuthorRepository : JpaRepository<Author, Long?>{
    fun findById (id: Long?): Author?
}