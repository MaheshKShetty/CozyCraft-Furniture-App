package com.cozycraft.android.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class User(
    var firstName: String,
    var middleName:String,
    var LastName:String,

    @PrimaryKey
    var email:String,

    var dob:String,
    var address: String,
    var password:String
)