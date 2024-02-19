package com.example.calculator

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.calculator.ui.theme.CalculatorTheme
import com.example.calculator.ui.theme.LightGray
import com.example.calculator.ui.theme.MediumGray
import com.example.calculator.ui.theme.Orange

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorTheme {
                val viewModel=viewModel<CalcViewModel>()
                val state=viewModel.state
                val buttonspace=8.dp
                Box(modifier = Modifier
                    .fillMaxSize()
                    .background(Color.DarkGray)
                    .padding(8.dp)
                )
                {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.BottomCenter),
                        verticalArrangement = Arrangement.spacedBy(buttonspace)
                    ) {
                            Text(
                                text=state.number1+(state.operation?.symbol?:"")+state.number2,
                                textAlign = TextAlign.End,
                                modifier = Modifier
                                    .padding(vertical =32.dp),
                                fontWeight = FontWeight.Light,
                                fontSize = 80.sp,
                                color=Color.White,
                                maxLines = 2
                            )
                        Row (
                            modifier=Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(buttonspace)
                        ){
                            CalcButton(symbol = "AC",
                                color= LightGray,
                                modifier = Modifier
                                    .aspectRatio(2f)
                                    .weight(2f)
                            ) {
                                viewModel.onAction(CalcaAction.Clear)
                            }
                            CalcButton(symbol = "Del",
                                color = LightGray,
                                modifier=Modifier
                                    .aspectRatio(1f)
                                    .weight(1f)
                                )
                            {
                                viewModel.onAction(CalcaAction.Delete)
                            }
                            CalcButton(symbol = "/",
                                color = Orange,
                                modifier=Modifier
                                    .aspectRatio(1f)
                                    .weight(1f)
                            )
                            {
                                viewModel.onAction(CalcaAction.Operation(CalcOperation.Div))
                            }

                            Row (
                                modifier=Modifier
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(buttonspace)
                            ) {
                                CalcButton(
                                    symbol = "7",
                                    color = MediumGray,
                                    modifier = Modifier
                                        .aspectRatio(1f)
                                        .weight(1f)
                                ) {
                                    viewModel.onAction(CalcaAction.Number(7))
                                }
                                CalcButton(
                                    symbol = "8",
                                    color = MediumGray,
                                    modifier = Modifier
                                        .aspectRatio(1f)
                                        .weight(1f)
                                )
                                {
                                    viewModel.onAction(CalcaAction.Number(8))
                                }
                                CalcButton(
                                    symbol = "9",
                                    color = MediumGray,
                                    modifier = Modifier
                                        .aspectRatio(1f)
                                        .weight(1f)
                                )
                                {
                                    viewModel.onAction(CalcaAction.Number(9))
                                }
                                CalcButton(
                                    symbol = "x",
                                    color = Orange,
                                    modifier = Modifier
                                        .aspectRatio(1f)
                                        .weight(1f)
                                )
                                {
                                    viewModel.onAction(CalcaAction.Operation(CalcOperation.Mul))
                                }
                            }
                                Row (
                                    modifier=Modifier
                                        .fillMaxWidth(),
                                    horizontalArrangement = Arrangement.spacedBy(buttonspace)
                                ) {
                                    CalcButton(
                                        symbol = "4",
                                        color = MediumGray,
                                        modifier = Modifier
                                            .aspectRatio(1f)
                                            .weight(1f)
                                    ) {
                                        viewModel.onAction(CalcaAction.Number(4))
                                    }
                                    CalcButton(
                                        symbol = "5",
                                        color = MediumGray,
                                        modifier = Modifier
                                            .aspectRatio(1f)
                                            .weight(1f)
                                    )
                                    {
                                        viewModel.onAction(CalcaAction.Number(5))
                                    }
                                    CalcButton(
                                        symbol = "6",
                                        color = MediumGray,
                                        modifier = Modifier
                                            .aspectRatio(1f)
                                            .weight(1f)
                                    )
                                    {
                                        viewModel.onAction(CalcaAction.Number(6))
                                    }
                                    CalcButton(
                                        symbol = "-",
                                        color = Orange,
                                        modifier = Modifier
                                            .aspectRatio(1f)
                                            .weight(1f)
                                    )
                                    {
                                        viewModel.onAction(CalcaAction.Operation(CalcOperation.Sub))
                                    }
                                }

                            Row (
                                modifier=Modifier
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(buttonspace)
                            ) {
                                CalcButton(
                                    symbol = "1",
                                    color = MediumGray,
                                    modifier = Modifier
                                        .aspectRatio(1f)
                                        .weight(1f)
                                ) {
                                    viewModel.onAction(CalcaAction.Number(1))
                                }
                                CalcButton(
                                    symbol = "2",
                                    color = MediumGray,
                                    modifier = Modifier
                                        .aspectRatio(1f)
                                        .weight(1f)
                                )
                                {
                                    viewModel.onAction(CalcaAction.Number(2))
                                }
                                CalcButton(
                                    symbol = "3",
                                    color = MediumGray,
                                    modifier = Modifier
                                        .aspectRatio(1f)
                                        .weight(1f)
                                )
                                {
                                    viewModel.onAction(CalcaAction.Number(3))
                                }
                                CalcButton(
                                    symbol = "+",
                                    color = Orange,
                                    modifier = Modifier
                                        .aspectRatio(1f)
                                        .weight(1f)
                                )
                                {
                                    viewModel.onAction(CalcaAction.Operation(CalcOperation.ADD))
                                }
                            }

                            Row (
                                modifier=Modifier
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(buttonspace)
                            ) {
                                CalcButton(
                                    symbol = "0",
                                    color = MediumGray,
                                    modifier = Modifier
                                        .aspectRatio(1f)
                                        .weight(1f)
                                ) {
                                    viewModel.onAction(CalcaAction.Number(0))
                                }
                                CalcButton(
                                    symbol = ".",
                                    color = MediumGray,
                                    modifier = Modifier
                                        .aspectRatio(2f)
                                        .weight(2f)
                                )
                                {
                                    viewModel.onAction(CalcaAction.Decimal)
                                }
                                CalcButton(
                                    symbol = "=",
                                    color = MediumGray,
                                    modifier = Modifier
                                        .aspectRatio(1f)
                                        .weight(1f)
                                )
                                {
                                    viewModel.onAction(CalcaAction.Calculate)
                                }

                            }
                        }
                    }
                }
            }
        }
    }
}



