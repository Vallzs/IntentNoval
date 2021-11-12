package com.noval.intentnoval

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var btnMoveActivity: Button
    private lateinit var btnMoveWithData: Button
    private lateinit var btnDialNumber: Button
    private lateinit var btnResultFromActivity: Button
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnMoveActivity = findViewById(R.id.btn_move_activity)
        btnMoveActivity.setOnClickListener(this)

        btnMoveWithData = findViewById(R.id.btn_move_with_data)
        btnMoveWithData.setOnClickListener(this)

        btnDialNumber = findViewById(R.id.btn_dial_number)
        btnDialNumber.setOnClickListener(this)

        btnResultFromActivity = findViewById(R.id.btn_result_from_activity)
        btnResultFromActivity.setOnClickListener(this)

        tvResult = findViewById(R.id.tv_result)
        AnimalReceived()
    }

    private fun AnimalReceived() {
        val bundle = intent.extras
        val hewan = bundle?.getString("Hewan")
        tvResult.text = hewan
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when(v.id) {
                R.id.btn_move_activity -> kotlin.run {
                    val intent = Intent(this, MoveActivity::class.java)
                    startActivity(intent)
                }
                R.id.btn_move_with_data -> run {
                    val intent = Intent(this, MoveWithDataActivity::class.java)
                    val bundle = Bundle()
                    bundle.putString("Nama", "Noval")
                    bundle.putString("Alamat", "Lawang")
                    intent.putExtras(bundle)
                    startActivity(intent)
                }
                R.id.btn_dial_number -> run {
                    var dialNumber = "08976479990"
                    val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + dialNumber))
                    startActivity(intent)
                }
                R.id.btn_result_from_activity -> {
                    val intent = Intent(this, MoveForResultActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}