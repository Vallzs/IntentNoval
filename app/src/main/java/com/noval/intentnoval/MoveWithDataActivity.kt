package com.noval.intentnoval

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MoveWithDataActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var tvDataReceived: TextView
    private lateinit var btnKembali: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_data)

        tvDataReceived = findViewById(R.id.tv_data_received)
        DataReceived()
        btnKembali = findViewById(R.id.btn_kembali)
        btnKembali.setOnClickListener(this)
    }

    private fun DataReceived() {
        val bundle = intent.extras
        val nama = bundle?.getString("Nama")
        val alamat = bundle?.getString("Alamat")

        tvDataReceived.text = nama + " " + alamat
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