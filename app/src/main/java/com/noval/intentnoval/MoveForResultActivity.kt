package com.noval.intentnoval

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.core.os.bundleOf

class MoveForResultActivity : AppCompatActivity() {
    var rgAnimal: RadioGroup? = null
    lateinit var radioButton: RadioButton
    private lateinit var btnChoose : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_for_result)

        rgAnimal = findViewById(R.id.rg_animal)
        btnChoose = findViewById(R.id.btn_choose)
        btnChoose.setOnClickListener{
            val selectOption: Int = rgAnimal!!.checkedRadioButtonId
            radioButton = findViewById(selectOption)

            val intent = Intent(this, MainActivity::class.java)
            val bundle = Bundle()
            bundle.putString("Hewan", radioButton.text as String?)
            intent.putExtras(bundle)
            startActivity(intent)
        }
    }
}