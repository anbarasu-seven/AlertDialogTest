package com.example.alertdialogtest

import android.content.DialogInterface
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    var skillSelected = booleanArrayOf(true, false, false)
    val skills = arrayOf("Lenovo", "Dell", "Samsung")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button1 = findViewById<Button>(R.id.button1)
        button1.setOnClickListener {
            showCustomAlert()
        }


    }

    fun showCustomAlert(){
        var alertDialog = AlertDialog.Builder(this)
        val text = TextView(this)
        text.text = "Custom alert UI"
        alertDialog.setView(text)
        alertDialog.show()
    }

    fun showMultiSelectionAlert(){
        var alertDialog = AlertDialog.Builder(this)
        alertDialog.setMultiChoiceItems(skills, skillSelected, DialogInterface.OnMultiChoiceClickListener { dialog, which, isChecked ->

        })
        alertDialog.setPositiveButton("Submit", DialogInterface.OnClickListener { dialog, which ->
            dialog.dismiss()
        })
        alertDialog.show()
    }

    fun showSingleSelectionAlert(){
        var alertDialog = AlertDialog.Builder(this)
        alertDialog.setSingleChoiceItems(skills, 0, DialogInterface.OnClickListener { dialog, which ->

        })
        alertDialog.setPositiveButton("Submit", DialogInterface.OnClickListener { dialog, which ->
            dialog.dismiss()
        })
        alertDialog.show()
    }

    fun showSimpleAlertToUser() {
        var alertDialog = AlertDialog.Builder(this)
        alertDialog.setTitle("Delete?")
        alertDialog.setMessage("Are you sure to delete this item from your app.....")
        alertDialog.setPositiveButton("YES", DialogInterface.OnClickListener { dialog, which ->
            Toast.makeText(this, "YES clicked", Toast.LENGTH_SHORT).show()
        })
        alertDialog.setNegativeButton("NO", DialogInterface.OnClickListener { dialog, which ->
            Toast.makeText(this, "No clicked", Toast.LENGTH_SHORT).show()
        })
        alertDialog.show()
    }

}