package com.example.socialcircle.dao

import com.example.socialcircle.models.User
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class UserDao {
    val database = FirebaseFirestore.getInstance()
    val usersCollection = database.collection("users")
    fun addUser(user: User){
        user?.let {
            GlobalScope.launch (Dispatchers.IO){
                usersCollection.add(it)
            }
        }
    }
}