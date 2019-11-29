package com.example.walmartlogin.dao

import com.example.walmartlogin.domain.User

class UserList{
    var userList:MutableList<User> = ArrayList()

    constructor(){
    userList.add(User("rjy","rjy"))
    userList.add(User("ryh","ryh"))
    userList.add(User("rxk","rxk"))

}
    fun getUserByname(username:String):User?{
        for(user in userList){
            if(user.username.equals(username))
                return user
        }
        return null
    }
    fun addUser(user:User){
        userList.add(user)
    }
}
