package com.example.instagramclone.daos

import com.example.instagramclone.model.User
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

//it is used add the user data in the user collection or firestore
class UserDao {

    //making instance of firestore
    val db = FirebaseFirestore.getInstance()
    //adding collections

    val userCollection = db.collection("users")

    fun addUser(user: User?){
        user?.let {
            GlobalScope.launch(Dispatchers.IO) {
                userCollection.document(user.uid).set(it)
            }
        }
    }

    fun gwtUserById(uID :String) : Task<DocumentSnapshot>{
        return userCollection.document(uID).get()
    }
}