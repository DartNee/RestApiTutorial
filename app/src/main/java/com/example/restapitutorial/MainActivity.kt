package com.example.restapitutorial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.util.Log
import com.example.restapitutorial.retrofit.RetrofitManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val TAG: String = "로그"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        get_method_btn.setOnClickListener {
            Log.d(TAG, "겟 메소드 호출")

            RetrofitManager.instance.getUserPaginate(page_input_edit_text.text.toString().toInt())

        }

        post_method_btn.setOnClickListener {
            Log.d(TAG, "포스트 메소드 호출")

            val intent = Intent(this, CreateUserActivity::class.java)
            startActivity(intent)

        }

        put_method_btn.setOnClickListener {
            Log.d(TAG, "풋 메소드 호출")

//            val userId = user_id_input_edit_text.text.toString()
//            val intent = Intent(this, EditUserActivity::class.java)
//
//            intent.putExtra("user_id", userId)
//
//            startActivity(intent)

            // api 호출
            // 레트로핏 매니저에서 응답 성공시 EditUserActivity 보여주기
            RetrofitManager.instance.getFirstUser()

        }

        delete_method_btn.setOnClickListener {
            Log.d(TAG, "딜리트 메소드 호출")
        }


    }

}
