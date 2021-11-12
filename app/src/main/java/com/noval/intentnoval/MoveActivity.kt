package com.noval.intentnoval

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.ActionBar

class MoveActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var btnKembali: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move)

        btnKembali = findViewById(R.id.btn_kembali)
        btnKembali.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when(v.id) {
                R.id.btn_kembali -> kotlin.run {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}