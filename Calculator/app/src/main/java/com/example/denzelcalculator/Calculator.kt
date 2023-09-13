package com.example.denzelcalculator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.denzelcalculator.ui.theme.LightGray
import com.example.denzelcalculator.ui.theme.Orange
//import java.lang.reflect.Modifier
import androidx.compose.ui.Modifier


@Composable
fun Calculator(
    state: CalculatorState,
    buttonSpacing: Dp = 8.dp,
    modifier: androidx.compose.ui.Modifier = Modifier,
//    Import the calculator action
    onAction: (CalculatorAction) -> Unit
) {
    Box(modifier = modifier) {
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            Text(
                text = state.number1 + (state.operation?.symbol?: "") + state.number2,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 32.dp),
                fontWeight = FontWeight.Light,
                fontSize = 80.sp,
                color = Color.White,
                maxLines = 2
            )
            // Action buttons
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                // Clear button
                CalculatorButton(
                    symbols = "AC",
                    modifier = Modifier
                        .background(LightGray)
                        .aspectRatio(2f)
                        .weight(2f),
                    onClick = {
                        onAction(CalculatorAction.Clear)

                    }
                )
                // End of clear button
                // Delete button
                CalculatorButton(
                    symbols = "Del",
                    modifier = Modifier
                        .background(LightGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Delete)

                    }
                )
                // End of clear button
                // Divide button
                CalculatorButton(
                    symbols = "/",
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Operation(CalculatorOperation.Divide))

                    }
                )
                // End of clear button
            }
            // End of action buttons

            // First row of Numbers and operation buttons
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                // 7 button
                CalculatorButton(
                    symbols = "7",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Number(7))

                    }
                )
                // End of 7 button
                // 8 button
                CalculatorButton(
                    symbols = "8",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Number(8))

                    }
                )
                // End of 8 button

                // 9 button
                CalculatorButton(
                    symbols = "9",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Number(9))

                    }
                )
                // End of 9 button

                // Multiply button
                CalculatorButton(
                    symbols = "x",
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Operation(CalculatorOperation.Multiply))

                    }
                )
                // End of multiply button
            }
            // End of first row numbers and operations buttons

            // Second row of Numbers and operation buttons
            Row (
                modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                // 7 button
                CalculatorButton(
                    symbols = "4",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Number(4))

                    }
                )
                // End of 7 button
                // 8 button
                CalculatorButton(
                    symbols = "5",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Number(5))

                    }
                )
                // End of 8 button

                // 9 button
                CalculatorButton(
                    symbols = "6",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Number(6))

                    }
                )
                // End of 9 button

                // Subtract button
                CalculatorButton(
                    symbols = "-",
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Operation(CalculatorOperation.Subtract))

                    }
                )
                // End of multiply button
            }
            // End of second row of numbers and operations buttons

            // Third row of Numbers and operation buttons
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                // 1 button
                CalculatorButton(
                    symbols = "1",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Number(1))

                    }
                )
                // End of 1 button
                // 2 button
                CalculatorButton(
                    symbols = "2",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Number(2))

                    }
                )
                // End of 2 button

                // 3 button
                CalculatorButton(
                    symbols = "3",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Number(3))

                    }
                )
                // End of 3 button

                // Add button
                CalculatorButton(
                    symbols = "+",
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Operation(CalculatorOperation.Add))

                    }
                )
                // End of add button
            }
            // End of third row of numbers and operations buttons

            // Fourth row of Numbers and operation buttons
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                // 1 button
                CalculatorButton(
                    symbols = "0",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(2f)
                        .weight(2f),
                    onClick = {
                        onAction(CalculatorAction.Number(0))

                    }
                )
                // End of 0 button
                // Decimal button
                CalculatorButton(
                    symbols = ".",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Decimal)

                    }
                )
                // End of Decimal button

                // Equals button
                CalculatorButton(
                    symbols = "=",
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Calculate)

                    }
                )
                // End of Equals button

            }
            // End of fourth row of numbers and operations buttons


        }
    }

}