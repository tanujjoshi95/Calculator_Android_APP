package com.example.calculator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import java.nio.file.Files.delete

class CalcViewModel:ViewModel() {
    var state by mutableStateOf(CalcState())

    companion object {
        private const val MAX_NUM_LENGTH = 8
    }

    fun onAction(action: CalcaAction) {
        when (action) {
            is CalcaAction.Number -> enterNumber(action.number)
            is CalcaAction.Operation -> enterOperation(action.operation)
            is CalcaAction.Decimal -> enterDecimal()
            is CalcaAction.Delete -> delete()
            is CalcaAction.Clear -> state = CalcState()
            is CalcaAction.Calculate -> calculate()

        }


    }

    private fun calculate() {
        val number1 = state.number1.toDoubleOrNull()
        val number2 = state.number2.toDoubleOrNull()
        if (number1 != null && number2 != null) {
            val result = when (state.operation) {
                is CalcOperation.ADD -> number1 + number2
                is CalcOperation.Sub -> number1 - number2
                is CalcOperation.Mul -> number1 * number2
                is CalcOperation.Div -> number1 / number2
                null -> return
            }
            state = state.copy(
                number1 = result.toString().take(15),
                number2 = "",
                operation = null
            )

        }
    }

    private fun delete() {
        when {
            state.number2.isNotBlank() -> state = state.copy(
                number2 = state.number2.dropLast(1)
            )

            state.operation != null -> state = state.copy(
                operation = null
            )

            state.number1.isNotBlank() -> state = state.copy(
                number1 = state.number1.dropLast(1)
            )
        }

    }

    private fun enterDecimal() {
        if (state.operation == null && !state.number1.contains(".") && state.number1.isNotBlank()) {
            state = state.copy(
                number1 = state.number1 + "."
            )
        } else if (!state.number2.contains(".") && state.number2.isNotBlank()) {
            state = state.copy(
                number2 = state.number2 + "."
            )
        }
    }

    private fun enterOperation(operation: CalcOperation) {
        if (state.number1.isNotBlank()) {
            state = state.copy(operation = operation)
        }

    }

    private fun enterNumber(number: Int) {
        if (state.operation == null) {
            if (state.number1.length >= MAX_NUM_LENGTH) {
                return
            }
            state = state.copy(
                number1 = state.number1 + number
            )
            return
        }
        if (state.number2.length >= MAX_NUM_LENGTH) {
            return
        }
        state = state.copy(
            number2 = state.number2 + number
        )
    }
}