package com.example.Pract__Book.controller

import com.example.Pract__Book.model.Author
import com.example.Pract__Book.service.AuthorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/author")
class AuthorController {
    @Autowired
    lateinit var authorService: AuthorService
    @GetMapping
    fun list ():List <Author>{
        return authorService.list()
    }

    //Peticiones post - Clase controller
    @PostMapping
    fun save (@RequestBody modelo: Author):ResponseEntity<Author>{
        return ResponseEntity(authorService.save(modelo), HttpStatus.OK)
    }

    //clase controller - Petición Put
    @PutMapping
    fun update (@RequestBody modelo: Author):ResponseEntity<Author>{
        return ResponseEntity(authorService.update(modelo), HttpStatus.OK)
    }

    //clase  controller-Petiicon Patch
    @PatchMapping
    fun updateName (@RequestBody modelo: Author):ResponseEntity<Author>{
        return ResponseEntity(authorService.update(modelo), HttpStatus.OK)
    }

    //clase  controller - Petición Delete
    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return authorService.delete(id)
    }
}