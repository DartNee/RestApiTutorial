package com.example.restapitutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.restapitutorial.model.User
import com.example.restapitutorial.retrofit.RetrofitManager
import kotlinx.android.synthetic.main.activity_edit_user.*

class EditUserActivity : AppCompatActivity() {

    val TAG: String = "로그"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_user)



        val firstUser = intent.extras?.get("firstUser") as User


//        Log.d(TAG, "EditUserActivity - onCreate() called / firstUser.firstName : ${firstUser.firstName}")
//
//        first_name_input.setText(firstUser.firstName)
//        last_name_input.setText(firstUser.lastName)
//        email_input.setText(firstUser.email)
//        password_input.setText(firstUser.password)

        edit_user_btn.setOnClickListener {
            RetrofitManager.instance.updateUser(firstName = first_name_input.text.toString(),
                                                lastName = last_name_input.text.toString(),
                                                email = email_input.text.toString(),
                                                password = password_input.text.toString()
                                                )
        }


    }



}
