package com.example.calculator

sealed class CalcaAction {

    data class Number(val number: Int):CalcaAction()
    data class Operation(val operation:CalcOperation):CalcaAction()
    object Clear: CalcaAction()
    object Delete : CalcaAction()
    object Calculate :CalcaAction()
    object Decimal:CalcaAction()

}