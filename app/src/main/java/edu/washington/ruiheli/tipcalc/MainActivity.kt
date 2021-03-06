package edu.washington.ruiheli.tipcalc

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnCalc = findViewById(R.id.btnCalc) as Button
        var txtInput = findViewById(R.id.txtInput) as EditText

        txtInput.addTextChangedListener(
            object:TextWatcher{
                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                    btnCalc.isEnabled = !s.toString().isNullOrEmpty()
                }

                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

                override fun afterTextChanged(s: Editable?) {}
            }
        )

        btnCalc.setOnClickListener ({
            val amount = txtInput.text.toString().toDouble()
            val tipAmount = amount * 0.15
            val total = amount * 1.15
            val output = "Tip Amount at 15% is $${"%.2f".format(tipAmount)}, Total is $${"%.2f".format(total)}"
            val toast = Toast.makeText(applicationContext, output, Toast.LENGTH_SHORT)
            toast.show()
        })
    }
}
