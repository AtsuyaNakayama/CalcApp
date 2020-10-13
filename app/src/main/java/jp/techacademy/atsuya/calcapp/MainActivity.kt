package jp.techacademy.atsuya.calcapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)


    }

    override fun onClick(v: View) {
        //空判定
        if (edittext1.text.toString() == "" || edittext2.text.toString() == ""){
            Snackbar.make(v, "値を入力してください。", Snackbar.LENGTH_SHORT).show()
            return
        }

        var res: Double = 0.0
        var num1: Double = edittext1.text.toString().toDouble()
        var num2: Double = edittext2.text.toString().toDouble()

        //計算
        if (v.id == R.id.button1) {
            res = num1 + num2
        } else if (v.id == R.id.button2) {
            res = num1 - num2
        } else if (v.id == R.id.button3) {
            res = num1 * num2
        } else if (v.id == R.id.button4) {
            res = num1 / num2
        }

        //画面切り替え
        val intent = Intent(this, Result::class.java)
        intent.putExtra("value1", res)
        startActivity(intent)
    }
}