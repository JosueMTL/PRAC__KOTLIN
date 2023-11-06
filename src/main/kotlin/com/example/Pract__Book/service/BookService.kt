package com.example.Pract__Book.service

import com.example.Pract__Book.model.Author
import com.example.Pract__Book.model.Book
import com.example.Pract__Book.repository.AuthorRepository
import com.example.Pract__Book.repository.BookRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.util.*

@Service
class BookService {
    @Autowired
    lateinit var bookRepository: BookRepository

    @Autowired
    lateinit var authorRepository: AuthorRepository

    fun list(): List<Book> {
        return bookRepository.findAll()
    }

    fun listOne(id: Long): Optional<Book> {
        return bookRepository.findById(id)
    }

    // PETICIONES POST
    fun save(modelo: Book): Book {
        try {
            authorRepository.findById(modelo.authorId) // Usar "modelo.authorId" en lugar de "modelo.clientId"
                ?: throw Exception("Id del autor no encontrado")
            return bookRepository.save(modelo)
        } catch (ex: Exception) {
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message)
        }
    }

    //Petición put
    fun update(modelo: Book): Book {
        try {
            bookRepository.findById(modelo.id)
                ?: throw Exception("ID no existe")

            return bookRepository.save(modelo)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    // Delete by id
    fun delete(id: Long?): Boolean? {
        try {
            val response = bookRepository.findById(id)
                ?: throw Exception("ID no existe")
            bookRepository.deleteById(id!!)
            return true
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }
}
