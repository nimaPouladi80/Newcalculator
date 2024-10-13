package com.newcalculator

import android.util.Log
import java.util.Stack

class Expression(var infixExpression: MutableList<String>) {
    private var postFix: String = ""
    private fun infixToPostfix() {
        Log.d("infixToPostFixFun","resault is:$infixExpression")
        var resault = ""
        var stack = Stack<String>()
        for (element in infixExpression) {
            if (element.all { it.isDigit() } || element.any { it == '.' }) {
                resault += "$element "
            } else if (element == "(") {
                stack.push(element)
            } else if (element == ")") {
                while (stack.peek() != "(" && stack.isNotEmpty()) {
                    resault += "${stack.pop()} "
                }
                if (stack.isNotEmpty()) {
                    stack.pop()
                }

            } else {
                while (stack.isNotEmpty() && precedences(stack.peek()) >= precedences(element)) {
                    resault += "${stack.pop()} "
                }
                stack.push(element)
            }



        }

        while (stack.isNotEmpty()) {
            resault += "${stack.pop()} "
        }
        postFix = resault
        Log.d("infixToPostFixFun","resault is:$resault")
    }

    private fun precedences(operator: String): Int {
        return when (operator) {
            "÷", "×" -> 2
            "+", "-" -> 1
            else -> -1
        }


    }


    fun evaluateExpression(): Number {
        infixToPostfix()
        val stack = Stack<Double>()
        var i = 0
        while (i < postFix.length) {
            if (postFix[i] == ' ') {
                i++
                continue
            } else if (Character.isDigit(postFix[i])) {
                var number = ""

                while (Character.isDigit(postFix[i]) || postFix[i] == '.') {
                    number += postFix[i]
                    i++
                }
                stack.push(number.toDouble())

            } else {
                var x = stack.pop()
                var y = stack.pop()
                when (postFix[i]) {
                    '÷' -> stack.push(y / x)
                    '×' -> stack.push(x * y)
                    '+' -> stack.push(y + x)
                    '-' -> stack.push(y - x)
                }
            }
            i++
        }
        return if (stack.peek() / stack.peek().toInt() == 1.0) stack.peek()
            .toInt() else stack.peek()


    }

}