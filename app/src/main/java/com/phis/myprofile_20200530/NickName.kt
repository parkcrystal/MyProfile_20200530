package com.phis.myprofile_20200530

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_nick_name.*

class NickName : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nick_name)

        modifyBtn.setOnClickListener {

            val inputNickName = nicknameEdt.text.toString()

            val resultsIntent = intent

            resultsIntent.putExtra("nick", inputNickName)

            setResult(Activity.RESULT_OK, resultsIntent)
            finish()

        }

        val myContent = intent.getStringExtra("content")
        nicknameEdt.setText(myContent)
    }
}
