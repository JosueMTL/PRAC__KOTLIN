package com.example.Pract__Book.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.Date
@Entity
@Table(name = "book")
class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    var id: Long? = null

    var title: String?=  null
    var isbn: String?= null

    @Column(name = "publication_year")
    var publicationYear: Int? = null

    @Column(name = "author_id")
    var authorId: Long? = null
}