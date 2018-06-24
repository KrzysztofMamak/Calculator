package example.mamak.calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var clicked: Boolean = false
        var operation: Operation? = null
        var firstNum: Double = 0.0

        var textView: TextView = findViewById(R.id.textView)
        
        var btn0: Button = findViewById(R.id.btn0)
        var btn1: Button = findViewById(R.id.btn1)
        var btn2: Button = findViewById(R.id.btn2)
        var btn3: Button = findViewById(R.id.btn3)
        var btn4: Button = findViewById(R.id.btn4)
        var btn5: Button = findViewById(R.id.btn5)
        var btn6: Button = findViewById(R.id.btn6)
        var btn7: Button = findViewById(R.id.btn7)
        var btn8: Button = findViewById(R.id.btn8)
        var btn9: Button = findViewById(R.id.btn9)

        var btnClear: Button = findViewById(R.id.btnClear)
        var btnUnary: Button = findViewById(R.id.btnUnary)
        var btnPercent: Button = findViewById(R.id.btnPercent)
        var btnDiv: Button = findViewById(R.id.btnDiv)
        var btnMulti: Button = findViewById(R.id.btnMulti)
        var btnMinus: Button = findViewById(R.id.btnMinus)
        var btnPlus: Button = findViewById(R.id.btnPlus)
        var btnDot: Button = findViewById(R.id.btnDot)
        var btnEquals: Button = findViewById(R.id.btnEquals)

        btn0.setOnClickListener ({
            if (textView.text != "0")
                textView.text = textView.text.toString() + btn0.text.toString()
        })

        btn1.setOnClickListener ({
            textView.text = textView.text.toString() + btn1.text.toString()
        })

        btn2.setOnClickListener ({
            textView.text = textView.text.toString() + btn2.text.toString()
        })

        btn3.setOnClickListener ({
            textView.text = textView.text.toString() + btn3.text.toString()
        })

        btn4.setOnClickListener ({
            textView.text = textView.text.toString() + btn4.text.toString()
        })

        btn5.setOnClickListener ({
            textView.text = textView.text.toString() + btn5.text.toString()
        })

        btn6.setOnClickListener ({
            textView.text = textView.text.toString() + btn6.text.toString()
        })

        btn7.setOnClickListener ({
            textView.text = textView.text.toString() + btn7.text.toString()
        })

        btn8.setOnClickListener ({
            textView.text = textView.text.toString() + btn8.text.toString()
        })

        btn9.setOnClickListener ({
            textView.text = textView.text.toString() + btn9.text.toString()
        })

        btnClear.setOnClickListener ({
            textView.text = ""
        })

        btnUnary.setOnClickListener ({
            //---------------------BUG---------------------//
            if (textView.text.contains("-"))
                removeMinus(textView.text.toString(), "-")
            else
                textView.text = "-" + textView.text.toString()
        })

        btnPercent.setOnClickListener ({
            textView.text = (textView.text.toString().toDouble() * 0.01).toString()
        })

        btnDiv.setOnClickListener ({
            if (clicked == false) {
                firstNum = textView.text.toString().toDouble()
                textView.text = ""
                operation = Operation.DIV
                clicked = true
            }
        })

        btnMulti.setOnClickListener ({
            if (clicked == false) {
                firstNum = textView.text.toString().toDouble()
                textView.text = ""
                operation = Operation.MULTI
                clicked = true
            }
        })

        btnMinus.setOnClickListener ({
            if (clicked == false) {
                firstNum = textView.text.toString().toDouble()
                textView.text = ""
                operation = Operation.MINUS
                clicked = true
            }
        })

        btnPlus.setOnClickListener ({
            if (clicked == false) {
                firstNum = textView.text.toString().toDouble()
                textView.text = ""
                operation = Operation.PLUS
                clicked = true
            }
        })

        btnDot.setOnClickListener ({
            if (textView.text != "" && textView.text[textView.text.lastIndex] != '.')
                textView.text = textView.text.toString() + btnDot.text.toString()
        })

        btnEquals.setOnClickListener ({

            if (clicked == true) {
                var secondNum: Double = 0.0
                var result: Double = 0.0

                secondNum = textView.text.toString().toDouble()

                if (operation == Operation.PLUS) {
                    result = firstNum + secondNum
                } else if (operation == Operation.MINUS) {
                    result = firstNum - secondNum
                } else if (operation == Operation.MULTI) {
                    result = firstNum * secondNum
                } else if (operation == Operation.DIV) {
                    result = firstNum / secondNum
                }

                textView.text = result.toString()
                clicked = false
            }
        })
    }

    enum class Operation {
        PLUS, MINUS, DIV, MULTI
    }
}

fun removeMinus(value: String, x: String) : String {
    return value.replace(x, "")
}
