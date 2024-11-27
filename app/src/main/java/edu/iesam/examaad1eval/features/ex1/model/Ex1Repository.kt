package edu.iesam.examaad1eval.features.ex1.model

interface Ex1Repository {
    fun getUsers(): List<User>
    fun getItems(): List<Item>
    fun getServices(): List<Services>
}