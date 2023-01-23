package com.example.demo.controllers

import com.example.demo.entities.User
import com.example.demo.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/user")
class UserController(
    @Autowired
    private val userService: UserService
) {
    @GetMapping("all-users")
    fun findAllUsers(): List<User> {
        return userService.getAllUsers()
    }

    @PostMapping("add-user")
    fun createUser(user: User): User {
        return userService.addUser(user)
    }
}