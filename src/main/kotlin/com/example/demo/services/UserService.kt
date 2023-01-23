package com.example.demo.services

import com.example.demo.entities.User
import com.example.demo.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService(
    @Autowired
    private val userRepository: UserRepository
) {
   fun getAllUsers(): List<User> {
       return userRepository.findAll()
   }

    fun getUserById(id: Long): User {
        return userRepository.findById(id).get()
    }

    fun addUser(user: User): User {
        return userRepository.save(user)
    }
}