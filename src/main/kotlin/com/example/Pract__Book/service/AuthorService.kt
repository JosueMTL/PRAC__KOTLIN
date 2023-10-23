package com.example.Pract__Book.service

import com.example.Pract__Book.model.Author
import com.example.Pract__Book.repository.AuthorRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class AuthorService {
    @Autowired
    lateinit var authorRepository: AuthorRepository

    fun list ():List<Author>{
        return authorRepository.findAll()
    }

    //PETICIONES POST
    //clase service
    fun save(modelo: Author): Author{
        try{
            return authorRepository.save(modelo)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    //clase service -Petición put
    fun update(modelo: Author): Author{
        try {
            authorRepository.findById(modelo.id)
                ?: throw Exception("ID no existe")

            return authorRepository.save(modelo)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    //clase service - Delete by id
    fun delete (id: Long?):Boolean?{
        try{
            val response = authorRepository.findById(id)
                ?: throw Exception("ID no existe")
            authorRepository.deleteById(id!!)
            return true
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
}