package com.example.denzelcalculator

sealed class CalculatorAction {
    data class Number(val number: Int): CalculatorAction()
    object Clear: CalculatorAction()
    object Delete: CalculatorAction()
    object Calculate: CalculatorAction()
    object Decimal: CalculatorAction()

    data class Operation(val operation: CalculatorOperation): CalculatorAction()
}
