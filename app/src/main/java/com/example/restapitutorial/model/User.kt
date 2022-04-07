package com.example.restapitutorial.model

import android.os.Parcel
import android.os.Parcelable

class User() : Parcelable {

    var title: String = ""
    var body: String = ""
    var userId: Int = 0

    constructor(parcel: Parcel) : this() {
        title = parcel.readString().toString()
        body = parcel.readString().toString()
        userId = parcel.readString().toString().toInt()
    }

    constructor(firstName: String, lastName: String, email: String, password: String) : this() {

        this.title = title
        this.body = body
        this.userId = userId

    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(body)
        parcel.writeString(userId.toString())
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }


}
