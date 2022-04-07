package com.example.restapitutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.restapitutorial.retrofit.RetrofitManager
import kotlinx.android.synthetic.main.activity_create_user.*

class CreateUserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 레이아웃과 연결
        setContentView(R.layout.activity_create_user)


        // 유저 생성 버튼이 클릭 되었을 때
        create_user_btn.setOnClickListener {
            val title = first_name_input.text.toString()
            val body = last_name_input.text.toString()
            val userId = email_input.text.toString().toInt()

            RetrofitManager.instance.createUser(title, body, userId)

        }

    }
}
