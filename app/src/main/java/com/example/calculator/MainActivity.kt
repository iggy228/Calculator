package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_0.setOnClickListener {
            pridajZnak("0")
        }
        btn_1.setOnClickListener {
            pridajZnak("1")
        }
        btn_2.setOnClickListener {
            pridajZnak("2")
        }
        btn_3.setOnClickListener {
            pridajZnak("3")
        }
        btn_4.setOnClickListener {
            pridajZnak("4")
        }
        btn_5.setOnClickListener {
            pridajZnak("5")
        }
        btn_6.setOnClickListener {
            pridajZnak("6")
        }
        btn_7.setOnClickListener {
            pridajZnak("7")
        }
        btn_8.setOnClickListener {
            pridajZnak("8")
        }
        btn_9.setOnClickListener {
            pridajZnak("9")
        }
        btn_plus.setOnClickListener {
            pridajZnak("+")
        }
        btn_minus.setOnClickListener {
            pridajZnak("-")
        }
        btn_multiply.setOnClickListener {
            pridajZnak("*")
        }
        btn_divide.setOnClickListener {
            pridajZnak("/")
        }
        btn_dot.setOnClickListener {
            pridajZnak(".")
        }
        btn_equal.setOnClickListener {
            result()
        }
        btn_leftBracket.setOnClickListener {
            pridajZnak("(")
        }
        btn_rightBracket.setOnClickListener {
            pridajZnak(")")
        }
        btn_ce.setOnClickListener {
            findViewById<TextView>(R.id.text1).setText("0")
        }
        btn_erase.setOnClickListener {
            eraseLastChar()
        }
    }
    fun pridajZnak(char: String) {
        val vyraz = findViewById<TextView>(R.id.text1)
        var vyrazStr = vyraz.text.toString()
        if (vyrazStr == "0") {
            vyrazStr = ""
        }
        vyrazStr += char
        vyraz.setText(vyrazStr)
    }
    fun result() {
        val vyraz = findViewById<TextView>(R.id.text1)
        val str = vyraz.text.toString()
        val expression = ExpressionBuilder(str).build()
        try {
            val result = expression.evaluate()
            vyraz.setText(result.toString())
        }
        catch(e: NumberFormatException) {
            val result = "Error"
            vyraz.setText(result.toString())
        }
    }
    fun eraseLastChar() {
        val vyraz = findViewById<TextView>(R.id.text1)
        var str = vyraz.text.toString()
        str = str.substring(0, str.length - 1)
        vyraz.setText(str)
    }
}
