package com.example.sharedpreferences

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //loadData() jika ingin data sebelumnya termuat lagi panggil ini

        button.setOnClickListener {
            saveData()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun saveData(){
        val insertNama = edit_text_nama.text.toString()
        val insertID = edit_text_id.text.toString()
        view_text.text = "Saudara/i $insertNama dengan NPM $insertID berhasil absen"

        val sharedPreferences = getSharedPreferences("sharedPref", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.apply {
            putString("STRING_KEY", insertNama)
            putString("STRING_KEY", insertID)
        }.apply()

        Toast.makeText(this, "Absensi Diterima", Toast.LENGTH_SHORT).show()
    }

    private fun loadData(){
        val sharedPreferences = getSharedPreferences("sharedPref", Context.MODE_PRIVATE)
        val savedString = sharedPreferences.getString("STRING_KEY", null)

        view_text.text = savedString
    }
}