package com.example.demo.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "user", schema = "public")
class User {
    @Id
    @Column(name = "id")
    var id: Long = 0

    @Column(name = "name")
    var name: String = ""

    @Column(name = "password")
    var password: String = ""
}