package com.example.Pract__Book.controller

import com.example.Pract__Book.model.Book
import com.example.Pract__Book.service.BookService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/book")
class BookController {
    @Autowired
    lateinit var bookService: BookService
    @GetMapping
    fun list ():List <Book>{
        return bookService.list()
    }

    @GetMapping("/{id}")
    fun listOne (@PathVariable id: Long) : Optional<Book> {
        return bookService.listOne(id)
    }

    //Peticiones post - Clase controller
    @PostMapping
    fun save (@RequestBody modelo: Book): ResponseEntity<Book> {
        return ResponseEntity(bookService.save(modelo), HttpStatus.OK)
    }

    //clase controller - Petición Put
    @PutMapping
    fun update(@RequestBody modelo: Book): ResponseEntity<Book> {
        return ResponseEntity(bookService.update(modelo), HttpStatus.OK)
    }

    //clase  controller-Petiicon Patch
    @PatchMapping
    fun updateName (@RequestBody modelo: Book): ResponseEntity<Book> {
        return ResponseEntity(bookService.update(modelo), HttpStatus.OK)
    }

    //clase  controller - Petición Delete
    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return bookService.delete(id)
    }
}