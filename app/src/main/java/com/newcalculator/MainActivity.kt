package com.newcalculator


import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.appcompat.widget.AppCompatButton

class MainActivity : ComponentActivity() {
    private val input = mutableListOf<String>()
    private var display: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout)
        display = findViewById(R.id.display)
    }

    @SuppressLint("SetTextI18n")
    fun onClick(button: View) {
        var infixExpression: Expression? = null
        //         input.add(buttontext)
//         display?.text="${display?.text} ${button.text} "
        when (val buttontext = (button as AppCompatButton).text.toString()) {

            "=" -> {
                infixExpression = Expression(input)
                display?.text = infixExpression.evaluateExpression().toString()
                input.clear()
                input.add(display?.text.toString())
            }

            "CL" -> {
                input.remove(input.last())
                display?.text = "${display?.text}".dropLast(2)
            }

            "C" -> {
                input.clear()
                display?.text = ""
            }


            else -> {
                if (Character.isDigit(buttontext[0])||buttontext[0]=='.') {
                    if (input.isNotEmpty() && Character.isDigit(input.last()[0])) {
                       input[input.lastIndex]=input.last()+buttontext
                        display?.text = "${display?.text}${button.text}"
                    } else {


                        input.add(buttontext)
                        display?.text = "${display?.text} ${button.text}"
                    }
                } else {
                    input.add(buttontext)
                    display?.text = "${display?.text} ${button.text}"
                }
            }


        }
    }


}
