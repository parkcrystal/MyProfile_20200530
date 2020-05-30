package com.phis.myprofile_20200530

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val REQ_FOR_NICKNAME = 1001

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        nickBtn.setOnClickListener {


            var inputContent = myNickNameTxt.text.toString()
            if(inputContent == "본인 닉네임 표시")
            {
                inputContent = ""
            }

            val myIntent  = Intent(this, NickName::class.java)
            myIntent.putExtra("content", inputContent)
            startActivityForResult(myIntent, REQ_FOR_NICKNAME)


        }

        callBtn.setOnClickListener {

            val phoneNum = phoneEdt.text.toString()

            val myUri = Uri.parse("tel:${phoneNum}")

            val myIntent = Intent(Intent.ACTION_DIAL, myUri)

            startActivity(myIntent)
        }

        smsBtn.setOnClickListener {
            val phoneNum = phoneEdt.text.toString()
            val content = smsEdt.text.toString()

            val myUri = Uri.parse("smstp:${phoneNum}")
            val myIntent = Intent(Intent.ACTION_SENDTO, myUri)

            myIntent.putExtra("sms_body", content)
            startActivity(myIntent)


        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == REQ_FOR_NICKNAME) {
            if(resultCode == Activity.RESULT_OK)
            {
                val newNickName = data?.getStringExtra("nick")
                myNickNameTxt.text = newNickName

            }


        }

    }





}
